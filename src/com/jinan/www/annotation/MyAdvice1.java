package com.jinan.www.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;


//֪ͨ��
@Aspect
//��ʾ������һ��֪ͨ��
public class MyAdvice1 {
	@Pointcut(value = "execution(*  com.jinan.www.service.*ServiceImpl.*(..))")
	public void pc() {
		
	}

		
	//ǰ��֪ͨ
	//ָ���÷�����ǰ��֪ͨ����ָ�������
	@Before("MyAdvice1.pc()")
	public void before() {
		System.out.println("����ǰ��֪ͨ");
	}
	//����֪ͨ
	@AfterReturning("MyAdvice1.pc()")
	public void afterReturning() {
		System.out.println("���Ǻ���֪ͨ����������쳣������ã�");
	}
	//����֪ͨ
	@Around("MyAdvice1.pc()")
	public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
		System.out.println("���ǻ���֪֮ͨǰ�Ĳ���");
		Object proceed= proceedingJoinPoint.proceed();//����Ŀ�귽��
		System.out.println("���ǻ���֪֮ͨ��Ĳ���");
		return proceed;
	}
	//�쳣֪ͨ
	@AfterThrowing("MyAdvice1.pc()")
	public void afterException() {
		System.out.println("�����쳣��");
	}
	//����֪ͨ
	@After("MyAdvice1.pc()")
	public void after() {
		System.out.println("���Ǻ���֪ͨ�������쳣Ҳ���ã�");
	}
}
