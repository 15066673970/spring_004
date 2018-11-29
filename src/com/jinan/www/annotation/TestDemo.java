package com.jinan.www.annotation;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jinan.www.service.UserService;

//帮我们创建容器
@RunWith(SpringJUnit4ClassRunner.class)
//指定创建容器时使用哪个配置文件
@ContextConfiguration("classpath:com/jinan/www/annotation/applicationContext.xml")
public class TestDemo {

	@Resource(name="userService")
	private UserService us;
	
	@Test
	public void fun1() {
		us.save();
	}
	


}
