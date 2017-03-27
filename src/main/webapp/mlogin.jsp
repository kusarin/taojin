<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


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
				<td><input type="text" name="account" /></td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input type="text" name="password" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="登录" /></td>
			</tr>
		</table>
	</form>
</body>
</html>
