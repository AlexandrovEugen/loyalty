package com.evg.config

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

@Configuration
@EnableWebSecurity
class SecurityConfiguration : WebSecurityConfigurerAdapter() {


    override fun configure(http: HttpSecurity?) {
        http
            ?.httpBasic()
            ?.and()
            ?.formLogin()
            ?.loginPage("/login")?.successForwardUrl("/")?.permitAll()
            ?.and()
            ?.logout()?.permitAll()
            ?.and()
            ?.authorizeRequests()
            ?.antMatchers("/user", "/user/**")
            ?.permitAll()?.anyRequest()?.authenticated()
            ?.and()
            ?.csrf()?.disable()
    }


}