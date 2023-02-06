package com.avisos.avisos20.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	    http.authorizeRequests()
	            .antMatchers("/test").permitAll()
	            .antMatchers("/login").permitAll()
	            .antMatchers("/test/managers").hasAnyRole("MANAGERS")
	            .antMatchers("/test/users").hasAnyRole("USERS","MANAGERS")
	            .anyRequest().authenticated().and().formLogin();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.withUser("caio")
		.password("{noop}123")
		.roles("USERS")
		.and()
		.withUser("admin")
		.password("{noop}admin123")
		.roles("MANAGERS"); 
		
	}
}
