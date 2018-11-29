package com.jinan.www.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import com.jinan.www.service.UserService;
import com.jinan.www.service.UserServiceImpl;


//观光代码->cglib代理
public class UserServiceProxyFactory2  implements MethodInterceptor{


	public UserService getUserServiceProxy() {
		Enhancer enhancer =new Enhancer();//帮我们生成代理对象
		enhancer.setSuperclass(UserServiceImpl.class);//设置对谁进行代理
		enhancer.setCallback(this);//代理要做什么
		UserService userService = (UserService) enhancer.create();//创建代理对象
		return userService;
	}

	@Override
	public Object intercept(Object proxyobj, Method method, Object[] arg, MethodProxy methodProxy) throws Throwable {
		//打开事务
		System.out.println("打开事务");
		//打开原有事务
		Object returnValue = methodProxy.invokeSuper(proxyobj, arg);
		//提交事务
		System.out.println("提交事务");
		return returnValue;
	}
}
