<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>

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
 <title>二手淘金网--修改管理员密码</title> 
 </head> 
  
 <body> 
 <form action="updatepassword.do" method="post"> 
  <table> 
   <tr> 
    <td colspan="2">修改密码</td> 
    <td><input type="hidden" name="account" value="${manager.account}"/> 
    </td> 
   </tr> 
   <tr> 
    <td>新密码：</td> 
    <td><input type="password" name="password" /> 
    </td> 
   </tr> 
   <tr> 
    <td colspan="2">
    	<input type="submit" value="修改" />  
    </td> 
   </tr> 
  </table> 
 </form>
</body> 
</html> 