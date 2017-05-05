<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
	function deleteone(resourcefile_id){
		if(confirm("确定要删除这条数据吗？")){
			window.location.href="deleteRF.do?id="+resourcefile_id;
		}
	}
</script>
<title>资源文件管理</title>
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
			<!--  breadcrumb -->
			<ul class="breadcrumb">
				<li>管理员界面 <span class="divider">/</span></li>
				<li>文件资源管理</li>
			</ul>
			<div class="row">
				<!-- Sidebar Start-->
				<aside class="span3">
				<div class="sidewidt">
					<h2 class="heading2">
						<span>管理员功能</span>
					</h2>
					<ul class="nav nav-list categories">
						<li><a class="managerInterface" href="managerInterface.jsp">管理员账户管理</a></li>
						<li><a class="SRmanage" href="./lookSR.do?page=1">店铺认证管理</a></li>
						<li><a class="userManage" href="./userManage.do?page=1">用户信息管理</a></li>
						<li><a class="shopManage" href="./shopManage.do?page=1">店铺信息管理</a></li>
						<li><a class="itemManage" href="./itemManage.do?page=1">商品信息管理</a></li>
						<li><a class="comment" href="./lookComment.do?page=1">用户留言管理</a></li>
						<li><a class="RFmanage" href="./findResourceFile.do?page=1">文件资源管理</a></li>
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
						<div class="pull-right">
							<a href="addRF.jsp"><input type="button" value="新增文件资源"
								class="btn btn-orange" /></a>
						</div>
						<div class="mb20">
							<section class="leavecomment">
							<h2 class="heading2">
								<span>资源文件列表</span>
							</h2>
							<table width="90%">
								<tbody>
									<tr>
										<td width="30%">文件名</td>
										<td width="40%">文件地址</td>
										<td width="20%">文件类型</td>
										<td width="10%"></td>
									</tr>
									<c:forEach items="${ResourceFile}" var="r">
										<tr>
											<td>${r.name}</td>
											<td>${r.address}</td>
											<td>${r.type}</td>
											<td><a onclick="deleteone(${r.resourcefile_id})"
												href="javascript:void(0)">删除</a></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
							<br>
							<div align="center">
								<form action="findResourceFile.do" method="post">
									<c:choose>
										<c:when test="${page != 1}">
											<a href="findResourceFile.do?page=${page-1}"><input
												type="button" name="lastPage" value="上一页"
												class="btn btn-orange" /></a>
										</c:when>
										<c:otherwise>
											<input type="button" disabled="true" name="lastPage"
												value="上一页" class="btn btn-orange" />
										</c:otherwise>
									</c:choose>

									<!-- 页数列表 -->
									<c:forEach items="${pageList}" var="pn">
										<c:choose>
											<c:when test="${pn == page}">
																		${pn}
																	</c:when>
											<c:otherwise>
												<a href="findResourceFile.do?page=${pn}"><U>${pn}</U></a>
											</c:otherwise>
										</c:choose>
									</c:forEach>

									<!-- 下一页 按钮 -->
									<c:choose>
										<c:when test="${page != totalPage}">
											<a href="findResourceFile.do?page=${page+1}"> <input
												type="button" name="nextPage" value="下一页"
												class="btn btn-orange" />
											</a>
										</c:when>
										<c:otherwise>
											<input type="button" disabled="true" name="nextPage"
												value="下一页" class="btn btn-orange" />
										</c:otherwise>
									</c:choose>
									&nbsp共${totalPage}页 &nbsp -向<input type="text" name="page"
										id="jump" onkeyup="this.value=this.value.replace(/\D/g,'')"
										onafterpaste="this.value=this.value.replace(/\D/g,'')" />页 <input
										type="submit" value="跳转" />
								</form>
							</div>
							</section>
						</div>
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