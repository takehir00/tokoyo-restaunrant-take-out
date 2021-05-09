package com.example.tokyorestauranttakeout.security.client;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class ClientLoginUser extends User {

    private final Integer userId;

    private String name;

    public ClientLoginUser(Integer userId,String email, String password, String name, Collection<? extends GrantedAuthority> authorities) {
        super(email, password, authorities);
        this.name = name;
        this.userId = userId;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }
}
