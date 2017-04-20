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
    
	function refuseone(shop_id){
		if(confirm("确定要拒绝本申请吗？")){
			window.location.href="refuseSR.do?id="+shop_id;
		}
	}
	function passone(shop_id){
		if(confirm("确定要通过本申请吗？")){
			window.location.href="passSR.do?id="+shop_id;
		}
	}
</script>
<title>店铺认证管理</title>
</head>
<body>
店铺认证申请
<table width="90%" border="1" align="center">  
 <tbody>  
            <tr >  
                <td width="30%">店铺名</td>  
                <td width="70%">${sr.name}</td>  
            </tr>  
            <tr>  
                <td >店铺类型</td>  
                <td >${sr.type}</td>  
            </tr>  
            <tr >  
                <td >店铺介绍</td>  
                <td >${sr.intro}</td>  
            </tr>  
            <tr >  
                <td >用户名</td>  
                <td>${user.username}</td>  
            </tr>  
            <tr >  
                <td>用户真实姓名</td>  
                <td>${user.name}</td>  
            </tr>  
            <tr >  
                <td>用户联系方式</td>  
                <td>${user.tele}</td>  
            </tr>  
            <tr >  
                <td>用户身份证号</td>  
                <td>${user.ID}</td>  
            </tr> 
</tbody>
</table>
<table width="30%" border="1">
            <tr>  
             	<td align="center">
                	<a onclick="passone(${sr.shop_id})"
					href="javascript:void(0)">通过</a>
                </td> 
             	<td align="center">
                	<a onclick="refuseone(${sr.shop_id})"
					href="javascript:void(0)">拒绝</a>
                </td> 
            </tr>
</table> 
</body>
</html>