package com.demo.command

import com.demo.domain.PageDomain

class PageCommand {
	Long id 
	String pageName
	String pageDescriptions
	boolean isActive
	
	static constraints = {
		id nullable:true
		pageName nullable:false
		pageDescriptions nullable:false
	}
	
	public getPage(){
		PageDomain page = new PageDomain();
		page.id = this.id
		page.pageName = this.pageName
		page.pageDescriptions = this.pageDescriptions
		page.isActive = this.isActive
		page
	}
	
	public adaptPage(PageDomain page){
		this.id = page.id
		this.pageName = page.pageName
		this.pageDescriptions = page.pageDescriptions
		this.isActive = page.isActive
		
	}
}
