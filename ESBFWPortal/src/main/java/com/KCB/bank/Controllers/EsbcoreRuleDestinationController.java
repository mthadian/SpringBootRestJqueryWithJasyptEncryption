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

import com.KCB.bank.Repos.EsbcoreRuleDestinationRepository;
import com.KCB.bank.models.EsbcoreRule;
import com.KCB.bank.models.EsbcoreRuleDestination;

@RestController
public class EsbcoreRuleDestinationController 
{
	@Autowired
	EsbcoreRuleDestinationRepository esbcoreRuleDestinationRepository;
	
	@GetMapping("/api/ruledestinations")
	public List<EsbcoreRuleDestination> getRuleDestinations() throws Exception
	{
		List<EsbcoreRuleDestination> ruleDestinations= esbcoreRuleDestinationRepository.findAll();
		
		if(ruleDestinations.isEmpty())
		{
			throw new Exception("No items found");
		}
		
		 return ruleDestinations;
		
	}
	
	@GetMapping("/api/ruledestinations/{rdid}")
	public Optional<EsbcoreRuleDestination> getById(@PathVariable("rdid") BigDecimal rdid) throws Exception
	{
		Optional<EsbcoreRuleDestination> ruledestination = esbcoreRuleDestinationRepository.findById(rdid);
		if(!ruledestination.isPresent())
		{
			throw new Exception("No Items found with ruleDestination ID: "+rdid);
			
		}
		
		return ruledestination;
		
		
	}
	
	@GetMapping("/api/ruledestinations/rule/{rid}")
	public Optional<EsbcoreRuleDestination> findByRuleId(@PathVariable("rid") BigDecimal rid)
	{
		Optional<EsbcoreRuleDestination> ruledestination=esbcoreRuleDestinationRepository.findByRuleId_RuleId(rid);
		return ruledestination;
		
		
	}
	
	@PostMapping("/api/ruledestinations")
	public EsbcoreRuleDestination addRuleDestination(@RequestBody EsbcoreRuleDestination ruleDestination)
	{
		esbcoreRuleDestinationRepository.save(ruleDestination);
		return ruleDestination;
		
	}
	@PutMapping("/api/ruledestinations")
	public EsbcoreRuleDestination editRuleDestination(@RequestBody EsbcoreRuleDestination ruleDestination)
	{
		esbcoreRuleDestinationRepository.save(ruleDestination);
		return ruleDestination;
		
	}
	
	@DeleteMapping("/api/ruledestinations/{rdid}")
	public Optional<EsbcoreRuleDestination> deleteRuleDestination(@PathVariable("rdid") BigDecimal rdid) throws Exception
	{
		Optional<EsbcoreRuleDestination> ruledestination = esbcoreRuleDestinationRepository.findById(rdid);
		if(!ruledestination.isPresent())
		{
			throw new Exception("No Items found with ruleDestination ID: "+rdid);
		}
		esbcoreRuleDestinationRepository.deleteById(rdid);
		
		return ruledestination;
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
