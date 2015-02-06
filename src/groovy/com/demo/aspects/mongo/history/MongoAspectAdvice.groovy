package com.demo.aspects.mongo.history;

import grails.transaction.Transactional
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.aspectj.lang.annotation.After
import org.aspectj.lang.annotation.*
import org.springframework.stereotype.Component
import com.mongo.*
import org.codehaus.groovy.grails.web.context.ServletContextHolder as SCH
import org.codehaus.groovy.grails.web.servlet.GrailsApplicationAttributes as GA

@Aspect
public class MongoAspectAdvice {
	def ctx
	
	
	@Pointcut("execution(* com.demo.global.BaseOptionService.neoSave(..))")
  	private void selectAll(){}
	
	
	@AfterReturning(pointcut = "selectAll()", returning="obj")
	public void afterReturningAdvice(Object obj){
		ctx = SCH.servletContext.getAttribute(GA.APPLICATION_CONTEXT)
		def commonService = ctx.commonService
		commonService.doObjectProcess(obj)
		
	}
	
	
	@After("selectAll()")
	public void  afterMethod2(){
		//nothing to execute
	}
	
	@Before("selectAll()")
	public void  beforeMethod2(){
		//nothing to execute
	}
}
