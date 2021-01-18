package com.wipro.training.client;

import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.wipro.training.domain.Product;

public class TestUsingClientRestTemplate {

	private static final String URL= "http://localhost:8080/product-mgmt/";
	static RestTemplate template= null;
	static {
		 template= new RestTemplate();
	}
	private static void getMessage() {
		String message= template.getForObject(URL, String.class);
		System.out.println("********"+message+"************");
	}
	
	private static void getProduct(int id) {
		System.out.println("********GET PRODUCT WITH ID 1************");
		Product message= template.getForObject(URL+"/read/"+id, Product.class);
		System.out.println("********"+message+"************");
	}
	
	private static void saveRecord() {
		System.out.println("********SAVE PRODUCT************");
		Product newProduct = new Product("mobile","china",1234.4f);
		ResponseEntity<?> response = template.postForEntity(URL, newProduct, Object.class);
		System.out.println("********PRODUCT SAVED: "+response.getBody()+"************");
	}
	
	private static void updateRecord(int id) {
		System.out.println("********UPDATE PRODUCT WITH ID:"+id+"************");
		Product newProduct = new Product("mobile","china",1244.4f);
		RequestEntity <?> requestEntity = RequestEntity.put(URL+"/"+id).body(newProduct);
		ResponseEntity<?> response = template.exchange(requestEntity, Object.class);
		System.out.println("********"+response.getBody()+"************");
	}
	
	private static void deleteRecord(int id) {
		System.out.println("********DELETE PRODUCT WITH ID:"+id+"************");
		RequestEntity <?> requestEntity = RequestEntity.delete(URL+"/"+id).build();
		ResponseEntity<?> response = template.exchange(requestEntity, ResponseEntity.class);
		System.out.println("*******DELETION DONE************");
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getMessage();
		saveRecord();
		getProduct(1);
		updateRecord(1);
		deleteRecord(1);
		try {
		getProduct(1);
		}catch(HttpClientErrorException ex) {
			System.out.println(ex.getMessage());
		}
	}

}
