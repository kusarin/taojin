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
 <title>二手淘金网--添加资源文件</title> 
 </head> 
  
 <body> 
 <form action="addRF.do" method="post"> 
  <table> 
   <tr> 
    <td colspan="2">新增窗口</td> 
   </tr> 
   <tr> 
    <td>文件名：</td> 
    <td><input type="text" name="name" /> 
    </td> 
   </tr> 
   <tr> 
    <td>文件地址：</td> 
    <td><input type="text" name="address" /> 
    </td> 
   </tr> 
   <tr> 
    <td>文件类型：</td> 
    <td><input type="text" name="type" /> 
    </td> 
   </tr> 
   <tr> 
    <td colspan="2">
    	<input type="submit" value="新增" />  
    </td> 
   </tr> 
  </table> 
 </form>
</body> 
</html> 