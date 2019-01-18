package com.KCB.bank.Controllers;


import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DateFormat;

import java.util.HashMap;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.KCB.bank.Repos.EsbcoreDomainRepository;
import com.KCB.bank.Repos.EsbcoreRuleConditionRepository;
import com.KCB.bank.Repos.EsbcoreRuleDestinationRepository;
import com.KCB.bank.Repos.EsbcoreRuleRepository;
import com.KCB.bank.Repos.EsbcoreServiceDestinationRepository;
import com.KCB.bank.Repos.EsbcoreServiceRepository;
import com.KCB.bank.Repos.EsbcoreSystemDomainRepository;
import com.KCB.bank.Repos.EsbcoreSystemRepository;
import com.KCB.bank.models.EsbcoreDomain;
import com.KCB.bank.models.EsbcoreRule;
import com.KCB.bank.models.EsbcoreRuleCondition;
import com.KCB.bank.models.EsbcoreRuleDestination;
import com.KCB.bank.models.EsbcoreService;
import com.KCB.bank.models.EsbcoreServiceDestination;
import com.KCB.bank.models.EsbcoreSystem;
import com.KCB.bank.models.EsbcoreSystemDomain;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;



@RestController
public class NewServiceController
{
	@Autowired
	EsbcoreServiceRepository serviceRepo;
	@Autowired
	EsbcoreServiceRepository serviceRepo1;
	@Autowired
	EsbcoreRuleRepository ruleRepo;
	@Autowired
	EsbcoreRuleConditionRepository ruleConditionRepo;
	@Autowired
	EsbcoreRuleDestinationRepository ruleDestinationRepo;
	
	@Autowired
	EsbcoreServiceDestinationRepository serviceDestinationRepo;
	
	@Autowired
	EsbcoreDomainRepository domainRepo;
	
	@Autowired
	EsbcoreSystemRepository systemRepo;
	
	@Autowired
	EsbcoreSystemDomainRepository systemDomainRepo;
	
	
	@GetMapping(value="/api/allservices")
	public Map<String, Object> getAllServices()
	{
		
		Map<String, Object> servicesMap=new HashMap<String, Object>();
		
		
		servicesMap.put("services", serviceRepo.findAll());
		servicesMap.put("rules", ruleRepo.findAll());
		servicesMap.put("ruleConditions", ruleConditionRepo.findAll());
		servicesMap.put("ruleDestinations", ruleDestinationRepo.findAll());
		servicesMap.put("serviceDestinations", serviceDestinationRepo.findAll());
		
		return servicesMap;
		
	}
	
	@GetMapping(value="/api/lastserviceid")
	public EsbcoreService getLastServiceID()
	{
		return serviceRepo.findFirstByOrderByServiceIdDesc();
		
	
	}
	@GetMapping(value="/api/lastruleid")
	public EsbcoreRule getLastRuleID()
	{
		return ruleRepo.findFirstByOrderByRuleIdDesc();
		
	
	}
	
	@GetMapping(value="/api/lastrulecondid")
	public EsbcoreRuleCondition getLastRuleCondID()
	{
		return ruleConditionRepo.findFirstByOrderByRuleConditionIdDesc();
		
	
	}
	@GetMapping(value="/api/lastruledestid")
	public EsbcoreRuleDestination getLastRuleDestID()
	{
		return ruleDestinationRepo.findFirstByOrderByRuleDestinationIdDesc();

	}
	
	@GetMapping(value="/api/lastdomainid")
	public EsbcoreDomain getLastDomainID()
	{
		return domainRepo.findFirstByOrderByDomainIdDesc();
	
	}
	
	@GetMapping(value="/api/lastsystemid")
	public EsbcoreSystem getLastSystemID()
	{
		return systemRepo.findFirstByOrderBySystemCodeDesc();
	}
	
	@GetMapping(value="/api/lastsysdomid")
	public EsbcoreSystemDomain getLastSysDomID()
	{
		return systemDomainRepo.findFirstByOrderBySystemDomainIdDesc();
	}
	
