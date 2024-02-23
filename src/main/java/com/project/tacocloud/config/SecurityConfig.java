package com.project.tacocloud.config;

import com.project.tacocloud.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableGlobalAuthentication
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/design", "/orders").hasRole("USER")
                        .requestMatchers("/", "/**").permitAll())

                .formLogin(form -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/design"))

                .logout(logout -> logout
                        .logoutSuccessUrl("/"))
                .build();
    }

    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepo) {
        return username ->
                userRepo.findByUsername(username)
                        .orElseThrow(() -> new UsernameNotFoundException("User '" + username + "' not found"));
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
