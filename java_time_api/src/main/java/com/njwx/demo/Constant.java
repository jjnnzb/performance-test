package com.njwx.demo;

import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * @author Jiang Jining
 * @date 2020/3/21 23:44
 */
public class Constant {
    private Constant(){}
    public static final String WEIBO_TIME_STRING_DEMO1 = "Fri May 11 22:20:48 +0800 2012";
    public static final String WEIBO_TIME_STRING_DEMO2 = "Mon Apr 16 21:33:03 +0800 2018";
    public static final String WEIBO_TIME_STRING_DEMO3 = "Sat Mar 21 23:47:29 +0800 2020";
    public static final String WEIBO_TIME_STRING_DEMO4 = "Sun Mar 01 23:54:48 +0800 2020";
    public static final String WEIBO_TIME_STRING_DEMO5 = "Wed Aug 14 11:47:23 +0800 2013";
    public static final String WEIBO_TIME_STRING_DEMO6 = "Tue Feb 28 12:02:27 +0800 2017";
    public static final String WEIBO_TIME_STRING_DEMO7 = "2020-03-21 18:40:32";

    public static final String STANDARD_WEIBO_TIME_PATTERN = "EEE MMM dd HH:mm:ss Z yyyy";
    public static final SimpleDateFormat STANDARD_WEIBO_TIME_PARSER = new SimpleDateFormat(STANDARD_WEIBO_TIME_PATTERN, Locale.ENGLISH);
    public static final String STANDARD_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static final SimpleDateFormat STANDARD_TIME_FORMATTER = new SimpleDateFormat(STANDARD_TIME_PATTERN);
}
