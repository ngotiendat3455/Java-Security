package com.eazybytes.demo.config;

import javax.sql.DataSource;

import com.eazybytes.demo.audit.AuditAwareImpl;
import com.eazybytes.demo.common.RestAuthenticationEntryPoint;
import com.eazybytes.demo.filter.AuthoritiesLoggingAfterFilter;
import com.eazybytes.demo.filter.AuthoritiesLoggingAtFilter;
import com.eazybytes.demo.filter.JWTTokenGeneratorFilter;
import com.eazybytes.demo.filter.JWTTokenValidatorFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;

@Configuration
public class ProjectSecurityConfig {


	@Autowired
	private RestAuthenticationEntryPoint restAuthenticationEntryPoint;

	@Bean
	public AuditorAware<String> springSecurityAuditorAware() {
		return new AuditAwareImpl();
	}
	@SuppressWarnings("removal")
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and()
				.exceptionHandling().authenticationEntryPoint(restAuthenticationEntryPoint)
				.and()
				.authorizeRequests()
				.requestMatchers("/api/v1/auth/**").permitAll()
				// .requestMatchers("/api/v1/roles/**").authenticated()
				.anyRequest().permitAll().and()
				.addFilterAt(new AuthoritiesLoggingAtFilter(),BasicAuthenticationFilter.class)
				.addFilterAfter(new AuthoritiesLoggingAfterFilter(), BasicAuthenticationFilter.class)
				.addFilterBefore(new JWTTokenValidatorFilter(), BasicAuthenticationFilter.class);
		http.csrf().disable();
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

	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
		// TokenAuthenticationFilter will ignore the below paths
		return (web) -> {
			web.ignoring().requestMatchers(
					HttpMethod.POST,
					"/api/v1/auth/**");
		};
	}
}
