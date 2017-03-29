<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>用户留言管理</title>
</head>
<body>

<table width="90%" border="1" align="center">  
 <tbody>  
            <tr align="center">  
                <td width="60%">内容</td>  
                <td width="30%">发布时间</td>  
                <td width="10%">发布者ID</td> 
            </tr>  
            <c:forEach items="${Comment}" var="i">  
              <tr>  
                <td> ${i.content} </td>  
                <td> ${i.datetime}</td>  
                <td> ${i.user_id} </td>  
            </tr>  
            </c:forEach>  
            <tr>
            <form action="lookComment.do" method="post">
            <td><input type="submit" value="显示" /></td>
            </form>
            </tr>
</tbody>
</table>
</body>
</html>