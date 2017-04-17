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
<title>店铺认证管理</title>
</head>
<body>

<table width="90%" border="1" align="center">  
 <tbody>  
            <tr align="center">  
                <td width="20%">店铺名</td>  
                <td width="10%">店铺类型</td>  
                <td width="50%">申请者ID</td> 
                <td width="20%"></td>
            </tr>  
            <c:forEach items="${SR}" var="sr">  
              <tr>  
                <td> ${sr.name} </td>  
                <td> ${sr.type}</td>  
                <td> ${sr.user_ID} </td> 
                <td align="center">
                	<a href="./findSR.do?id=${sr.shop_id}"><button>查看详情</button></a>
                </td> 
              </tr>  
            </c:forEach>  
</tbody>
</table>
</body>
</html>