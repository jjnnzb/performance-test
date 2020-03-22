package com.njwx.demo;

import org.apache.commons.lang3.time.DateUtils;

import java.util.Date;

/**
 * @author Jiang Jining
 * @date 2020/3/21 19:17
 */
public class ApacheCommonsDemo {
    public static void main(String[] args) {
        Date date = new Date();
        Date addedDate = DateUtils.addDays(date, 1);

        System.out.println(addedDate.toString());
    }
}
