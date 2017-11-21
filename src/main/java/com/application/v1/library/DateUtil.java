package com.application.v1.library;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author ttm
 * @data 2017/11/21
 */
public class DateUtil {

    private static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd HH:MM:SS";

    /**
     * 获取系统当前时间, 格式: YYYY-MM-DD HH:MM:SS
     * @return
     */
    public static String fetchCurrentTime() {
        LocalDateTime localDateTime = LocalDateTime.now();
        return localDateTime.format(DateTimeFormatter.ofPattern(DEFAULT_DATE_FORMAT));
    }

}
