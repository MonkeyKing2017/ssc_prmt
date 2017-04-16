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
.zuida{
	height: 100%;
	width: 100%;
}
.daxiao{
	height: 20px;
	width: 100%;
}
.zuofudong{
	height: 20px;
	width: 25%;
	float: left;
	
}
.zuofudongqianse{
	height: 20px;
	width: 100px;
	float: left;
	color: #C0C0C0;
}
</style>
	<head>
		<title>找回密码</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<script type="text/javascript" src="<%=basePath%>assets/js/jQuery/jquery-3.2.1.min.js"></script>
	</head>
	<body>
		<div class="zuida" >找回登录密码</div>
<!-- 找回密码第一页 -->
		<div class="One">
			<div class="daxiao">
				<div class="zuofudong">输入账号</div>
				<div class="zuofudongqianse">身份验证</div>
				<div class="zuofudongqianse">重置密码</div>
				<div class="zuofudongqianse">找回成功</div>
			</div>
			<div class="">
				<div class="">
					账　号：<input type="text" name="account" id="account" placeholder="手机号"/>
				</div>
				<div class="">
					<span id="accountSpan">　　　　　　　　　　</span>
				</div>
				<div class="daxiao" >
					<div class="zuofudong">验证码：<input type="text" name="yanzhengma" placeholder="验证码"/></div>
					<div class="zuofudong">KVX5看不清？<a href="#">换一张</a></div>
				</div>
				<div>
					<br />
					<input class="OneBut" type="button" value="下一步" />
				</div>
			</div>
		</div>	
<!-- 找回密码第二页 -->
		<div class="Two" style="display:none;" >
			<div class="daxiao">
				<div class="zuofudongqianse">输入账号</div>
				<div class="zuofudong">身份验证</div>
				<div class="zuofudongqianse">重置密码</div>
				<div class="zuofudongqianse">找回成功</div>
			</div>
			<div>
				<div>
					您的手机号：<input type="text" name="account"/>
				</div>
				<div class="daxiao" style="width: 500px;">
					<div>验证码：<input type="text" name="yanzhengma" placeholder="验证码"/></div>
					<div><input type="button" value="免费获取验证码"></div>
				</div>
				<div></div>
				<div >
					<br />
					<br />
					<input class="TwoBut" type="button" value="下一步" />
				</div>
			</div>
		</div>
<!-- 找回密码第三页 -->
		<div class="Three" style="display:none;">
			<div class="daxiao">
				<div class="zuofudongqianse">输入账号</div>
				<div class="zuofudongqianse">身份验证</div>
				<div class="zuofudong">重置密码</div>
				<div class="zuofudongqianse">找回成功</div>
			</div>
			<div>
				<div>
					<div class="zuofudong">
						新密码　：<input type="password" name="password" id="password"/>
					</div>
					<div class="zuofudong">
						6~20位字符，可以为英文或数字
					</div>
				</div>
				<div>
					<br />
				</div>
				<div class="zuofudong">
					再次确认：<input type="password" name="password1"/>
				</div>
				<div>
					<br />
				</div>
				<div>
					<input class="ThreeBut" type="button" value="下一步" />
				</div>
			</div>
		</div>
<!-- 找回密码第四页 -->
		<div class="Four" style="display:none;">
			<div class="daxiao">
				<div class="zuofudongqianse">输入账号</div>
				<div class="zuofudongqianse">身份验证</div>
				<div class="zuofudongqianse">重置密码</div>
				<div class="zuofudong">找回成功</div>
			</div>
			<div>
				<h1>恭喜您！找回成功</h1>
				<p>
					我们已经将您账号的密码修改为您提交的新密码，
					请您使用新密码登录车享付网站。
				</p>
			</div>
			<div>
				<input class="FourBut" type="button" value="前往登录" />
			</div>
		</div>	
	</body>
	<script type="text/javascript">

	
	$(".TwoBut").click(function(){
		$(".Two").hide();
		$(".Three").show();
		return true;
	});	
	
	$(".OneBut").click(function(){
		if (checkAccount()) {
			$.ajax({
				type:"post",
				url:"<%=basePath%>cxfpc/forget.json",
				data: {
					"account":$("#account").val()
				},
				success:function(data){
					if (data == "forget") {
						$(".One").hide();
						$(".Two").show();
					} else {
						alert("账号不存在");
					}
				},
				error:function(data){
					alert("失败了"+data);
				}
			});
		} else {
			$("#accountSpan").html("<span style='color:red;'>请输入正确的手机号</span>");
		}
	});	
	

	$(".ThreeBut").click(function(){
		$.ajax({
			type:"post",
			url:"<%=basePath%>cxfpc/forget1.json",
			data: {
				"account":$("#account").val(),
				"password":$("#password").val()
			},
			success:function(data){
				if (data == "forget") {
					$(".Three").hide();
					$(".Four").show();
				} else {
				alert("账号不存在");
				}
			},
			error:function(data){
				alert("失败了"+data);
			}
		});	
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