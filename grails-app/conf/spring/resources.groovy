// Place your Spring DSL code here
beans = {
	xmlns neo4j:"http://www.springframework.org/schema/data/neo4j"
	xmlns context:"http://www.springframework.org/schema/context"
	context.'component-scan'('base-package': 'com')
	neo4j.'repositories'('base-package':'com.demo.repository')
	neo4j.'config'('storeDirectory':'neo4jDev/data', 'base-package':'com.demo.domain')
	/*
	mongoAspect(com.demo.aspects.mongo.history.MongoAspectAdvice)
	aop{
		config("proxy-target-class": true) {
			aspect(id: "mongoHistory", ref: "mongoAspect") {
				before method: "beforeMethod",
				pointcut: "execution(* com.demo.global.BaseOptionService.save())"
			}
			aspect(id: "afterService", ref: "mongoAspect") {
				after method: "afterMethod",
				pointcut: "execution(* com.demo.global.BaseOptionService.save())"
			}
		}
	}
	*/
	
	
		mongoAspect(com.demo.aspects.mongo.history.MongoAspectAdvice)
	
		xmlns aop:"http://www.springframework.org/schema/aop"
		aop{
			config("proxy-target-class": true) {
				//aspect(id: "mongoAspectService", ref: "mongoAspect")
			}
		}
	
	
	/*switch(Environment.current){
		case Environment.PRODUCTION:
		   neo4j.'config'('storeDirectory':'/opt/VolcareNeo4jData', 'base-package':'com.demo.domain')
		   break
		case Environment.DEVELOPMENT:
		   neo4j.'config'('storeDirectory':'neo4jDev/data', 'base-package':'com.demo.domain')
		   break
		case Environment.TEST:
		   neo4j.'config'('storeDirectory':'neo4jTest/data', 'base-package':'com.demo.domain')
		   break
	}*/
		/*def config = ['ha.server_id': '1', 'ha.initial_hosts': '127.0.0.1:5001']
	 
		graphDbFactory(HighlyAvailableGraphDatabaseFactory)
	 */
	/*	switch(Environment.current){
			case Environment.PRODUCTION:
				graphDbBuilder(graphDbFactory: 'newHighlyAvailableDatabaseBuilder') { bean ->
					bean.constructorArgs = ['/opt/VolcareNeo4jData']
				}
				break
			case Environment.DEVELOPMENT:
			   graphDbBuilder(graphDbFactory: 'newHighlyAvailableDatabaseBuilder') { bean ->
				   bean.constructorArgs = ['neo4jDev/data']
			   }
			   break
			   case Environment.TEST:
			   graphDbBuilder(graphDbFactory: 'newHighlyAvailableDatabaseBuilder') { bean ->
				   bean.constructorArgs = ['neo4jTest/data']
			   }
			   break
		}
	 
		graphDbBuilderFinal(graphDbBuilder: 'setConfig') { bean ->
		   bean.constructorArgs = [config]
		}
	 
		graphDatabaseService(graphDbBuilderFinal: 'newGraphDatabase') { bean ->
		   bean.destroyMethod = 'shutdown'
		   
		   neo4jTemplate(Neo4jTemplate, ref('graphDatabaseService'))
		   
		   neo4j.'config'('graphDatabaseService':'graphDatabaseService','base-package':'com.volcare.domain')
		}
	*/
}
