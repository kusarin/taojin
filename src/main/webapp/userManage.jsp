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
用户信息列表
<table width="90%" border="1" align="center">  
 <tbody>  
            <tr align="center">  
                <td width="30%">用户名</td> 
                <td width="30%">用户编号</td>
                <td width="30%">用户姓名</td>  
                <td width="10%"></td>
            </tr>  
            <c:forEach items="${user}" var="u">  
              <tr>  
                <td> ${u.username} </td>
                <td> ${u.user_ID} </td>  
                <td> ${u.name}</td>  
                <td align="center">
                	<a href="./findUser.do?id=${u.user_ID}"><button>查看</button></a>
                </td> 
              </tr>  
            </c:forEach>  
</tbody>
</table>
</body>
</html>