package com.example.tokyorestauranttakeout.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public interface PasswordUtil {

    /**
     * パスワードをエンコードする
     *
     * @param rawPassword エンコード前のパスワード
     * @return エンコードしたパスワード
     */
    String encode(String rawPassword);
}
