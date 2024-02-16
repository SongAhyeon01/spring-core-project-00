package com.nhnacademy.spring.core;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

public class SpeedAspect {
    public Object doStopWatch(ProceedingJoinPoint pjp) throws Throwable {
        StopWatch stopWatch = new StopWatch("Profiling");

        try {
            stopWatch.start();
            Object retVal = pjp.proceed();

            return retVal;
        } finally {
            stopWatch.stop();
            System.out.println(stopWatch.prettyPrint());
        }
    }
}
