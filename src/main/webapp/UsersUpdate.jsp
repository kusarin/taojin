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
<title>二手淘金网--信息更改</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="./TaoJin/css/bootstrap.css" rel="stylesheet">
<link href="./TaoJin/css/bootstrap-responsive.css" rel="stylesheet">
<link href="./TaoJin/css/style.css" rel="stylesheet">
<link href="./TaoJin/css/flexslider.css" type="text/css" media="screen"
	rel="stylesheet" />
<link href="./TaoJin/css/jquery.fancybox.css" rel="stylesheet">
<link href="./TaoJin/css/cloud-zoom.css" rel="stylesheet">
<link rel="shortcut icon" href="assets/ico/favicon.html">
<script type="text/javascript">
	function setTab(name, m, n) {
		for (var i = 1; i <= n; i++) {
			var menu = document.getElementById(name + i);
			var showDiv = document.getElementById("cont_" + name + "_" + i);
			menu.className = i == m ? "on" : "";
			showDiv.style.display = i == m ? "block" : "none";
		}
	}
</script>
<div class="tab">
	<ul>
		<li id="tow1" class="on" onclick='setTab("tow",1,3)'>商品</li>
		<li id="tow2" onclick='setTab("tow",2,3)'>店铺</li>
	</ul>
</div>
<div class="tabList">
	<div id="cont_tow_1" class="one block">
		<form action="searchItem.do?page=1" method="post">
			<div style="margin-top: 10px;">
				<input type="text" name="str" class="input-medium search-query"
					placeholder="搜索你想要的二手"
					style="height: 20px; width: 100; border: 4px solid #FFA07A">
				<input type="submit" value="搜索"
					style="height: 30px; width: 40; background-color: #FFA07A; border: 4px solid #FFA07A;">
			</div>
		</form>
	</div>
	<div id="cont_tow_2" class="one">
		<form action="searchShop.do?page=1" method="post">
			<div style="margin-top: 10px;">
				<input type="text" name="str" class="input-medium search-query"
					placeholder="搜索你想要的二手"
					style="height: 20px; width: 100; border: 4px solid #FFA07A">
				<input type="submit" value="搜索"
					style="height: 30px; width: 40; background-color: #FFA07A; border: 4px solid #FFA07A;">
			</div>
		</form>
	</div>
