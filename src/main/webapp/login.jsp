<%@ page language="java" pageEncoding="utf-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html> 
 <head> 

   
 <title>二手淘金网--用户登录</title> 
   
 <meta http-equiv="pragma" content="no-cache"> 
 <meta http-equiv="cache-control" content="no-cache"> 
 <meta http-equiv="expires" content="0">  
 <meta http-equiv="keywords" content="keyword1,keyword2,keyword3"> 
 <meta http-equiv="description" content="This is my page"> 
 <!-- 
 <link rel="stylesheet" type="text/css" href="styles.css"> 
 -->
 </head> 
  
 <body> 
 <form action="login_action.jsp" method="post"> 
  <table> 
   <tr> 
    <td colspan="2">登录窗口</td> 
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
    <td colspan="2"><input type="submit" value="登录" /> <a href="register.jsp">注册</a> 
    </td> 
   </tr> 
  </table> 
 </form> 
</body> 
</html> 