package com.example.tokyorestauranttakeout.security.admin;

import com.example.tokyorestauranttakeout.entity.AdminAccount;
import com.example.tokyorestauranttakeout.repositories.AdminAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class AdminUserDaoRealm implements UserDetailsService {

    @Autowired
    AdminAccountRepository adminAccountRepository;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {

        AdminAccount adminAccount = adminAccountRepository.selectByName(name)
                .orElseThrow(() -> {
                    throw new UsernameNotFoundException("your name not found");
                });

        return new AdminLoginUser(adminAccount.getName(), adminAccount.getPassword(), AuthorityUtils.NO_AUTHORITIES);
    }
}
