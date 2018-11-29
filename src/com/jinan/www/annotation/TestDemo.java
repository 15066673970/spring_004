package com.jinan.www.annotation;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jinan.www.service.UserService;

//�����Ǵ�������
@RunWith(SpringJUnit4ClassRunner.class)
//ָ����������ʱʹ���ĸ������ļ�
@ContextConfiguration("classpath:com/jinan/www/annotation/applicationContext.xml")
public class TestDemo {

	@Resource(name="userService")
	private UserService us;
	
	@Test
	public void fun1() {
		us.save();
	}
	


}
