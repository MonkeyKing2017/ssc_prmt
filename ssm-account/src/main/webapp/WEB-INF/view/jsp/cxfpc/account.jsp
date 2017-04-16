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
		<title>注册页面</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<script type="text/javascript" src="<%=basePath%>assets/js/jQuery/jquery-3.2.1.min.js"></script>
	</head>
	<body>
		<div>注册车享账号<input type="button" id="wori" value="wori?"/></div>
<!-- 注册会员第一页 -->	
		<div class="One">
			<div class="daxiao">
				<div class="zuofudong">成为注册会员</div>
				<div class="zuofudongqianse">注册成功</div>
			</div>
			<div>
				<div class="daxiao">
					<div class="zuofudong">
						车享账号:
					</div>
					<div class="zuofudong" >
						<input type="text" name="account"  id="account"/>
					</div>
					<div class="zuofudong">
						<span id="accountSpan">输入您的手机号码</span>
					</div>
				</div>
				<div class="daxiao">
					<div class="zuofudong">
						设置密码:
					</div>
					<div class="zuofudong">
						<input type="password"id="password"/>
					</div>
					<div class="zuofudong" style="width: 50%;">
						<span>您需要输入6~20位的字符，使用字母或字符组合更安全。</span>
					</div>
				</div>
				<div class="daxiao">
					<div class="zuofudong">
						确认密码:
					</div>
					<div class="zuofudong">
						<input type="password" id="password1" />
					</div>
					<div class="zuofudong">
						<span id="passwordSpan">　　　　　</span>
					</div>
				</div>
				<div class="daxiao">
					<div class="zuofudong">
						验证码:
					</div>
					<div class="zuofudong">
						<input type="text" name="yanzhengma" />
					</div>
					<div class="zuofudong">
						<input type="button" value="获取手机验证码"/>
					</div>
				</div>
				<div>
					<div>
						<input id="buttonZhuCe" type="button" value="注册"/>
					</div>
				</div>
				<div class="daxiao">
					<div class="zuofudong">
						<input type="checkbox" class="tongyi" value="1"/>我已阅读并同意
					</div>
					<div class="zuofudong">
						<a href="#">《车享网会员入会协议》</a>
					</div>
				</div>
			</div>
		</div>
<!-- 注册会员第二页 -->		
		<div class="Two" style="display:none;">
			<div class="daxiao">
				<div class="zuofudongqianse">成为注册会员</div>
				<div class="zuofudong">注册成功</div>
			</div>
			<div>
				<h1>恭喜您成为车享会员</h1>
				<p>
					我们诚挚的邀请您进一步成为认证会员
				</p>
				<p class="zuofudongqianse">
					您将享有的车享认证会员收益<br />
					-违章查询<br />
					-租车85折特权<br />
					-免费道路求援<br />
				</p>
			</div>
			<div>
				<input id="accountBtn" type="button" value="进入车享付" />
			</div>
		</div>
<!-- 弹出层 -->
		<div class="showDiv">
			
		</div>

	</body>
	<script type="text/javascript">
	$("#wori").click(function(){
		var persons = new Array();
		persons.push({
            name:"员工3",
            id:"1546134"
        });
		persons.push({
            name:"员工2",
            id:"1sssss"
        });
		var job = {};
		job.name = "wori?";
		job.persons = persons;
		console.log(JSON.stringify(persons));
		console.log(JSON.stringify(job));
		$.ajax({
			type:"post",
			url:"<%=basePath%>cxfpc/hehehe.json",
			data:JSON.stringify(job)
			,
			dataType:"json",
			contentType:"application/json;charset=utf-8",
			success:function(data){
				console.log(data);
				alert(1);
			},
			error:function(data){
				console.log(data);
				alert(2);
			}
		});
	});
	$("#buttonZhuCe").click(function(){
		
		if (checkAccount() && checkPassword()) {
			$.ajax({
				type:"get",
				url:"<%=basePath%>cxfpc/account.json",
				data:{
					"account":$("#account").val(),
					"password":$("#password").val()
				},
				success:function(data){
					if (data == "AAAA") {
						$(".One").hide();
						$(".Two").show();
					} 
				},
				error:function(){
					alert("注册失败了，少年");
				}
			});
		} else {
			checkAccount();
			checkPassword();
		}	
	});	
	
	$("#accountBtn").click(function(){
				location.href = "<%=basePath%>cxfpc/personal.html";
		});
	
	$("#account").blur(function(){
		checkAccount();
	});
	
	var checkAccount = function (){
		var account = $("#account");
		var reg = /^1[3|4|5|8][0-9]\d{8}$/;
		if(reg.test(account.val())){
			$("#accountSpan").html("<span style='color:green;'>输入正确</span>");
			return true;
		}else{
			$("#accountSpan").html("<span style='color:red;'>请输入正确的手机号</span>");
			return false;
		}};
		
	$("#password1").blur(function(){
		checkPassword();
	});
	
	var checkPassword = function(){
		if (($("#password").val() != null) && ($("#password").val() != "")) {
			if ($("#password").val() == $("#password1").val()) {
				$("#passwordSpan").html("<span style='color:green;'>两次密码相同</span>");
				return true;
			} else {
				$("#passwordSpan").html("<span style='color:red;'>两次密码不相同</span>");
				return false;
			}
		}else {
			$("#passwordSpan").html("<span style='color:red;'>密码为空</span>");
		}
	};
	
	
	
	</script>
	
</html>	