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
<title>4.找回密码</title>
</head>
<h2>4.找回密码</h2>
<body align="center">
	<form action="<%=basePath%>cxuser/wangjimima4" id="mainForm" method="get">
		恭喜找回密码成功<br />
		<input type="submit" value="返回主页" />
	</form>
</body>
</html>