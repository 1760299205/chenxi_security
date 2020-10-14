package com.chenxi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Objects;

@Configuration
public class MyWebSecurityConfig extends WebSecurityConfigurerAdapter {
    // 指定密码的加密方式
    @Bean
    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
        return new PasswordEncoder() {
            @Override
            public String encode(CharSequence charSequence) {
                return charSequence.toString();
            }

            @Override
            public boolean matches(CharSequence charSequence, String s) {
                return Objects.equals(charSequence.toString(), s);
            }
        };
    }
    // 配置用户及其对应的角色
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("root").password("123").roles("ADMIN","DBA")
                .and()
                .withUser("admin").password("123").roles("ADMIN","USER")
                .and()
                .withUser("hangge").password("123").roles("USER");
    }
    // 配置 URL 访问权限
    @Override
    protected  void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests() // 开启 HttpSecurity 配置
                .antMatchers("/admin/**").hasRole("ADMIN") // admin/** 模式URL必须具备ADMIN角色
                .antMatchers("/user/**").access("hasAnyRole('ADMIN','USER')") // 该模式需要ADMIN或USER角色
                .antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')") // 需ADMIN和DBA角色
                .anyRequest().authenticated() // 用户访问其它URL都必须认证后访问（登录后访问）
                .and().formLogin().loginProcessingUrl("/login").permitAll() // 开启表单登录并配置登录接口
                .and().csrf().disable(); // 关闭csrf
    }
}