<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"> 
<html> 
 <head> 

   
 <title>个人信息查看</title> 
   

 <!-- 
 <link rel="stylesheet" type="text/css" href="styles.css"> 
 -->
 </head> 
  
 <body> 
 <table> 
  <tr> 
      <tr> 
       <td>欢迎你，</td> 
       <td>${user.username}</td>
      </tr> 
      <tr> 
       <td colspan="2"><input type="submit" value="退出" /></td> 
      </tr> 
      
 </table> 
 <table width="90%" border="1" align="center">  
 <tbody>  
            <tr align="center">  
                <td>用户名</td>  
                <td>密码</td>  
                <td>姓名</td>  
                <td>电话</td>  
                <td>email</td>  
            </tr>  
              
              <tr>  
                <td> ${user.username}  </td>
                <td> ${user.password} </td>  
                <td> ${user.name} </td>  
                <td> ${user.tele} </td>  
                <td> ${user.email} </td>    
            </tr>  
</tbody>
</table>
</body> 
</html> 