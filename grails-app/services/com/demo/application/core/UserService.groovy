package com.demo.application.core

import com.demo.command.PostCommand
import com.demo.command.UserCommand
import com.demo.domain.PostDomain
import com.demo.domain.UserDomain
import com.demo.domain.UserPostRelation
import com.demo.repository.UserDomainRepository


class UserService {
	
	
	def baseOptionService
	UserDomainRepository userDomainRepository
	
	/**
	 * Adding a user in neo4j and adding a label on userdomain object
	 * @param username
	 * @param email
	 * @param role
	 * @param phonenumber
	 * @param token
	 * @return
	 */
	def addUser(username,email,role,phonenumber,token){
		log.debug "user ===== "+username
		UserCommand userCommand = new UserCommand()
		
		userCommand.username = username
		userCommand.email = email
		userCommand.phonenumber = phonenumber
		userCommand.role = role
		userCommand.token = token
		//adding a label on user domain
		if(userCommand.labels?.empty == true || userCommand.labels == null){
			if(role == null){
				userCommand.addLabel(null)
			}else{
			userCommand.addLabel("_UserDomain")
			userCommand.addLabel("UserDomain")
			userCommand.addLabel(role)
		    }
		}
		userCommand.isActive = true
		userCommand.token = token
		
		UserDomain user = userCommand.getUser()
		log.debug "user == "+user
		baseOptionService.neoSave(user) //Aspect is used on execution of neoSave method
		log.debug user.token
		return user
	}
	
	/**
	 * Removing a label from userdomain object , if label exists
	 * @param id
	 * @param label
	 * @return
	 */
	def removeLabels(id,label){
		UserDomain user = findOne(id,UserDomain)
	    if(user.labels?.contains(label)){
			user.labels.remove(label)
		}
		baseOptionService.neoSave(user) //Aspect is used on execution of neoSave method
		return user
	}
	
	/**
	 *  Adding a post for a user
	 * @param postText
	 * @param isPublished
	 * @param token
	 * @return
	 */
	def createPost(postText,isPublished,token){
		def user = userDomainRepository.findByToken(token)
		log.debug "User ================= post "+user+ "  "+token
		PostCommand postCommandObj = new PostCommand();
		postCommandObj.lastUpdatedDate = new Date();
		postCommandObj.createdDate = new Date();
		postCommandObj.latitude = "73.2810000"
		postCommandObj.longitude = "29.11111111"
		postCommandObj.postText = postText
		PostDomain posts = postCommandObj.getPost()
		baseOptionService.neoSave(posts)
		UserPostRelation userPostRelation=new UserPostRelation()
		userPostRelation.user=user
		userPostRelation.post=posts
		baseOptionService.neoSave(userPostRelation) //Aspect is used on execution of neoSave method 
		return posts;
		
	}
	
    def serviceMethod() {

    }
}
