<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- 弹窗设置点 -->
<script type="text/javascript">
    window.onload=function(){
    	var error="${requestScope.error}";
    	  if(error!=""&&error!=null&&typeof(error)!="undefined"){
    		  alert(error);
    	  }
    }
</script>
<title>二手淘金--修改商品信息</title>
<link />
</head>
<body>
	<form action="changeItem.do" method = "post">
		<table>
			<tbody>
				<tr>
					<td>商品名称:</td>
					<td><input type="text" name="name" /></td>
				</tr>
				<tr>
					<td>商品类型:</td>
					<td><select id="code" name="typeh">
							<option value="高级分类1">高级分类1</option>
							<option value="高级分类2">高级分类2</option>
					</select> <select id="code" name="typel">
							<option value="低级分类1">低级分类1</option>
							<option value="低级分类2">低级分类2</option>
					</select></td>
				</tr>
				<tr>
					<td>商品数量:</td>
					<td><input type="text" name="number" onkeyup="value=value.replace(/[^(\d)]/g,'')"/></td>
				</tr>
				<tr>
					<td>商品价格:¥</td>
					<td><input type="text" name="price" /></td>
				</tr>
				<tr>
					<td>商品描述:</td>
					<td><input type="text" name="detail" /></td>
				</tr>
				<tr>
					<td>商品图片:</td>
					<td><input type="text" name="image" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="确认修改" /></td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>