package com.demo.global


import org.springframework.data.neo4j.support.Neo4jTemplate
import org.springframework.transaction.annotation.Transactional


@Transactional
class BaseOptionService {
    
	Neo4jTemplate neo4jTemplate

	/**
	 * To save neo4j entity,this method will also persist system properties(createdDate etc.) automatically.
	 * @param entity
	 * @return
	 */
	def neoSave(def entity){
		if(entity.id == null){
			entity.createdDate = new Date()
		}
		entity.lastUpdatedDate = new Date()
		log.debug(entity)
		neo4jTemplate.save(entity)
	}

	/**
	 * To find all entity of given type.
	 * @param entity
	 * @return
	 */
	def neoFindAll(def entity){
		neo4jTemplate.findAll(entity)
	}

	/**
	 * To delete entity of given type.
	 * @param entity
	 * @return
	 */
	def neoDelete(def entity){
		neo4jTemplate.delete(entity)
	}

	def neoFindOne(long id,def entity){
		neo4jTemplate.findOne(id,entity)
	}

	/**
	 * To delete relationship between nodes
	 * @return
	 */
	def neoDeleteRelationshipBetween(def entity1,def entity2,String relationship){
		neo4jTemplate.deleteRelationshipBetween(entity1,entity2,relationship)
	}

	/**
	 * 
	 * @param entity1 // start node
	 * @param entity2 // end node
	 * @param entity3 // relationship node
	 * @param relationship // relationship type
	 * @return relationship node between start node and end node
	 */
	def neoGetRelationshipBetween(def entity1,def entity2,def entity3,String relationship){
		neo4jTemplate.getRelationshipBetween(entity1,entity2,entity3,relationship)
	}

	/**
	 * for lazy load to any entity
	 * @param entity
	 * @return fully lazy loaded entity
	 */
	def neoFetch(def entity){
		neo4jTemplate.fetch(entity)
	}
	
	
	def neoCount(def entity){
		neo4jTemplate.count(entity)
	}
	
	def neoGetDomainObjectFromNode(def nodeData, def entity){
		return neo4jTemplate.convert(nodeData, entity)
	}
}