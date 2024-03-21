package com.eazybytes.demo.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.eazybytes.demo.model.Customer;
import com.eazybytes.demo.reponsitory.CustomerReponsitory;

@Component
public class EazyBankUsernamePwdAuthenticationProvider implements AuthenticationProvider {

	public CustomerReponsitory customerReponsitory;
	public PasswordEncoder passwordEncoder;
	
	
	public EazyBankUsernamePwdAuthenticationProvider(CustomerReponsitory customerReponsitory,
			PasswordEncoder passwordEncoder) {
		this.customerReponsitory = customerReponsitory;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String pwd = authentication.getCredentials().toString();
		List<Customer> customer = this.customerReponsitory.findByEmail(username);
		
		if (customer.size() > 0) {
			if (passwordEncoder.matches(pwd, customer.get(0).getPwd())) {
				List<GrantedAuthority> authorities = new ArrayList<>();
				authorities.add(new SimpleGrantedAuthority(customer.get(0).getRole()));
				return new UsernamePasswordAuthenticationToken(username,  pwd, authorities);
			} else {
				throw new BadCredentialsException("Invalid password");
			}
		} else {
			throw new BadCredentialsException("No user registered with this details");
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
	}

}
