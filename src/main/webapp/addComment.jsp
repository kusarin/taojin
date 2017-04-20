<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>留言</title>
</head>
<body>
<form action="addComment.do" method="post"> 
  <table> 
   <tr> 
    <td colspan="2">留言给我们！谢谢您参与网站的完善！</td> 
   </tr> 
   <input type="hidden" name="user_id" value="${user.user_id}" />
   <tr> 
    <td>内容：</td> 
    <td><input type="text" name="content" /> 
    </td> 
   </tr> 
   <tr> 
    <td colspan="2">
    	<a href="./" ><input type="submit" value="发布" /></a> 
    </td> 
   </tr> 
  </table> 
 </form>
</body>
</html>