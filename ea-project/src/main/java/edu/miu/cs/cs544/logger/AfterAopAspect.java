package edu.miu.cs.cs544.logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

import edu.miu.cs.cs544.service.Response;

@Aspect
@Configuration
public class AfterAopAspect implements ILogger {
	public void log(String logstring) {
		java.util.logging.Logger.getLogger("AppLogger").info(logstring);
	}

	@AfterReturning(value = "execution(* edu.miu.cs.cs544.controller.*.*(..))", returning = "result")
	public void afterReturning(JoinPoint joinPoint, Object result) {
		Response  response = (Response)result;
		String text = String.format(joinPoint + " returned with value " + response.getMessage());
		log(text);
	}

	@After(value = "execution(* edu.miu.cs.cs544.controller.*.*(..))")
	public void after(JoinPoint joinPoint) {
		log("after execution of " + joinPoint);
	}
}
