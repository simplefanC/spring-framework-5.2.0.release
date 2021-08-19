package com.simplefanc.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class HiAspect {
	@Pointcut("execution(* com.simplefanc.demo.service.impl.HiServiceImpl.*(..))")
	public void embed() {

	}

	@Before("embed()")
	public void before(JoinPoint joinPoint) {
		System.out.println("before拦截 " + joinPoint);
	}

	@After("embed()")
	public void after(JoinPoint joinPoint) {
		System.out.println("after拦截 " + joinPoint);
	}

	@AfterReturning(pointcut = "embed()", returning = "returnVal")
	public void afterReturning(JoinPoint joinPoint, Object returnVal) {
		System.out.println("afterReturning拦截 " + joinPoint + " 返回值[" + returnVal + "]");
	}
}
