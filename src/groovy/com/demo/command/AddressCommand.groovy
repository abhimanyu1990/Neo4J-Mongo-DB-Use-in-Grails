package com.demo.command

import com.demo.domain.AddressDomain

class AddressCommand {
	Long id
	String longitude
	String latitude
	String addressLine1
	String addressLine2
	String pincode
	
	static constraint = {
		id nullable:true
	}
	
	public getAddress(){
		AddressDomain address = new AddressDomain();
		address.id = this.id
		address.longitude = this.longitude
		address.latitude = this.latitude
		address.addressLine1 = this.addressLine1
		address.addressLine2 = this.addressLine2
		address.pincode = this.pincode
		address
	}
	
	public adaptAddress(AddressDomain address){
		this.id = address.id
		this.longitude = address.longitude
		this.latitude  = address.latitude
		this.addressLine1 = address.addressLine1
		this.addressLine2 = address.addressLine2
		this.pincode = address.pincode
	}
}
