package com.emart.services;

import java.util.List;

import com.emart.entities.Customer;

public interface ICustomerService {

	public Customer saveCustomer(Customer c);
	public List<Customer>getAllCustomers();
	public void deleteCustomer(int cid);
	public Customer getCustomerById(int cid);
}
