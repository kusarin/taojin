<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<script type="text/javascript">
	window.onload = function() {
		var error = "${requestScope.error}";
		if (error != "" && error != null && typeof (error) != "undefined") {
			alert(error);
		}
	}
</script>
<title>二手淘金网--用户注册</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="./TaoJin/css/bootstrap.css" rel="stylesheet">
<link href="./TaoJin/css/bootstrap-responsive.css" rel="stylesheet">
<link href="./TaoJin/css/style.css" rel="stylesheet">
<link href="./TaoJin/css/flexslider.css" type="text/css" media="screen"
	rel="stylesheet" />
<link href="./TaoJin/css/jquery.fancybox.css" rel="stylesheet">
<link href="./TaoJin/css/cloud-zoom.css" rel="stylesheet">
<!-- fav -->
<link rel="shortcut icon" href="assets/ico/favicon.html">
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
								<input type="text" class="input-medium search-query"
									placeholder="Search Here…">
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
						<li class="dropdown hover"><a href="#"
							class="dropdown-toggle" data-toggle="">US Doller <b
								class="caret"></b></a>
							<ul class="dropdown-menu currency">
								<li><a href="#">US Doller</a></li>
								<li><a href="#">Euro </a></li>
								<li><a href="#">British Pound</a></li>
							</ul></li>
						<li class="dropdown hover"><a href="#"
							class="dropdown-toggle" data-toggle="">English <b
								class="caret"></b></a>
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
								<li>
									<table>
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
									</div>
								</li>
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
									<li><a href="#">Shoes <span
											class="label label-warning">(25)</span>
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
		<section id="product">
			<form action="addUser.do" method="post" class="form-horizontal">
				<div class="container">
					<!--  breadcrumb -->
					<ul class="breadcrumb">
						<li><a href="#">主页</a> <span class="divider">/</span></li>
						<li class="active">注册</li>
					</ul>
					<div class="row">
						<!-- Register Account-->
						<div class="span9">
							<h1 class="heading1">
								<span class="maintext">注册新用户</span><span class="subtext"></span>
							</h1>
							<h3 class="heading3">个人信息</h3>
							<div class="registerbox">
								<fieldset>
									<div class="control-group">
										<label class="control-label"><span class="red">*</span>
											帐号:</label>
										<div class="controls">
											<input type="text" class="input-xlarge" name="username">
										</div>
									</div>
									<div class="control-group">
										<label class="control-label"> Email:</label>
										<div class="controls">
											<input type="text" class="input-xlarge" name="email">
										</div>
									</div>
									<div class="control-group">
										<label class="control-label"> 电话号码:</label>
										<div class="controls">
											<input type="text" class="input-xlarge" name="tele">
										</div>
									</div>
									<div class="control-group">
										<label class="control-label"> 真实姓名:</label>
										<div class="controls">
											<input type="text" class="input-xlarge" name="name">
										</div>
									</div>
								</fieldset>
							</div>
							<h3 class="heading3">密码</h3>
							<div class="registerbox">
								<fieldset>
									<h3 class="heading3"></h3>
									<div class="registerbox">
										<fieldset>
											<div class="control-group">
												<label class="control-label"><span class="red">*</span>
													密码:</label>
												<div class="controls">
													<input type="password" class="input-xlarge" name="password"
														id="pwd1">
												</div>
											</div>
											<div class="control-group">
												<label class="control-label"><span class="red">*</span>
													确认密码::</label>
												<div class="controls">
													<input type="password" class="input-xlarge" id="pwd2">
												</div>
											</div>
										</fieldset>
									</div>
									<script>
										function check() {
											var pwd1 = document
													.getElementById("pwd1").value;
											var pwd2 = document
													.getElementById("pwd2").value;
											if (pwd1 != pwd2) {
												alert("两次密码不同，请重新输入");
													return false;
												}
											}
									</script>
									<div class="pull-right">
										<label class="checkbox inline"> </label>
										请仔细确认所输入信息--------------- &nbsp; <input type="Submit"
											class="btn btn-orange" value="完成注册" id="register"
											onclick="return check()">
									</div>
								</fieldset>
							</div>
							<div class="clearfix"></div>
							<br>
						</div>
					</div>
				</div>
			</form>
		</section>
	</div>

	<!-- Footer -->
	<footer id="footer">
		<section class="footersocial">
			<div class="container">
				<div class="row">
					<div class="span3 aboutus">
						<h2>About Us</h2>
						<p>
							Lorem Ipsum is simply dummy text of the printing and typesetting
							industry. Lorem Ipsum has been the industry's standard dummy text
							ever since the 1500s, when an unknown printer took a galley of
							type and scrambled it to make a type specimen book. <br> <br>
							t has survived not only five centuries, but also the leap into
							electronic typesetting, remaining essentially unchanged.
						</p>
					</div>
					<div class="span3 contact">
						<h2>Contact Us</h2>
						<ul>
							<li class="phone">+123 456 7890, +123 456 7890</li>
							<li class="mobile">+123 456 7890, +123 456 78900</li>
							<li class="email">test@test.com</li>
							<li class="email">test@test.com</li>
						</ul>
					</div>
					<div class="span3 twitter">
						<h2>Twitter</h2>
						<div></div>
					</div>
					<div class="span3 facebook">
						<h2>Facebook</h2>
						<div id="fb-root"></div>

					</div>
				</div>
			</div>
		</section>
		<section class="footerlinks">
			<div class="container">
				<div class="info">
					<ul>
						<li><a href="#">Privacy Policy</a></li>
						<li><a href="#">Terms &amp; Conditions</a></li>
						<li><a href="#">Affiliates</a></li>
						<li><a href="#">Newsletter</a></li>
					</ul>
				</div>
				<div id="footersocial">
					<a href="#" title="Facebook" class="facebook">Facebook</a> <a
						href="#" title="Twitter" class="twitter">Twitter</a> <a href="#"
						title="Linkedin" class="linkedin">Linkedin</a> <a href="#"
						title="rss" class="rss">rss</a> <a href="#" title="Googleplus"
						class="googleplus">Googleplus</a> <a href="#" title="Skype"
						class="skype">Skype</a> <a href="#" title="Flickr" class="flickr">Flickr</a>
				</div>
			</div>
		</section>
		<section class="copyrightbottom">
			<div class="container">
				<div class="row">
					<div class="span6">
						All images are copyright to their owners. More Templates <a
							href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a>
						- Collect from <a href="http://www.cssmoban.com/" title="网页模板"
							target="_blank">网页模板</a>
					</div>
					<div class="span6 textright">ShopSimple @ 2012</div>
				</div>
			</div>
		</section>
		<a id="gotop" href="#">Back to top</a>
	</footer>
</body>
</html>