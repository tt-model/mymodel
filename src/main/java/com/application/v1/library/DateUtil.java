package com.application.v1.library;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author ttm
 * @data 2017/11/21
 */
public class DateUtil {

    private static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd HH:MM:SS";

    private static final ThreadLocal<SimpleDateFormat> threadLocal = new ThreadLocal<SimpleDateFormat>();

    private static final Object object = new Object();

    /**
     * 获取系统当前时间, 格式: YYYY-MM-DD HH:MM:SS
     * @return
     */
    public static String fetchCurrentTime() {
        LocalDateTime localDateTime = LocalDateTime.now();
        return localDateTime.format(DateTimeFormatter.ofPattern(DEFAULT_DATE_FORMAT));
    }

    /**
     * 将日期字符串转化为日期。失败返回null。
     *
     * @param date
     *            日期字符串
     * @param pattern
     *            日期格式
     * @return 日期
     */
    public static Date StringToDate(String date, String pattern) {
        Date myDate = null;
        if (date != null) {
            try {
                myDate = getDateFormat(pattern).parse(date);
            } catch (Exception e) {
            }
        }
        return myDate;
    }

    /**
     * 获取SimpleDateFormat
     *
     * @param pattern
     *            日期格式
     * @return SimpleDateFormat对象
     * @throws RuntimeException
     *             异常：非法日期格式
     */
    private static SimpleDateFormat getDateFormat(String pattern)
            throws RuntimeException {
        SimpleDateFormat dateFormat = threadLocal.get();
        if (dateFormat == null) {
            synchronized (object) {
                if (dateFormat == null) {
                    dateFormat = new SimpleDateFormat(pattern);
                    dateFormat.setLenient(false);
                    threadLocal.set(dateFormat);
                }
            }
        }
        dateFormat.applyPattern(pattern);
        return dateFormat;
    }

}
