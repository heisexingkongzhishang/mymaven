package com.etc.test;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.etc.dao.TopicTypeMapper;
import com.etc.entity.Topictype;
import com.etc.service.TopictypeService;

public class MyTest {

	@Test
	public void test1(){
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext-mybatis.xml");
		TopictypeService us = (TopictypeService) ctx.getBean("topictypeService");
		
		List<Topictype> list = us.queryAllTopictype();
		for(Topictype c : list){
			System.out.println(list.get(0).getTopicType_name());
		}
		
	}
	
}
