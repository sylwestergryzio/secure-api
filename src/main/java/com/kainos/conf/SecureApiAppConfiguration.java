package com.kainos.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecureApiAppConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/callback/code/keycloak").permitAll()
            .antMatchers("/").permitAll()
            .antMatchers("/orders").hasAuthority("SCOPE_READ_Orders")
            .antMatchers("/employees").hasAuthority("SCOPE_READ_Employees")
            .anyRequest().authenticated()
            .and().oauth2ResourceServer().jwt();
    }
}