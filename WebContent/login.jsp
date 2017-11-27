<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>已买网</title>
<style type="text/css">
	#box{
	margin-top:50px;
	width:500px;
	text-align: center;
	margin-left: 500px;
	border: 1px solid black; 
	
	
	}
	#b1{
		background-color: lightblue;
	}
	#b2{
	
		border: 1px solid black; 
	}
	table {
	margin-left 50px;
	
text-align: center;
	
	}
	a{
		text-decoration: none;
	 	
	
	
	}

</style>

</head>
<body>
<div id="box">
<div id="b1">欢迎来到已买网</div>


<div id="b2">

<%
	String mess=(String) request.getAttribute("mess");



		if(mess!=null) {%>
		
	<%=request.getAttribute("mess") %>
	
	
	<% } %>
	<!-- this.src='code.do?id='+new Date().gettime() -->
  <form action="login.do" method="post" onsubmit="return junge()">
  <table>
  <tr><td>用户名：</td><td colspan="2"><input type="text" name="uname" id="uname"><span id ="suname"></span></td></tr>
  <tr><td>登录密码：</td><td colspan="2"><input type="password" name="upwd" id ="upwd"><span id ="supwd"></span></td></tr>
  	<tr><td colspan="3"><a href ="#" onclick="flushPage()" >看不清，请刷新。</a></td></tr>
  <tr><td colspan="2">验证码：</td><td><input type="text" name="vcode"></td><td><img src="code.do" ></td></tr>
  
  <tr><td><input type="submit" value ="提交"></td><td colspan="2"><input type="reset" value="重置"></td></tr>
  	
  
  </table>
  
  
  </form>



</div>


</div>
<script type="text/javascript">
<!--
校验用户的输入数据
//-->


		/*获取刷新  */
		function flushPage(){
			
			location.reload("login.jsp");
			
			
		}
	/*获取数值  */
	
	function junge(){
		var uname =document.getElementById("uname").value;
		var upwd =document.getElementById("upwd").value;
		var supwd =document.getElementById("supwd").value;
		var suname =document.getElementById("suname").value;
	/*判断值是否为空  */
	if(uanem==null)
	{
		
		return  false;
		
		
		}
	
	if(upwd==null)
		{
			return false;
		
		}
	return true;
	
	}
	
</script>

</body>
</html>