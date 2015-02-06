package com.demo.domain

import org.springframework.data.neo4j.annotation.GraphId
import org.springframework.data.neo4j.annotation.*;

@NodeEntity
class LikesDomain {
	
	   @GraphId
	   Long id
	   boolean isLike
       Date dateCreated 
	   Date lastUpdated
}
