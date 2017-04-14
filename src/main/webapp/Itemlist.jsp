<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>商品列表</title>
<link />
</head>
<body>

<!-- Header Start -->
	<header>
	<div class="headerstrip">
		<div class="container">
			<div class="row">
				<div class="span12">
					<!-- Top Nav Start -->
					<div class="pull-left">
						<div class="navbar" id="topnav">
						
							<div class="navbar-inner">
							<div style="float:left;color:white;margin-top:26px;">
							  <span>您好,</span>
							  <a href="#"><span style="color:white;">登录</span></a>
							  <a href="#"> <span style="margin-left:20px;color:white;">注册</span></a>
							 </div>
							  <div style="margin-left:250px;">
								<ul class="nav">
								    <li><a class="home active" href="#">首页</a></li>
									<li><a class="myaccount" href="#">个人账户</a></li>
									<li><a class="shoppingcart" href="#">购物车</a></li>
									<li><a class="checkout" href="#">我的订单</a></li>
								    <li><a class="checkout" href="#">发布二手</a></li>
								</ul>
							 </div>
							</div>
						</div>
					</div>
					<!-- Top Nav End -->
					<div class="pull-right">
						<form class="form-search top-search">
							<input type="text" class="input-medium search-query"  style="width:auto;border:4px solid #FFA07A"
								placeholder="搜索你想要的二手"><input type="submit" value="搜索"
								style="height:40px;width:auto;background-color:#FFA07A;border:4px solid #FFA07A;">
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	</header>
	<!-- Header End -->

<form action="Itemlist.do"></form>
<table width="90%" border="1" align="center">  
 <tbody>  
            <tr align="center">  
                <td>编号</td>  
                <td>商品名称</td>  
                <td>商品类型</td>  
                <td>商品价格</td>  
                <td>商品描述</td>  
            </tr>  
            <c:forEach items="${itemlist}" var="i">             
              <tr>
              
                <td><a href="lookItem.do?id=${i.item_id}">  ${i.item_id}  </a></td>  
                <td><a href="lookItem.do?id=${i.item_id}"> ${i.name} </a></td>  
                <td><a href="lookItem.do?id=${i.item_id}"> ${i.typel} </a></td>  
                <td><a href="lookItem.do?id=${i.item_id}"> ${i.price} </a></td>  
                <td><a href="lookItem.do?id=${i.item_id}"> ${i.detail} </a></td>
                
            </tr>  
              
            </c:forEach>  
</tbody>
</table>
</body>
</html>