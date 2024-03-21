package com.eazybytes.demo.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.eazybytes.demo.model.Customer;
import com.eazybytes.demo.reponsitory.CustomerReponsitory;

@Service
public class EazyBankUserDetails implements UserDetailsService {
	public CustomerReponsitory customerReponsitory;
	
	
	public EazyBankUserDetails(CustomerReponsitory customerReponsitory) {
		this.customerReponsitory = customerReponsitory;
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Customer customer = null;
		List<GrantedAuthority> authorities = null;
		String userName, password = null;
		List<Customer> listCustomer = this.customerReponsitory.findByEmail(username);
		
		if (listCustomer.size() == 0) {
			throw new UsernameNotFoundException("User details found for the user:" + username);
		} else {
			userName = listCustomer.get(0).getEmail();
			password = listCustomer.get(0).getPwd();
			authorities = new ArrayList<GrantedAuthority>();
			authorities.add(new SimpleGrantedAuthority(listCustomer.get(0).getRole()));
			
		}
		// TODO Auto-generated method stub
		return new User(userName, password, authorities);
	}
	
}
