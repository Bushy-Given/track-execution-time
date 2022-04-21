package com.track.trackexecutiontime.service;

import com.track.trackexecutiontime.aop.TrackExecutionTime;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class JobService {

    @TrackExecutionTime //will track the time the method took to execute
    @SneakyThrows(InterruptedException.class)
    public void doSomeProcessing() {
        log.info("processing task");
        Thread.sleep(5000);
        log.info("processing task done");
    }
}
