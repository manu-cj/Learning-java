package org.manu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
      .authorizeHttpRequests(auth -> auth
        .requestMatchers("/", "/error", "/webjars/**", "/swagger-ui/**", "/v3/api-docs/**").permitAll()
        .anyRequest().authenticated()
      )
      .oauth2Login(); // active l'authentification OAuth2
    return http.build();
  }
}
