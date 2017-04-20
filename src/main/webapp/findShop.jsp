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
<title>店铺信息管理</title>
</head>
<body>
店铺信息
<table width="90%" border="1" align="center">  
 	<tbody>  
            <tr>  
                <td width="30%">店铺名</td>  
                <td width="70%">${shop.name}</td>  
            </tr>
            <tr>  
                <td>店铺编号</td>  
                <td>${shop.shop_id}</td>  
            </tr>  
            <tr>  
                <td>店主编号</td>  
                <td>${shop.user_ID}</td>  
            </tr>  
            <tr>  
                <td>店铺类型</td>  
                <td>${shop.type}</td>  
            </tr>  
            <tr>  
                <td>店铺介绍</td>  
                <td>${shop.intro}</td>  
            </tr>  
	</tbody>
</table>
<table width="30%" border="0">
            <tr>  
             	<td align="center">
                <a href="./shopManage.do">返回</a>	
                </td> 
            </tr>
</table> 
</body>
</html>