package com.bank.app.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import com.bank.app.exception.CustomerNotFoundException;
import com.bank.app.pojo.Customer;
import com.bank.app.service.BankServiceImpl;
//@CrossOrigin

@RestController
public class BankController {
	@Autowired
	BankServiceImpl service;

	//private static final Logger logger= (Logger) LoggerFactory.getLogger(BankController.class);

	@RequestMapping("/view")
	public ResponseEntity<List<Customer>> viewAll() throws CustomerNotFoundException{
		//logger.info("Returning all the ToDo´s");
		List<Customer> list=new ArrayList<>();
		System.out.println(service.viewAll());
		list= service.viewAll();
		if(list.size()<=0)
		{
			throw new CustomerNotFoundException("nit found");
		}
		return new ResponseEntity<List<Customer>>(service.viewAll(), HttpStatus.OK);
	}

	@RequestMapping(value="/view/{start}/{count}",method=RequestMethod.GET)
	public Resources getCustomerByPages(@PathVariable int start,@PathVariable int count) {
		
		List<Customer> tempCustomer=service.viewAll();
		List<Customer> customer=new ArrayList<>();
		for(int i=start-1;i<(start+count)-1;i++) {
			customer.add(tempCustomer.get(i));
		}

		Link nextLink=linkTo(methodOn(this.getClass()).getCustomerByPages(start+count,count)).withRel("nextlink");
		Link prevLink=linkTo(methodOn(this.getClass()).getCustomerByPages(start-count>=0?start-count:1,count)).withRel("prevlink");
		return new Resources<>(customer,nextLink,prevLink);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/add") 
	public void addNewCustomer(@RequestBody Customer customer) {
		service.addNewCustomer(customer);
	}

	@RequestMapping("/view/{customerId}")
	public ResponseEntity<Optional<Customer>> getCustomerById(@PathVariable int customerId) throws CustomerNotFoundException{
		Customer customer=new Customer();
		Optional<Customer> customers=service.getCustomerById((customerId));
		//List<Customer> customerlist=service.viewAll();
		//Link newLink =linkTo(methodOn(this.getClass()).viewAll()).withRel("viewall");
		if(customers==null||customer.getCustomerId()<=0) {
			throw new CustomerNotFoundException("Customer doesn't exists");
		}
		return new ResponseEntity<Optional<Customer>>(service.getCustomerById(customerId), HttpStatus.OK);


	}
	@RequestMapping(method=RequestMethod.PUT,value="/update/{customerId}")
	public void updateById(@RequestBody Customer customer,@PathVariable int customerId) {
		service.updateCustomerId(customer,customerId);
	}
	
	

}
