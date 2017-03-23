<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%> 
<% 
String path = request.getContextPath(); 
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 
%> 
  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"> 
<html> 
 <head> 
 <base href="<%=basePath%>"> 
   
 <title>My JSP 'welcom.jsp' starting page</title> 
   
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
 <table> 
  <tr> 
   <td><img src="images/logo4.png" /> 
   </td> 
   <td><img src="images/logo2.png" height="90" /> 
   </td> 
  </tr> 
  <tr> 
   <td colspan="2"><hr /> 
   </td> 
  </tr> 
  <tr> 
   <td> 
    <table> 
     <tr> 
      <td><a>Main</a> 
      </td> 
     </tr> 
     <tr> 
      <td><a>Menu1</a> 
      </td> 
     </tr> 
     <tr> 
      <td><a>Menu2</a> 
      </td> 
     </tr> 
     <tr> 
      <td><a>Menu3</a> 
      </td> 
     </tr> 
     <tr> 
      <td><a>Menu4</a> 
      </td> 
     </tr> 
     <tr> 
      <td><a>Menu5</a> 
      </td> 
     </tr> 
     <tr> 
      <td><a>Menu6</a> 
      </td> 
     </tr> 
     <tr> 
      <td><a>Menu7</a> 
      </td> 
     </tr> 
     <tr> 
      <td><a>Menu8</a> 
      </td> 
     </tr> 
    </table></td> 
   <td> 
    <form action="loginout.jsp" method="post"> 
     <table> 
      <tr> 
       <td colspan="2">登录成功!</td> 
      </tr> 
      <tr> 
       <td>欢迎你，</td> 
       <td>${username }</td> 
      </tr> 
      <tr> 
       <td colspan="2"><input type="submit" value="退出" /></td> 
      </tr> 
     </table> 
    </form></td> 
  </tr> 
 </table> 
</body> 
</html> 