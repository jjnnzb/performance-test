package com.example.performance.service.impl;

import com.example.performance.entity.PerformanceEntity;
import com.example.performance.service.PerformanceService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Jiang Jining
 * @date 2020/7/22 20:45
 */
@Slf4j
@Service
public class PerformanceServiceImpl implements PerformanceService {

    private ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 1000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(),
            new BasicThreadFactory.Builder().namingPattern("performance-pool-%d").daemon(true).build());


    @Override
    public String calculatePerformance(PerformanceEntity performanceEntity) {
        Objects.requireNonNull(performanceEntity);
        Integer threadNum = performanceEntity.getThreadNum();
        Objects.requireNonNull(threadNum);
        String url = performanceEntity.getUrl();
        Objects.requireNonNull(url);
        AtomicInteger atomicInteger = new AtomicInteger(0);
        List<Long> timeConsumeList = new ArrayList<>(threadNum);
        List<PerformanceTask> futureList = new ArrayList<>(threadNum);
        List<Future<Long>> tempList = new ArrayList<>(threadNum);
        for (int i = 0; i < threadNum; i++) {
            PerformanceTask performanceTask = new PerformanceTask(atomicInteger.addAndGet(1), performanceEntity.getUrl());
            Future<Long> timeConsumeFuture = threadPoolExecutor.submit(performanceTask);
            tempList.add(timeConsumeFuture);
            futureList.add(performanceTask);
        }
        try {
            threadPoolExecutor.invokeAll(futureList, 1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            if (log.isErrorEnabled()) {
                log.error(e.getMessage());
            }
        }
        tempList.forEach(longFuture -> {
            try {
                Long aLong = longFuture.get();
                timeConsumeList.add(aLong);
            } catch (InterruptedException | ExecutionException exception) {
                if (log.isErrorEnabled()) {
                    log.error(exception.getMessage());
                }
            }
        });
        timeConsumeList.sort(Long::compare);
        long totalConsume = 0L;
        int size = timeConsumeList.size();
        for (Long aLong : timeConsumeList) {
            totalConsume += aLong;
        }
        int ninetyFifthIndex = (int) (size * 0.95);
        return "95%响应时间:" +
                timeConsumeList.get(ninetyFifthIndex - 1) +
                "ms, 平均响应时间:" +
                totalConsume * 1.0 / size +
                "ms";
    }
}
