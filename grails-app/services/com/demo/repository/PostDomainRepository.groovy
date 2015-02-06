package com.demo.repository

import org.springframework.data.neo4j.repository.GraphRepository;

import com.demo.domain.PostDomain;

public interface PostDomainRepository extends GraphRepository<PostDomain>{
	PostDomain findById(Long postGraphId);
}
