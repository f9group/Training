package com.five9group.basics;

import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.five9group.basics.Renter;

public class RenterTest {

	public static void main (String args[]){
		FileSystemXmlApplicationContext  context = new FileSystemXmlApplicationContext("bean.xml");
		Renter renter = (Renter)context.getBean("renter");
		renter.displayCostOfHiringCar();
		context.close();
	}
}
