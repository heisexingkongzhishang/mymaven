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
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
	<body>
		<a href="#"><img src="" alt="加载不出来" style="width: 100px;height: 100px;"/></a><br /><!--我是头像 -->
		
		<input type="text" name="name" id="name" value="我是昵称" />&nbsp;<input type="text" name="sex" id="sex" value="我是性别" />
		<input type="button" value="修改资料" onclick="updateAttr()"/>
		<h2>个人收藏</h2>
		<div style="border: dashed;width: 100px;height: 100px;float: left;"><a href="#">我是帖子收藏</a></div><div style="border: dashed;width: 100px;height: 100px;float: left;"><a href="#">我是视频收藏</a></div>
		<h2 style="clear: both;">个人发布</h2>
		<div style="border: dashed;width: 100px;height: 100px;float: left;"><a href="#">我是帖子发布</a></div><div style="border: dashed;width: 100px;height: 100px;float: left;"><a href="#">我是视频发布</a></div>
	</body>

<script src="${pageContext.request.contextPath}/static/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		firstinit();
	});
	

	function firstinit()
	{
		$.getJSON("${pageContext.request.contextPath}/center/init.html",{id:9},function(data)
			{
				$("#name").attr("value",data.user_name);
				$("#sex").attr("value",data.user_sex);
			});
	};
	
	function updateAttr()
	{
		var name=$("#name").val();
		var sex=$("#sex").val();
		alert("name:"+name+" sex:"+sex);
		$.getJSON("${pageContext.request.contextPath}/center/update.html",{id:9,name:name,sex:sex},function(data)
			{
				if(data==1)
					alert("修改成功");
				else alert("修改失败");
			});
	};
	
</script>
</html>
