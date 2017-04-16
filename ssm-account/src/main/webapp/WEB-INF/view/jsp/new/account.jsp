<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<script type="text/javascript" src="<%=basePath%>assets/js/jQuery/jquery-3.2.1.min.js"></script>
	</head>
	<body>
		<form action="<%=basePath%>cxuser/shshshshshs.do" id="accountForm" method="post">
			<table>
				<tbody>
					<tr>
						<td>车享账号</td>
						<td colspan="2"><input type="text" name="account" placeholder="请输入手机号" id="account" ></input></td>
						<td><span id="accountSpan">输入您的手机号码</span></td>
					</tr>
					<tr>
						<td>设置密码</td>
						<td colspan="2"><input type="password" name="password"></input></td>
						<td><span>您需要输入6-20位字符。使用字母、数字或符号组合更安全</span></td>
					</tr>
					<tr>
						<td>确认密码</td>
						<td colspan="2"><input type="password" name="password1"/></td>
						<td><span>两次密码不相同</span></td>
					</tr>
					<tr>
						<td>手机验证码</td>
						<td><input type="text" name="yz" style="width: 50px;"/></td>
						<td><input type="button" id="getYz" style="width: 150px;" value="获取手机验证码"/></td>
						<td></td>
					</tr>
					<tr>
						<td></td>
						<td colspan="2"><button type="button" id="accountBtn">注册</button></td>
						<td></td>
					</tr>
					<tr>
						<td></td>
						<td colspan="2"><input type="checkbox" id="tongyi" value="1"/>我已阅读并同意<a href="#">《车享网会员入会协议》</a></td>
						<td></td>
					</tr>
				</tbody>
			</table>
		</form>
	</body>
	<script type="text/javascript">
		
		var submitForm = function(u,d,s,e){
			$.ajax({
				type:"post",
				url:u,
				data:d,
				success:s,
				error:e
			});
		};
		var success = function(data){
			alert("成功了小臂篮子"+data);
		}
		var error = function(data){
			alert("失败了小臂篮子"+data)
		}
		$("#accountBtn").click(function(){
			<%-- console.log($("#accountForm").serialize());
			// 这是一种方法
			submitForm(
					"<%=basePath%>cxf/account.json",
					$("#accountForm").serialize(),
					success,error
			); --%>
			// 第二种方法
			$.ajax({
				type:"post",
				url:"<%=basePath%>cxf/account.json",
				data:$("#accountForm").serialize(),
				success: function(data){
					alert("成功了小臂篮子"+data);
				},
				error:function(data){
					alert("失败了小臂篮子"+data)
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



