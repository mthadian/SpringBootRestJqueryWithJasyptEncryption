package com.KCB.bank.Controllers;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.KCB.bank.Repos.EsbcoreRuleRepository;
import com.KCB.bank.Repos.EsbcoreServiceRepository;
import com.KCB.bank.models.EsbcoreRule;
import com.KCB.bank.models.EsbcoreService;

@RestController
public class EsbcoreServiceController 
{
	@Autowired
	EsbcoreServiceRepository esbcoreServiceRepository;
	
	@Autowired
	EsbcoreRuleRepository ruleRepo;
	
	@GetMapping(value="/api/businessservices")
	public List<EsbcoreService> getBusinessServices() throws Exception
	{
		List<EsbcoreRule> rules=ruleRepo.findAll();
		//Query service Ids in EsbcoreRule because EsbcoreRule only has service IDs for business
		
		List<EsbcoreService> serviceIdServices = new ArrayList<EsbcoreService>();
		
		for(EsbcoreRule rule: rules)
		{
			EsbcoreService serviceid=rule.getServiceId();
			
			serviceIdServices.add(serviceid);
		
			
		}
	
		return serviceIdServices;
		
		
	}
	
	
	

	
	@GetMapping(value="/api/services")
	public List<EsbcoreService> getServices() throws Exception
	{
		List<EsbcoreService> services = esbcoreServiceRepository.findAll();
		if(services.isEmpty())
		{
			throw new Exception("No Services were found");
		}
		return services;
		
		
	}
	
	@PostMapping(value="/api/services",produces="application/json",consumes="application/json")
	public EsbcoreService addService(@RequestBody EsbcoreService esbcoreService)
	{
		esbcoreServiceRepository.save(esbcoreService);
		return esbcoreService;
	}
	
	@PutMapping(value="/api/services",produces="application/json",consumes="application/json")
	public EsbcoreService editService(@RequestBody EsbcoreService esbcoreService)
	{
		esbcoreServiceRepository.save(esbcoreService);
		return esbcoreService;
	}
	
	@DeleteMapping("/api/services/{sid}")
	public Optional<EsbcoreService> deleteService(@PathVariable("sid") BigDecimal sid) throws Exception
	{
		Optional<EsbcoreService> service= esbcoreServiceRepository.findById(sid);
		if(!service.isPresent())
		{
			throw new Exception("No items found with serviceId "+sid);
		}
		//EsbcoreService service1=findByServiceIdAndSystemDomainId
		esbcoreServiceRepository.deleteById(sid);
		return service;
		
	}
	
	@GetMapping(value="/api/services/{sid}")
	public Optional<EsbcoreService> getById(@PathVariable("sid") BigDecimal sid) throws Exception
	{
		Optional<EsbcoreService> services= esbcoreServiceRepository.findById(sid);
		if(!services.isPresent())
		{
			throw new Exception("No items found with serviceId "+sid);
		}
		return services;
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
