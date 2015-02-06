/**
 * Service to add history in the mongodb
 */
package com.mongo

import java.util.Date;
import java.util.HashSet;

import com.demo.domain.PostDomain
import com.demo.domain.UserDomain

import grails.transaction.Transactional

@Transactional
class UserHistoryService {
	
	def addUserToMongo(UserDomain user){
		println "user id  === "+user.id
		
		UserHistory userHistory = new UserHistory(
			neo4jId:user.id,
			username:user.username,
			email:user.email,
			phonenumber:user.phonenumber,
			isActive:user.isActive,
			token:user?.token,
			role:user.role,
			labels:user.labels
			)
		if(!userHistory.save()){
			userHistory.errors.each{
				log.debug it
			}
		}
	}
	
	def addPostToUser(PostDomain posts){
		PostHistory postHistoryObj = new PostHistory(
			neo4jPostId:posts.id,
			postText:posts.postText
			)
	if(!postHistoryObj.save()){
		postHistoryObj.errors.each{
			log.debug it
		}
	}
	}

    def serviceMethod() {

    }
}
