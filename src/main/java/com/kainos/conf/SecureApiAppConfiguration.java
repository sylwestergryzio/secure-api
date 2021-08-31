package com.kainos.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecureApiAppConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/").permitAll()
            .anyRequest().authenticated()
            .and().oauth2Login();
    }
}

//.authorizeRequests().mvcMatchers("/orders").authenticated()
//    .and().cors()
//    .and().oauth2Login()
//    .and().oauth2ResourceServer().jwt();