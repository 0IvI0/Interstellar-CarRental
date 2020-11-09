package com.interstellarcarrental.carrental.security;

import java.security.SecureRandom;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


//Authentication:

	@Bean
	public UserDetailsService userDetailsService() {
		return new SecurityService();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(14, new SecureRandom());
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());
		return authProvider;
	}


	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}


//Authorization:

    @Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.httpBasic()
				.and()
			.authorizeRequests()
				.antMatchers("/api/employee/**").hasRole("EMPLOYEE")
				.antMatchers("/api/customer/**").hasRole("CUSTOMER")
				.antMatchers("/api/user/**").hasAnyRole("CUSTOMER", "EMPLOYEE")
				.antMatchers("/", "/home", "/api/register", "/api/listCars").permitAll()
				.anyRequest().authenticated()
				.and()
			// .exceptionHandling()        // TO DO - Whitelabel error
			// 	.authenticationEntryPoint(new Http403ForbiddenEntryPoint())
			// 	.and()
			.csrf()
				.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
				 .and()
			.cors()	 
				 .and()	
			.formLogin().permitAll()
				//.loginPage("/login").permitAll()
				//.defaultSuccessUrl("/customer/profile{id}", true)    // TO DO
				.and()	
			.logout()
			.logoutUrl("/api/logout")
			.deleteCookies("JSESSIONID")
				.logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler());   //TO DO	
	}
}