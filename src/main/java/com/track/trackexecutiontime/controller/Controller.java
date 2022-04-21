package com.track.trackexecutiontime.controller;

import com.track.trackexecutiontime.aop.TrackExecutionTime;
import com.track.trackexecutiontime.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class Controller {
    private final JobService jobService;
    @GetMapping("/")
    @TrackExecutionTime //will track the time the method took to execute
    public String process(){
        jobService.doSomeProcessing();
        return "processed => execution time tracked";
    }
}
