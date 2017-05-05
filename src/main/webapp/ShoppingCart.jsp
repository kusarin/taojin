<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<% 
response.setHeader("Cache-Control","no-store"); 
response.setHeader("Pragrma","no-cache"); 
response.setDateHeader("Expires",0); 
%> 
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
function allc(name,checked){
	
	var vv=document.getElementsByName("cartItemId");
	var to=document.getElementsByName("to");
	 for(var i =0;i<vv.length;i++){
         vv[i].checked=checked;
       }
	 if(checked){
		 document.getElementById("cn").innerHTML=""+vv.length;
		 var ac=document.getElementById("ac");
		 var val=0;
		 for(var j=0;j<to.length;j++){
			 val=val+parseFloat(to[j].innerHTML);
		 }
		 ac.innerHTML=""+val;
	 }else{
		 document.getElementById("cn").innerHTML=""+0;
		 document.getElementById("ac").innerHTML=""+0.0;
	 }
}
function cl(name,checked,tot){
	var va=parseFloat(document.getElementById("ac").innerHTML);
	var cn=parseInt(document.getElementById("cn").innerHTML);
	if(checked){
		va=(va+tot).toFixed(2);
		document.getElementById("ac").innerHTML=""+va;
		cn++;
		document.getElementById("cn").innerHTML=""+cn;
		var vv=document.getElementsByName("cartItemId");
		if(cn==vv.length){
			document.getElementById("al").checked=true;
		}else{
			document.getElementById("al").checked=false;
		}
	}else{
		va=(va-tot).toFixed(2);
		document.getElementById("ac").innerHTML=""+va;
		cn--;
		document.getElementById("cn").innerHTML=""+cn;
		document.getElementById("al").checked=false;
	}
} 
function deleteo(cartItemId){
	if(confirm("确定要移除此商品吗？")){
		window.location.href="deleteCart.do?cartItemId="+cartItemId;
	}
}
function mm(id){
	window.location.href="updateNumberAndTotal.do?flag=1&itemId="+id;
}
function p(id,number,snumber){
	if(snumber<number){
	window.location.href="updateNumberAndTotal.do?flag=0&itemId="+id;
	}
	else{
		alert("您所填写的商品数量超过库存！");
	}
}
function comm(){
	 var ii=0;
	   var cks=document.getElementsByName("cartItemId");
     for(var i =0;i<cks.length;i++){
  	   if(cks[i].checked){
  		   ii++;
  	   }
     }
     if(ii==0){
  	   alert("至少选择一条");
       return;
     }
     document.myform.action="payingCart.do";
     // $(".myform")
     document.myform.submit();

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
						<form class="form-search top-search" action="searchItem.do?page=1" method="post">
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
	
	<form action="" name="myform" method="post">
     <div class="containers">
	   <div class="orderTitle" style="color:gray;">
	      <p>购物车</p>
	   </div>
	   
	   <div class="receive">
		      <div class="info">
	             <strong>全部商品</strong><span style="color:red;">${clist.sh.totalnumber}</span>
		      </div>
	   </div>
		<div class="receive" style="border-bottom:0px;">
		    <div class="nav1">
			    <table>
				<tr>
				   <td class="nav11"><input type="checkbox" id="al" onclick="allc('cartItemId',this.checked)" style="float:left;"><span style="float:left;margin-left:5px;">全选</span><span>商品</span></td>
			       <td class="nav12">数量</td>
			       <td class="nav12">单价</td>
			       <td class="nav12">小计</td>
				   <td class="nav12">操作</td>
				</tr>
				</table>
			</div>
		</div>
		<c:forEach items="${clist.ca}" var="c" >
		
		<div class="shoper">
			    <span>店铺：${c.shopName}</span>
		</div>
		<div class="orderDe" style="border:1px solid #80ffff;">
		<table>
		      <tr>
			     <td class="test1"><input type="checkbox" name="cartItemId" onclick="cl('cartItemId',this.checked,${c.totalPrice})" value="${c.cartItemId}" style="margin-top:0px;float:left;">
			     <a href="lookItem.do?id=${c.item.item_id}"><img src="${pageContext.request.contextPath}${c.item.image}"/></a>
		         <a href="lookItem.do?id=${c.item.item_id}"><p>${c.item.name}</p></a></td>
				 <td class="common" style="padding-left:0px;text-align:center;">
				 <input type="button" value="-" onclick="mm(${c.item.item_id})" style="text-align:center;height:30px;width:20px;float:left;border:0;">
				 <input type="text" value="${c.tradingNumbers}" id="mp" readonly="true" style="background-color:white;text-align:center;width:20px;float:left;border:1px;">
				 <input type="button" value="+"  onclick="p(${c.item.item_id},${c.item.number},${c.tradingNumbers})" style="height:30px;width:20px;text-align:center;float:left;border:0;"></td>
				 <td class="common" style="text-align:center;">${c.item.price}</td>
				 <td class="common" style="text-align:center;"><p name="to">${c.totalPrice}</p></td>
				 <td class="common" style="text-align:center;"><a onclick="deleteo(${c.cartItemId})" href="javascript:void(0)">删除</a></td>
			 </tr>
		 </table>
		</div>
		</c:forEach>
		
		<div class="orderDe">
		    <table class="same">
			     <tr><td style="padding-top:15px;padding-bottom:15px;">已选<strong class="pay" id="cn">0</strong>件商品，总商品金额：<strong class="pay" id="ac">0.0</strong></td></tr>
			</table>
		</div>
		
		<div class="commit">
		    <input type="button" value="结算" onclick="comm()" style="width:70px;height:40px;"/>
		</div>
		
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