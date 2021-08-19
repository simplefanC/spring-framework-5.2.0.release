package com.simplefanc.demo.aspect;

import com.simplefanc.demo.introduction.LittleUniverse;
import com.simplefanc.demo.introduction.impl.LittleUniverseImpl;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class ServiceAspect {
	@Pointcut("execution(* com.simplefanc.demo.service..*.*(..))")
	public void embed() {

	}

	@Before("embed()")
	public void before(JoinPoint joinPoint) {
		System.out.println("before开始调用 " + joinPoint);
	}

	@Around("embed()")
	public Object around(JoinPoint joinPoint) throws Throwable {
		long startTime = System.currentTimeMillis();
		Object returnVal = null;
		System.out.println("around开始计时 " + joinPoint);
		returnVal = ((ProceedingJoinPoint) joinPoint).proceed();
		System.out.println("around执行成功，结束计时 " + joinPoint);
		System.out.println("around总耗时 " + joinPoint + " [" + (System.currentTimeMillis() - startTime) + "]");
		return returnVal;
	}

	@After("embed()")
	public void after(JoinPoint joinPoint) {
		System.out.println("after调用完成 " + joinPoint);
	}

	@AfterReturning(pointcut = "embed()", returning = "returnVal")
	public void afterReturning(JoinPoint joinPoint, Object returnVal) {
		System.out.println("afterReturning无论是空还是有值都返回 " + joinPoint + " 返回值[" + returnVal + "]");
	}

	@AfterThrowing(pointcut = "embed()", throwing = "ex")
	public void afterThrowing(JoinPoint joinPoint, Exception ex) {
		System.out.println("afterThrowing抛出异常通知 " + joinPoint + " " + ex.getMessage());
	}


	@DeclareParents(value = "com.simplefanc.demo.controller..*", defaultImpl = LittleUniverseImpl.class)
	public LittleUniverse littleUniverse;
}
