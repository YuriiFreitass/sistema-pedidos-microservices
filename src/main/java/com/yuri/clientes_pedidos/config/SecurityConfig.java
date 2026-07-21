package com.yuri.clientes_pedidos.config;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity)
			throws Exception {

		return httpSecurity.csrf(csrf -> csrf.disable())
				.authorizeHttpRequests(auth -> auth
						.requestMatchers("/swagger-ui/**",
								"/swagger-ui.html",
								"/v3/api/docs/**").permitAll()
						.requestMatchers(HttpMethod.GET,
								"/v1/clientes/**").hasAnyRole("USER", "ADMIN")
						.requestMatchers(HttpMethod.POST,
								"/v1/clientes/**").hasRole("ADMIN")
						.requestMatchers(HttpMethod.PUT,
								"/v1/clientes/**").hasRole("ADMIN")
						.requestMatchers(HttpMethod.DELETE,
								"/v1/clientes/**").hasRole("ADMIN")
						.anyRequest().authenticated()
				)
				.httpBasic(Customizer.withDefaults())
				.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {

		UserDetails user = User.builder()
				.username("user")
				.password(passwordEncoder.encode("123456"))
				.roles("USER")
				.build();

		UserDetails admin = User.builder()
				.username("admin")
				.password(passwordEncoder.encode("123456"))
				.roles("ADMIN")
				.build();

		return new InMemoryUserDetailsManager(user, admin);
	}


}

