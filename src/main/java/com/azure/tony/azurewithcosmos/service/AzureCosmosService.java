package com.azure.tony.azurewithcosmos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.azure.tony.azurewithcosmos.model.User;
import com.azure.tony.azurewithcosmos.repo.AzurecosmosRepo;


@Service
public class AzureCosmosService {
	
	
	
	@Autowired
	private  AzurecosmosRepo repo;
	
	public List<User> getUserDetails(String location) {
		
		
		return repo.findByLocation(location);
		
	}
	
	
public User saveUserDetails(User user) {
		
		
		return repo.save(user);
		
	}
	
	
	

}
