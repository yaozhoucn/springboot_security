package com.yao.springboot_security.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by WXHang on HANG at 2021/9/7 16:31
 * Desc：
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
       http.authorizeRequests().antMatchers("/").permitAll()
               .antMatchers("/level1/**").hasRole("vip1")
               .antMatchers("/level2/**").hasRole("vip2")
               .antMatchers("/level2/**").hasRole("vip3");
    }
}
