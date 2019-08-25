package com.etc.controller;

import java.io.IOException;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.etc.entity.Topicreply;
import com.etc.entity.Topics;
import com.etc.entity.Topictype;
import com.etc.entity.User;
import com.etc.pojo.TopicsAllDisp;
import com.etc.service.TopicsService;
import com.etc.service.TopictypeService;
import com.etc.service.UserService;
import com.etc.tools.Constants;

@Controller
@SessionAttributes("user")
public class TopicsController {

	@Resource
	private TopicsService topicsService;
	@Resource
	private UserService userService;
	@Resource
	private TopictypeService topictypeService;
	
	
	@RequestMapping("/questions/queryAllTopicType")
	@ResponseBody     //返回字符串不会经过视图解析器也没有带特殊forward: redirect:
	public List<Topictype> queryAllTopicType(HttpServletResponse response) throws IOException{
		List<Topictype> topictypeList = topictypeService.queryAllTopictype();
		return topictypeList;
	}
	
	@RequestMapping("/questions/queryTopicsByTypeId")
	@ResponseBody
	public List<TopicsAllDisp> queryTopicsByTypeId(Integer topicsType_id, Integer nowPage, HttpServletResponse response) throws IOException{
		
//		response.setContentType("text/html;charset=utf-8");
//		PrintWriter out = response.getWriter();
		
		List<TopicsAllDisp> tadList = new ArrayList<TopicsAllDisp>();
		List<Topics> topicsList = topicsService.queryTopicsByTypeId(topicsType_id, new RowBounds((nowPage-1)*4, 4));
		List<Topicreply> topicreplyList;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		for (Topics topics : topicsList) {

			Topicreply lastReply = null;
			
			//找到当前帖子的最后一个回复记录
			if(!topics.getTopic_replies().isEmpty()){
				
				topicreplyList = topics.getTopic_replies();
				lastReply = topicreplyList.get(0);
				
				for (Topicreply t : topicreplyList) {
					if(lastReply.getReply_time().compareTo(t.getReply_time()) == -1){
						lastReply = t;
					}
				}
			}
			
			TopicsAllDisp tad = new TopicsAllDisp();
			tad.setTopics(topics);
			if(lastReply == null){
				tad.setReply_lastUser(null);
				tad.setReply_lastTime(null);
			}else{
				tad.setReply_lastUser(lastReply.getReply_user());
				tad.setReply_lastTime(format.format(lastReply.getReply_time()));
			}

			
			tadList.add(tad);
		}
		
		
		return tadList;
	}
	
	@RequestMapping("/questions/getMaxPage")
	@ResponseBody
	public Integer getMaxPage(Integer topicsType_id){
		
		int counts = topicsService.getCounts(topicsType_id);
		int pages = (counts%4==0)?(counts/4):((counts/4)+1);
		return pages;
		
	}
	
	@RequestMapping("/question/getTopFive")
	@ResponseBody
	public List<Topics> getTopFive(Integer topicsType_id){
		
		return topicsService.getTopFive(topicsType_id, new RowBounds(0,5));
		
	}
	
	@RequestMapping("/questions/login.html")
	@ResponseBody
	public String login(Model model, @RequestParam("user_phone") String user_phone, @RequestParam("user_password") String user_password,
			HttpSession session) {
		User user = userService.login(user_phone, user_password);
		model.addAttribute("user",user);
		if (user != null) {// 登录成功
			// 将用户信息保存到session
			return "1";//
		} else {// 登录失败
			return "0";
		}
	}
	
	@RequestMapping("/questions/isLogined")
	@ResponseBody
	public String isLogined(HttpSession session){
		if(session.getAttribute("user") != null){
			return "1";
		}
		return "0";
	}
	
	@RequestMapping("/questions/addTopics")
	@ResponseBody
	public void addTopics(String topicsTitle, String topicsType, String topicsContent, HttpServletResponse response) throws IOException{
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		System.out.println(topicsTitle + "    " + topicsType + "    " + topicsContent);
		
		out.print("1");
		out.flush();
		out.close();
		
	}
	
	
}
