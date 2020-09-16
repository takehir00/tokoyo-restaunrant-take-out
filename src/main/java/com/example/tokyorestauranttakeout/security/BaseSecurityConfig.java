package com.example.tokyorestauranttakeout.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class BaseSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDaoRealm userDaoRealm;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    /**
     * 静的ファイルに認証をかけない
     * @param web
     */
    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/css/**");
    }

    /**
     * UserDetaiインターフェースを実装した独自の認証レルムを使用する設定
     *なんか判定したりとか？
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDaoRealm)
                .passwordEncoder(passwordEncoder());
    }

    /**
     * @param httpSecurity
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        String[] permittedUrls = {"/css/**","/**", "/webjars/bootstrap/4.3.1/css/bootstrap.css", "/user/registerForm", "/signUp"};

        //認証がかからないエンドポイントを明示する。それ以外にはかかるようにする
        httpSecurity.authorizeRequests()
                .antMatchers(permittedUrls).permitAll()
                .anyRequest().authenticated()
                .and()
                .exceptionHandling();

        //ログイン設定
        httpSecurity.formLogin()
                //ログイン画面のURL
                .loginPage("/login")
                //認可を処理する
                //.loginProcessingUrl("/authenticate")
                //ログイン成功時の遷移先
                .successForwardUrl("/success")
                //ログイン失敗時の遷移先
                .failureForwardUrl("/failure")
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
                .logoutUrl("/logout")
                //ログアウト後の遷移先
                //.logoutSuccessUrl("/logout")
                //セッションを破棄する
                .invalidateHttpSession(true).permitAll();

    }
}
