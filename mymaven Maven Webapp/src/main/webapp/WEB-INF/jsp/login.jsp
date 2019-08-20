<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>用户登录</title>

</head>

<body>
	<form action="${pageContext.request.contextPath}/user/login.html" method="post">
		<p>账号：<input type="text" name="userCode"></p>
		<p>密码：<input type="password" name="userPassword"></p>
		<p>
			<input type="submit" value="登录">
		</p>
	</form>
</body>
</html>
