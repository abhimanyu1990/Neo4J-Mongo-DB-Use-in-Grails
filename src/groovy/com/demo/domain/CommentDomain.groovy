package com.demo.domain

import org.springframework.data.neo4j.annotation.GraphId
import org.springframework.data.neo4j.annotation.*;

@NodeEntity
class CommentDomain {
		   @GraphId
		   Long id
           String commentText
		   Date dateCreated
		   Date lastUpdated
}
