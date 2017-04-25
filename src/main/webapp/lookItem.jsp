<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>

<meta charset="utf-8">
<title>${lookitem.name}</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<link href="./TaoJin/css/bootstrap.css" rel="stylesheet">
<link href="./TaoJin/css/bootstrap-responsive.css" rel="stylesheet">
<link href="./TaoJin/css/style.css" rel="stylesheet">
<link href="./TaoJin/css/flexslider.css" type="text/css" media="screen"
	rel="stylesheet" />
<link href="./TaoJin/css/jquery.fancybox.css" rel="stylesheet">
<link href="./TaoJin/css/cloud-zoom.css" rel="stylesheet">

<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
<!-- fav -->
<link rel="shortcut icon" href="assets/ico/favicon.html">
<style>
.itemimage {
	width: 275px;
	height: 150px;
	float: left;
}

.price {
	float: left;
	color: red;
}

.textshop {
	font-size: 18px;
	color: orange;
}
</style>
<script>
  function plus(val){
   var num=document.getElementById("mp");
   var value=parseInt(num.value);
   var total=document.getElementById("total");
   var itemprice=document.getElementById("itemprice");
   var unitPrice=document.getElementById("unitPrice");
   var actulpayment=document.getElementById("actulpayment");
   var ac=document.getElementById("ac");
   if(value<val){
    num.value=value+1;
    total.innerHTML=num.value;
    itemprice.innerHTML=""+parseFloat(unitPrice.value)*parseInt(num.value);
    actulpayment.innerHTML=itemprice.innerHTML;
    ac.innerHTML=actulpayment.innerHTML;
   }
   else{
    alert("这样的商品总共"+num.value+"件！抱歉！！");
   }
  }
  
  function minus(){
	    var num=document.getElementById("mp");
		var value=parseInt(num.value);
		var total=document.getElementById("total");
		var itemprice=document.getElementById("itemprice");
		var unitPrice=document.getElementById("unitPrice");
		var actulpayment=document.getElementById("actulpayment");
		var ac=document.getElementById("ac");
		if(value>1){
	    num.value=value-1;
	    total.innerHTML=num.value;
	    itemprice.innerHTML=""+parseFloat(unitPrice.value)*parseInt(num.value);
	    actulpayment.innerHTML=itemprice.innerHTML;
	    ac.innerHTML=actulpayment.innerHTML;
		}
	  }
  
  </script>
<!-- 弹窗设置点 -->
<script type="text/javascript">
	window.onload = function() {
		var error = "${requestScope.error}";
		if (error != "" && error != null && typeof (error) != "undefined") {
			alert(error);
		}
	   
	}
	 function purchas(){
		 var num=parseInt(document.getElementById("mp").value);
		 window.location.href="sureOrder.do?itemId=${lookitem.item_id}&number="+num;
	   }
	 function addCart(){
		 var num=parseInt(document.getElementById("mp").value);
		 window.location.href="index.do?itemId=${lookitem.item_id}&number="+num;
	   }
	 function succ(){
		 alert("添加成功！");
	 }
