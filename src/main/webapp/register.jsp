<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html> 
 <head> 

   
 <title>二手淘金网--用户注册</title> 
   
 <!-- 
 <link rel="stylesheet" type="text/css" href="styles.css"> 
 -->
 </head> 
  
 <body> 
 <form action="login.do" method="post"> 
  <table> 
   <tr> 
    <td colspan="2">注册窗口</td> 
   </tr> 
   <tr> 
    <td>用户名：</td> 
    <td><input type="text" name="username" /> 
    </td> 
   </tr> 
   <tr> 
    <td>密码：</td> 
    <td><input type="text" name="password" /> 
    </td> 
   </tr> 
   <tr> 
    <td>真实姓名：</td> 
    <td><input type="text" name="name" /> 
    </td> 
   </tr> 
   <tr> 
    <td>电话/手机：</td> 
    <td><input type="text" name="tele" /> 
    </td> 
   </tr> 
   <tr> 
    <td>电子邮箱：</td> 
    <td><input type="text" name="email" /> 
    </td> 
   </tr> 
   <tr> 
    <td colspan="2">
    	<input type="submit" value="完成注册" /> 
    </td> 
   </tr> 
  </table> 
 </form> 
</body> 
</html> 