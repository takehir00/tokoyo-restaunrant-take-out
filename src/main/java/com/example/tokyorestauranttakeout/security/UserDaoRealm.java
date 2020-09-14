package com.example.tokyorestauranttakeout.security;

import com.example.tokyorestauranttakeout.entity.Account;
import com.example.tokyorestauranttakeout.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoRealm implements UserDetailsService {

    @Autowired
    AccountRepository accountRepository;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<GrantedAuthority> authorityList = new ArrayList<>();
        authorityList.add(new SimpleGrantedAuthority("USER"));

        Account account = accountRepository.selectByName(username);

        return new LoginUser(account.getName(), account.getPassword(), authorityList);
    }
}
