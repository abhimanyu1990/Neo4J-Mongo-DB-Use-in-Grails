/**
 *  saves user history in mongodb
 */

package com.mongo

import java.util.Collection;
import java.util.Date;


class UserHistory {

	
	Long neo4jId
	String username
	String email
	String phonenumber
	boolean isActive
	String token
	String role
	Date createdDate = new Date();
	Date lastUpdatedDate = new Date()
	HashSet<String> labels ;
	
	static mapWith = "mongo"
    static constraints = {
	  
	  username nullable:false,uniqueUser:['domainClass':'User','propertyName':'username']
	  email nullable:false,isEmail:true
	  phonenumber nullable:true
	  token nullable:true
	  role nullable:false
	  
  }
}
