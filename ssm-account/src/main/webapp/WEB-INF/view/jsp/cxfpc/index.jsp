<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
	<style>
	.daxiao{
		height: 20px;
		width: 100%;
	}
	.zuofudong{
		height: 20px;
		width: 25%;
		float: left;
		
	}
	</style>
	<head>
		<title>登录页面</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<script type="text/javascript" src="<%=basePath%>assets/js/jQuery/jquery-3.2.1.min.js"></script>
	</head>
	<body>
		<div>
			<div>登录车享付</div>
			<div class="daxiao">
				<div class="zuofudong">
					<input class="" type="text" name="account" id="account" placeholder="车享账号" />
				</div>
			</div>
			<div class="daxiao">
				<div class="zuofudong"><span id="accountSpan" >　　　　　　　　　　</span></div>
			</div>
			<div class="daxiao">
				<div class="zuofudong"style="width: 20%">
					<input type="password" name="password" id="password" placeholder="密码"/>
				</div>
				<div class="zuofudong"><a href="<%=basePath%>cxfpc/forget.html">忘记密码</a></div>
			</div>
			<div class="daxiao">
				<div class="zuofudong"><span class="" id="" >　　　　　</span></div>
			</div>
			<div class="daxiao">
				<div class="zuofudong" style="width: 20%"><input type="text" name="yanzhengma" placeholder="验证码"/></div>
				<div class="zuofudong" style="width: 5%">KVX5</div>
				<div class="zuofudong">看不清？<a href="#">换一张</a></div>
			</div>
			<div class="daxiao">
				<div class="zuofudong"><span id="" ></span></div>
			</div>
			<div class="daxiao">
				<div class="zuofudong"><input type="button" id="accountBtn" value="登录"/></div>
			</div>
			<div class="daxiao">
				<div class="zuofudong" style="width: 10%">没有账号？</div>
				<div class="zuofudong"><a href="<%=basePath%>cxfpc/account.html">立即注册</a></div>
			</div>
		</div>
		
		
	<script type="text/javascript">
	
	$("#accountBtn").click(function(){
		if (checkAccount()) {
			$.ajax({
				type:"post",
				url:"<%=basePath%>cxfpc/index.json",
				data:{
					"account":$("#account").val(),
					"password":$("#password").val()
				},
				success:function(data){
					if (data == "index") {
						alert("登录成功");
					} else {
						$("#accountSpan").html("<span style='color:red;'>账号密码不存在</span>");
					}
				},
				error:function(){
				}
			});
		} else {
			$("#accountSpan").html("<span style='color:red;'>请输入正确的手机号</span>");
		}
	});
		
		var checkAccount = function (){
			var account = $("#account");
			var reg = /^1[3|4|5|8][0-9]\d{8}$/;
			if(!reg.test(account.val())){
				$("#accountSpan").html("<span style='color:red;'>请输入正确的手机号</span>");
				return false;
			}else{
				$("#accountSpan").html("<span style='color:green;'>输入正确</span>");
				return true;
			}
		}
		$("#account").blur(function(){
			checkAccount();
		});
		
	</script>
	
</html>

