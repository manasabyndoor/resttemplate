package com.bank.app;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.bank.app.pojo.Customer;
import com.bank.app.service.BankServiceImpl;


@SpringBootApplication
public class App 
{
	
	 private static final Logger logger= LogManager.getLogger(App.class);
    public static void main( String[] args )
    {
        SpringApplication.run(App.class,args);
    
		//logger.error("error");
    }
   
    
    @Bean
    public CommandLineRunner initialer(BankServiceImpl service) {
    	return (args)-> {
    	    logger.info("info");
    		//logger.error("error");
    		//logger.fatal("info");
    		
    		service.addNewCustomer(new Customer(12,"fs"));
    		service.addNewCustomer(new Customer(13,"sdf"));
    		service.addNewCustomer(new Customer(14,"fs"));
    		service.addNewCustomer(new Customer(15,"sdf"));
    		/*service.addNewCustomer(new Customer("16","fs"));
    		service.addNewCustomer(new Customer("17","sdf"));
    		service.addNewCustomer(new Customer("18","fs"));
    		service.addNewCustomer(new Customer("19","sdf"));
    		service.addNewCustomer(new Customer("10","fs"));
    		service.addNewCustomer(new Customer("1","sdf"));
    		service.addNewCustomer(new Customer("2","fs"));
    		service.addNewCustomer(new Customer("3","sdf"));
    	*/
    		
    		
    	};
    }
}
