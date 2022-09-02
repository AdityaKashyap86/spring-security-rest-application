package com.sunglowsys.config;

import com.sunglowsys.service.serviceImpl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig  extends WebSecurityConfigurerAdapter {

    @Bean
    public UserDetailsService userDetailsService () {
        return new UserDetailsServiceImpl ();
    }

    @Bean
    public BCryptPasswordEncoder encoder () {
        return new BCryptPasswordEncoder ();
    }

    @Bean
    public DaoAuthenticationProvider provider () {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider ();
        authenticationProvider.setUserDetailsService (userDetailsService());
        authenticationProvider.setPasswordEncoder (encoder());

        return authenticationProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(provider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf ().disable ()
                .authorizeRequests ()
                .antMatchers ("/api").hasAuthority ("ADMIN")
                //.antMatchers ("/api").hasAuthority ("CREATOR")
                .antMatchers ("/users/**").hasAnyAuthority("ADMIN")
                .and ()
                .httpBasic ();
    }
}
