package com.eazybytes.demo.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.eazybytes.demo.constants.AppAuthority;
import com.eazybytes.demo.entity.Account;
import com.eazybytes.demo.entity.role.Role;
import com.eazybytes.demo.entity.role.RoleDetail;
import com.eazybytes.demo.reponsitory.AccountReponsitory;
import jakarta.transaction.Transactional;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.eazybytes.demo.entity.Customer;
import com.eazybytes.demo.reponsitory.CustomerReponsitory;

@Component
public class EazyBankUsernamePwdAuthenticationProvider implements AuthenticationProvider {

	// public CustomerReponsitory customerReponsitory;
	public AccountReponsitory accountReponsitory;
	public PasswordEncoder passwordEncoder;
	
	
	public EazyBankUsernamePwdAuthenticationProvider(AccountReponsitory accountReponsitory,
			PasswordEncoder passwordEncoder) {
		// this.customerReponsitory = customerReponsitory;
		this.accountReponsitory = accountReponsitory;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	@Transactional
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String pwd = authentication.getCredentials().toString();
		List<Account> accounts = this.accountReponsitory.findByUsername(username);
		
		if (accounts.size() > 0) {
			if (passwordEncoder.matches(pwd, accounts.get(0).getPassword())) {
				List<GrantedAuthority> authorities = new ArrayList<>();
				Set<Role> listRole = accounts.get(0).getRoles();
				if (!listRole.isEmpty()) {
					accounts.get(0).getRoles().forEach(role -> {
						Set<RoleDetail> listRoleDetails = role.getRoleDetails();
						if (!listRoleDetails.isEmpty()){
							role.getRoleDetails().forEach(roleDetail -> {
								authorities.add(new AppAuthority(roleDetail));
							});
						}

					});
				}

				// authorities.add(new AppAuthority(accounts.get(0).getRole()));
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
