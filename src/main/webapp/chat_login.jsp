<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.mn.js"></script>
<script type="text/javascript">
	function chatlogin() {
		var name = document.getElementById("name").value;
			$.ajax({
				url : "chatlogin.do",
				data : "name=" + name,
				dataType:'json',
			    
			});
			window.location.href = "chat_main.jsp";
	}
</script>
</head>
<body>
	
			姓名：<input type="text" id="name"><span id="sp"></span><br>
		<input type="button" value="登陆" onclick="chatlogin()"><font color=""></font>
	<br/>
	商品咨询：
	<div>
	<button type="button" id="name" name="feglin" onclick="chatlogin()">在线咨询</button>
	<font color=""></font> </div>

		
</body>
</html>