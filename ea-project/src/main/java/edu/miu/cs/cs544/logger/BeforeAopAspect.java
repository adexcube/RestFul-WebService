package edu.miu.cs.cs544.logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class BeforeAopAspect implements ILogger {

	public void log(String logstring) {
		java.util.logging.Logger.getLogger("AppLogger").info(logstring);		
	}
	
    @Before("execution(* edu.miu.cs.cs544.controller.*.*(..))")
    public void logBefore(JoinPoint jp) {
    	log("Before executing Method: " + jp.getSignature().getName() + ".");
    }
}
