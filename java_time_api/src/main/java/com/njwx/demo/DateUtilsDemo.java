package com.njwx.demo;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Apache commons-lang3 DateUtils demo.
 *
 * @author Jiang Jining
 * @date 2020/3/22 9:16
 */
public class DateUtilsDemo {
    public static void main(String[] args) throws ParseException {
        String pattern1 = "yyyy-MM-dd HH:mm:ss";
        String pattern2 = "EEE MMM dd HH:mm:ss Z yyyy";
        String[] patterns = new String[]{pattern1, pattern2};

        Date date1 = DateUtils.parseDate(Constant.WEIBO_TIME_STRING_DEMO6, Locale.ENGLISH, patterns);
        Date date2 = DateUtils.parseDate(Constant.WEIBO_TIME_STRING_DEMO7, patterns);
        String date1String = DateFormatUtils.format(date1, pattern1);
        String date2String = DateFormatUtils.format(date2, pattern1);
        System.out.println(date1String);
        System.out.println(date2String);
    }
}
