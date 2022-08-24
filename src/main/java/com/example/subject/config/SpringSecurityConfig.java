package com.example.subject.config;

import com.example.subject.config.passwordencoder.SHA512PasswordEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.*;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {


    @Bean
    public PasswordEncoder delegatingPasswordEncoder() {
        Map<String, PasswordEncoder> encoders = new HashMap<>();
        PasswordEncoder defaultEncoder = new SHA512PasswordEncoder();
        encoders.put("bcrypt", new BCryptPasswordEncoder());

        DelegatingPasswordEncoder passworEncoder = new DelegatingPasswordEncoder(
                "bcrypt", encoders);

        //prefix가 없는 암호는 sha512로 hash
        passworEncoder.setDefaultPasswordEncoderForMatches(defaultEncoder);

        return passworEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/member", "/api", "/expense").permitAll()
                .and()
                .formLogin()
                .defaultSuccessUrl("/", true)
                .permitAll()
                .and()
                .logout();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/static/js/**","/static/css/**","/static/img/**","/static/frontend/**");
    }
}
