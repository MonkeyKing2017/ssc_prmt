<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<html>
	<body>
		<form action="<%=basePath%>cxuser/zhuce.do" id="mainForm" method="get">
			昵　称：<input type="text" name="account" /><br />
			用户名：<input type="text" name="name" /><br />
			密　码：<input type="password" name="password" /><br />
			邮　箱：<input type="text" name="email" /><br />
			<input type="submit" value="注册" />
		</form>
	</body>
</html>


