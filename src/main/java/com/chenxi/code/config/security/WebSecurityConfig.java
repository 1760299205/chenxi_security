package com.chenxi.code.config.security;

import com.chenxi.code.sys.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;

    @Autowired
    MyFilterInvocationSecurityMetadataSource myFilterInvocationSecurityMetadataSource;

    @Autowired(required=false)
    MyAccessDecisionManager myAccessDecisionManager;


    //授权认证
    @Autowired(required=false)
    AuthenticationAccessDeniedHandler authenticationAccessDeniedHandler;
    //登录成功
    @Autowired(required=false)
    MyAuthenticationSuccessHandler myAuthenticationSuccessHandler;
    //登录失败
    @Autowired(required=false)
    MyAuthenticationFailureHandler myAuthenticationFailureHandler;


    /*
     *主要配置身份验证，包括登录验证等等
     *name:xurenxin
     *time:2020/10/16 16:29
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //后台写死配发
        // auth.inMemoryAuthentication().withUser("user").password("123").roles("quanxian");
        //高一个级别玩法，自定义验证：把自己验证方法直接丢给他
        auth.userDetailsService(userService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
                    @Override
                    public <O extends FilterSecurityInterceptor> O postProcess(O o) {
                        o.setSecurityMetadataSource(myFilterInvocationSecurityMetadataSource);
                        o.setAccessDecisionManager(myAccessDecisionManager);
                        return o;
                    }
                }).and().formLogin().failureHandler(myAuthenticationFailureHandler).successHandler(myAuthenticationSuccessHandler)
                .and().logout().permitAll().and().csrf().disable()
                .exceptionHandling().accessDeniedHandler(authenticationAccessDeniedHandler);
    }
}
