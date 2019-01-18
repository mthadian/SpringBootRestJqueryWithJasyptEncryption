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

import com.KCB.bank.Repos.EsbcoreSystemDomainRepository;
import com.KCB.bank.models.EsbcoreSystemDomain;


@RestController
public class EsbcoreSystemDomainController
{
	@Autowired
	EsbcoreSystemDomainRepository esbcoreSystemDomainRepository;
	
	@GetMapping("/api/systemdomains")
	public List<EsbcoreSystemDomain> getSystemDomains() throws Exception
	{
		List<EsbcoreSystemDomain> systemDomains= esbcoreSystemDomainRepository.findAll();
		if(systemDomains.isEmpty())
		{
			throw new Exception("No systemdomains found");
		}
		
		return systemDomains;
		
	}
	
	@GetMapping("/api/systemdomains/{sdId}")
	public Optional<EsbcoreSystemDomain> getById(@PathVariable("sdId") BigDecimal sdId) throws Exception
	{
		Optional<EsbcoreSystemDomain> esbcoreSystemDomain= esbcoreSystemDomainRepository.findById(sdId);
		if(!esbcoreSystemDomain.isPresent())
		{
			throw new Exception("No Items found with the ID "+sdId);
		}
		
		return esbcoreSystemDomain;
	}
	
	@PostMapping("/api/systemdomains")
	public EsbcoreSystemDomain addSystemDomain(@RequestBody EsbcoreSystemDomain esbcoreSystemDomain)
	{
		esbcoreSystemDomainRepository.save(esbcoreSystemDomain);
		return esbcoreSystemDomain;
		
	}
	
	@PutMapping("/api/systemdomains")
	public EsbcoreSystemDomain editSystemDomain(@RequestBody EsbcoreSystemDomain esbcoreSystemDomain)
	{
		esbcoreSystemDomainRepository.save(esbcoreSystemDomain);
		return esbcoreSystemDomain;
	}
	
	@DeleteMapping("/api/systemdomains/{sdId}")
	public List<EsbcoreSystemDomain> deleteSystemDomain(@PathVariable("sdId") BigDecimal sdId)
	{
		EsbcoreSystemDomain systemDomain=esbcoreSystemDomainRepository.getOne(sdId);
		esbcoreSystemDomainRepository.delete(systemDomain);
		return esbcoreSystemDomainRepository.findAll();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
