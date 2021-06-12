package com.azure.tony.azurewithcosmos.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.azure.spring.data.cosmos.repository.CosmosRepository;
import com.azure.tony.azurewithcosmos.model.User;


@Repository
public interface azurecosmosRepo  extends CosmosRepository<User, String>{
	
	List<User> findByLocation(String location);

}
