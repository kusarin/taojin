<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>支付</title>
</head>
<body>
<p>${address}</p>
<p>${actulpayment}</p>
<c:if test="${payway==0}">
<p>支付方式：货到付款</p>
</c:if>
<c:if test="${payway==1}">
<p>支付方式：在线支付</p>
</c:if>
<c:forEach items="${orderDe}" var="v">
   <p>${v.unitPrice}</p>
   <p>${v.item.image}</p>
   <p>${v.itemId}</p>
</c:forEach>
</body>
</html>