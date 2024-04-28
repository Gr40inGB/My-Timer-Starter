package org.gr40in.mytimerstarter.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Slf4j
@Component
@Aspect
public class TimerAspect {
    @Around("@annotation(org.gr40in.mytimerstarter.aspect.RunTimer)")
    public Object timeLogMethod(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        var startTime = LocalDateTime.now();
        System.out.println("am i work ?");
        log.info("method start - " + startTime);
        Object proceed = proceedingJoinPoint.proceed();
        var endTime = LocalDateTime.now();
        log.info("method finished - " + endTime);
        log.info("method running time = " + (Duration.between(startTime, endTime).toNanos() / 1000_000 + " msec"));
        return proceed;
    }

}
