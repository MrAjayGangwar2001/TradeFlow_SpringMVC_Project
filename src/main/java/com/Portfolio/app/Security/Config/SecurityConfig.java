package com.Portfolio.app.Security.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.Portfolio.app.Security.CustomSuccessHandler;

@Configuration
public class SecurityConfig {


    @Bean
    public PasswordEncoder EncodePassword(){

        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain SecurityConfiguration(HttpSecurity httpSecurity) throws Exception{

        httpSecurity
            .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                    .requestMatchers("/", "/register").permitAll()
                    // .requestMatchers("/user").authenticated()
                    // .requestMatchers("/admin").authenticated()
                    .requestMatchers("/user").hasRole("USER")
                    .requestMatchers("/admin").hasRole("ADMIN")
                    .anyRequest().authenticated()
                )
                // .formLogin(form -> form.disable()
                .formLogin(form -> form
                .loginPage("/login")           // apna Login page
                .loginProcessingUrl("/login")  // form action URL
                .successHandler(new CustomSuccessHandler())
                // .defaultSuccessUrl("/user", true) // login success ke baad
                .failureUrl("/login?error=true")  // agar galat credentials
                .permitAll()
            )
            // .httpBasic(basic -> basic.disable())
            // .logout(logout -> logout.disable()
            .logout(logout -> logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/")
                .permitAll()
            );

        return httpSecurity.build();
    }

}
