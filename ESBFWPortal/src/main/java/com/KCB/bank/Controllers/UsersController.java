package com.KCB.bank.Controllers;

import java.math.BigInteger;
import java.text.DateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.KCB.bank.Repos.AuthoritiesRepository;
import com.KCB.bank.Repos.UserRepository;
import com.KCB.bank.models.auth.Authorities;
import com.KCB.bank.models.auth.Users;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


@RestController
public class UsersController
{
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	AuthoritiesRepository authoritiesRepo;
	

	
	@GetMapping("/api/getlastroleid")
	public Authorities getLastRoleId()
	{
		return authoritiesRepo.findFirstByOrderByAuthorityidDesc();
	}
	
	
	@GetMapping(value="/api/userrolemap")
	public Map<String, Object> getUserRoleMap()
	{
		
		Map<String, Object> userandRolesMap=new HashMap<String, Object>();
		
		
		userandRolesMap.put("users", userRepo.findAll());
		userandRolesMap.put("roles", authoritiesRepo.findAll());
		
		return userandRolesMap;
		
	}
	
	@PostMapping(value="/api/users")
	public Object addNewUser(@RequestBody Map<String, Object> userMap)
	{
		Gson gson= new GsonBuilder().disableHtmlEscaping()
				 .serializeNulls()
				 .setLenient()
				 .setDateFormat(DateFormat.FULL, DateFormat.FULL)				 			
				 .create();

		
		Object raw_users=userMap.get("users");
		Object raw_roles=userMap.get("roles");
		
		Users user= gson.fromJson(raw_users.toString().trim(),Users.class);
		Authorities roles= gson.fromJson(raw_roles.toString().trim(),Authorities.class);
		
		String username=user.getUsername();
		String password=user.getPassword();
		String firstname=user.getFirstname();
		String lastname=user.getLastname();
		String email=user.getEmail();
		BigInteger enabled=user.getEnabled();
	
		String bpassword=BCrypt.hashpw(password, BCrypt.gensalt(14));
			
		
		Users user_obj=new Users();
	
		user_obj.setUsername(username);
		user_obj.setPassword(bpassword);
		user_obj.setEmail(email);
		user_obj.setEnabled(enabled);
		user_obj.setFirstname(firstname);
		user_obj.setLastname(lastname);
		
		userRepo.save(user_obj);
		

		
		authoritiesRepo.save(roles);
	
		return userMap;
	}
	
	@PutMapping(value="/api/users")
	public Object editUser(@RequestBody Map<String, Object> userMap)
	{
		Gson gson= new GsonBuilder().disableHtmlEscaping()
				 .serializeNulls()
				 .setLenient()
				 .setDateFormat(DateFormat.FULL, DateFormat.FULL)				 			
				 .create();

		
		Object raw_users=userMap.get("users");
		Object raw_roles=userMap.get("roles");
		
		Users user= gson.fromJson(raw_users.toString().trim(),Users.class);
		Authorities roles= gson.fromJson(raw_roles.toString().trim(),Authorities.class);
		
		String username=user.getUsername();
		String password=user.getPassword();
		String firstname=user.getFirstname();
		String lastname=user.getLastname();
		String email=user.getEmail();
		BigInteger enabled=user.getEnabled();
	
		String bpassword=BCrypt.hashpw(password, BCrypt.gensalt(14));
			
		
		Users user_obj=new Users();
	
		user_obj.setUsername(username);
		user_obj.setPassword(bpassword);
		user_obj.setEmail(email);
		user_obj.setEnabled(enabled);
		user_obj.setFirstname(firstname);
		user_obj.setLastname(lastname);
		
		userRepo.save(user_obj);
		

		
		authoritiesRepo.save(roles);
	
		return userMap;
	}
	

	
	@GetMapping("/api/users")
	public List<Users> getAllUsers()
	{
		return userRepo.findAll();
		
	}
	
	
	@GetMapping("/api/usersandroles")
	public List<Authorities> getAllAuthorities()
	
	{
		return authoritiesRepo.findAll();
		
	}

}
