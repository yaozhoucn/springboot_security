package com.yao.springboot_security.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by WXHang on HANG at 2021/9/7 16:31
 * Desc：
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        /**
         * 链接数据库可使用     auth.jdbcAuthentication().dataSource()
         */
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("yaoshen").password(new BCryptPasswordEncoder().encode("123456")).roles("vip2","vip3")
                .and()
                .withUser("root").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1","vip2","vip3")
                .and()
                .withUser("guest").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1");
        }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
       http.authorizeRequests().antMatchers("/").permitAll()
               .antMatchers("/level1/**").hasRole("vip1")
               .antMatchers("/level2/**").hasRole("vip2")
               .antMatchers("/level3/**").hasRole("vip3");

       //没有限权默认到登陆页面
       http.formLogin().loginPage("/toLogin").failureUrl("/toLogin");

       http.csrf().disable();

       //开启注销功能
        http.logout().deleteCookies("remember-me").invalidateHttpSession(true);


        //开启记住我功能，自定义接收前端参数
        http.rememberMe().rememberMeParameter("rememberMe");
    }
}
