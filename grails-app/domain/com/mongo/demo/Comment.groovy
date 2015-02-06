/*
 * save comment in mongodb (not part of history)
 * 
 */
package com.mongo.demo

import java.util.Date;

class Comment {
	String commentText
	Long postId
	Date dateCreated
	Date lastUpdated
	
	static mapWith = "mongo"
    static constraints = {
    }
}
