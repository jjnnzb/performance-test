package com.njwx.demo;

import java.util.Calendar;
import java.util.Date;

/**
 * @author Jiang Jining
 * @date 2020/3/20 7:46
 */
public class ClassicDateDemo {
    public static void main(String[] args) {
        System.out.println("--------------Date-Demo1--------------");
        Date date = new Date(2020, Calendar.MARCH, 20, 10, 20, 30);
        // date to string
        System.out.println(date.toString());

        System.out.println("--------------Date-Demo2--------------");
        Date date1 = new Date();
        System.out.println(date1.getTime());
        // now to string
        System.out.println(date1.toString());
        // tomorrow to date to string
        System.out.println(new Date(date1.getTime() + 24 * 3600 * 1000L));

        System.out.println("--------------Date-Demo3--------------");
        Date date2 = new Date(Constant.WEIBO_TIME_STRING_DEMO1);
        System.out.println(date2.toString());
        // date - non null
        System.out.println(date2.compareTo(date));
        System.out.println(date2.toLocaleString());
    }
}
