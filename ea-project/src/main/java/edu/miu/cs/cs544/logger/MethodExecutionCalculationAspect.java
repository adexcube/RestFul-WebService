package edu.miu.cs.cs544.logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class MethodExecutionCalculationAspect implements ILogger {
	public void log(String logstring) {
		java.util.logging.Logger.getLogger("AppLogger").info(logstring);
	}

	@Around("execution(* edu.miu.cs.cs544.controller.*.*(..))")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		long startTime = System.currentTimeMillis();
		Object obj = joinPoint.proceed();
		long timeTaken = System.currentTimeMillis() - startTime;

		String text = String.format("Time Taken by " + joinPoint.getSignature() + " is " + timeTaken + " milliseconds");
		log(text);
		return obj;
	}
}
