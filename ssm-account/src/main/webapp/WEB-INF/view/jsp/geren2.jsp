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
<title>个人信息</title>
</head>
<body align="center">
	<h2>2.完善个人信息-添加爱车</h2>
	<form action="<%=basePath%>cxuser/geren2" id="mainForm" method="get">
		姓名：<input type="text" name="account" /><br /> 
		车牌号：<input type="text" name="xxxx" /><br /> 
		VIN号：<input type="text"name="xxxx" /><br /> 
		<input type="submit" value="下一步" />
	</form>
</body>
</html>