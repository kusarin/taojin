<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">店铺添加</h1>
	<div align="center">
		<form id="myform" action="doAdd.do" method="post">
			<table>
				<tr>
					<td>name</td>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<td>type</td>
					<td><input type="text" name="type"></td>
				</tr>
				<tr>
					<td>intro</td>
					<td><input type="text" name="intro"></td>
				</tr>
			</table>
			 <input type="submit" value="添加"/>
			 <input type="button" value="返回" onclick="javaScript:history.back(-1)"/>
		</form>
	</div>
</body>
</html>