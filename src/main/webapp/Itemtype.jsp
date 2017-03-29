<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>查看某个类型商品</title>
<link />
</head>
<body>
	<form action="ItemType.do" method="post">
		<table>
			<tbody>
				<tr>
					<td>选择商品类型:</td>
					<td><select id="code" name="typeh">
							<option value="高级分类1">高级分类1</option>
							<option value="高级分类2">高级分类2</option>
					</select> <select id="code" name="typel">
							<option value="低级分类1">低级分类1</option>
							<option value="低级分类2">低级分类2</option>
					</select></td>
				</tr>

				<tr>
					<td><input type="submit" value="确认选择" /></td>
				</tr>
			</tbody>
		</table>
	</form>

		<tr>
			<td>当前商品类型:</td>
			
			<td>${itemtypechoice.typeh}</td>
			<td>${itemtypechoice.typel}</td>
			 
		</tr>
		
	<table width="90%" border="1" align="center">
		<tbody>
			<tr align="center">
				<td>编号</td>
				<td>商品名称</td>
				<td>商品类别</td>
				<td>商品价格</td>
				<td>商品描述</td>
			</tr>
			<c:forEach items="${itemtype}" var="i">

				<tr>
					<td>${i.item_id}</td>
					<td>${i.name}</td>
					<td>${i.part}</td>
					<td>${i.price}</td>
					<td>${i.detail}</td>
				</tr>

			</c:forEach>
		</tbody>
	</table>
</body>
</html>