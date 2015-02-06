package com.demo.domain


import org.springframework.data.neo4j.annotation.*;

@NodeEntity
class PageDomain {
	
	@GraphId
	Long id
	String pageName
	String pageDescriptions
	Boolean isActive
}
