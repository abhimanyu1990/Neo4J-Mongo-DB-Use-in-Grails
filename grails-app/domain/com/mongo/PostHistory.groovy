/**
 *  saves post history in mongodb
 */
package com.mongo

class PostHistory {
    Long neo4jPostId
	Date dateCreated
	String postText
	
	static mapWith = "mongo"
    static constraints = {
    }
}
