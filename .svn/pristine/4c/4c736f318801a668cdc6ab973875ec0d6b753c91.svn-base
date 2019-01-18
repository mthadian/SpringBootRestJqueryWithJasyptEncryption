package com.KCB.bank.Controllers;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.KCB.bank.Repos.EsbcoreServiceDestinationRepository;
import com.KCB.bank.models.EsbcoreServiceDestination;

@RestController
public class EsbcoreServiceDestinationController 
{
	@Autowired
	EsbcoreServiceDestinationRepository esbcoreServiceDestinationRepository;
	
	@GetMapping("/api/servicedestinations")
	public List<EsbcoreServiceDestination> getServiceDestinations()
	{
		List<EsbcoreServiceDestination> serviceDestinations= esbcoreServiceDestinationRepository.findAll();
		return serviceDestinations;
		
	}
	
	@GetMapping("/api/servicedestinations/{sdid}")
	public Optional<EsbcoreServiceDestination> getById(@PathVariable("sdid") BigDecimal sdid) throws Exception
	{
		Optional<EsbcoreServiceDestination> serviceDestination=esbcoreServiceDestinationRepository.findById(sdid);
		if(!serviceDestination.isPresent())
		{
			throw new Exception("No Items found with serviceDestination ID "+sdid);
		}
		 return serviceDestination;
	}
	
	@PostMapping("/api/servicedestinations")
	public EsbcoreServiceDestination addServiceDomain(@RequestBody EsbcoreServiceDestination serviceDestination) 
	{
		
		esbcoreServiceDestinationRepository.save(serviceDestination);
		return serviceDestination;
		
	}
	
	@PutMapping("/api/servicedestinations")
	public EsbcoreServiceDestination editServiceDestination(@RequestBody EsbcoreServiceDestination serviceDestination)
	{
		esbcoreServiceDestinationRepository.save(serviceDestination);
		return serviceDestination;
		
	}
	
	@DeleteMapping("/api/servicedestinations/{sdid}")
	public Optional<EsbcoreServiceDestination> deleteServiceDestination(@PathVariable("sdid") BigDecimal sdid) throws Exception
	{
		Optional<EsbcoreServiceDestination> serviceDestination=esbcoreServiceDestinationRepository.findById(sdid);
		if(!serviceDestination.isPresent())
		{
			throw new Exception("No Items found with serviceDestination ID "+sdid);
		}
		
		esbcoreServiceDestinationRepository.deleteById(sdid);
		return serviceDestination;
		
		
	}
	
	
	
	
	
	
	
	
	
	
	

}
