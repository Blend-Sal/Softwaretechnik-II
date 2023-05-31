package com.example.softwaretechnik2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SpringSecurity {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/register/**").permitAll()
                .antMatchers("/produkterstellung").hasRole("EMPLOYEE")
                .anyRequest().authenticated()
                .and()
                .formLogin(form -> form.loginPage("/login")
                        .loginProcessingUrl("/login")
                        .defaultSuccessUrl("/start", true)
                        .permitAll())
                .logout(logout -> logout.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                        .permitAll());
        return http.build();
    }
}
