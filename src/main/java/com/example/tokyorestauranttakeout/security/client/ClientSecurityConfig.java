package com.example.tokyorestauranttakeout.security.client;

import com.example.tokyorestauranttakeout.ClientServerPaths;
import com.example.tokyorestauranttakeout.security.SecurityOrderConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * クライアント画面セキュリティ設定
 */
@Configuration
@EnableWebSecurity
@Order(SecurityOrderConst.CLIENT)
public class ClientSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private  ClientUserDaoRealm clientUserDaoRealm;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * UserDetailインターフェースを実装した独自の認証レルムを使用する設定
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(clientUserDaoRealm)
                .passwordEncoder(passwordEncoder);
    }

    /**
     * @param httpSecurity
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        // クライアント画面パスにセキュリティをかける
        httpSecurity.authorizeRequests(authorize ->
                authorize.antMatchers(
                        ClientServerPaths.PUB + "/**",
                                    ClientServerPaths.ACCOUNT + "/register").permitAll()
                        .antMatchers(
                                ClientServerPaths.ROOT + "/**").authenticated());

        //ログイン設定
        httpSecurity.formLogin()
                //ログイン画面のURL
                .loginPage(ClientServerPaths.AUTH +"/login")
                //認可を処理する
                //.loginProcessingUrl("/authenticate")
                //ログイン成功時の遷移先
                .successForwardUrl(ClientServerPaths.AUTH + "/success")
                //ログイン失敗時の遷移先
                .failureForwardUrl(ClientServerPaths.AUTH + "/failure")
                //ログインidのパラメータ名
                .usernameParameter("email")
                //パスワードのパラメータ名
                .passwordParameter("password").permitAll();

        //ログアウト設定
        httpSecurity.logout()
                //.logoutRequestMatcher(new AntPathRequestMatcher("hoge"))
                //cookieを破棄する
                //.deleteCookies("/session")
                //ログアウト画面のURL
                .logoutUrl(ClientServerPaths.AUTH + "/logout")
                //ログアウト後の遷移先
                .logoutSuccessUrl(ClientServerPaths.PUB)
                //セッションを破棄する
                .invalidateHttpSession(true).permitAll();
    }
}
