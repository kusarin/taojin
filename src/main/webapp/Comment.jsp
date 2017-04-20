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
	<div  align="center">
	<form action="lookComment.do" method="post">
			<c:choose>
			<c:when test="${page != 1}">
				<a href="lookComment.do?page=${page-1}"><input type="button" name="lastPage" value="上一页" /></a>
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
					<a href="lookComment.do?page=${pn}">${pn}</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
	
	<!-- 下一页 按钮 -->
		<c:choose>
			<c:when test="${page != totalPage}">
				<a href="lookComment.do?page=${page+1}">
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