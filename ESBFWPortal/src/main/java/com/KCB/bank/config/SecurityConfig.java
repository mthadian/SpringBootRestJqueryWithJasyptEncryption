

package com.KCB.bank.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author Patrick Muthama
 *
 */
@Configuration
@EnableWebSecurity


public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
    DataSource dataSource;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
		//return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}

	//Enable jdbc authentication
	
    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
        .usersByUsernameQuery("select username, password,1 as enabled from sys.users where username=?")
        //.usersByUsernameQuery("select username, password,1 as enabled from users where username=?")
        
        .authoritiesByUsernameQuery("select username,authority from sys.authorities where username=?")
        //.authoritiesByUsernameQuery("select username,authority from authorities where username=?")
        .passwordEncoder(passwordEncoder());

    }
    

	
    /**
	// InMemory authentication : User --> Roles
	
	@Autowired
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.inMemoryAuthentication()		
		.withUser("user1").password("{noop}user1").roles("USER")
		.and()
		.withUser("admin1").password("{noop}admin1").roles("USER", "ADMIN");
	}
	
	**/
	
	
	@Override
	public void configure(WebSecurity web) throws Exception {
	    web.ignoring().antMatchers("/esbhome/**");
	    web.ignoring().antMatchers("/*.css");
	    web.ignoring().antMatchers("/*.js");
	    web.ignoring().antMatchers("/*.html");
	}
	

	// Authorization : Role -> Access
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
			.headers()
	        .frameOptions().disable()
         //.and()
			//.httpBasic()
		.and()
			.authorizeRequests()
			//.antMatchers("/newservice").hasRole("USER")
			.antMatchers("/bootstrap/**").permitAll()
			.antMatchers("/js/**").permitAll()
			.antMatchers("/javascript/**").permitAll()
			.antMatchers("/jquerysteps/**").permitAll()
			.antMatchers("/css/**").permitAll()
			.antMatchers("/favicon.ico/**").permitAll()
			.antMatchers("/fonts/**").permitAll()
			
			.antMatchers("/").permitAll()
			.antMatchers("/login").permitAll()
			
			
			//.antMatchers("/api/**").permitAll()
			
			.antMatchers("/sysdomhome").permitAll()
			.antMatchers("/newservice").permitAll()
			.antMatchers("/service").permitAll()
			.antMatchers("/newservices").permitAll()
			.antMatchers("/home").permitAll()
			//crrect
			.antMatchers("/api/**").permitAll()
			//.antMatchers("/api/**").hasRole("USER")
			//.antMatchers("/api/**").hasRole("ADMIN")
		
			.antMatchers("/**").hasRole("ADMIN") 
			.antMatchers("/users").hasRole("ADMIN")
			.antMatchers(HttpMethod.POST, "/api/**").hasRole("ADMIN")	
			
			.anyRequest().authenticated()
			.and()
			
		.formLogin()
			.loginPage("/login")
			
			.defaultSuccessUrl("/home")
			
			.failureUrl("/login")
			
			.usernameParameter("username").passwordParameter("password")
			.and()
			.csrf().disable();
		
	}

}
