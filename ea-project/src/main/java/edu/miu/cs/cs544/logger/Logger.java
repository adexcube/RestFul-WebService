package edu.miu.cs.cs544.logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class Logger {

    @Before("execution (* edu.miu.cs.cs544.controller.*(..))")
    public void log(JoinPoint jp) {
        System.out.println("Method: " + jp.getSignature().getName() + " Executed.");
    }
}
