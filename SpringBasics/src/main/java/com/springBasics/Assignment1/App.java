package com.springBasics.Assignment1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext(
                "assignment1Config.xml");

        Movie obj = (Movie) context.getBean("movieBean");
        System.out.println(obj.toString());
	}

}
