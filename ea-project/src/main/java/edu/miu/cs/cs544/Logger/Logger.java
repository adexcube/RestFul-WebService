package edu.miu.cs.cs544.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class Logger {

    @Before("within (edu.miu.cs.cs544.repository.appointment)")
    public void log(JoinPoint jp) {
        System.out.println("Method: " + jp.getSignature().getName() + " Executed.");
    }
}
