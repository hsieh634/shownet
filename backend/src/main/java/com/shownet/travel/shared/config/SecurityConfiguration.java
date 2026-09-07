package com.shownet.travel.shared.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    @Bean
    SecurityFilterChain applicationSecurity(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/api/v1/health", "/api/v1/catalog/**", "/actuator/health", "/v3/api-docs/**", "/swagger-ui/**")
                        .permitAll()
                        .anyRequest().denyAll())
                .build();
    }
}
