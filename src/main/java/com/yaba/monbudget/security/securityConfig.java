package com.yaba.monbudget.security;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebSecurity
@EnableMethodSecurity
@Configuration
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class securityConfig implements WebMvcConfigurer {

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {

        return http
                .csrf(csrf-> csrf.disable())
                .authorizeHttpRequests(request ->
                        request.requestMatchers(OPEN_API_WHITELIST).permitAll()
                                .requestMatchers("/budget/api/cmd/**").permitAll()
                                .anyRequest().authenticated())
                .build();
    }


    private static final String[] OPEN_API_WHITELIST = {
            "/api/v1/auth/**",
            "/v3/api-docs/**",
            "/v3/api-docs.yaml",
            "/swagger-ui/**",
            "/swagger-ui.html"
    };
}
