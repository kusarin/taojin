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
    function jump() {
		var id = document.getElementById("topage").value;
		if(id < 1 || id > 1000000000){
			alert("输入内容超出范围，请重新输入！");
			return false;
		}
    }
</script>
<title>商品信息管理</title>
</head>
<body>
商品信息列表

<form action="findItem.do" method="post"> 
	<table border="0" align="right">
		<tr>
			<td>按照商品编号查找</td>
			<td><input type="text" id = "id" name="id"
					onkeyup="this.value=this.value.replace(/\D/g,'')" 
					onafterpaste="this.value=this.value.replace(/\D/g,'')"></td>
			<td><input type="submit" value="查找" onclick="return check()" /></td>
		</tr>
	</table>
</form>

<table width="90%" border="1" align="center">  
 <tbody>  
            <tr align="center">  
                <td width="30%">商品名</td> 
                <td width="20%">商品编号</td>
                <td width="20%">商品高级类型</td> 
                <td width="20%">商品低级类型</td> 
                <td width="10%"></td>
            </tr>  
            <c:forEach items="${item}" var="i">  
              <tr>  
                <td> ${i.name} </td>
                <td> ${i.item_id} </td>  
                <td> ${i.typeh}</td>
                <td> ${i.typel}</td>  
                <td align="center">
                	<a href="./findItem.do?id=${i.item_id}"><button>查看</button></a>
                </td> 
              </tr>  
            </c:forEach>  
</tbody>
</table>

<div  align="center">
	<form action="itemManage.do" method="post">
			<c:choose>
			<c:when test="${page != 1}">
				<a href="itemManage.do?page=${page-1}"><input type="button" name="lastPage" value="上一页" /></a>
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
					<a href="itemManage.do?page=${pn}">${pn}</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
	
	<!-- 下一页 按钮 -->
		<c:choose>
			<c:when test="${page != totalPage}">
				<a href="itemManage.do?page=${page+1}">
					<input type="button" name="nextPage" value="下一页" />
				</a>
			</c:when>
			<c:otherwise>
				<input type="button" disabled="true" name="nextPage" value="下一页" />
			</c:otherwise>
		</c:choose>
	共${totalPage}页 
	-向<input type="text" name="page" id="topage" 
	onkeyup="this.value=this.value.replace(/\D/g,'')" 
	onafterpaste="this.value=this.value.replace(/\D/g,'')"/>页
	<input type="submit" value="跳转" onclick="return jump()"/>
	</form>
	</div>
</body>
</html>