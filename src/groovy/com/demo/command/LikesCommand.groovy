package com.demo.command

import com.demo.domain.LikesDomain
import java.util.Date;

class LikesCommand {
	Long id
	boolean isLike
	Date dateCreated
	Date lastUpdated
	
	
	static constraints = {
		id nullable:true
	}
	
	
	public getLikes(){
		LikesDomain likes = new LikesDomain();
		likes.id = this.id
		likes.isLike = this.isLike
		likes.dateCreated = this.dateCreated
		likes.lastUpdated = this.lastUpdated
		likes
	}
	
	public adaptLikes(LikesDomain likes){
		this.id = likes.id
		this.isLike = likes.isLike
		this.dateCreated = likes.dateCreated
		this.lastUpdated = likes.lastUpdated
	}
}
