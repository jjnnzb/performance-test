package com.njwx.demo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Jiang Jining
 * @date 2020/3/17 23:07
 */
public class DateFormatDemo {

    public static void main(String[] args) {
        DateTimeFormatter yyyyDateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter yYYYDateTimeFormatter = DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.of(2020, 12, 30, 20, 10, 20);
        LocalDateTime localDateTime1 = localDateTime.plusDays(1);
        LocalDateTime localDateTime3 = localDateTime.minusDays(1);
        LocalDateTime localDateTime2 = localDateTime.plusDays(2);
        System.out.println("case0 - origin: " + localDateTime.toString());
        System.out.println("case1 - origin: " +localDateTime1.toString());
        System.out.println("case2 - origin: " +localDateTime2.toString());
        System.out.println("case3 - origin: " +localDateTime3.toString());
        System.out.println("case0 - yyyy: " + localDateTime.format(yyyyDateTimeFormatter));
        System.out.println("case0 - YYYY: " + localDateTime.format(yYYYDateTimeFormatter));
        System.out.println("case1 - yyyy: " + localDateTime1.format(yyyyDateTimeFormatter));
        System.out.println("case1 - YYYY: " + localDateTime1.format(yYYYDateTimeFormatter));
        System.out.println("case2 - yyyy: " + localDateTime2.format(yyyyDateTimeFormatter));
        System.out.println("case2 - YYYY: " + localDateTime2.format(yYYYDateTimeFormatter));
        System.out.println("case4 - yyyy: " + localDateTime3.format(yyyyDateTimeFormatter));
        System.out.println("case4 - YYYY: " + localDateTime3.format(yYYYDateTimeFormatter));
    }
}
