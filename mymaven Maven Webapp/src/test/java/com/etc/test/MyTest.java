package com.etc.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.etc.controller.AnimationVontroller;
import com.etc.dao.AnimationVideoMapper;
import com.etc.entity.Video;
import com.etc.service.AnimationVideoService;
import com.etc.service.impl.AnimationVideoServiceImpl;
import com.etc.tools.PageSupport;

public class MyTest {
	
	@Resource
	static
	AnimationVideoService avm;

	public static void test(){
		System.out.println(avm.showAnimationType().size());
		
	}
	
	public static void main(String[] args) {
		test();
	}
}
