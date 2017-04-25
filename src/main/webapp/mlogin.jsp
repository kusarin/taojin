<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
    window.onload=function(){
    	var error="${requestScope.error}";
    	  if(error!=""&&error!=null&&typeof(error)!="undefined"){
    		  alert(error);
    	  }
    }
</script>
<title>二手淘金网--管理员登录</title>
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
									<span><h3>二手淘金交易网——管理员界面</h3></span>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</header>
<div id="maincontainer">
		<section id="product">
			<div class="container">
				<div class="row">
					<!-- Sidebar Start-->
					<aside class="span3">
						<div class="sidewidt"></div>
					</aside> 
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
											<h2 class="heading2">
												<span>管理员登录</span>
											</h2>
										<section class="leavecomment">
											<form action="mlogin.do" method="post"> 
												<fieldset>
														<div class="control-group">
															<label class="control-label">账户</label>
															<div class="controls">
																<input type="text" name="account" onkeyup="value=value.replace(/[^\w\.\/]/ig,'')" /> 
															</div>
														</div>
														<div class="control-group">
															<label class="control-label">密码</label>
															<div class="controls">
																<input type="password" name="password" />
															</div>
														</div>
														<div class="controls"><input type="submit" value="登录" onclick="return check()" class="btn btn-orange" style="width :200px" />
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
	<footer style="margin-top:100px"> <img
		src="${pageContext.request.contextPath}/image/footer-tri.png"
		style="width: 100%;">
	<div
		style="margin: 0px 0px 10px; text-align: center; padding-top: 10px;">

		<span>友情链接/</span> <a href="http://www.nwpu.edu.cn/" target="_top"
			class="links">西北工业大学</a>

	</div>
	<div style="text-align: center; margin-bottom: 10px;">
		<span>©2017 版权所有</span> <span>鄂ICP备14003265号-2</span>
	</div>
	</footer>
</body>
</html>
