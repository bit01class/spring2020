package com.bit.sts12.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BeforeAop {

	@Before("execution(* com.bit.sts12.service.EmpService.select*(..))")
	public void before() {
		System.out.println("Aop before시점에 출력");
	}
}
