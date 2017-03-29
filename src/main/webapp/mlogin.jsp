<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
    window.onload=function(){
    	var error="${requestScope.error}";
    	  if(error!=""&&error!=null&&typeof(error)!="undefined"){
    		  alert(error);
    	  }
    }
</script>

<title>二手淘金网--管理员登录</title>

<!-- 
 <link rel="stylesheet" type="text/css" href="styles.css"> 
 -->
</head>

<body>
	<form action="mlogin.do" method="post">
		<table>
			<tr>
				<td colspan="2">登录窗口</td>
			</tr>
			<tr>
				<td>账号：</td>
				<td><input type="text" name="account" />
			</tr>
			<tr>
				<td>密码：</td>
				<td><input type="password" name="password" />
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="登录" />
			</tr>
		</table>
	</form>
</body>
</html>
