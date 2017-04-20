<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
	function deleteone(resourcefile_id){
		if(confirm("确定要删除这条数据吗？")){
			window.location.href="deleteRF.do?id="+resourcefile_id;
		}
	}
</script>
<title>资源文件管理</title>
</head>
<body>
文件资源列表
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
                <td><a onclick="deleteone(${r.resourcefile_id})"
					href="javascript:void(0)">删除</a>
                </td> 
            </tr>  
            </c:forEach>  
            <tr>
            <td colspan="3"><a href="addRF.jsp" >新增文件资源</a></td>
            </tr>
	</tbody>
</table>
	<div  align="center">
	<form action="findResourceFile.do" method="post">
			<c:choose>
			<c:when test="${page != 1}">
				<a href="findResourceFile.do?page=${page-1}"><input type="button" name="lastPage" value="上一页" /></a>
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
					<a href="findResourceFile.do?page=${pn}">${pn}</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
	
	<!-- 下一页 按钮 -->
		<c:choose>
			<c:when test="${page != totalPage}">
				<a href="findResourceFile.do?page=${page+1}">
					<input type="button" name="nextPage" value="下一页" />
				</a>
			</c:when>
			<c:otherwise>
				<input type="button" disabled="true" name="nextPage" value="下一页" />
			</c:otherwise>
		</c:choose>
	共${totalPage}页 
	-向<input type="text" name="page" id="jump" 
	onkeyup="this.value=this.value.replace(/\D/g,'')" 
	onafterpaste="this.value=this.value.replace(/\D/g,'')"/>页
	<input type="submit" value="跳转"/>
	</form>
	</div>
</body>
</html>