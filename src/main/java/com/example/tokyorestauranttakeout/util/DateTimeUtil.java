package com.example.tokyorestauranttakeout.util;

import java.time.LocalDateTime;
import java.util.Date;

public class DateTimeUtil {

    /**
     * 生成禁止
     */
    private DateTimeUtil() {}

    public static LocalDateTime now() {
        return LocalDateTime.now();
    }
}
