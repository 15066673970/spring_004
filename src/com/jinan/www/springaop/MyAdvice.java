package com.jinan.www.springaop;

import org.aspectj.lang.ProceedingJoinPoint;

//֪ͨ��
public class MyAdvice {

	//ǰ��֪ͨ��Ŀ�귽������֮ǰ���á�
	//����֪ͨ������������쳣������ã�Ŀ�귽������֮�����
	//����֪ͨ����Ŀ�귽��֮ǰ��֮�󶼵���
	//�쳣����֪ͨ����������쳣�ͻ����
	//����֪ͨ���������Ƿ�����쳣������ã���Ŀ�귽������֮�����
	
	
	//ǰ��֪ͨ
	public void before() {
		System.out.println("����ǰ��֪ͨ");
	}
	//����֪ͨ
	public void afterReturning() {
		System.out.println("���Ǻ���֪ͨ����������쳣������ã�");
	}
	//����֪ͨ
	public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
		System.out.println("���ǻ���֪֮ͨǰ�Ĳ���");
		Object proceed= proceedingJoinPoint.proceed();//����Ŀ�귽��
		System.out.println("���ǻ���֪֮ͨ��Ĳ���");
		return proceed;
	}
	//�쳣֪ͨ
	public void afterException() {
		System.out.println("�����쳣��");
	}
	//����֪ͨ
	public void after() {
		System.out.println("���Ǻ���֪ͨ�������쳣Ҳ���ã�");
	}
}
