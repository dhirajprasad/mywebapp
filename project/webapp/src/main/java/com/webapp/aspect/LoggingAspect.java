package com.webapp.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect@Component
public class LoggingAspect {

	@After("execution(* com.webapp.service.EmployeeService.addEmployee(..))")
	public void logAfter(JoinPoint joinPoint) {

		System.out.println("logAfter() is running!");
		System.out.println("hijacked : " + joinPoint.getSignature().getName());
		System.out.println("******"+joinPoint.METHOD_EXECUTION);
		System.out.println(joinPoint.getArgs());
		Object[] arr=joinPoint.getArgs();
		for (Object object : arr) {
			System.out.println(">>><<<"+object);
		}

	}
	
	@Before("execution(* com.webapp.service.EmployeeService.addEmployee(..))")
	public void logBefore(JoinPoint joinPoint) {

		System.out.println("logbefore() is running!");
		System.out.println("hijacked : " + joinPoint.getSignature().getName());
		System.out.println("******");

	}
}
