package com.emart.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emart.entities.Customer;
import com.emart.services.ICustomerService;
import com.emart.userDefinedExceptions.CustomerNotFoundException;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
    private ICustomerService customerService;

    @PostMapping("/add")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.saveCustomer(customer));
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllCustomers() {
    	return new ResponseEntity<>(customerService.getAllCustomers(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable("id") int customerId) {
        if (customerService.getCustomerById(customerId) == null) {
            throw new CustomerNotFoundException("Customer not found with ID: " + customerId);
        }
        customerService.deleteCustomer(customerId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("id") int customerId) {
        Customer customer = customerService.getCustomerById(customerId);
        return customer != null ? ResponseEntity.ok(customer) : ResponseEntity.notFound().build();
    }
}