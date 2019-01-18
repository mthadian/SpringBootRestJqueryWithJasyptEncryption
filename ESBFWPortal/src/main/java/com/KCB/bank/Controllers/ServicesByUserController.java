
package com.KCB.bank.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.KCB.bank.Repos.EsbcoreServiceRepository;
import com.KCB.bank.models.EsbcoreService;


/**
 * @author Patrick Muthama
 *
 */
@RestController
public class ServicesByUserController
{
	@Autowired
	EsbcoreServiceRepository serviceRepository;
	
	@GetMapping("/api/userservices/{username}")
	public List<EsbcoreService> findByUser(@PathVariable("username") String username) throws Exception
	{
		List<EsbcoreService> userservices=serviceRepository.findByCreatedBy(username);
		if(userservices.isEmpty())
		{
			throw new Exception("No Services were found with user "+username);
		}
		else
		{
			return userservices;
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

