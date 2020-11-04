package com.ly.commons.demos.java8;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * @ClassName LocalDateTimeDemo
 * @Author alan.wang   QQ:3103484396
 * @Description
 */
public class LocalDateTimeDemo
{
    static DateTimeFormatter dateTimeFormatter =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void dayOfMonth(){
        /* now获取当前系统时间 */
        LocalDateTime localDateTime = LocalDateTime.now();
        /* LocalTime\LocalDate */
        LocalDate localDate = LocalDate.from(localDateTime);
        int month = localDate.getMonthValue();
        //利用Date获取这个月的最后一天
        System.out.println(month + ":共有" + localDate.lengthOfMonth() + "天");
    }
    public static void afterDay(int day)
    {
        LocalDateTime localDateTime = LocalDateTime.now();
        localDateTime = localDateTime.plusDays(day);
        String dateStr = localDateTime.format(dateTimeFormatter);
        System.out.println(dateStr);
    }
    public static void startAndEnd(){
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime start =
                LocalDateTime.of(localDateTime.getYear() , localDateTime.getMonth() , 1 , localDateTime.getHour() , localDateTime.getMinute());
        System.out.println(start.format(dateTimeFormatter));

        LocalDate localDate = LocalDate.from(localDateTime);
        LocalDateTime end =
                LocalDateTime.of(localDateTime.getYear() , localDateTime.getMonth() , localDate.lengthOfMonth() , localDateTime.getHour() , localDateTime.getMinute());
        System.out.println(end.format(dateTimeFormatter));
    }
    public static void dateToLocalDateTime(){
        Date date = new Date();
        Instant instant = date.toInstant();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant , ZoneId.systemDefault());
    }

    public static void main(String[] args) {
        startAndEnd();
    }
}
