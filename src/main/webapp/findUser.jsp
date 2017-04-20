<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%@ page isELIgnored="false" %>
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
<title>用户信息管理</title>
</head>
<body>
用户信息
<table width="90%" border="1" align="center">  
 <tbody>  
            <tr>  
                <td width="30%">用户名</td>  
                <td width="70%">${user.username}</td>  
            </tr>
            <tr>  
                <td>用户编号</td>  
                <td>${user.user_ID}</td>  
            </tr>  
            <tr>  
                <td>用户姓名</td>  
                <td>${sr.name}</td>  
            </tr>  
            <tr>  
                <td>联系电话</td>  
                <td>${user.tele}</td>  
            </tr>  
            <tr>  
                <td>联系邮箱</td>  
                <td>${user.email}</td>  
            </tr>  
            <tr>  
                <td>用户身份证号</td>  
                <td>${user.ID}</td>  
            </tr> 
</tbody>
</table>
<table width="30%" border="0">
            <tr>  
             	<td align="center">
                <a href="./userManage.do?page=1">返回</a>	
                </td> 
            </tr>
</table> 
</body>
</html>