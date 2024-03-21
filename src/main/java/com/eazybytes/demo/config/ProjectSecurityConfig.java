package com.eazybytes.demo.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {
	@SuppressWarnings("removal")
	@Bean
	  SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception{
		  http.csrf().disable().authorizeHttpRequests()
		  		.requestMatchers("/myLoans", "/myCards", "/myAccount", "/myBalance").authenticated()
		  		.requestMatchers("/notices", "/contact", "/register").permitAll()
		  		.and().formLogin()
		  		.and().httpBasic();
		  return http.build();
	  }
	
	@Bean
	public UserDetailsService userDetailsService(DataSource dataSource) {
		return new JdbcUserDetailsManager(dataSource);
	}
	
	 @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
}
