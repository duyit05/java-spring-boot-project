package com.cybersoft.osahaneat.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

// khi chạy web thì quét qua class CustomFilterSecurity
@Configuration

// có thể config bên trong filter
@EnableWebSecurity
public class CustomFilterSecurity {
     @Autowired
     CustomUserDetailService customUserDetailService;

     @Autowired
     CustomFilterJwt customFilterJwt;

    @Bean
    public AuthenticationManager authenticationManager (HttpSecurity security) throws Exception {

        AuthenticationManagerBuilder authenticationManagerBuilder = security.getSharedObject(AuthenticationManagerBuilder.class);

        authenticationManagerBuilder.userDetailsService(customUserDetailService).passwordEncoder(passwordEncoder());

        return  authenticationManagerBuilder.build();

    }

    @Bean
    public SecurityFilterChain filterChain (HttpSecurity http) throws  Exception{
        http.cors().and().
                csrf(AbstractHttpConfigurer::disable).
                sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().
                authorizeHttpRequests(authorize -> authorize.requestMatchers(
                        "/login/**","/restaurant/file/**","/food/file/**","/category","/user"
                ).
                permitAll().
                anyRequest().authenticated());
        http.addFilterBefore(customFilterJwt, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    // mã hóa password
    @Bean
    public PasswordEncoder passwordEncoder (){
        return  new BCryptPasswordEncoder();
    }

}
