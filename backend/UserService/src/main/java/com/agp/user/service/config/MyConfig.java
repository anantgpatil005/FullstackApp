package com.agp.user.service.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.agp.user.service.services.MyUserDetailService;

@Configuration
@EnableWebSecurity
public class MyConfig {

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	/*
	 * @Bean public CorsConfigurationSource corsConfigurationSource() {
	 * CorsConfiguration configuration = new CorsConfiguration();
	 * configuration.setAllowCredentials(true);
	 * configuration.addAllowedOriginPattern("http://localhost:5173"); // more
	 * flexible configuration.addAllowedHeader("*");
	 * configuration.addAllowedMethod("*"); // allow all methods
	 * UrlBasedCorsConfigurationSource source = new
	 * UrlBasedCorsConfigurationSource(); source.registerCorsConfiguration("/**",
	 * configuration); return source; }
	 */

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	    return http.csrf(csrf -> csrf.disable())
	            .cors(Customizer.withDefaults())
	            .authorizeHttpRequests(req -> req
	                .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll() // allow preflight
	                .requestMatchers("/users/authentication/register","/users/authentication/generate-token").permitAll()
	                .anyRequest().authenticated())
	            .userDetailsService(userDetailsService())
	            .httpBasic(Customizer.withDefaults())
	            .build();
	}

	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception{
		return configuration.getAuthenticationManager();
	}
	
	@Bean
	public UserDetailsService userDetailsService() {
		return new MyUserDetailService();
	}
}
