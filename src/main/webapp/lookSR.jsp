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
<title>店铺认证管理</title>
</head>
<body>
店铺认证申请列表
<table width="90%" border="1" align="center">  
	<tbody>  
         	<tr align="center">  
                <td width="20%">店铺名</td>  
                <td width="20%">申请者ID</td>  
                <td width="50%">店铺类型</td> 
                <td width="10%"></td>
            </tr>  
            <c:forEach items="${SR}" var="sr">  
              <tr>  
                <td> ${sr.name} </td>  
                <td> ${sr.user_ID}</td>  
                <td> ${sr.type} </td> 
                <td align="center">
                	<a href="./findSR.do?id=${sr.shop_id}"><button>查看详情</button></a>
                </td> 
              </tr>  
            </c:forEach>  
	</tbody>
</table>
	<div  align="center">
	<form action="lookSR.do" method="post">
			<c:choose>
			<c:when test="${page != 1}">
				<a href="lookSR.do?page=${page-1}"><input type="button" name="lastPage" value="上一页" /></a>
			</c:when>
			<c:otherwise>
				<input type="button" disabled="true" name="lastPage" value="上一页" />
			</c:otherwise>
		</c:choose>
	
	<!-- 页数列表 -->
		<c:forEach items="${pageList}" var="pn">
			<c:choose>
				<c:when test="${pn == page}">
					${pn}
				</c:when>
				<c:otherwise>
					<a href="lookSR.do?page=${pn}">${pn}</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
	
	<!-- 下一页 按钮 -->
		<c:choose>
			<c:when test="${page != totalPage}">
				<a href="lookSR.do?page=${page+1}">
					<input type="button" name="nextPage" value="下一页" />
				</a>
			</c:when>
			<c:otherwise>
				<input type="button" disabled="true" name="nextPage" value="下一页" />
			</c:otherwise>
		</c:choose>
	共${totalPage}页 
	-向<input type="text" name="page" id="id" 
	onkeyup="this.value=this.value.replace(/\D/g,'')" 
	onafterpaste="this.value=this.value.replace(/\D/g,'')"/>页
	<input type="submit" value="跳转" onclick="return check()"/>
	</form>
	</div>
</body>
</html>