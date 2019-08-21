<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>个人中心</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta charset="utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
	<body>
		<a href="#"><img src="C:\Users\Administrator\Desktop\wanjiang.jsp" alt="加载不出来" style="width: 100px;height: 100px;"/></a><br /><!--我是头像 -->
		
		<form action="${pageContext.request.contextPath}/center/update.html" method="post">
		<input type="text" name="name" id="" value="我是昵称" />&nbsp;<input type="text" name="sex" id="" value="我是性别" />
		<input type="submit" value="修改资料"/>
		</form>
		<h2>个人收藏</h2>
		<div style="border: dashed;width: 100px;height: 100px;float: left;"><a href="#">我是帖子收藏</a></div><div style="border: dashed;width: 100px;height: 100px;float: left;"><a href="#">我是视频收藏</a></div>
		<h2 style="clear: both;">个人发布</h2>
		<div style="border: dashed;width: 100px;height: 100px;float: left;"><a href="#">我是帖子发布</a></div><div style="border: dashed;width: 100px;height: 100px;float: left;"><a href="#">我是视频发布</a></div>
	</body>
</html>
<script>
	function firstinit()
	{
		$.getJSON("/center/init",{id:9},function(data){
			
		});
	}
	
</script>
