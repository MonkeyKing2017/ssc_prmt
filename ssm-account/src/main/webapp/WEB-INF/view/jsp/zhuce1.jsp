<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<title>注册页面</title>
</head>
<body align="center">
<h2>注册界面1</h2>
	<form action="<%=basePath%>cxuser/zhuce1" id="mainForm" method="get">
		用户名：<input type="text" name="account" /><br />
		密码：<input type="password" name="password" /><br />
		<!-- 再次输入密码：<input type="password1" name="password1" /><br /> -->
		<input type="submit" value="下一步" />
		
	</form>
</body>
</html>
