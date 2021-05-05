package com.example.tokyorestauranttakeout.security.client;

import com.example.tokyorestauranttakeout.entity.ClientAccount;
import com.example.tokyorestauranttakeout.repositories.ClientAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class ClientUserDaoRealm implements UserDetailsService {

    @Autowired
    ClientAccountRepository clientAccountRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        ClientAccount clientAccount = clientAccountRepository.selectByEmail(email)
                .orElseThrow(() -> {
                    throw new UsernameNotFoundException("your email not found");
                });
        return new ClientLoginUser(
                clientAccount.getId(),
                clientAccount.getEmail(),
                clientAccount.getPassword(),
                clientAccount.getName(),
                AuthorityUtils.NO_AUTHORITIES);
    }
}
