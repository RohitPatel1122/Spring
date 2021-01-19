package com.wipro.bankingApplication.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.bankingApplication.domain.Customer;
//import com.wipro.bankingApplication.dta.CustomerRepository;

@Service
 class CustomerServiceImp implements ICustomerService{
	
	//@Autowired
	//CustomerRepository customerRepository;
	private static int customerId ;
	private Map<Integer,Customer> customerData = new HashMap<>();
	private Map<String, Integer> PhoneIdData = new HashMap<>();
	
	public Customer saveCustomerRecord( Customer theCustomer) {
		
		if(!isCustomerExits(theCustomer)) {
			int id= getNewCustomerId();
			theCustomer.setId(id);
			customerData.put(id, theCustomer);
			PhoneIdData.put(theCustomer.getPrimaryMobileNumber(), id);
			
		}
		return theCustomer; 
		//return customerRepository.save(theCustomer);
		
	}

	private Integer getNewCustomerId() {
		// TODO Auto-generated method stub
		return ++customerId;
	}


	@Override
	public Optional<Customer> findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public boolean isCustomerExits(Customer customer) {
		// TODO Auto-generated method stub
		return PhoneIdData.containsKey(customer.getPrimaryMobileNumber());
	}
}
