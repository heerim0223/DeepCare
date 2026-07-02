package com.deepcare.configuration;

import com.deepcare.security.JwtAuthenticationFilter;
import com.deepcare.security.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@RequiredArgsConstructor
@EnableWebSecurity
@Configuration
public class SecurityConfig {

    private final JwtProvider jwtProvider;
    private final SecurityProperties securityProperties; // com.deepcare.configuration.SecurityProperties (같은 패키지라 import 불필요)

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.httpBasic(basic -> basic.disable())    // HTTP 기본 인증 비활성화
                .csrf(csrf -> csrf.disable())            // CSRF 보호 비활성화 (JWT는 쿠키/세션 안 쓰므로 불필요)
                .cors(Customizer.withDefaults())         // CORS 설정
                .sessionManagement(configurer -> configurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(securityProperties.getWhitelist().toArray(new String[0])).permitAll()
                        .anyRequest().authenticated())
                .addFilterBefore(
                        new JwtAuthenticationFilter(securityProperties.getWhitelist(), jwtProvider),
                        UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}