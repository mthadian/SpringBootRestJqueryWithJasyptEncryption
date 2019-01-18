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

import com.KCB.bank.Repos.EsbcoreDomainRepository;
import com.KCB.bank.models.EsbcoreDomain;

@RestController
public class EsbcoreDomainController
{
	@Autowired
	EsbcoreDomainRepository esbcoreDomainRepo;
	
	@GetMapping("/api/domains")
	public List<EsbcoreDomain> getDomains() throws Exception
	{
		List<EsbcoreDomain> domains = esbcoreDomainRepo.findAll();
		
		if(domains.isEmpty())
		{
			throw new Exception("No Domains found!!");
		}
	
		
		return domains;
		
	}
	
	@PostMapping("/api/domains")
	public EsbcoreDomain addDomain(@RequestBody EsbcoreDomain esbcoreDomain)
	{
		esbcoreDomainRepo.save(esbcoreDomain);
		return esbcoreDomain;
		
		
	}
	
	@PutMapping("/api/domains")
	public EsbcoreDomain editDomain(@RequestBody EsbcoreDomain esbcoreDomain)
	{
		esbcoreDomainRepo.save(esbcoreDomain);
		return esbcoreDomain;
		
	}
	
	@DeleteMapping("/api/domains/{domainId}")
	public List<EsbcoreDomain> deleteDomain(@PathVariable("domainId") BigDecimal domainId)
	{
		EsbcoreDomain thisDomain= esbcoreDomainRepo.getOne(domainId);
		esbcoreDomainRepo.delete(thisDomain);
		return esbcoreDomainRepo.findAll();
		
	}
	
	
	@GetMapping("/api/domains/{domainId}")
	public Optional<EsbcoreDomain> getById(@PathVariable("domainId") BigDecimal domainId) throws Exception
	{
		Optional<EsbcoreDomain> domain= esbcoreDomainRepo.findById(domainId);
		
		if(!domain.isPresent())
		{
			throw new Exception("NO DOMAIN FOUND WITH DOMAIN ID "+domainId);
		}
		
		return domain;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}