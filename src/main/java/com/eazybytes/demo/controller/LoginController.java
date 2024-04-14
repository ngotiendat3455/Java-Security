package com.eazybytes.demo.controller;

import com.eazybytes.demo.constants.SecurityConstants;
import com.eazybytes.demo.entity.Account;
import com.eazybytes.demo.entity.role.Role;
import com.eazybytes.demo.filter.AuthoritiesLoggingAfterFilter;
import com.eazybytes.demo.reponsitory.AccountReponsitory;
import com.eazybytes.demo.type.ILoginParams;
import com.eazybytes.demo.type.ILoginReponse;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.eazybytes.demo.entity.Customer;
import com.eazybytes.demo.reponsitory.CustomerReponsitory;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/v1/auth")
public class LoginController {
	private final Logger LOG =
			Logger.getLogger(AuthoritiesLoggingAfterFilter.class.getName());
	AccountReponsitory accountReponsitory;
	PasswordEncoder passwordEncoder;
	public LoginController(AccountReponsitory accountReponsitory, PasswordEncoder passwordEncoder) {
		this.accountReponsitory = accountReponsitory;
		this.passwordEncoder = passwordEncoder;
	}
	
	@PostMapping("/signup/{companyCode}")
	public ResponseEntity<String> registerUser(@RequestBody Account account){
		Account savedAccount = null;
		ResponseEntity response = null;
		
		try {
			String hashPwd = this.passwordEncoder.encode(account.getPassword());
			account.setPassword(hashPwd);
			savedAccount = accountReponsitory.save(account);
			response = ResponseEntity.status(HttpStatus.CREATED).body("Given user details are successfully registered");
		} catch (Exception ex) {
			response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An exception occured due to" + ex.getMessage());
		}
		return response;
	}

	@PostMapping("/login")
	public ResponseEntity<ILoginReponse> loginUser(@RequestBody ILoginParams obj) {
		List<Account> currentAccount = accountReponsitory.findByUsername(obj.getUsername());
		ResponseEntity response = null;
		try {
			if (currentAccount.isEmpty()) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ILoginReponse("Invalid credentials", null, null));
			}
			String hashPwd = this.passwordEncoder.encode(obj.getPassword());
			LOG.info("test login pwd hash" + hashPwd);
			LOG.info("test login not hash " + obj.getPassword());
			if (passwordEncoder.matches(obj.getPassword(), currentAccount.get(0).getPassword())) {
				Set<String> authoritiesSet = new HashSet<>();
				for (Role authority : currentAccount.get(0).getRoles()) {
					authoritiesSet.add(authority.getRoleName());
				}
				SecretKey key = Keys.hmacShaKeyFor(SecurityConstants.JWT_KEY.getBytes(StandardCharsets.UTF_8));
				String jwt = Jwts.builder().issuer("Eazy Bank").subject("JWT Token")
						.claim("username", currentAccount.get(0).getUsername())
						.claim("authorities", String.join(",", authoritiesSet))
						.issuedAt(new Date())
						.expiration(new Date((new Date()).getTime() + 30000000))
						.signWith(key).compact();
				response = ResponseEntity.status(HttpStatus.OK).body(new ILoginReponse("Login Success", null, jwt));
			} else {
				response = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ILoginReponse("Invalid Password", null, null));
			}
		} catch (Exception ex) {
			response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ILoginReponse("An exception occured due to" + ex.getMessage(), null, null));
		}
		return response;
	}
}
