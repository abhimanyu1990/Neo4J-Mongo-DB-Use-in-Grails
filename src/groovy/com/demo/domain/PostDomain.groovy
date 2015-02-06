package com.demo.domain


import java.util.Date;
import java.util.Set;

import org.springframework.data.neo4j.annotation.*;



@NodeEntity
class PostDomain {
	
	 @GraphId
	 Long id
     String postText
	  Date createdDate
      Date lastUpdatedDate
	 String longitude
	 String latitude
	 
	 @RelatedTo(type='HAS_USER')
	 UserDomain user
}
