package com.demo.application

import org.codehaus.groovy.grails.web.json.JSONObject
import com.demo.application.core.UserService
import com.demo.repository.*
import com.mongo.demo.Comment

class UserController {
	def userService
	def baseOptionService
	PostDomainRepository postDomainRepository
	UserDomainRepository userDomainRepository
	static responseFormats = ['json']
    
	/**
	 * 
	 * @author Abhimanyu  , Ashu Khurana ( The Bewkoof )
	 *  Action to add a new user (persist in neo4j)
	 */
	def add() {
		log.debug  request.getJSON()
		JSONObject body = request.getJSON()
		log.debug "body == "+body
		def user = userService.addUser(body?.username,body?.email,body?.role,body?.phonenumber,body.token)
		respond user
	}
	
	def show() {
		
	}
	/**
	 * @author abhimanyu
	 * Remove a Label from a user domain (persist in neo4j)
	 * @return user as Json
	 */
	def removeLabels(){
		JSONObject body = request.getJSON()
		log.debug "body == "+body
		def user = userService.removeLabels(body.id.toLong(),body.labels)
		respond user
	}
	
	/**
	 * @author abhimanyu
	 * Create a post for a user (persist in neo4j)
	 * @playload postText, isPublished (boolean),token(user token)
	 * return post as JSON
	 */
	def createPost(){
		
		JSONObject body = request.getJSON()
		log.debug body
		def post = userService.createPost(body.postText,body.isPublished,body.token)
		respond post
	}
	
	/**
	 * @author abhimanyu 
	 * Add a comment on a post  (persist in mongodb)
	 * @params postId
	 * @payload commentText
	 * @return comment object as json
	 */
	def addComment(){
		log.debug "PostId is not null = "+params.postId
	    def posts = postDomainRepository.findById(params.postId?.toLong())
		if(posts != null){
			log.debug "Post is not null = "+posts.id
			Comment comment = new Comment(
				  commentText:request.getJSON().commentText,
				  postId : posts.id
				)
			comment.save()
			render comment
		}
		render "failed"
	}
	
	/**
	 * @author abhimanyu
	 * Update a post  (persist in neo4j)
	 * @paramsId postId
	 * @payload postText
	 * @return posts object as json
	 */
	def updatePost(){
		log.debug "PostId is not null = "+params.postId
		def posts = postDomainRepository.findById(params.postId?.toLong())
		if(posts != null){
			log.debug "Post is not null = "+posts.id
			posts.postText = request.getJSON().postText
			baseOptionService.neoSave(posts) //Aspect is used on execution of neoSave method
			respond posts
		}
		render "failed"
	}
	
	
	/**
	 * @author Abhimanyu
	 * find all user who is admin
	 * @return user object
	 */
	def findAdmin(){
		log.debug "====== admins ========"
		def adminUsers = userDomainRepository.findAllAdmin()
		respond adminUsers
	}
    def index() { }
}
