package com.azure.tony.azurewithcosmos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.azure.tony.azurewithcosmos.model.User;
import com.azure.tony.azurewithcosmos.service.AzureCosmosService;

@RestController
public class AzurewithcosmosController {
	
	@Autowired
	private AzureCosmosService azureService;
	
	@GetMapping(path="/getuserdata/{location}")
	public List<User> getuserdata(@PathVariable String location) {
		 
		return azureService.getUserDetails(location);
	}
	
	

}
