package com.bank.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bank.app.dao.Bankdao;
import com.bank.app.pojo.Customer;

@Component
public class BankServiceImpl implements BankService {

	@Autowired
	Bankdao dao;

	@Override
	public void addNewCustomer(Customer customer) {
		dao.save(customer);

	}

	@Override
	public Optional<Customer> getCustomerById(int customerId) {

		return dao.findById(customerId);
	}

	@Override
	public void updateCustomerId(Customer customer, int customerId) {
		dao.save(customer);
	}

	@Override
	public List<Customer> viewAll() {

		return dao.findAll();
	}

}
