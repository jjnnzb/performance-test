package com.njwx.demo;

import org.springframework.util.StopWatch;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Jiang Jining
 * @date 2020/3/19 22:52
 */
public class LocalDateTimeFormatDemo {
    private static final DateTimeFormatter STANDARD_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public static final DateTimeFormatter STANDARD_WEIBO_TIME_PARSER = DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss Z yyyy", Locale.ENGLISH);

    public static String formatDate(LocalDateTime date) {
//        System.out.println(date);
        return STANDARD_TIME_FORMATTER.format(date);
    }

    public static LocalDateTime parse(String strDate) {
        return LocalDateTime.parse(strDate, STANDARD_WEIBO_TIME_PARSER);
    }

    public static void main(String[] args) throws InterruptedException {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        ExecutorService service = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 100; i++) {
            service.execute(() -> {
                for (int j = 0; j < 100; j++) {
                    String string = "Fri May 11 22:20:48 +0800 2012";
                    System.out.println(formatDate(parse(string)));
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
