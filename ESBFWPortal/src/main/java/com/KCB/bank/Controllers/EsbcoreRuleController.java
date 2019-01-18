package com.KCB.bank.Controllers;

import java.math.BigDecimal;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.KCB.bank.Repos.EsbcoreRuleRepository;
import com.KCB.bank.Repos.EsbcoreServiceRepository;
import com.KCB.bank.models.EsbcoreRule;

@RestController
public class EsbcoreRuleController 
{
	@Autowired
	EsbcoreRuleRepository esbcoreRuleRepository;
	
	
	
	@GetMapping(value="/api/rules")
	public List<EsbcoreRule> getRules()
	{
		List<EsbcoreRule> rules=esbcoreRuleRepository.findAll();
		return rules;
	}
	
	@GetMapping(value="/api/rules/service/{sid}")
	public Optional<EsbcoreRule> findByServiceId(@PathVariable("sid") BigDecimal sid)
	{
		List<EsbcoreRule> rules=esbcoreRuleRepository.findByServiceId_ServiceId(sid);
		Optional<EsbcoreRule> ruleservice= esbcoreRuleRepository.findFirstByServiceId_ServiceIdOrderByRuleOrderDesc(sid);
		return ruleservice;
	}
	
	@GetMapping("/api/rules/{rid}")
	public Optional<EsbcoreRule> getById(@PathVariable("rid") BigDecimal rid) throws Exception
	{
		Optional<EsbcoreRule> rule=esbcoreRuleRepository.findById(rid);
		if(!rule.isPresent())
		{
			throw new Exception("No Item found with rule ID "+rid);
		}
		
		return rule;
	}
	
	@PostMapping(value="/api/rules",produces="application/json",consumes="application/json")
	public EsbcoreRule addRule(@RequestBody EsbcoreRule rule) throws Exception
	{
		if(rule.equals(null))
		{
			throw new Exception("No items to add");
		}
		esbcoreRuleRepository.save(rule);
		return rule;
		
	}
	/*

	@PostMapping("/api/rulepost")
	public @ResponseBody EsbcoreRule saveRule(EsbcoreRule esbcoreRule)
	{
		esbcoreRuleRepository.save(esbcoreRule);
		return esbcoreRule;
		
	}
	*/
	
	
	@PutMapping("/api/rules")
	public EsbcoreRule editRules(@RequestBody EsbcoreRule rule)
	{
		esbcoreRuleRepository.save(rule);
		return rule;
		
	}
	
	@DeleteMapping("/api/rules/{rid}")
	public Optional<EsbcoreRule> deleteRule(@PathVariable("rid") BigDecimal rid) throws Exception
	{
		Optional<EsbcoreRule> rule=esbcoreRuleRepository.findById(rid);
		if(!rule.isPresent())
		{
			throw new Exception("No item found with Rule Id "+rid);
		}
		esbcoreRuleRepository.deleteById(rid);
		return rule;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}