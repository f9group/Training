package com.five9group.basics;

import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.five9group.basics.PropertyInjection;

public class PropertyInjectionTest {

	public static void main(String args[]){
		
		FileSystemXmlApplicationContext  context = new FileSystemXmlApplicationContext("bean.xml");
		PropertyInjection propertyInjection = (PropertyInjection) context.getBean("propertyInjection");
		propertyInjection.printName();
		context.close();
	}
}
