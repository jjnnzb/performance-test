package com.njwx.demo;

import cn.hutool.core.date.StopWatch;

import java.text.ParseException;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static com.njwx.demo.Constant.STANDARD_TIME_FORMATTER;
import static com.njwx.demo.Constant.STANDARD_WEIBO_TIME_PARSER;

/**
 * @author Jiang Jining
 * @date 2020/3/19 22:52
 */
public class MultiThreadSimpleDateFormatDemo {


    public static synchronized String formatDate(Date date) {
        return STANDARD_TIME_FORMATTER.format(date);
    }

    public static synchronized Date parse(String strDate) throws ParseException {
        return STANDARD_WEIBO_TIME_PARSER.parse(strDate);
    }

    public static void main(String[] args) throws InterruptedException {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        ExecutorService service = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 100; i++) {
            service.execute(() -> {
                for (int j = 0; j < 100; j++) {
                    try {
                        Date date = parse(Constant.WEIBO_TIME_STRING_DEMO3);
                        System.out.println(formatDate(date));
                    } catch (ParseException e) {
                        System.out.println(e.getMessage());
                    }
                }
            });
        }
        // 等待上述的线程执行完
        service.shutdown();
        service.awaitTermination(1, TimeUnit.DAYS);
        stopWatch.stop();
        System.out.println(stopWatch.getTotalTimeSeconds());
    }
}
