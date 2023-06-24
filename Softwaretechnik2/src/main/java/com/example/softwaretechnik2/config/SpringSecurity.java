package com.example.softwaretechnik2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SpringSecurity {

    // Autowired UserDetailsService for authentication
    @Autowired
    private UserDetailsService userDetailsService;

    // Bean for password encoder using BCrypt
    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Bean for security filter chain configuration
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/logo").permitAll() // AStA-Logo image accessable for login page
                .antMatchers("/register/**").permitAll() // Allow access to registration without authentication
                .antMatchers("/shopinformation/edit").hasRole("EMPLOYEE") // Restrict access to edit shop information to employees only
                .antMatchers("/produkterstellung").hasRole("EMPLOYEE") // Restrict access to product creation to employees only
                .anyRequest().authenticated() // Require authentication for any other requests
                .and()
                .formLogin(form -> form.loginPage("/login") // Set custom login page
                        .loginProcessingUrl("/login") // Set login processing URL
                        .defaultSuccessUrl("/start", true) // Redirect to /start after successful login
                        .failureUrl("/login-error") // Redirect to /login-error after failed login
                        .permitAll()) // Allow access to login page without authentication
                .logout(logout -> logout.logoutRequestMatcher(new AntPathRequestMatcher("/logout")) // Set logout request matcher
                        .logoutSuccessUrl("/login") // Redirect to /login after successful logout
                        .permitAll()); // Allow access to logout without authentication
        return http.build();
    }

    // Global authentication configuration
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService) // Set the custom UserDetailsService
                .passwordEncoder(passwordEncoder()); // Set the password encoder
    }
}
