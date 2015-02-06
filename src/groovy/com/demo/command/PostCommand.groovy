package com.demo.command

import com.demo.domain.PostDomain
import com.demo.domain.UserDomain
import java.util.Date;

class PostCommand {
	Long id
	String postText
	 Date createdDate
  Date lastUpdatedDate
	String longitude
	String latitude
	
	static constraints = {
		id nullable:true
		postText nullable:false
		user nullable:true
		
	}
	public getPost(){
		PostDomain posts = new PostDomain();
		posts.id = this.id
		posts.postText = this.postText
		posts.longitude = this.longitude
		posts.latitude = this.latitude
		posts.createdDate = this.createdDate
		posts.lastUpdatedDate = this.lastUpdatedDate
		posts
	}
	
	public adaptPost(PostDomain posts){
		this.id = post.id
		this.postText = posts.postText
		this.longitude = posts.longitude
		this.latitude = posts.latitude
		this.createdDate = posts.createdDate
		this.lastUpdatedDate = posts.lastUpdatedDate
		
	}
}
