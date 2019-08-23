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
		<form method="post" enctype="multipart/form-data" id="form_pic">
		选择照片<input type="file" name="myfile"><br/>
		<input type="submit" value="提交照片">
		</form>
		<a href="javascript:void(0)"><img src="" style="width: 100px;height: 100px;" id="pic"/></a><br /><!--我是头像 -->
		
		<input type="text" name="name" id="name" value="我是昵称" />&nbsp;<input type="text" name="sex" id="sex" value="我是性别" />
		<input type="button" value="修改资料" onclick="updateAttr()"/>
		<h2>帖子专区</h2>
		<h3>我的帖子</h3>
		<h3>我的收藏</h3>
		<h2>视频专区</h2>
		<h3>我的视频</h3>
		<h3>我的收藏</h3>
	</body>

<script src="${pageContext.request.contextPath}/static/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
	var id=9;
	$(document).ready(function(){
		$("#form_pic").attr("action","${pageContext.request.contextPath}/uploadPic.html?id="+id);
		firstinit();
	});
	
	
	function firstinit()
	{
		$.getJSON("${pageContext.request.contextPath}/center/init.html",{id:id},function(data)
			{
				$("#name").attr("value",data.user_name);
				$("#sex").attr("value",data.user_sex);
				$("#pic").attr("src","${pageContext.request.contextPath}/center/pic/"+data.user_picture);
			});
	};
	
	function updateAttr()
	{
		var name=$("#name").val();
		var sex=$("#sex").val();
		$.getJSON("${pageContext.request.contextPath}/center/update.html",{id:id,name:name,sex:sex},function(data)
			{
				if(data==1)
					alert("修改成功");
				else alert("修改失败");
			});
	};
	
</script>
</html>
