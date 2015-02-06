package com.demo.repository;

import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.neo4j.annotation.Query
import com.demo.domain.UserDomain;

public interface UserDomainRepository extends GraphRepository<UserDomain>{
	UserDomain findById(Long userGraphId);
	UserDomain findByUsername(String username);
	UserDomain findByToken(String token)

	@Query("Match (u:Admin) return u")
	List<UserDomain> findAllAdmin()
}

