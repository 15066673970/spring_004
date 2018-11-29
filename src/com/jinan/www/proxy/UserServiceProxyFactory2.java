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


//�۹����->cglib����
public class UserServiceProxyFactory2  implements MethodInterceptor{


	public UserService getUserServiceProxy() {
		Enhancer enhancer =new Enhancer();//���������ɴ������
		enhancer.setSuperclass(UserServiceImpl.class);//���ö�˭���д���
		enhancer.setCallback(this);//����Ҫ��ʲô
		UserService userService = (UserService) enhancer.create();//�����������
		return userService;
	}

	@Override
	public Object intercept(Object proxyobj, Method method, Object[] arg, MethodProxy methodProxy) throws Throwable {
		//������
		System.out.println("������");
		//��ԭ������
		Object returnValue = methodProxy.invokeSuper(proxyobj, arg);
		//�ύ����
		System.out.println("�ύ����");
		return returnValue;
	}
}
