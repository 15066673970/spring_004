package com.jinan.www.proxy;

import org.junit.Test;

import com.jinan.www.service.UserService;
import com.jinan.www.service.UserServiceImpl;

public class TestDemo {

	@Test
	public void fun1() {
		UserService userService = new UserServiceImpl();
		
		UserServiceProxyFactory factory  = new UserServiceProxyFactory(userService);
		UserService userServiceProxy = factory.getUserServiceProxy();
		userServiceProxy.save();
		//�ڶ�̬�����У���������뱻�������ʵ������ͬ�Ľӿ�
		//��������뱻�������û�м̳й�ϵ
		System.out.println(userServiceProxy instanceof UserServiceImpl);
	}
	
	
	@Test
	public void fun2() {
		
		UserServiceProxyFactory2 factory  = new UserServiceProxyFactory2();
		UserService userServiceProxy = factory.getUserServiceProxy();
		userServiceProxy.save();
		//��cglib�����У��������̳��˱�����Ķ���
		System.out.println(userServiceProxy instanceof UserServiceImpl);
	}
	

}
