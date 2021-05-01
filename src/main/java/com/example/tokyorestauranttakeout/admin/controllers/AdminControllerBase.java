package com.example.tokyorestauranttakeout.admin.controllers;

import com.example.tokyorestauranttakeout.entity.Account;
import com.example.tokyorestauranttakeout.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class AdminControllerBase {

    @Autowired
    AccountRepository accountRepository;

    /**
     * ユーザープリンシパルからユーザー名を取得する
     *
     * @return
     */
    protected String getName() {
        Object principal = getPrincipal();
        if (principal instanceof UserDetails) {
            return ((UserDetails)principal).getUsername();
        } else {
            return principal.toString();
        }
    }

    /**
     * メールアドレスからユーザーエンティティを取得する
     *
     * @return
     */
    protected Account getAccount() {
        return accountRepository.selectByName(getName()).get();
    }

    /**
     * ユーザープリンシパルを取得
     *
     * @return
     */
    private Object getPrincipal() {
        return SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();
    }
}
