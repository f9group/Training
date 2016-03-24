package com.five9group.basics;

public class PropertyInjection {

	private String firstName;

	//Get and Set methods
	public final String getFirstName() {
		return this.firstName;
	}

	public final void setFirstName(final String firstName) {
		this.firstName = firstName;
	}
	
	public void printName(){
		System.out.println(this.firstName);
	}
	
}
