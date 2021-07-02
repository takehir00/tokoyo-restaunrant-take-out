package com.example.tokyorestauranttakeout.util;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.sql.Date;
import java.time.format.DateTimeFormatter;

public class DateTimeUtil {

    /**
     * 生成禁止
     */
    private DateTimeUtil() {}

    /**
     * 現在日時を生成
     * @return 現在日時
     */
    public static LocalDateTime now() {
        return LocalDateTime.now().withNano(0);
    }

    /**
     * DateインスタンスとTimeインスタンスからLocalDateTimeインスタンスを生成する
     * @param date Dateインスタンス
     * @param time Timeインスタンス
     * @return LocalDateTimeインスタンス
     */
    public static LocalDateTime toLocalDatetime(Date date, Time time) {
        return LocalDateTime.of(date.toLocalDate(),time.toLocalTime());
    }

    /**
     * 日時を成形する
     * @param localDateTime LocalDateTimeインスタンス
     * @return 成形した日時
     */
    public static String format(LocalDateTime localDateTime) {
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("yyyy MM dd HH. mm. ss");
        return localDateTime.format(formatter);
    }
}
