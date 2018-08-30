package com.bank.app.pojo;



import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public  class Customer {
	@Id
	private int customerId;
	private String customerName;
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public Customer() {
	}
	public Customer(int customerId, String customerName) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
	}
	
	
}
