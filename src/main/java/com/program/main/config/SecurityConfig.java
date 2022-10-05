package com.program.main.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
public class SecurityConfig {


    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){

        UserDetails user1 = User.builder()
                .username("tzuyu")
                .password("{noop}123")
                .roles("ADMIN")
                .build();


        return new InMemoryUserDetailsManager(user1);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{

        return httpSecurity
                .authorizeRequests(
                        configurer ->
                                configurer
                                        .antMatchers("/", "/css/**")
                                        .permitAll()
                )
                .build();


    }
}
