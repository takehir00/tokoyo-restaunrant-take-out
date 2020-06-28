package com.example.tokyorestauranttakeout.util;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

/**
 * ファイル操作ユーティリティクラス
 */
@Component
public class FileUtil {

    public static String encodeBase64(MultipartFile file) throws IOException {
        byte[] data = file.getBytes();
        return Base64.getEncoder().encodeToString(data);
    }
}
