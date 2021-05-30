package com.example.tokyorestauranttakeout.admin.controllers;

import com.example.tokyorestauranttakeout.entity.AdminAccount;
import com.example.tokyorestauranttakeout.repositories.AdminAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class AdminControllerBase {

    @Autowired
    AdminAccountRepository adminAccountRepository;

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
    protected AdminAccount getAccount() {
        return adminAccountRepository.selectByName(getName()).get();
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
