package com.njwx.demo;

import java.util.Calendar;

/**
 * java.util.Calendar demo
 *
 * @author Jiang Jining
 * @date 2020/3/17 23:10
 */
public class CalendarDemo {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        // 四月
        Calendar calendar1 = new Calendar.Builder().setDate(2020, Calendar.MARCH, 21).build();
        Calendar calendar2 = new Calendar.Builder().setDate(2020, 3, 21).build();
        System.out.println(calendar);
        System.out.println(calendar.getTimeZone());
        System.out.println(calendar1);
        System.out.println(calendar1.after(calendar2));
        System.out.println(calendar.after(calendar1));
        System.out.println(calendar.after(calendar2));
    }
}
