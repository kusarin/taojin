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
    
    function check() {
		var id = document.getElementById("id").value;
		if(id < 1 || id > 1000000000){
			alert("输入内容超出范围，请重新输入！");
			return false;
		}
	}
</script>
<title>店铺信息管理</title>
</head>
<body>
店铺信息列表

<form action="findShop.do" method="post"> 
	<table border="0" align="right">
		<tr>
			<td>按照店铺编号查找</td>
			<td><input type="text" id = "id" name="id"></td>
			<td><input type="submit" value="查找" onclick="return check()" /></td>
		</tr>
	</table>
</form>

<table width="90%" border="1" align="center">  
 <tbody>  
            <tr align="center">  
                <td width="30%">店铺名</td> 
                <td width="30%">店铺编号</td>
                <td width="30%">店铺类型</td>  
                <td width="10%"></td>
            </tr>  
            <c:forEach items="${shop}" var="s">  
              <tr>  
                <td> ${s.name} </td>
                <td> ${s.shop_id} </td>  
                <td> ${s.type}</td>  
                <td align="center">
                	<a href="./findShop.do?id=${s.shop_id}"><button>查看</button></a>
                </td> 
              </tr>  
            </c:forEach>  
</tbody>
</table>
</body>
</html>