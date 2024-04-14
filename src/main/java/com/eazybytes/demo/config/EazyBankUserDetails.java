package com.eazybytes.demo.config;

import java.util.ArrayList;
import java.util.List;

import com.eazybytes.demo.constants.AppAuthority;
import com.eazybytes.demo.entity.Account;
import com.eazybytes.demo.reponsitory.AccountReponsitory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.eazybytes.demo.entity.Customer;
import com.eazybytes.demo.reponsitory.CustomerReponsitory;

@Service
public class EazyBankUserDetails implements UserDetailsService {
	public AccountReponsitory accountReponsitory;
	
	
	public EazyBankUserDetails(AccountReponsitory accountReponsitory) {
		this.accountReponsitory = accountReponsitory;
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Account staff = null;
		List<GrantedAuthority> authorities;
		String userName, password = null;
		List<Account> listAccount = this.accountReponsitory.findByUsername(username);
		
		if (listAccount.size() == 0) {
            authorities = null;
            throw new UsernameNotFoundException("User details found for the user:" + username);
		} else {
			userName = listAccount.get(0).getUsername();
			password = listAccount.get(0).getPassword();
			authorities = new ArrayList<GrantedAuthority>();
			listAccount.get(0).getRoles().forEach(role -> {
				role.getRoleDetails().forEach(roleDetail -> {
					authorities.add(new AppAuthority(roleDetail));
				});
			});
			// authorities.add(new AppAuthority(listAccount.get(0).get));
			
		}
		// TODO Auto-generated method stub
		return new User(userName, password, authorities);
	}
	
}
