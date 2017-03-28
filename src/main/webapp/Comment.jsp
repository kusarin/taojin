<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>用户留言管理</title>
</head>
<body>
<form action="lookComment.do"></form>
<table width="90%" border="1" align="center">  
 <tbody>  
            <tr align="center">  
                <td>内容</td>  
                <td>发布时间</td>  
                <td>发布者ID</td> 
            </tr>  
            <c:forEach items="${Comment}" var="i">  
              <tr>  
                <td>  ${i.content}  </td>  
                <td> ${i.datetime} </td>  
                <td> ${i.User_id} </td>  
            </tr>  
            </c:forEach>  
</tbody>
</table>
</body>
</html>