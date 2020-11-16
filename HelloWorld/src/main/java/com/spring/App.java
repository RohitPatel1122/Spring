package com.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.common.HelloWorld;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext(
                "beanConfiguration.xml");

        HelloWorld obj = (HelloWorld) context.getBean("helloBean");
        obj.printHello();
	}

}