</div>
<script type="text/javascript">
	function setImagePreview(docObj) {

		var name = docObj.value;
		var type = name.split(".");
		type = type[type.length - 1];
		if ("jpg" != type && "png" != type && "jpeg" != type && "gif" != type) {
			alert("错误的类型，请选择图片");
			document.getElementById("txtSrc").value = null;//防止将非图片类型上传  
			return;
		}

		if (docObj.files && docObj.files[0]) {

			//alert("hello"+docObj.files[0]);  
			//火狐7以上版本不能用上面的getAsDataURL()方式获取，需要一下方式      
			document.getElementById("imgDiv").style.display = "block";
			document.getElementById("img").src = window.URL
					.createObjectURL(docObj.files[0]);
		} else {
			//IE下，使用滤镜    
			docObj.select();
			var imgSrc = document.selection.createRange().text;

			//必须设置初始大小    
			localImagId.style.width = "200px";
			localImagId.style.height = "200px";

			//图片异常的捕捉，防止用户修改后缀来伪造图片    
			try {
				localImagId.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
				localImagId.filters
						.item("DXImageTransform.Microsoft.AlphaImageLoader").src = imgSrc;
			} catch (e) {
				alert("您上传的图片格式不正确，请重新选择!");
				return false;
			}
			imgObjPreview.style.display = 'none';
			document.selection.empty();
		}
		return true;
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
										<span>您好,</span>
										<c:if test="${user == null}">
											<a href="login.jsp"><span style="color: white;">登录</span></a>
											<a href="register.jsp"> <span
												style="margin-left: 20px; color: white;"> 注册</span></a>
										</c:if>
										<c:if test="${user != null}">
											<img style="width: 20px; length: 20px"
												src="${pageContext.request.contextPath}${user.picture}">
											<c:out value="${user.username}" />
											<a href="logout.do"><span style="color: white;">
													注销</span></a>
										</c:if>
									</div>
									<div style="margin-left: 250px;">
										<ul class="nav">
											<li><a class="home active" href="Itemlist.do?page=1">首页</a></li>
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
							<form action="searchItem.do?page=1" method="post">
								<div style="margin-top: 10px;">
									<input type="text" name="str" class="input-medium search-query"
										placeholder="搜索你想要的二手"
										style="height: 20px; width: 100; border: 4px solid #FFA07A">
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
				<!--  breadcrumb -->
				<ul class="breadcrumb">
					<li><a href="Itemlist.do?page=1">主页</a> <span class="divider">/</span></li>
					<li class="active">个人中心</li>
				</ul>
				<div class="row">
					<!-- Sidebar Start-->
					<aside class="span3">
						<div class="sidewidt">
							<h2 class="heading2">
								<span>我的个人中心</span>
							</h2>
							<ul class="nav nav-list categories">
								<li><a href="UsersUpdate.jsp">修改个人信息 </a></li>
								<li><a href="changepw.jsp">更改密码</a></li>
								<li><a href="addressList.do">更改/添加我的地址</a></li>
								<li><a href="orderItem.do">我的订单 </a></li>
								<li><a href="shopList.do">店铺信息管理</a></li>
							</ul>
						</div>
						<div class="sidewidt"></div>
					</aside>
					<!-- Sidebar End-->

					<div class="span9">
						<!-- Blog start-->
						<section id="latestblog">
							<div class="blogdetail">
								<div class="blogicons">
									<div class="pull-left"></div>
								</div>
								<ul class="margin-none">
									<li class="listblcok">
										<div class="mb20">
											<section class="leavecomment">
												<h2 class="heading2">
													<span>修改个人信息</span>
												</h2>
												<form action="updateUser.do" method="post"
													class="form-horizontal commentform2"
													enctype="multipart/form-data" novalidate>
													<fieldset>
														<input type="hidden" name="username"
															value="${user.username}" /> <input type="hidden"
															name="type" value=1 />
														<div class="control-group">
															<label class="control-label">电话/手机 </label>
															<div class="controls">
																<input type="text" name="tele" id="tele"
																	value="${user.tele}" />
															</div>
														</div>
														<div class="control-group">
															<label class="control-label">真实姓名</label>
															<div class="controls">
																<input type="text" name="name" id="name"
																	value="${user.name}" />
															</div>
														</div>
														<div class="control-group">
															<label class="control-label">电子邮箱</label>
															<div class="controls">
																<input type="text" name="email" id="email"
																	value="${user.email}" />
															</div>
														</div>
														<div class="control-group">
															<label class="control-label">个人身份证</label>
															<div class="controls">
																<input type="text" name="ID" id="ID" value="${user.ID}" />
															</div>
														</div>
														<div class="control-group">
															<label class="control-label">上传头像</label>
															<div class="controls">
																<p>注意：上传的图片名中不能包含中文</p>
															</div>
														</div>
														<input type="hidden" name="motopic"
															value="${user.picture}" />
														<div class="control-group">
															<div class="controls">
																<input type="file" name="picturefile"
																	onChange="setImagePreview(this);" id="picturefile"
																	accept="image/*" />
															</div>
														</div>
														<div class="control-group">
															<label class="control-label">头像预览：</label>
															<div style="display: none" id="imgDiv">
																<img alt="" src="" id="img" name="图片预览" width="200"
																	height="200" id="图片预览">
															</div>
														</div>
														<div class="controls">
															<input type="submit" id="submit_id" value="确认提交"
																class="btn btn-orange"
																onclick="return window.alert('修改完成')"> <input
																type="reset" value="重新输入" class="btn">
														</div>
													</fieldset>
												</form>
											</section>
										</div>
									</li>
								</ul>
							</div>
						</section>
					</div>
				</div>
			</div>
		</section>
	</div>
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
			<span>?2017 版权所有</span>
		</div>
	</footer>
	<!-- javascript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="js/jquery.js"></script>
	<script src="js/bootstrap.js"></script>
	<script src="js/respond.min.js"></script>
	<script src="js/application.js"></script>
	<script src="js/bootstrap-tooltip.js"></script>
	<script defer src="js/jquery.fancybox.js"></script>
	<script defer src="js/jquery.flexslider.js"></script>
	<script type="text/javascript" src="js/jquery.tweet.js"></script>
	<script src="js/cloud-zoom.1.0.2.js"></script>
	<script type="text/javascript" src="js/jquery.validate.js"></script>
	<script type="text/javascript"
		src="js/jquery.carouFredSel-6.1.0-packed.js"></script>
	<script type="text/javascript" src="js/jquery.mousewheel.min.js"></script>
	<script type="text/javascript" src="js/jquery.touchSwipe.min.js"></script>
	<script type="text/javascript"
		src="js/jquery.ba-throttle-debounce.min.js"></script>
	<script defer src="js/custom.js"></script>
</body>
</html>