package com.example.tokyorestauranttakeout.security;

import com.example.tokyorestauranttakeout.entity.AdminAccount;
import com.example.tokyorestauranttakeout.repositories.AdminAccountRepository;
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
public class AdminUserDaoRealm implements UserDetailsService {

    @Autowired
    AdminAccountRepository adminAccountRepository;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        List<GrantedAuthority> authorityList = new ArrayList<>();
        authorityList.add(new SimpleGrantedAuthority("USER"));

        AdminAccount adminAccount = adminAccountRepository.selectByName(name)
                .orElseThrow(() -> {
                    throw new UsernameNotFoundException("your name not found");
                });

        return new AdminLoginUser(adminAccount.getName(), adminAccount.getPassword(), authorityList);
    }
}
