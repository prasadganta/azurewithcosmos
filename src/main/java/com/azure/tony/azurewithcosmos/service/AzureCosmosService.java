package com.azure.tony.azurewithcosmos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.azure.tony.azurewithcosmos.model.User;
import com.azure.tony.azurewithcosmos.repo.azurecosmosRepo;

public class AzureCosmosService {
	
	
	
	@Autowired
	public azurecosmosRepo repo;
	
	public List<User> getUserDetails(String location) {
		
		
		return repo.findByLocation(location);
		
	}
	
	

}
