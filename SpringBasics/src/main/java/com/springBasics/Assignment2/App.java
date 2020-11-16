package com.springBasics.Assignment2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("assignment2Config.xml");
		
        Movie obj = (Movie) context.getBean("movie");
        System.out.println(obj.toString());
	}

}
