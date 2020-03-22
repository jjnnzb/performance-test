package com.njwx.timedemo.service.impl;

import com.njwx.timedemo.service.TimeService;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executor;

/**
 * @author Jiang Jining
 * @date 2020/3/19 7:18
 */
@Service
public class TimeServiceImpl implements TimeService {

    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Executor executor = new S

    @Override
    public String getCurrentTime() {
        Date date = new Date();
        return simpleDateFormat.format(date);
    }
}
