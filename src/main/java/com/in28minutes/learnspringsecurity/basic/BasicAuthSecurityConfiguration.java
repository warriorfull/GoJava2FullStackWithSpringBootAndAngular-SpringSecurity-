package com.in28minutes.learnspringsecurity.basic;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class BasicAuthSecurityConfiguration {
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(
				(auth) -> {
					auth.anyRequest().authenticated();
				});
		http.sessionManagement(
				session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				);
//		http.formLogin(withDefaults());
		http.httpBasic(withDefaults());
		http.csrf().disable();
		return http.build();
	}
	
//	@Bean
//	public WebMvcConfigurer corsConfigurer() {
//		return new WebMvcConfigurer() {
//			public void addCorsMappings(CorsRegistry registry) {
//				registry.addMapping("/**")
//					.allowedMethods("*")
//					.allowedOrigins("https://localhost:3000");
//			}
//		};
//	}
	
	@Bean
	public UserDetailsService userDetailService() {
		var user = User.withUsername("in28minutes")
			.password("{noop}doggie")
			.roles("USER")
			.build();
		
		var admin = User.withUsername("admin")
			.password("{noop}doggie")
			.roles("ADMIN")
			.build();
		
		return new InMemoryUserDetailsManager(user, admin);
	}
}
