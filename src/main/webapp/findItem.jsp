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
<title>商品信息管理</title>
</head>
<body>
商品信息
<table width="90%" border="1" align="center">  
 	<tbody>  
            <tr>  
                <td width="30%">商品名</td>  
                <td width="70%">${item.name}</td>  
            </tr>
            <tr>  
                <td>商品编号</td>  
                <td>${item.item_id}</td>  
            </tr>  
            <tr>  
                <td>店铺编号</td>  
                <td>${item.shop_id}</td>  
            </tr>  
            <tr>  
                <td>商品高级类型</td>  
                <td>${item.typeh}</td>  
            </tr>  
            <tr>  
                <td>商品低级类型</td>  
                <td>${item.typel}</td>  
            </tr>  
         	<tr>  
                <td>商品数量</td>  
                <td>${item.number}</td>  
            </tr> 
	     	<tr>  
                <td>商品价格</td>  
                <td>${item.price}</td>  
            </tr>
            <tr>  
                <td>商品描述</td>  
                <td>${item.detail}</td>  
            </tr>
            <tr>  
                <td>商品图片</td>  
                <td><img src=${pageContext.request.contextPath}${item.image}></p></td>  
            </tr> 
	</tbody>
</table>
<table width="30%" border="0">
            <tr>  
             	<td align="center">
                <a href="./itemManage.do?page=1">返回</a>	
                </td> 
            </tr>
</table> 
</body>
</html>