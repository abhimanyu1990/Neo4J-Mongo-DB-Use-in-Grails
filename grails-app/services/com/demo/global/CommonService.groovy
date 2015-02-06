/**
 * This service is to check the class and call a function  on the basis of object class to save it in history.
 * 
 */
package com.demo.global

import grails.transaction.Transactional

@Transactional
class CommonService {
    def userHistoryService
	def doObjectProcess(obj){
		def classFullName = obj.getClass().toString()
		def className = classFullName.substring(classFullName.lastIndexOf(".")+1)
		
		switch(className){
			case "UserDomain":
			userHistoryService.addUserToMongo(obj)
			break;
			case "PostDomain":
			userHistoryService.addPostToUser(obj);
			break;
			default : 
			    log.debug "nothing to debug "
		}
	}
    def serviceMethod() {

    }
}
