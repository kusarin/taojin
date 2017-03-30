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
<title>用户留言管理</title>
</head>
<body>

<table width="90%" border="1" align="center">  
 <tbody>  
            <tr align="center">  
                <td width="50%">内容</td>  
                <td width="30%">发布时间</td>  
                <td width="10%">发布者ID</td> 
                <td width="10%"></td>
            </tr>  
            <c:forEach items="${Comment}" var="i">  
              <tr>  
                <td> ${i.content} </td>  
                <td> ${i.datetime}</td>  
                <td> ${i.user_id} </td> 
                <td><a href="./deleteComment.do?id=${i.id}"><button>删除</button></a></td> 
            </tr>  
            </c:forEach>  
</tbody>
</table>
</body>
</html>