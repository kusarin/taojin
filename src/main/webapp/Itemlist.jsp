<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>商品列表</title>
<link />
</head>
<body>
<form action="Itemlist.do"></form>
<table width="90%" border="1" align="center">  
 <tbody>  
            <tr align="center">  
                <td>编号</td>  
                <td>商品名称</td>  
                <td>商品类型</td>  
                <td>商品价格</td>  
                <td>商品描述</td>  
            </tr>  
            <c:forEach items="${itemlist}" var="i">  
              
              <tr>  
                <td>  ${i.item_id}  </td>  
                <td> ${i.name} </td>  
                <td> ${i.typel} </td>  
                <td> ${i.price} </td>  
                <td> ${i.detail} </td>    
            </tr>  
              
            </c:forEach>  
</tbody>
</table>
</body>
</html>