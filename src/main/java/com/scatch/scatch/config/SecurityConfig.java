package com.scatch.scatch.config;

import com.scatch.scatch.repository.UserRepository;
import com.scatch.scatch.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(request -> {
                    request.requestMatchers( "/","/css/*","/users/register","/users/login","/images/*","/javascript/*").permitAll()
                            .anyRequest().authenticated();
                })
                .formLogin(
                        form -> form.loginPage("/")
                                .permitAll()
                                .defaultSuccessUrl("/home", false) // false import.
                                .usernameParameter("email") // name is email in login form default was username hence changed
//                                .passwordParameter("password")
                                .failureUrl("/?error")
                                .loginProcessingUrl("/users/login") // post form login action
                )
                .logout(logout -> logout
                        .logoutSuccessUrl("/?logout")
                        .permitAll()
                );

        return http.build();

    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider(); // authentication provider for database.

        authProvider.setPasswordEncoder(new BCryptPasswordEncoder(12)); // password encoder same strength as object created
        authProvider.setUserDetailsService(userDetailsService); //  userdetails service

        return authProvider;
    }
}


