<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="./TaoJin/css/bootstrap.css" rel="stylesheet">
<link href="./TaoJin/css/bootstrap-responsive.css" rel="stylesheet">
<link href="./TaoJin/css/style.css" rel="stylesheet">
<link href="./TaoJin/css/flexslider.css" type="text/css" media="screen" rel="stylesheet"  />
<link href="./TaoJin/css/jquery.fancybox.css" rel="stylesheet">
<link href="./TaoJin/css/cloud-zoom.css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
	<!-- Header Start -->
	<header>
	<div class="headerstrip">
		<div class="container">
			<div class="row">
				<div class="span12">
					<a href="index-2.html" class="logo pull-left"><img
						src="img/logo.png" alt="SimpleOne" title="SimpleOne"></a>
					<!-- Top Nav Start -->
					<div class="pull-left">
						<div class="navbar" id="topnav">
							<div class="navbar-inner">
								<ul class="nav">
									<li><a class="home active" href="#">Home</a></li>
									<li><a class="myaccount" href="#">My Account</a></li>
									<li><a class="shoppingcart" href="#">Shopping Cart</a></li>
									<li><a class="checkout" href="#">CheckOut</a></li>
								</ul>
							</div>
						</div>
					</div>
					<!-- Top Nav End -->
					<div class="pull-right">
						<form class="form-search top-search">
							<input type="text" class="input-medium search-query" name="str"
								placeholder="Search Here…">
							<a href="searchShop.do?str">搜索</a>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="headerdetails">
			<div class="pull-left">
				<ul class="nav language pull-left">
					<li class="dropdown hover"><a href="#" class="dropdown-toggle"
						data-toggle="">US Doller <b class="caret"></b></a>
						<ul class="dropdown-menu currency">
							<li><a href="#">US Doller</a></li>
							<li><a href="#">Euro </a></li>
							<li><a href="#">British Pound</a></li>
						</ul></li>
					<li class="dropdown hover"><a href="#" class="dropdown-toggle"
						data-toggle="">English <b class="caret"></b></a>
						<ul class="dropdown-menu language">
							<li><a href="#">English</a></li>
							<li><a href="#">Spanish</a></li>
							<li><a href="#">German</a></li>
						</ul></li>
				</ul>

			</div>
			<div class="pull-right">
				<ul class="nav topcart pull-left">
					<li class="dropdown hover carticon "><a href="#"
						class="dropdown-toggle"> Shopping Cart <span
							class="label label-orange font14">1 item(s)</span> - $589.50 <b
							class="caret"></b></a>
						<ul class="dropdown-menu topcartopen ">
							<li><table>
									<tbody>
										<tr>
											<td class="image"><a href="product.html"><img
													width="50" height="50" src="img/prodcut-40x40.jpg"
													alt="product" title="product"></a></td>
											<td class="name"><a href="product.html">MacBook</a></td>
											<td class="quantity">x&nbsp;1</td>
											<td class="total">$589.50</td>
											<td class="remove"><i class="icon-remove"></i></td>
										</tr>
										<tr>
											<td class="image"><a href="product.html"><img
													width="50" height="50" src="img/prodcut-40x40.jpg"
													alt="product" title="product"></a></td>
											<td class="name"><a href="product.html">MacBook</a></td>
											<td class="quantity">x&nbsp;1</td>
											<td class="total">$589.50</td>
											<td class="remove"><i class="icon-remove "></i></td>
										</tr>
									</tbody>
								</table>
								<table>
									<tbody>
										<tr>
											<td class="textright"><b>Sub-Total:</b></td>
											<td class="textright">$500.00</td>
										</tr>
										<tr>
											<td class="textright"><b>Eco Tax (-2.00):</b></td>
											<td class="textright">$2.00</td>
										</tr>
										<tr>
											<td class="textright"><b>VAT (17.5%):</b></td>
											<td class="textright">$87.50</td>
										</tr>
										<tr>
											<td class="textright"><b>Total:</b></td>
											<td class="textright">$589.50</td>
										</tr>
									</tbody>
								</table>
								<div class="well pull-right buttonwrap">
									<a class="btn btn-orange" href="#">View Cart</a> <a
										class="btn btn-orange" href="#">Checkout</a>
								</div></li>
						</ul></li>
				</ul>
			</div>
		</div>
		<div id="categorymenu">
			<nav class="subnav">
			<ul class="nav-pills categorymenu">
				<li><a class="active" href="index-2.html">Home</a>
					<div>
						<ul>
							<li><a href="index2.html">Home Style 2</a></li>
							<li><a href="index3.html">Home Style 3</a></li>
							<li><a href="index4.html">Home Style 4</a></li>
							<li><a href="index5.html">Home Style 5</a></li>
							<li><a href="index6.html">Home Style 6</a></li>
							<li><a href="index-2.html">Home Style 1</a></li>
						</ul>
					</div></li>
				<li><a href="product.html">Products</a>
					<div>
						<ul>
							<li><a href="product.html">Product style 1</a></li>
							<li><a href="product2.html">Product style 2</a></li>
							<li><a href="#"> Women's Accessories</a></li>
							<li><a href="#">Men's Accessories <span
									class="label label-success">Sale</span>
							</a></li>
							<li><a href="#">Dresses </a></li>
							<li><a href="#">Shoes <span class="label label-warning">(25)</span>
							</a></li>
							<li><a href="#">Bags <span class="label label-info">(new)</span>
							</a></li>
							<li><a href="#">Sunglasses </a></li>
						</ul>
						<ul>
							<li><img src="img/proudctbanner.jpg" alt="" title="">
							</li>
						</ul>
					</div></li>
				<li><a href="category.html">Categories</a></li>
				<li><a href="shopping-cart.html">Shopping Cart</a></li>
				<li><a href="checkout.html">Checkout</a></li>
				<li><a href="compare.html">Compare</a></li>
				<li><a href="blog.html">Blog</a>
					<div>
						<ul>
							<li><a href="blog.html">Blog page</a></li>
							<li><a href="bloglist.html">Blog List VIew</a></li>
						</ul>
					</div></li>
				<li><a href="myaccount.html">My Account</a>
					<div>
						<ul>
							<li><a href="myaccount.html">My Account</a></li>
							<li><a href="login.html">Login</a></li>
							<li><a href="register.html">Register</a></li>
							<li><a href="wishlist.html">Wishlist</a></li>
						</ul>
					</div></li>
				<li><a href="features.html">Features</a></li>
				<li><a href="contact.html">Contact</a></li>
			</ul>
			</nav>
		</div>
	</div>
	</header>
	<!-- Header End -->

	<div id="maincontainer">
<div class="flush">
        <form action="">
		<table style="border-left-width: 0px; border-collapse: collapse; border-right-width: 0px;"bordercolor="#ff6600" bgcolor="#DFFFDF" cellspacing="0" cellpadding="0" width="250" align="center" border="1">
		<thead>
		<tr><th style="text-align: center;">店铺名</th>
		</tr></thead>
		<c:forEach items="${search }" var="c">
		<tr id="${c.shop_id }">
		<td>${c.name }</td>
		</tr>
		</c:forEach>
		</table></form>
</div></div>
</body>
</html>