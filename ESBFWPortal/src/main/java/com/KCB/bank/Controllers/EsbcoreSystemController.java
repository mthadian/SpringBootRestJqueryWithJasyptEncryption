package com.KCB.bank.Controllers;

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

import com.KCB.bank.Repos.EsbcoreSystemRepository;
import com.KCB.bank.models.EsbcoreSystem;

@RestController
public class EsbcoreSystemController
{
	@Autowired
	EsbcoreSystemRepository esbcoreSystemRepo;
	
	@GetMapping("/api/systems")
	public List<EsbcoreSystem> getSystems() throws Exception
	{
		List<EsbcoreSystem> systems= esbcoreSystemRepo.findAll();
		
		if(systems.isEmpty())
		{
			throw new Exception("No Systems");
		}
		
		return systems;
	}
	
	@GetMapping("/api/systems/{systemId}")
	public Optional<EsbcoreSystem> getById(@PathVariable("systemId") String systemId) throws Exception
	{
		Optional<EsbcoreSystem> system= esbcoreSystemRepo.findById(systemId);
		if(!system.isPresent())
		{
			throw new Exception("No record found with ID "+systemId);
			
		}
		 return system;
	}
	
	@PostMapping("/api/systems")
	public EsbcoreSystem addSystem(@RequestBody EsbcoreSystem esbcoreSystem)
	{
		esbcoreSystemRepo.save(esbcoreSystem);
		return esbcoreSystem;
	}
	
	@PutMapping("/api/systems")
	public EsbcoreSystem editSystem(@RequestBody EsbcoreSystem esbcoreSystem)
	{
		esbcoreSystemRepo.save(esbcoreSystem);
		return esbcoreSystem;
	}
	
	@DeleteMapping("/api/systems/{systemId}")
	public List<EsbcoreSystem> deleteSystem(@PathVariable("systemId") String systemId) throws Exception
	{
		EsbcoreSystem delSystem= esbcoreSystemRepo.getOne(systemId);
		if(delSystem==null)
		{
			throw new Exception("No System with ID "+systemId+ " found!!!");
		}
		esbcoreSystemRepo.delete(delSystem);
		return esbcoreSystemRepo.findAll();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
