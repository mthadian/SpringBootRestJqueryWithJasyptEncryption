
package com.KCB.bank.Controllers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.KCB.bank.Repos.EsbcoreServiceDestinationRepository;
import com.KCB.bank.Repos.EsbcoreServiceRepository;
import com.KCB.bank.models.EsbcoreService;
import com.KCB.bank.models.EsbcoreServiceDestination;


/**
 * @author Patrick Muthama
 *
 */
@RestController
public class ServicesByUserController
{
	@Autowired
	EsbcoreServiceRepository serviceRepository;
	
	@Autowired
	EsbcoreServiceDestinationRepository serviceDestinationRepo;
	
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
	
	/*
	@GetMapping("/api/userservicedestinations/{username}")
	public List<EsbcoreServiceDestination> findUserServDestinations(@PathVariable("username") String username)
	{
		List<EsbcoreService> userservices=serviceRepository.findByCreatedBy(username);
		
		List<EsbcoreServiceDestination> serviceDestinations= new ArrayList<EsbcoreServiceDestination>();
		 for(EsbcoreService userservice: userservices)
		 {
			 EsbcoreServiceDestination sdId=userservice.getServiceId();
			 sdId.get
			
			 serviceDestinations.add(sdId);
			 
		 }
		 return serviceDestinations;
		
		
	}
	*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

