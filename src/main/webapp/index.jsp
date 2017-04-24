<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script>
   function purchase(){
	   window.location.href="sureOrder.do?number=1&itemId=1";
   }
   function addCart(){
	   window.location.href="index.do?number=1&itemId=1";
   }
</script>
</head>
<body>
<span>
<button onclick="purchas()">立即购买</button>
<button onclick="addCart()">加入购物车</button>
</span>

</body>
</html>