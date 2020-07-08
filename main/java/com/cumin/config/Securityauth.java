package com.cumin.config;

import java.util.logging.Logger;

import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.HttpComponentsAsyncClientHttpRequestFactory;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
@Configuration
@EnableWebSecurity

public class Securityauth extends WebSecurityConfigurerAdapter {
@Autowired
private DataSource securityData;
	
@Override
protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	auth.jdbcAuthentication().dataSource(securityData);
	
//	UserBuilder user =User.withDefaultPasswordEncoder();
////	// Hard coded
//	auth.inMemoryAuthentication().withUser(user.username("Kritika").password("test123!").roles("DEVELOPER"))  ;
//	auth.inMemoryAuthentication().withUser(user.username("Jitendra").password("test123!").roles("MANAGER"))  ;
//	auth.inMemoryAuthentication().withUser(user.username("Badal").password("test123!").roles("TESTER"))  ;
//   
}


@Override
protected void configure(HttpSecurity http) throws Exception {
	http.authorizeRequests().
	antMatchers("/Managers/**").hasRole("MANAGER").
	antMatchers("/Testers/**").hasRole("TESTER").
	antMatchers("/").hasRole("DEVELOPER")
	.and()
	.formLogin().loginPage("/showMyLoginPage").loginProcessingUrl("/authenticateTheUser")
	.permitAll()
	.and().logout().permitAll().and().exceptionHandling().accessDeniedPage("/access-denied");
	
	}
}