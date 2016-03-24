package com.five9group.basics;

import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.five9group.basics.HelloWorld;

public class TestingHelloWorld {

	public static void main(String args[]){
		FileSystemXmlApplicationContext  context = new FileSystemXmlApplicationContext("bean.xml");
		HelloWorld helloWorld = (HelloWorld) context.getBean("helloWorld");
     	helloWorld.sayHello();
     	context.close();
		
	}
}
