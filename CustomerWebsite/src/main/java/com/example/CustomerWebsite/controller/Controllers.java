package com.example.CustomerWebsite.controller;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.CustomerWebsite.pojo.Customer;
import com.google.gson.Gson;

@Controller
public class Controllers {
	@RequestMapping("/home")
	public String home() {
		return "home";
	}

	@RequestMapping(value = "/customers", method = RequestMethod.GET)
	public String getAllEmployeesXML(Model model) {
		final String uri = "http://localhost:8080/view";

		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<List<Customer>> response = restTemplate.getForObject(uri, ResponseEntity.class);
		System.out.println("gh");
		/*Gson gson = new Gson();
		ResponseEntity<List<Customer>> list = gson.fromJson("employees", (Type) response);*/
		System.out.println(response);
		model.addAttribute("employee", response);
		return "website";

	}

}
