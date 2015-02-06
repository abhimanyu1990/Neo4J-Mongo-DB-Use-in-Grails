package com.demo.command

import com.demo.domain.UserDomain
import java.util.Collection;

import org.springframework.data.neo4j.annotation.Labels;
import org.codehaus.groovy.grails.validation.Validateable

@Validateable
class UserCommand {
	Long id
	String username
	String password
	String email
	String phonenumber
	boolean isActive
	String role
	String token
	Date createdDate
	Date lastUpdatedDate
	
	@Labels
	HashSet<String> labels = new HashSet();
	
	static constraints = {
	  id nullable:true
	  username nullable:false,uniqueUser:['domainClass':'User','propertyName':'username']
	  password nullable:false
	  email nullable:false,isEmail:true
	  phonenumber nullable:true
	  token nullable:true
	  role nullable:false
	  
  }
  
  
	public getUser(){
		UserDomain user = new UserDomain();
		user.id = this.id
		user.isActive = this.isActive
		user.username = this.username
		user.email = this.email
		user.phonenumber = this.phonenumber
		user.id = null
		user.labels = this.labels
		user.role = this.role
		user.token = this.token
		user
    }
  
	public void addLabel(String label) {
		HashSet<String> newLabels = this.labels;
		if (newLabels.add(label)) this.labels = newLabels;
	}
	
	public adaptUser(UserDomain user){
		this.id = user.id
		this.isActive = user.isActive
		this.username = user.username
		this.email = user.email
		this.phonenumber = user.phonenumber
		this.password = user.password
		this.id = user.id
		this.labels = user.labels
		this.role = user.role
		this.token = user.token
	}
	
	public setUserToken(UserDomain user){
		user.token = UUID.randomUUID()
		user
	}
	
	
}
