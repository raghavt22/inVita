package com.emart.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emart.entities.Customer;
import com.emart.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements ICustomerService {

		@Autowired
	    private CustomerRepository customerRepo;

	    @Override
	    public Customer saveCustomer(Customer c) {
	        return customerRepo.save(c);
	    }

	    @Override
	    public List<Customer> getAllCustomers() {
	        return customerRepo.findAll();
	    }

	    @Override
	    public void deleteCustomer(int cid) {
	    	customerRepo.deleteById((long) cid);
	    }

	    @Override
	    public Customer getCustomerById(int cid) {
	        return customerRepo.findById((long) cid).get();
	    }
}

