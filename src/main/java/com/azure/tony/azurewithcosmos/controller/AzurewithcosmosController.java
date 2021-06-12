package com.azure.tony.azurewithcosmos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AzurewithcosmosController {
	
	@GetMapping(path="/getempData/{location}")
	public String getempdata(@PathVariable String location) {
		 
		return "Hello World!!! welcome to "+location;
	}
	
	

}
