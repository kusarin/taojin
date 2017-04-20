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
    
    function check() {
		var password = document
			.getElementById("pwd1").value;
		var repsword = document
			.getElementById("pwd2").value;
		if (password != repsword) {
			alert("两次密码不同，请重新输入！");
			return false;
		}
	}
</script>
 <title>二手淘金网--新增管理员</title> 
 </head> 
  
 <body> 
 <form action="addmanager.do" method="post"> 
  <table> 
   <tr> 
    <td colspan="2">新增窗口</td> 
   </tr> 
   <tr> 
    <td>账户：</td> 
    <td><input type="text" name="account"/> 
    </td> 
   </tr> 
   <tr> 
    <td>密码：</td> 
    <td><input type="password" name="password" id="pwd1"/> 
    </td> 
   </tr> 
   <tr> 
    <td>确认密码：</td> 
    <td><input type="password" id="pwd2"/> 
    </td> 
   </tr>
   <tr> 
    <td colspan="2">
    	<input type="submit" value="新增" onclick="return check()" />  
    </td> 
   </tr> 
  </table> 
 </form>
</body> 
</html> 