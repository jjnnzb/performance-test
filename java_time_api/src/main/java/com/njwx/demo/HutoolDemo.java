package com.njwx.demo;

import cn.hutool.core.date.DateUtil;

import java.util.Date;

/**
 * @author Jiang Jining
 * @date 2020/3/20 8:00
 */
public class HutoolDemo {
    public static void main(String[] args) {
        Date date = DateUtil.parse("2020-03-20 08:05:00");
        System.out.println(date.toString());

    }
}
