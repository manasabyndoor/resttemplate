package com.bank.app.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.bank.app.pojo.Customer;
import com.bank.app.service.BankServiceImpl;

@RestController
public class BankController {
	@Autowired
	BankServiceImpl service = new BankServiceImpl();

	@RequestMapping("/view")
	public List<Customer> viewAll() {
		System.out.println(service.viewAll());
		return service.viewAll();
	}

	@RequestMapping(method = RequestMethod.POST, value = "/add")
	public void addNewCustomer(@RequestBody Customer customer) {
		service.addNewCustomer(customer);
	}

	@RequestMapping("/view/{customerId}")
	public Customer getCustomerById(@PathVariable String customerId) {
		return service.getCustomerById((customerId));

	}
	@RequestMapping(method=RequestMethod.PUT,value="/update/{customerId}")
	public void updateById(@RequestBody Customer customer,@PathVariable String customerId) {
		service.updateCustomerId(customer,customerId);
	}
	

}
