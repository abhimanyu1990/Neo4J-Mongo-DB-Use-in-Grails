package com.demo.domain

import org.springframework.data.neo4j.annotation.GraphId
import org.springframework.data.neo4j.annotation.*;

@NodeEntity
class AddressDomain {
	@GraphId
	Long id
	String longitude
	String latitude
	String addressLine1
	String addressLine2
	String pincode
	
	
}
