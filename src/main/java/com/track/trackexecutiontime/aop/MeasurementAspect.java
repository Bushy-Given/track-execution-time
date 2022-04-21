package com.track.trackexecutiontime.aop;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class MeasurementAspect {
    @Around("@annotation(com.track.trackexecutiontime.aop.TrackExecutionTime)")
    @SneakyThrows(Throwable.class)
    public Object measureExecutionTime(ProceedingJoinPoint joinPoint) {
        long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long executionTime = System.currentTimeMillis() - start;
        log.info(joinPoint.getSignature() + " executed in " + executionTime + "ms");
        return proceed;
    }
}
