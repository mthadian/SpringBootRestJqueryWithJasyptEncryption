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

import com.KCB.bank.Repos.EsbcoreRuleConditionRepository;
import com.KCB.bank.models.EsbcoreRuleCondition;

@RestController
public class EsbcoreRuleConditionController
{
	@Autowired
	EsbcoreRuleConditionRepository esbcoreRuleConditionRepository;
	
	@GetMapping("/api/ruleconditions")
	public List<EsbcoreRuleCondition> getRuleConditions() throws Exception
	{
		List<EsbcoreRuleCondition> ruleConditions = esbcoreRuleConditionRepository.findAll();
		
		if(ruleConditions.isEmpty())
		{
			throw new Exception("No items found");
		}
		
		return ruleConditions;
		
	}
	
	@GetMapping("/api/ruleconditions/{rcid}")
	public Optional<EsbcoreRuleCondition> getById(@PathVariable("rcid") BigDecimal rcid) throws Exception
	{
		Optional<EsbcoreRuleCondition> ruleCondition=esbcoreRuleConditionRepository.findById(rcid);
		if(!ruleCondition.isPresent())
		{
			throw new Exception("No Items found using Id: "+rcid);
		}
		return ruleCondition;
		
	}
	@PostMapping("/api/ruleconditions")
	public EsbcoreRuleCondition addRuleCondition(@RequestBody EsbcoreRuleCondition ruleCondition)
	{
		esbcoreRuleConditionRepository.save(ruleCondition);
		return ruleCondition;
		
	}
	
	@PutMapping("/api/ruleconditions")
	public EsbcoreRuleCondition editRuleCondition(@RequestBody EsbcoreRuleCondition ruleCondition)
	{
		esbcoreRuleConditionRepository.save(ruleCondition);
		return ruleCondition;
		
	}
	
	@DeleteMapping("/api/ruleconditions/{rcid}")
	public Optional<EsbcoreRuleCondition> deleteRuleCondition(@PathVariable("rcid") BigDecimal rcid) throws Exception
	{
		Optional<EsbcoreRuleCondition> ruleCondition=esbcoreRuleConditionRepository.findById(rcid);
		if(!ruleCondition.isPresent())
		{
			throw new Exception("No Items found with ID: "+rcid);
		}
		esbcoreRuleConditionRepository.deleteById(rcid);
		return ruleCondition;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
