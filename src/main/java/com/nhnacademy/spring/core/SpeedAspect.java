package com.nhnacademy.spring.core;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class SpeedAspect {
    @Pointcut("execution(public boolean com.nhnacademy.spring.core.DoorayMessageSender.sendMessage(..))")
    public void doorayMessageSenderPointcut(){}

    @Around("doorayMessageSenderPointcut()")
    public Object doStopWatch(ProceedingJoinPoint pjp) throws Throwable {
        String className = pjp.getTarget().getClass().getSimpleName();
        String methodName = pjp.getSignature().getName();
        StopWatch stopWatch = new StopWatch("Profiling");

        try {
            stopWatch.start();
            Object retVal = pjp.proceed();

            return retVal;
        } finally {
            stopWatch.stop();
            long millis = stopWatch.getTotalTimeMillis();
            String formatMillis = String.format("[%s].[%s] [%d]ms", className, methodName, millis);
            System.out.println(formatMillis);
        }
    }
}
