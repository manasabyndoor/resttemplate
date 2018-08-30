package com.bank.app.service;

import java.util.List;
import java.util.Optional;

import com.bank.app.pojo.Customer;

public interface BankService {
	
	
	public List<Customer> viewAll();
	public void addNewCustomer(Customer customer);
	public Optional<Customer> getCustomerById(int id) ;
	public void updateCustomerId(Customer customer,int customerId) ;
}
