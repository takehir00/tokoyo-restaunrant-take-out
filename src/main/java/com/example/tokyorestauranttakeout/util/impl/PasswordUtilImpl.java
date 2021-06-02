package com.example.tokyorestauranttakeout.util.impl;

import com.example.tokyorestauranttakeout.util.PasswordUtil;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PasswordUtilImpl implements PasswordUtil {

    /**
     * {@inheritDoc}
     */
    public String encode(String decodedPassword) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(decodedPassword);
    }
}
