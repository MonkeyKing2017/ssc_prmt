<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>2.找回密码</title>
</head>
<h2>2.找回密码</h2>
<body align="center">
	<form action="<%=basePath%>cxuser/wangjimima2" id="mainForm" method="get">
		您的手机号：<input type="text" name="" /><br /> 
		<input type="submit" value="下一步" />
	</form>
</body>
</html>