<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
 <title>购物车</title>
 <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
 
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/shoppingCart.css"/>
<link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/bootstrap-responsive.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/flexslider.css" type="text/css" media="screen" rel="stylesheet"  />
<link href="${pageContext.request.contextPath}/css/jquery.fancybox.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/cloud-zoom.css" rel="stylesheet">

<script>
function plus(val){
	   var num=document.getElementById("mp");
	   var value=parseInt(num.value);
	   if(value<val){
	    num.value=value+1;
	   }
	   else{
	    alert("这样的商品总共"+num.value+"件！抱歉！！");
	   }
	  }
function minus(){
	    var num=document.getElementById("mp");
		var value=parseInt(num.value);
		if(value>1){
	    num.value=value-1;
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
							<input type="text" class="input-medium search-query"
								placeholder="搜索你想要的二手"/ style="border:4px solid #FFA07A;">
								<input type="submit" value="搜索"
								style="height:42px;width:auto;background-color:#FFA07A;margin-left:-4px;border:4px solid #FFA07A;"/>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	</header>
	<!-- Header End -->
	
	<form action="submitOrder.do" method="post">
     <div class="containers">
	  <form>
	   <div class="orderTitle" style="color:gray;">
	      <p>购物车</p>
	   </div>
	   
	   <div class="receive">
		      <div class="info">
	             <strong>全部商品</strong><span style="color:red;">2</span>
		      </div>
	   </div>
		<div class="receive" style="border-bottom:0px;">
		    <div class="nav1">
			    <table>
				<tr>
				   <td class="nav11"><input type="checkbox" style="float:left;"><span style="float:left;margin-left:5px;">全选</span><span>商品</span></td>
			       <td class="nav12">数量</td>
			       <td class="nav12">单价</td>
			       <td class="nav12">小计</td>
				   <td class="nav12">操作</td>
				</tr>
				</table>
			</div>
		</div>
		<div class="shoper">
			    <span>店铺：<a href="#">dkbov帝克博威旗舰店</a></span>
				<input type="hidden" value="dkbov帝克博威旗舰店" name="">
		</div>
		<div class="orderDe" style="border:1px solid #80ffff;">
		<table>
		   <tr>
			     <td class="test1"><a href="#"><img src="image/order1.jpg"/></a>
		        <a href="#"><p>Seagate希捷移动硬盘1T Backup Plus 新睿品4 2tb USB3.0超薄包邮 [交易快照]套餐类型：套餐一颜色分类：土豪金500G
		        gdfghjkll;lkjhjkl;;jkjiuygjhgghoopll</p></a></td>
				 <td class="common" style="padding-left:0px;text-align:center;">
				 <input type="button" value="-"  id="m" onclick="minus()" style="text-align:center;height:30px;width:20px;float:left;border:0;">
				 <input type="text" value="1" id="mp" readonly="true" style="background-color:white;text-align:center;width:20px;float:left;border:1px;">
				 <input type="button" value="+"  onclick="plus(3)" style="height:30px;width:20px;text-align:center;float:left;border:0;"></td>
				 <td class="common" style="text-align:center;">370.00</td>
				 <td class="common" style="text-align:center;">270.00</td>
				 <td class="common" style="text-align:center;"><a href="#">删除</a></td>
			 </tr>
		 </table>
		</div>
		
		<div class="orderDe">
		    <table class="same">
			     <tr><td style="padding-top:15px;padding-bottom:15px;">已选<strong class="pay">1</strong>件商品，总商品金额：<strong class="pay">￥29.90</strong></td></tr>
			</table>
		</div>
		
		<div class="commit">
		    <input type="submit" value="去付款"/>
		</div>
		</form>
    </div> 
    </form>
    <!-- footer -->
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