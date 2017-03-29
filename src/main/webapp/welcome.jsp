<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"> 
<html> 
 <head> 

   
 <title>欢迎进入主页</title> 
   

 <!-- 
 <link rel="stylesheet" type="text/css" href="styles.css"> 
 -->
 </head> 
  
 <body> 
 <table> 
  <tr> 
   <td><img src="image/1.png" /> 
   </td> 
  </tr> 
  <tr> 
   <td colspan="2"><hr /> 
   </td> 
  </tr> 
  <tr> 
      <tr> 
       <td colspan="2">登录成功!</td> 
      </tr> 
      <tr> 
       <td>欢迎你，</td> 
       <td>${user.username}</td>
      <tr> 
       <td colspan="2"><input type="submit" value="退出" /></td> 
      </tr> 
      <td colspan="2">
    	<a href="usersearch.jsp">查看个人信息</a> 
    </td> 
 </table> 
</body> 
</html> 