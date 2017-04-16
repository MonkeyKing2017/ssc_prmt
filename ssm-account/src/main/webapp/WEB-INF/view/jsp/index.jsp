<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<body align="center">
<h2>欢迎登录</h2>
	<form action="<%=basePath%>cxuser/shouye" id="mainForm" method="get">
		用户名：<input type="text" name="name" /><br />
		密　码：<input type="password" name="password" /><br />
		<input type="submit" value="登陆" />
		<input type="reset" value="重置" /><br />
		<a href="<%=basePath%>cxuser/wangjimima">忘记密码</a><br />
		<a href="<%=basePath%>cxuser/zhuce">注册</a>
	</form>
</body>
</html>
