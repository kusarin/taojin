<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<input type="text" name="str">
<a href="search.do?str=${str}">搜索</a>
<div class="flush">
		<table style="border-left-width: 0px; border-collapse: collapse; border-right-width: 0px;"bordercolor="#ff6600" bgcolor="#DFFFDF" cellspacing="0" cellpadding="0" width="250" align="center" border="1">
		<thead>
		<tr><th style="text-align: center;">店铺名</th>
		</tr></thead>
		<c:forEach items="${shopli }" var="c">
		<tr id="${c.shop_id }">
		<td>${c.name }</td>
		</tr>
		</c:forEach>
		</table>
</div>
<script type="text/javascript">
	    function docate(n){
	    	$('#flushDIV').html("");
			$.ajax({
				 type:"POST",
				 url:"feedback\\.do",
				 data:{pageNo:n},
				 dataType: "html",   //返回值类型	 使用json的话也可以，但是需要在JS中编写迭代的html代码，如果格式样式
				 cache:false,
				 success:function(data){
				     //var json = eval('('+msg+')');//拼接的json串
				     $('#flushDIV').html(data);
				 },
				 error:function(error){alert(error);}
			   });
		}
</script>
</body>
</html>