	@GetMapping(value="/api/systemdomain/{sys}/{dom}")
	public Optional<EsbcoreSystemDomain> getBySystemAndDomain(@PathVariable("sys") String sys,@PathVariable("dom") BigInteger dom)
	{
		return systemDomainRepo.findBySystemCode_SystemCodeAndDomainId(sys, dom);
	}
	
	
	@PostMapping(value="/api/allservices")
	public Object addnewservice(@RequestBody Map<String, Object> datamap)
	{
		 Gson gson= new GsonBuilder().disableHtmlEscaping()
				 .serializeNulls()
				 .setLenient()
				 .setDateFormat(DateFormat.FULL, DateFormat.FULL)				 			
				 .create();
		 
		
			    			     
		 Object esbcoreService_T=datamap.get("services_T");
		 Object esbcoreService_B=datamap.get("services_B");
		 Object esbcoreRule=datamap.get("rules");
		 Object esbcoreRuleCondition =datamap.get("ruleConditions");
		 Object esbcoreRuleDestination=datamap.get("ruleDestinations");
		 Object esbcoreServiceDestination=datamap.get("serviceDestinations");
		 
		 
		
		 EsbcoreService service_B=gson.fromJson(esbcoreService_B.toString().trim(),EsbcoreService.class);
		EsbcoreService service_T=gson.fromJson(esbcoreService_T.toString().trim(),EsbcoreService.class);
		
		EsbcoreRule rule= gson.fromJson(esbcoreRule.toString().trim(),EsbcoreRule.class);
		//EsbcoreService serviceT=gson.fromJson(esbcoreServiceT.toString(),EsbcoreService.class);
		EsbcoreRuleCondition ruleCondition=gson.fromJson(esbcoreRuleCondition.toString().trim(),EsbcoreRuleCondition.class);
		EsbcoreRuleDestination ruleDestination=gson.fromJson(esbcoreRuleDestination.toString().trim(),EsbcoreRuleDestination.class);
		EsbcoreServiceDestination serviceDestination=gson.fromJson(esbcoreServiceDestination.toString().trim(),EsbcoreServiceDestination.class);
	

		serviceRepo.save(service_B);
		serviceRepo.save(service_T);
	
		
		ruleRepo.save(rule);
		ruleConditionRepo.save(ruleCondition);
		ruleDestinationRepo.save(ruleDestination);
		serviceDestinationRepo.save(serviceDestination);
		
		
		
		
	
		return datamap;
		
	}
	
	
	
	@PostMapping(value="/api/technicalservices")
	public Object addnewservicefromBusiness(@RequestBody Map<String, Object> datamap)
	{
		 Gson gson= new GsonBuilder().disableHtmlEscaping()
				 .serializeNulls()
				 .setLenient()
				 .setDateFormat(DateFormat.FULL, DateFormat.FULL)				 			
				 .create();
		 
		
			    			     
		 Object esbcoreService_T=datamap.get("services_T");
		 //Object esbcoreService_B=datamap.get("services_B");
		 Object esbcoreRule=datamap.get("rules");
		 Object esbcoreRuleCondition =datamap.get("ruleConditions");
		 Object esbcoreRuleDestination=datamap.get("ruleDestinations");
		 Object esbcoreServiceDestination=datamap.get("serviceDestinations");
		 
		 
		
		// EsbcoreService service_B=gson.fromJson(esbcoreService_B.toString().trim(),EsbcoreService.class);
		EsbcoreService service_T=gson.fromJson(esbcoreService_T.toString().trim(),EsbcoreService.class);
		
		EsbcoreRule rule= gson.fromJson(esbcoreRule.toString().trim(),EsbcoreRule.class);
		//EsbcoreService serviceT=gson.fromJson(esbcoreServiceT.toString(),EsbcoreService.class);
		EsbcoreRuleCondition ruleCondition=gson.fromJson(esbcoreRuleCondition.toString().trim(),EsbcoreRuleCondition.class);
		EsbcoreRuleDestination ruleDestination=gson.fromJson(esbcoreRuleDestination.toString().trim(),EsbcoreRuleDestination.class);
		EsbcoreServiceDestination serviceDestination=gson.fromJson(esbcoreServiceDestination.toString().trim(),EsbcoreServiceDestination.class);
	

		//serviceRepo.save(service_B);
		serviceRepo.save(service_T);
	
		
		ruleRepo.save(rule);
		ruleConditionRepo.save(ruleCondition);
		ruleDestinationRepo.save(ruleDestination);
		serviceDestinationRepo.save(serviceDestination);
		
		
		
		
	
		return datamap;
		
	}
	

}
