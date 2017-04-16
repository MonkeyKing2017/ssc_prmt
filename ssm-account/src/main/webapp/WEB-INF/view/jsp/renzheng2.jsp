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
<title>实名认证</title>
</head>
<body align="center">
	<h2>2.认证信息</h2>
	<form action="<%=basePath%>cxuser/renzheng2" id="mainForm" method="get">
		完成实名认证<br /> 
		<input type="submit" value="返回主页" />
	</form>
</body>
</html>