package com.demo.domain

import org.springframework.data.neo4j.annotation.*

@RelationshipEntity(type="HAS_POST")
class UserPostRelation {
		@StartNode UserDomain user
		@EndNode PostDomain post
		
		@GraphId
		Long id
		boolean isPublished
		Date createdDate
		Date lastUpdatedDate
}