</script>
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
									<div style="float: left; color: white; margin-top: 26px;">
										<span>您好,</span> <a href="#"><span style="color: white;">登录</span></a>
										<a href="#"> <span
											style="margin-left: 20px; color: white;">注册</span></a>
									</div>
									<div style="margin-left: 250px;">
										<ul class="nav">
											<li><a class="home active" href="Itemlist.do">首页</a></li>
											<li><a class="myaccount" href="UsersUpdate.jsp">个人中心</a></li>
											<li><a class="checkout" href="shopList.do">我的店铺</a></li>
											<li><a class="shoppingcart" href="showCartAllItem.do">购物车</a></li>
											<li><a class="checkout" href="orderItem.do">我的订单</a></li>
										</ul>
									</div>
								</div>
							</div>
						</div>
						<!-- Top Nav End -->
						<div class="pull-right">
							<form action="searchItem.do" method="post">
								<div style="margin-top: 10px;">
									<input input type="text" name="str"
										class="input-medium search-query" placeholder="搜索你想要的二手"
										style="height: 20px; width: 100; border: 4px solid #FFA07A;">
									<input type="submit" value="搜索"
										style="height: 30px; width: 40; background-color: #FFA07A; border: 4px solid #FFA07A;">
								</div>

							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</header>
	<!-- Header End -->


	<div id="maincontainer">
		<section id="product">
			<div class="container">
				<!-- Product Details-->
				<div class="row">
					<!-- Left Image-->
					<div class="span5">
						<tr>
							<br>
							<td><img
								src=${pageContext.request.contextPath}${lookitem.image}></td>
						</tr>

						<!-- 参与评论 -->
						<form action="addItemDiscuss.do?id=${lookitem.item_id}"
							method="post" enctype="multipart/form-data">
							<div class="productdesc">
								<ul class="nav nav-tabs" id="myTab">
									<li class="active"><a href="#description">参与评论：</a></li>
								</ul>
								<div class="tab-content">
									<div class="tab-pane active" id="description">
										<input type="text" name="content" style="width: 425px"><br>
										<input type="submit" value="发表评论">
									</div>
								</div>
							</div>
						</form>

					</div>

					<!-- 右侧-->
					<div class="span7">
						<div class="row">
							<div class="span7">
								<h1 class="productname">
									<span class="bgnone">${lookitem.name}</span>
								</h1>
								<div class="productprice">
									<h2>商品价格:¥${lookitem.price}</h2>
								</div>

								<div class="productprice">
									<input type="button" value="-" id="m" onclick="minus()"
										style="text-align: center; height: 30px; width: 30px; float: left; border: 0;">
									<input type="text" value="1" id="mp" readonly="readonly"
										name="number"
										style="background-color: white; text-align: center; width: 40px; float: left; border: 1px;">
									<input type="button" value="+"
										onclick="plus(${lookitem.number})"
										style="height: 30px; width: 30px; text-align: center; float: left; border: 0;">
									<p>商品总数：${lookitem.number}</p>
								</div>

								<ul class="productpagecart">

									<li><a class="cart" href="javascript:void(0)"
										onclick="purchas()">现在购买</a></li>
									<li><a class="wish" href="javascript:succ()"
										onclick="addCart()">加入购物车</a></li>
								</ul>
							</div>
						</div>

						<!-- 商品描述和评论部分-->
						<!-- 商品描述 -->
						<div class="productdesc">
							<ul class="nav nav-tabs" id="myTab">
								<li class="active"><a href="#description">商品描述</a></li>
							</ul>
							<div class="tab-content">
								<div class="tab-pane active" id="description">
									<p>${lookitem.detail}</p>
								</div>
							</div>
						</div>

						<!-- 商品评论 -->
						<div class="productdesc">
							<ul class="nav nav-tabs" id="myTab">
								<li class="active"><a href="#description">商品评论</a></li>
							</ul>
							<div class="tab-content">
								<div class="tab-pane active" id="description">
									<p>${error0}</p>
									<c:forEach items="${discusslist}" var="d">
										<img src=${pageContext.request.contextPath}/image/dislogo.jpg
											style="heigh: 20px; width: 20px">:${d.content}<br>
									</c:forEach>
								</div>
							</div>

						</div>
					</div>
				</div>
			</div>
		</section>
	</div>
	<!-- 推荐部分-->
	<section id="related" class="row">
		<div class="container">
			<h1 class="heading1">
				<a href="lookshopItem.do?shopid=${lookitem.shop_id}"><span
					class="maintext">同店铺商品</span></a><span class="subtext"> 走过路过错过</span>
			</h1>
			<ul class="thumbnails">
				<c:forEach items="${looklist}" var="i">
					<li class="span3"><a class="prdocutname"
						href="lookItem.do?id=${i.item_id}"
						style="overflow: hidden; text-overflow: ellipsis; white-space: nowrap; width: 200px">${i.name}</a>
						<div class="thumbnail">
							<a href="lookItem.do?id=${i.item_id}"><img class="itemimage"
								src=${pageContext.request.contextPath}${i.image}></a>
							<div class="pricetag">
								<br>
								<div class="price">
									<div class="pricenew">
										<div class="price" style="float: left; margin-top: 20px">
											<p>¥${i.price}</p>
										</div>
									</div>
								</div>
							</div>
						</div></li>
				</c:forEach>
			</ul>
		</div>
	</section>
	<!--footer-->
	<footer style="margin-top: 100px">
		<img src="${pageContext.request.contextPath}/image/footer-tri.png"
			style="width: 100%;">
		<div
			style="margin: 0px 0px 10px; text-align: center; padding-top: 10px;">

			<span>友情链接/</span> <a href="http://www.nwpu.edu.cn/" target="_top"
				class="links">西北工业大学</a>

		</div>
		<div style="text-align: center; margin-bottom: 10px;">
			<a id="fd_footer" href="addComment.jsp">产品意见反馈</a>
		</div>
		<div style="text-align: center; margin-bottom: 10px;">
			<span>©2017 版权所有</span> <span>鄂ICP备14003265号-2</span>
		</div>
	</footer>
</body>
</html>