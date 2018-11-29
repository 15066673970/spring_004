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
		//在动态代理中：代理对象与被代理对象实现了相同的接口
		//代理对象与被代理对象没有继承关系
		System.out.println(userServiceProxy instanceof UserServiceImpl);
	}
	
	
	@Test
	public void fun2() {
		
		UserServiceProxyFactory2 factory  = new UserServiceProxyFactory2();
		UserService userServiceProxy = factory.getUserServiceProxy();
		userServiceProxy.save();
		//在cglib代理中：代理对象继承了被代理的对象
		System.out.println(userServiceProxy instanceof UserServiceImpl);
	}
	

}
