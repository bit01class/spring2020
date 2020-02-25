package com.bit.sts12.util;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

//@Aspect
//@Component
public class BeforeAop {
	//https://www.egovframe.go.kr/wiki/doku.php?id=egovframework:rte:fdl:aop:aspectj
	
//	@Before("execution(* com.bit.sts12.service.EmpService.select*(..))")
	public void before(JoinPoint join) {
		System.out.println("Aop before시점에 출력");
		System.out.println(join.getTarget());
		System.out.println(Arrays.toString(join.getArgs()));
	}
}
