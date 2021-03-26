package com.interstellarcarrental.carrental.security;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collections;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import com.interstellarcarrental.carrental.security.filter.AuthoritiesLoggingAfterFilter;
import com.interstellarcarrental.carrental.security.filter.AuthoritiesLoggingAtFilter;
import com.interstellarcarrental.carrental.security.filter.JwtTokenGeneratorFilter;
import com.interstellarcarrental.carrental.security.filter.JwtTokenValidatorFilter;
import com.interstellarcarrental.carrental.security.filter.RequestValidationBeforeFilter;
import com.interstellarcarrental.carrental.security.userdetails.AppUserDetailsService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


//Authentication:

	@Bean
	public UserDetailsService userDetailsService() {
		return new AppUserDetailsService();
	}


/*     @Bean
	public UserDetailsService userDetailsService(DataSource dataSource) {
		return new JdbcUserDetailsManager(dataSource);
	} */


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
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
            .cors().configurationSource(new CorsConfigurationSource() {
                @Override
                public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
                    CorsConfiguration config = new CorsConfiguration();
                    config.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
                    config.setAllowedMethods(Collections.singletonList("*"));
                    config.setAllowCredentials(true);
                    config.setAllowedHeaders(Collections.singletonList("*"));
                    config.setExposedHeaders(Arrays.asList("Authorization"));
                    config.setMaxAge(3600L);
                    return config;
                }
            })
                .and()
            .csrf()
				.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
				.and()
            .addFilterBefore(new RequestValidationBeforeFilter(), BasicAuthenticationFilter.class)
            .addFilterAfter(new AuthoritiesLoggingAfterFilter(), BasicAuthenticationFilter.class)
            .addFilterBefore(new JwtTokenValidatorFilter(), BasicAuthenticationFilter.class)
            .addFilterAfter(new JwtTokenGeneratorFilter(), BasicAuthenticationFilter.class)
            .addFilterAt(new AuthoritiesLoggingAtFilter(), BasicAuthenticationFilter.class)
            
			.authorizeRequests()
				// .mvcMatchers("/api/employee/**").hasRole("EMPLOYEE")
				// .mvcMatchers("/api/customer/**").hasRole("CUSTOMER")
				.mvcMatchers("/api/user/**").hasAnyRole("CUSTOMER", "EMPLOYEE")
                .mvcMatchers("/api/**").permitAll() // FOR TESTING PORPUSES - TO BE DELETED!**********
				.mvcMatchers("/", "/home", "/api/register", "/api/auth/login", "/api/listCars", "/api/cardetail/**").permitAll()
				.anyRequest().authenticated()
				.and()
            .formLogin()
                .and()
            .httpBasic()	 
				 .and()
			.logout()
			.logoutUrl("/api/logout")
			.deleteCookies("JSESSIONID")
				.logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler())   //TO DO	
                .and()
            .exceptionHandling().accessDeniedPage("/403");   
	}
}