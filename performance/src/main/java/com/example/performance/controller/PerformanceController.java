package com.example.performance.controller;

import com.example.performance.entity.PerformanceEntity;
import com.example.performance.entity.ResponseBean;
import com.example.performance.service.PerformanceService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Jiang Jining
 * @date 2020/7/22 20:39
 */
@CrossOrigin
@RestController
public class PerformanceController {

    @Resource
    private PerformanceService performanceService;

    @PostMapping(value = "/api/v1/performance/test")
    public ResponseBean<String> testPerformance(@RequestBody PerformanceEntity performanceEntity) {
        String s = performanceService.calculatePerformance(performanceEntity);
        return ResponseBean.success(s);
    }
}
