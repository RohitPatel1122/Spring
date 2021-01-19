package com.wipro.bankingApplication.service;

import java.util.Optional;

import com.wipro.bankingApplication.domain.Customer;

public interface ICustomerService {

	Customer saveCustomerRecord(Customer theCustomer);
	
	Optional<Customer> findById(int id);
	
	boolean isCustomerExits(Customer customer);
}
