package com.wipro.training.controller;

import java.util.Collection;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.training.domain.Product;
import com.wipro.training.service.IProductService;
import com.wipro.training.util.MyCustomErrorType;

@RestController()
@RequestMapping("/product-mgmt")
public class ProductController {
	
	@Autowired
	IProductService productService;
	
	@GetMapping("/")
	public String getMessage(){
		return "Message from service";
	}
	
	@GetMapping("/read/{id}")
	public ResponseEntity<?> findById(@PathVariable int id){
		ResponseEntity<?> response = new ResponseEntity<>(new MyCustomErrorType("Not found"),HttpStatus.NOT_FOUND);
		Product product = productService.findById(id);
		if(product != null)
			 response= ResponseEntity.ok(product);
		return response;
	}
	
	@GetMapping("/read/all")
	public ResponseEntity<?> findAll(){
		ResponseEntity<?> response = new ResponseEntity<>(new MyCustomErrorType("Empty"),HttpStatus.NOT_FOUND);
		Collection<Product> products = productService.findAllProduct();
		if(products.size()>0) {
			
			 response= ResponseEntity.ok(products);
		}
		
		return response;
	}
	
	@PostMapping("/")
	public ResponseEntity<?> saveRecord(@Validated @RequestBody Product product){
		ResponseEntity<?> response = new ResponseEntity<>(new MyCustomErrorType("Cannot create"),HttpStatus.INTERNAL_SERVER_ERROR);
		//product.setId();
		if(!productService.isProductExist(product)) {
			product = productService.saveProduct(product);
			 response= new ResponseEntity<>(product,HttpStatus.CREATED);
		}
		 
		return response;
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateRecord(@PathVariable int id,  @Validated @RequestBody Product product){
		ResponseEntity<?> response = new ResponseEntity<>(new MyCustomErrorType("Cannot update"),HttpStatus.INTERNAL_SERVER_ERROR);
		product.setId(id);
		//System.out.println(productService.isProductExist(product));
		if(productService.isProductExist(product)) {
			product = productService.updateProduct(product);
			 response= new ResponseEntity<>(product,HttpStatus.ACCEPTED);
		}
		 
		return response;
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteRecord(@PathVariable int id){
		ResponseEntity<?> response = new ResponseEntity<>(new MyCustomErrorType("Cannot Delete:"+id),HttpStatus.NOT_FOUND);
		
		if(productService.findById(id)!=null) {
			productService.deleteById(id);
			 response= new ResponseEntity<>(HttpStatus.ACCEPTED);
		}
		 
		return response;
	}
	
	
	
	
	
	
}
