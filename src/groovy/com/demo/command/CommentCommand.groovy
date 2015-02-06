package com.demo.command

import com.demo.domain.CommentDomain
import java.util.Date;

class CommentCommand {
	Long id
	String commentText
	Date dateCreated
	Date lastUpdated
	
	static constraints = {
		id nullable:true
		commentText nullable:false
	}
	
	public getComment(){
		CommentDomain comment = new CommentDomain();
		comment.id = this.id
		comment.commentText = this.comment
		comment.dateCreated = this.dateCreated
		comment.lastUpdated = this.lastUpdated
		comment
	}
	
	public adaptComment(CommentDomain comment){
		this.id = comment.id
		this.commentText = comment.commentText
		this.dateCreated = comment.dateCreated
		this.lastUpdated = comment.lastUpdated
	}
}
