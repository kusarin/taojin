<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="flush">
        <form action="">
		<table style="border-left-width: 0px; border-collapse: collapse; border-right-width: 0px;"bordercolor="#ff6600" bgcolor="#DFFFDF" cellspacing="0" cellpadding="0" width="250" align="center" border="1">
		<thead>
		<tr><th style="text-align: center;">店铺名</th>
		</tr></thead>
		<c:forEach items="${search }" var="c">
		<tr id="${c.shop_id }">
		<td>${c.name }</td>
		</tr>
		</c:forEach>
		</table></form>
</div>
</body>
</html>