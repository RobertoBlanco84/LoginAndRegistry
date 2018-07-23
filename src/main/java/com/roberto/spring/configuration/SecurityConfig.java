package com.roberto.spring.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.core.userdetails.User;
import com.roberto.spring.model.bean.Userz;

import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.authentication.builders.*;
import org.springframework.security.config.annotation.web.configuration.*;



@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	/*	@Autowired
	private UserDetailsService userDetailService;

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder aut) throws Exception{
		aut.userDetailsService(userDetailService).passwordEncoder(passwordEncoder());
	} */

	/*@Override
	  protected void configure(HttpSecurity http) throws Exception {
	    http.authorizeRequests().anyRequest().hasAnyRole("ADMIN", "USER")
	    .and()
	    .authorizeRequests().antMatchers("/login**").permitAll()
	    .and()
	    .formLogin().loginPage("/login").loginProcessingUrl("/loginAction").permitAll()
	    .and()
	    .logout().logoutSuccessUrl("/login").permitAll()
	    .and()
	    .csrf().disable();
	  } */
	
	
	@Bean
	public UserDetailsService userDetailService() {
		System.out.println("In UserDetailMeth METH");
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		manager.createUser(User.withDefaultPasswordEncoder().username("Roberto").password("hej123").roles("USER").build());
		return manager;
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		System.out.println("In configure METH");
		http.authorizeRequests().anyRequest().hasAnyRole("USER")
		.and()
		.authorizeRequests().antMatchers("/login**").permitAll()
		.and()
		.formLogin().loginPage("/").defaultSuccessUrl("/profile").permitAll()
		.and()
		.logout().logoutSuccessUrl("/index").permitAll()
		.and()
		.csrf().disable();
	}  
}
