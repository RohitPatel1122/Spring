package com.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.ioc.config.Assignment1Config;
import com.ioc.models.Student;
import com.ioc.models.Test;

@ComponentScan("com.ioc.config")
public class Assignment1App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new AnnotationConfigApplicationContext(Assignment1Config.class);
		Test test = context.getBean("testBean",Test.class);
		test.setTestId("1");
		test.setTestmarks("90");
		test.setTestTitle("Java Test");
		
		Test test1 = context.getBean("testBean",Test.class);
		test1.setTestId("2");
		test1.setTestmarks("80");
		test1.setTestTitle("Science Test");
		
		Student student1 = context.getBean("studentBean",Student.class);
		
		student1.setStudentId("1");
		student1.setStudentName("Rohit");
		student1.getStudentTest().add(test);
		student1.getStudentTest().add(test1);
		
		Student student2 = context.getBean("studentBean",Student.class);
		student2.setStudentId("2");
		student2.setStudentName("Raj");
		student2.getStudentTest().add(test);
		
		System.out.println(student1.toString());
		System.out.println(student2.toString());
		
	}

}
