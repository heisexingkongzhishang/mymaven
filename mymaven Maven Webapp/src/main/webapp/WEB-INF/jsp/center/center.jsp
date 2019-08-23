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
	<style>
	.div_scroll {
    	height: 200px;
    	overflow-y: scroll;
    	overflow-x: hidden;
	}
	</style>
  </head>
	<body>
		
		<a href="javascript:void(0)"><img src="" alt="暂无头像" style="width: 200px;height: 200px; border-radius: 50%" id="pic"/></a><br /><!--我是头像 -->
		<form method="post" enctype="multipart/form-data" id="form_pic">
		选择照片<input type="file" name="myfile">
		<input type="submit" value="提交照片">
		</form>
		<input type="text" name="name" id="name" value="我是昵称" style="clear:both;"/>&nbsp;<input type="text" name="sex" id="sex" value="我是性别" />
		<input type="button" value="修改资料" onclick="updateAttr()"/>
		<h2>帖子专区</h2>
		<h3>我的帖子</h3>
		<div id="mytopics" class="div_scroll"></div>
		<h3>我的收藏</h3>
		<div id="mycollectiontopics" class="div_scroll"></div>
		<h2>视频专区</h2>
		<h3>我的视频</h3>
		<h3>我的收藏</h3>
	</body>

<script src="${pageContext.request.contextPath}/static/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
	var id=10;
	$(document).ready(function(){
		$("#form_pic").attr("action","${pageContext.request.contextPath}/uploadPic.html?id="+id);
		firstinit();
		mytopics();
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
	
	function mytopics()
	{
		$.getJSON("${pageContext.request.contextPath}/center/mytopics.html",{id:id},function(data){
			str="<table>";
			for(var i=0;i<data.length;i++)
			{
				str+="<tr><td><a href='#'>"+data[i]+"</a></td></tr>";
			}
			str+="</table>";
			$("#mytopics").html(str);
		});
		$.getJSON("${pageContext.request.contextPath}/center/mycollectiontopics.html",{id:2},function(data){
			str="<table>";
			for(var i=0;i<data.length;i++)
			{
				str+="<tr><td><a href='#'>"+data[i]+"</a></td></tr>";
			}
			str+="</table>";
			$("#mycollectiontopics").html(str);
		});
	}
	
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
