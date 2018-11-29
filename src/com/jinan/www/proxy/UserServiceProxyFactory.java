package com.jinan.www.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.jinan.www.service.UserService;
import com.jinan.www.service.UserServiceImpl;


//观光代码->动态代理
public class UserServiceProxyFactory  implements InvocationHandler{

	private UserService us;
	
	
	public UserServiceProxyFactory(UserService us) {
		super();
		this.us = us;
	}

	public UserService getUserServiceProxy() {
		//生成动态代理
		UserService  usProxy = (UserService) Proxy.newProxyInstance(UserServiceProxyFactory.class.getClassLoader(), 
				UserServiceImpl.class.getInterfaces(),
				this);
		//返回
		return usProxy;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("打开事务");
		Object invoke = method.invoke(us, args);
		System.out.println("提交事务");
		return invoke;
	}
}
