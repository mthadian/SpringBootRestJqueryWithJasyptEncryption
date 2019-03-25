package com.KCB.bank.mvcControllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController
{
	
	
	 @GetMapping("/login")
	   public String login()
	   {
		   return "esbhome/login";
	   }
	 
	 @GetMapping("/")
	   public String loginStart()
	   {
		   return "esbhome/login";
	   }
	 /**
	 @GetMapping("/login2")
	   public String login2()
	   {
		   return "esbhome/login2";
	   }
	   **/
	
	@GetMapping("/home")
	public String mainPage()
	{
		return "esbhome/index";
	}
	
	@GetMapping("/users")
	public String usersPage()
	{
		return "esbhome/users";
	}
	
	@GetMapping("/userstable")
	public String usersTable()
	{
		return "users/userstable";
	}
	/**
	@GetMapping("/header")
	public String header()
	{
		return "header";
	}
	**/
	
	
	
	@GetMapping("/domain")
	
	public String domain()
	{
		return "sysdom/domain";
	}
	
	@GetMapping("/system")
	
	public String system()
	{
		return "sysdom/system";
	}
	
	@GetMapping("/systemdomain")
	
	public String systemDomain()
	{
		return "sysdom/systemdomain";
	}
	
	@GetMapping("/sysdomhome")
	public String sysdomhome()
	{
		return "sysdom/sysdomhome";
	}
	@GetMapping("/myservices")
	public String myservices()
	{
		return "sysdom/myservices";
	}
	
	
	
	
	@GetMapping("/service")
	
	public String service()
	{
		return "service/service";
	}
   @GetMapping("/servicehome")
	
	public String serviceHome()
	{
		return "service/servicehome";
	}
   @GetMapping("/servicedestination")
	
  	public String serviceDestination()
  	{
  		return "service/servicedestination";
  	}
   
   
   @GetMapping("/rule")
	
  	public String rules()
  	{
  		return "rulconden/rule";
  	}

   @GetMapping("/ruledestination")
	
  	public String ruledestination()
  	{
  		return "rulconden/ruledestination";
  	}
   
   
   @GetMapping("/rulecondition")
   public String rulecondition()
   {
	   return "rulconden/rulecondition";
   }
   /**
   @GetMapping("/rulecondenhome")
   public String ruleconden()
   {
	   return "rulconden/rulcondenhome";
   }
   **/
   
   
   @GetMapping("/newservice")
   public String newservice()
   {
	   return "newservice";
   }
   
   @GetMapping("/newservices")
   public String newservices()
   {
	   return "esbhome/newservice";
   }
   
   
   
   
   
   
   
   
   
   
   
   
   
  	

}
