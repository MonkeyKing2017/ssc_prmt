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
	<h2>3.完善个人信息-提交成功</h2>
	<form action="<%=basePath%>cxuser/geren3" id="mainForm" method="get">
		完善个人信息成功<br /> 
		<input type="submit" value="实名认证" />
	</form>
</body>
</html>