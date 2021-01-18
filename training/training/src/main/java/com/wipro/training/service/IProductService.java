package com.wipro.training.service;

import java.util.Collection;
import java.util.List;

import com.wipro.training.domain.Product;

public interface IProductService {
	
	
	Product saveProduct(Product product);
	
	Product findById(int id);
	Product findByName(String name);
	Collection<Product> findAllProduct ();
	
	Product updateProduct(Product product);
	
	boolean deleteById(int id);
	boolean isProductExist(Product product);


}
