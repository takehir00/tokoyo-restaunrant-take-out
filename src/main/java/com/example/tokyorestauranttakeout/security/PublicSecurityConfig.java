package com.example.tokyorestauranttakeout.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 認証不要パスセキュリティ設定
 */
@Configuration
@EnableWebSecurity
@Order(SecurityOrderConst.PUBLIC)
public class PublicSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * @param httpSecurity
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        String[] permittedUrls = {"/css/**","/images/**", "/webjars/bootstrap/4.3.1/css/bootstrap.css", "/pub/**"};

        //認証がかからないエンドポイントを明示する。
        httpSecurity.authorizeRequests()
                .antMatchers(permittedUrls)
                .permitAll();

    }
}
