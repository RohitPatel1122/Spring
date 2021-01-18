package com.wipro.training.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.wipro.training.domain.Product;

@Service 
public class ProductService implements IProductService{
	static int num =0;
	Map<Integer, Product> products = new HashMap<>();
	Map<String, Integer> productsByName = new HashMap<>();
	
	@Override
	public Product findById(int id) {
		// TODO Auto-generated method stub
		return products.get(id);
	}

	@Override
	public Product findByName(String name) {
		// TODO Auto-generated method stub
		return productsByName.get(name) != null?products.get(productsByName.get(name)):null;
	}

	@Override
	public Product saveProduct(Product product) {
		// TODO Auto-generated method stub
		product.setId(getId());
		products.put(product.getId(), product);
		productsByName.put(product.getName(), product.getId());
		return product;
	}

	private int getId() {
		// TODO Auto-generated method stub
		return ++num;
	}

	@Override
	public Product updateProduct(Product product) {
		products.put(product.getId(), product);
		productsByName.put(product.getName(), product.getId());
		return product;
	}

	@Override
	public boolean isProductExist(Product product) {
		// TODO Auto-generated method stub
		if(products.get(product.getId()) != null)
			return true;
		if(productsByName.get(product.getName()) != null)
			return true;
		return false;
	}

	@Override
	public Collection<Product> findAllProduct() {
		// TODO Auto-generated method stub
		return products.values();
	}

	@Override
	public boolean deleteById(int id) {
		// TODO Auto-generated method stub
		Product product = products.get(id);
		if(product!=null) {
			products.remove(id);
			productsByName.remove(product.getName());
			return true;
		}
		return false;
	}

	@Override
	public boolean isProductExistById(int id) {
		// TODO Auto-generated method stub
		if(products.get(id) != null)
			return true;
		return false;
	}
	
	

}
