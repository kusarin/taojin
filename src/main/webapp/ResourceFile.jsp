<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>资源文件管理</title>
</head>
<body>
<table width="90%" border="1" align="center">  
 <tbody>  
            <tr align="center">  
                <td width="30%">文件名</td>  
                <td width="50%">文件地址</td>  
                <td width="10%">文件类型</td> 
                <td width="10%"></td>
            </tr>  
            <c:forEach items="${ResourceFile}" var="r">  
              <tr>  
                <td> ${r.name} </td>  
                <td> ${r.address}</td>  
                <td> ${r.type} </td>  
                <td><a href="./deleteRF.do?id=${r.id}"><button>删除</button></a></td>
            </tr>  
            </c:forEach>  
            <tr>
            <td colspan="3"><a href="addRF.jsp" >新增文件资源</a></td>
            </tr>
</tbody>
</table>
</form>
</body>
</html>