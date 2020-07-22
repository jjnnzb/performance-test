package com.example.performance.service.impl;

import cn.hutool.http.HttpUtil;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StopWatch;

import java.time.LocalDate;
import java.util.concurrent.Callable;

/**
 * @author Jiang Jining
 * @date 2020/7/22 21:17
 */
@Setter
@Slf4j
@AllArgsConstructor
public class PerformanceTask implements Callable<Long> {

    private Integer currentNum;
    private String url;

    @Override
    public Long call() throws Exception {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        LocalDate localDate = LocalDate.of(2020, 1, 1);
        localDate = localDate.plusDays(currentNum);
        url += "/s?wd=" + localDate.toString();
        String s = HttpUtil.get(url, 30_000);
        if (log.isDebugEnabled()) {
            log.debug(s);
        }
        stopWatch.stop();
        if (log.isInfoEnabled()) {
            log.info("currentNum:{}, date:{}, total:{}", currentNum, localDate.toString(), stopWatch.getTotalTimeSeconds());
        }
        return stopWatch.getTotalTimeMillis();
    }
}
