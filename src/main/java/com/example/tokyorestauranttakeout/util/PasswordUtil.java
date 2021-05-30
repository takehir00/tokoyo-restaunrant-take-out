package com.example.tokyorestauranttakeout.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public interface PasswordUtil {

    String encode(String decodedPassword);
}
