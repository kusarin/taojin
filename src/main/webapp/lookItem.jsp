<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>SimpleOne - A Responsive Html5 Ecommerce Template</title>
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


<div id="maincontainer">
  <section id="product">
    <div class="container">      
      <!-- Product Details-->
      <div class="row">
       <!-- Left Image-->
        <div class="span5">
          <ul class="thumbnails mainimage">
            <span>这里应该有图片</span>
          </ul>
           <tr><td>${lookitem.image}</td></tr>
          
        </div>   
        
         <!-- 右侧-->
        <div class="span7">
          <div class="row">
            <div class="span7">
              <h1 class="productname"><span class="bgnone">${lookitem.name}</span></h1>
              <div class="productprice">
                  <h2 >商品价格:¥${lookitem.price}</h2></div>
               
              <div class="productprice">
                <input type="button" value="-"  id="m" onclick="minus()" style="text-align:center;height:30px;width:30px;float:left;border:0;">
				 <input type="text" value="1" id="mp" readonly="readonly" name="number" style="background-color:white;text-align:center;width:40px;float:left;border:1px;">
				 <input type="button" value="+"  onclick="plus(${lookitem.number})" style="height:30px;width:30px;text-align:center;float:left;border:0;">
				 <p>商品总数：${lookitem.number}</p>
              </div>
              <ul class="productpagecart">
                <li><a class="cart" href="#">现在购买</a>
                </li>
                <li><a class="wish" href="#" >加入购物车</a>
                </li>       
              </ul>
        
        </div>
      </div>
       
       <!-- 商品描述和评论部分-->
         <div class="productdesc">
                <ul class="nav nav-tabs" id="myTab">
                  <li class="active"><a href="#description">商品描述</a>
                  </li>
                  <li><a href="#">评论</a>
                  </li>
                </ul>
                <div class="tab-content">
                  <div class="tab-pane active" id="description">
                    <p>${lookitem.detail}</p>                
              </div>
            </div>
          </div>
          
          
    </div>
    
    
    
  </section>
  <!-- 推荐部分-->
  <section id="related" class="row">
    <div class="container">
      <h1 class="heading1"><span class="maintext">同店铺商品</span><span class="subtext"> 走过路过错过</span></h1>
      <ul class="thumbnails">
        <li class="span3">
          <a class="prdocutname" href="product.html">Product Name Here</a>
          <div class="thumbnail">
            <span class="sale tooltip-test">Sale</span>
            <a href="#"><img alt="" src="img/product1.jpg"></a>
            <div class="shortlinks">
              <a class="details" href="#">DETAILS</a>
              <a class="wishlist" href="#">WISHLIST</a>
              <a class="compare" href="#">COMPARE</a>
            </div>
            <div class="pricetag">
              <span class="spiral"></span><a href="#" class="productcart">ADD TO CART</a>
              <div class="price">
                <div class="pricenew">$4459.00</div>
                <div class="priceold">$5000.00</div>
              </div>
            </div>
          </div>
        </li>
        <li class="span3">
          <a class="prdocutname" href="product.html">Product Name Here</a>
          <div class="thumbnail">
            <a href="#"><img alt="" src="img/product2.jpg"></a>
            <div class="shortlinks">
              <a class="details" href="#">DETAILS</a>
              <a class="wishlist" href="#">WISHLIST</a>
              <a class="compare" href="#">COMPARE</a>
            </div>
            <div class="pricetag">
              <span class="spiral"></span><a href="#" class="productcart">ADD TO CART</a>
              <div class="price">
                <div class="pricenew">$4459.00</div>
                <div class="priceold">$5000.00</div>
              </div>
            </div>
          </div>
        </li>
        <li class="span3">
          <a class="prdocutname" href="product.html">Product Name Here</a>
          <div class="thumbnail">
            <span class="offer tooltip-test" >Offer</span>
            <a href="#"><img alt="" src="img/product1.jpg"></a>
            <div class="shortlinks">
              <a class="details" href="#">DETAILS</a>
              <a class="wishlist" href="#">WISHLIST</a>
              <a class="compare" href="#">COMPARE</a>
            </div>
            <div class="pricetag">
              <span class="spiral"></span><a href="#" class="productcart">ADD TO CART</a>
              <div class="price">
                <div class="pricenew">$4459.00</div>
                <div class="priceold">$5000.00</div>
              </div>
            </div>
          </div>
        </li>
        <li class="span3">
          <a class="prdocutname" href="product.html">Product Name Here</a>
          <div class="thumbnail">
            <a href="#"><img alt="" src="img/product2.jpg"></a>
            <div class="shortlinks">
              <a class="details" href="#">DETAILS</a>
              <a class="wishlist" href="#">WISHLIST</a>
              <a class="compare" href="#">COMPARE</a>
            </div>
            <div class="pricetag">
              <span class="spiral"></span><a href="#" class="productcart">ADD TO CART</a>
              <div class="price">
                <div class="pricenew">$4459.00</div>
                <div class="priceold">$5000.00</div>
              </div>
            </div>
          </div>
        </li>
      </ul>
    </div>
  </section>
 	<!--footer-->
    <footer style="margin-top:20px">
       <img  src="${pageContext.request.contextPath}/image/footer-tri.png" style="width:100%;">
            <div style="margin: 0px 0px 10px;text-align:center;padding-top:10px;">
			 
             <span>友情链接/</span>
                <a href="http://www.nwpu.edu.cn/" target="_top" class="links">西北工业大学</a>
				
            </div>
            <div style="text-align:center;margin-bottom:10px;">
               <a id="fd_footer" href="javascript:;">产品意见反馈</a>
               <a href="http://www.2shoujie.com/joinUs" target="_top">加入我们</a>
            </div>
        <div style="text-align:center;margin-bottom:10px;">
            <span>©2017   版权所有</span>
            <span>鄂ICP备14003265号-2</span>
        </div>
    </footer>
</body>
</html>