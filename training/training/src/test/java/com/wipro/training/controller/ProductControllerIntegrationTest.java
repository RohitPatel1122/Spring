package com.wipro.training.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import com.wipro.training.domain.Product;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
class ProductControllerIntegrationTest {

	@LocalServerPort
	private Integer randomPort;
	@Autowired
	private TestRestTemplate testRestTemplate;
	private static Product p1;
	private static Product p5;
	private static Product p4;
	private static Product p3;
	private static Product p2;
	private static  String URL;
	@BeforeAll
	static void init() {
		p1 = new Product("TV","Sony", "China",1234.4f);
		p2 = new Product("TV","LG", "South Korea",1224.4f);
		p3 = new Product("Mobile","Apple", "China",324.4f);
		p4 = new Product("Mobile","One+", "China",234.4f);
		p5 = new Product("Mobile","Sony", "Korea",134.4f);
	}
	@BeforeEach
	void setup() {
		URL= "http://localhost:"+randomPort+"/product-mgmt/";
	}
	
	@AfterAll
	static void destory() {
		p1= null;p2= null;
		p3= null;p4= null;p5= null;
	}
	@Test
	void testgetMessage() {
		String message = testRestTemplate.getForObject(URL, String.class);
		assertEquals("Message from service", message);
	}
	
	@Test
	void testCreateRecord() {
		Product product = testRestTemplate.postForObject(URL, p1, Product.class);
		assertNotNull(product);
		assertNotEquals(0, product.getId());
		assertEquals("TV", product.getName());
	}
	
	@Test
	void testGetRecordById() {
		Product product = testRestTemplate.getForObject(URL+"/read/1", Product.class);
		assertNotNull(product);		
	}
	
	@Test
	void testDeleteRecordById() {
		testRestTemplate.delete(URL+"/1");
		Product product = testRestTemplate.getForObject(URL+"/read/1", Product.class);
		assertNull(product.getName());		
	}

}

