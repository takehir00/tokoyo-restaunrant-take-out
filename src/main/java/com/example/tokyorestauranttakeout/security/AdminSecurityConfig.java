package com.example.tokyorestauranttakeout.security;

import com.example.tokyorestauranttakeout.AdminServerPaths;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * 管理画面セキュリティ設定
 */
@Configuration
@EnableWebSecurity
@Order(SecurityOrderConst.ADMIN)
public class AdminSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AdminUserDaoRealm adminUserDaoRealm;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    /**
     * UserDetailインターフェースを実装した独自の認証レルムを使用する設定
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(adminUserDaoRealm)
                .passwordEncoder(passwordEncoder());
    }

    /**
     * @param httpSecurity
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {

        // 管理画面パスにセキュリティをかける
        httpSecurity
                .antMatcher(AdminServerPaths.ROOT + "/**")
                .authorizeRequests(authorize ->
                        authorize.anyRequest().permitAll()
                );

        //ログイン設定
        httpSecurity.formLogin()
                //ログイン画面のURL
                .loginPage(AdminServerPaths.AUTH +"/login")
                //認可を処理する
                //.loginProcessingUrl("/authenticate")
                //ログイン成功時の遷移先
                .successForwardUrl(AdminServerPaths.AUTH + "/success")
                //ログイン失敗時の遷移先
                .failureForwardUrl(AdminServerPaths.AUTH + "/failure")
                //ログインidのパラメータ名
                .usernameParameter("name")
                //パスワードのパラメータ名
                .passwordParameter("password").permitAll();

        //ログアウト設定
        httpSecurity.logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("hoge"))
                //cookieを破棄する
                //.deleteCookies("/session")
                //ログアウト画面のURL
                .logoutUrl(AdminServerPaths.AUTH + "/logout")
                //ログアウト後の遷移先
                //.logoutSuccessUrl("/logout")
                //セッションを破棄する
                .invalidateHttpSession(true).permitAll();

    }

}
