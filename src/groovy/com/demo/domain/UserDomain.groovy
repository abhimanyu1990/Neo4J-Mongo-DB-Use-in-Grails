package com.demo.domain

import java.util.Collection;
import java.util.Date;
import java.util.Set;

import org.springframework.data.annotation.TypeAlias
import org.springframework.data.neo4j.annotation.*;
import org.neo4j.graphdb.Direction

@NodeEntity
class UserDomain {
	
  @GraphId
  Long id
  String username
  String password 
  String email
  String phonenumber
  boolean isActive 
  String token
  String role
  Date createdDate
  Date lastUpdatedDate
  @Labels
  Collection<String> labels ;
  
  @RelatedToVia(type='HAS_POST',direction = Direction.BOTH)
  Set<UserPostRelation> UserPostRelation
  
  
  public Collection<String> getLabels() {
	  return labels;
  }

  public void addLabel(String label) {
	  HashSet<String> newLabels = new HashSet<>(this.labels);
	  if (newLabels.add(label)) this.labels = newLabels;
  }
}
