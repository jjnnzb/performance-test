package com.njwx.demo.controller;

import com.njwx.demo.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jiang Jining
 * @date 2020/3/19 7:20
 */
@RestController
public class TimeController {

    @Autowired
    private TimeService timeService;

    @GetMapping("/test")
    public String getDateString() {
        return timeService.getCurrentTime();
    }
}
