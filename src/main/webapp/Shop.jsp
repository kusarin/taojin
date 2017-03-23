<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action=""></form>
<table style="border-left-width:0px;border-collapse:collapse;border-right-width:0px;"bordercolor="#ff6600"bgcolor="#DFFFDF" cellspacing="0" cellpadding="0" width="250" align="center" border="1">
<tbody>
<tr align="middle">
<table width="90%" border="1" align="center">  
         <thead>  
                     <tr>  
                           <td colspan="10"  align="center">店铺信息管理</td>  
                     </tr>        
         </thead>  
         <tbody>  
            <tr align="center">  
                <td>编号</td>  
                <td>用户名</td>  
                <td>店名</td>  
                <td>类型</td>  
                <td>介绍</td>  
            </tr>  
            <c:forEach items="${shop}" var="c">  
              
              <tr>  
                <td>  ${c.Shop_id}  </td>  
                <td> ${c.userID} </td>  
                <td> ${c.name} </td>  
                <td> ${c.type} </td>  
                <td> ${c.intro} </td>  
                <td><a href="">查看</a></td>  
            </tr>  
              
            </c:forEach>  
</tbody></table>
</body>
</html>