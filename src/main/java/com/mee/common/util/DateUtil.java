package com.mee.common.util;

import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @auther funnyzpc
 * @description process date or dateTime
 */
public class DateUtil {

    public static final DateTimeFormatter FORMAT_DAY = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static final DateTimeFormatter FORMAT_DAY_TIME = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public static final ZoneId zoneId = ZoneId.of("Asia/Shanghai");

    /**
     * 当前时间添加秒数
     * @param seconds
     * @return
     */
    public static LocalDateTime addSeconds(long seconds){
        return LocalDateTime.now(zoneId).plusSeconds(seconds);
    }

    /**
     * 当前时间加减天数
     * @param days
     * @return
     */
    public static String addDays(long days){
        return LocalDateTime.now(zoneId).plusDays(days).format(FORMAT_DAY);
    }

    public static LocalDateTime now(){
        return LocalDateTime.now(zoneId);
    }

    /**
     * 日期转换成时间字符串
     * @param date
     * @param formatStr
     */
    @Deprecated
    public static String format(Date date, String formatStr){
        if(date == null || StringUtils.isEmpty(formatStr)){
            return null;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formatStr);
        return simpleDateFormat.format(date);
    }

    /**
     * LocalDate、LocalDateTime 格式化字符串
     */
    public static String format(LocalDate localDate, String fmtPattern){
        if(localDate == null || StringUtils.isEmpty(fmtPattern)){
            return null;
        }
        return DateTimeFormatter.ofPattern(fmtPattern).format(localDate);
    }
    public static String format(LocalDateTime localDateTime, String fmtPattern){
        if(localDateTime == null || StringUtils.isEmpty(fmtPattern)){
            return null;
        }
        return DateTimeFormatter.ofPattern(fmtPattern).format(localDateTime);
    }

}
