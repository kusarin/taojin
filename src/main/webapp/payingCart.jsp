<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
 <title>确认订单</title>
 <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
 
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/sureOrder.css"/>
<link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/bootstrap-responsive.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/flexslider.css" type="text/css" media="screen" rel="stylesheet"  />
<link href="${pageContext.request.contextPath}/css/jquery.fancybox.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/cloud-zoom.css" rel="stylesheet">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.mn.js"></script>

<script>
function  che(){
	  var addr=document.getElementsByName("addr");
	  var i=-1;
	 
	  for( var j=0;j<addr.length;j++){
		  if(addr[j].checked){
			  i++;
			  break;
		  }
	  }
	  if(i==-1){
		  alert("请选择收货地址");
		  return;
	  }else{
		  document.myform.action="commitOrderDeCart.do";
	    	 // $(".myform")
	       document.myform.submit();
	  }
}

function checadr(){
	var addr=document.getElementsByName("addr");
	  var i=-1;
	 
	  for( var j=0;j<addr.length;j++){
		  if(addr[j].checked){
			  i=j;
			  break;
		  }
	  }
	  document.getElementById("adr").innerHTML=addr[i].value;
	  
}

//弹出隐藏层  
function ShowDiv(show_div,bg_div){  
 document.getElementById(show_div).style.display='block';  
 document.getElementById(bg_div).style.display='block' ;  
 var bgdiv = document.getElementById(bg_div);  
 bgdiv.style.width = document.body.scrollWidth;   
 // bgdiv.style.height = $(document).height();  
 $("#"+bg_div).height($(document).height());  
} 
//关闭弹出层  
function CloseDiv(show_div,bg_div)  
{  
 document.getElementById(show_div).style.display='none';  
 document.getElementById(bg_div).style.display='none';  
} 

//新增收货地址
function save(){
	      var addr = $("#rt").val();
	      var div = $("#receive");
	      if(addr.length==0){
	    	  alert("请输入收货地址");
	      }
	      else{
	      $.ajax(
	      {
	         url:"addAdr.do",
	         type:"get",
	         data:"addr="+addr,
	         contentType:"application/json;charset=utf-8",
	         dataType:"json",
	         error:function(data){  
	             alert("添加失败"); 
	         },  
	         success:function(data)
	         {
	        	   alert(data.msg);
	        	   window.location.reload();
		           CloseDiv('MyDiv','fade');	               
        }
	    });
	   }
	      
}
</script>
<style>  
.black_overlay{  
 display: none;  
 position: absolute;  
 top: 0%;  
 left: 0%;  
 width: 100%;  
 height: 100%;  
 background-color: black;  
 z-index:1001;  
 -moz-opacity: 0.8;  
 opacity:.80;  
 filter: alpha(opacity=80);  
}  
.white_content {  
 display: none;  
 position: absolute;  
 top: 10%;  
 left: 35%;  
 width: 30%;  
 height: 60%;    
 background-color: white;  
 z-index:1002;  
 overflow: auto;  
}  
 
</style>
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
	
	<form action="" method="post" name="myform">
    <div class="containers">
	   <div class="orderTitle" style="color:gray;">
	      <p>请核对订单信息</p>
	   </div>
	   <div class="receiver">
	       <div class="info">
	       <strong>收货人地址</strong><a href="javascript:void(0)" onclick="ShowDiv('MyDiv','fade')"><strong style="float:right;font-size:12px;">新增地址</strong></a>
		   </div>
		   
		   <div class="receiverInfo" id="receive">
		   <c:forEach items="${address}" var="adr">
			     <input type="radio" name="addr" value="${adr.addr}" onclick="checadr()">${adr.addr}<br>
		    </c:forEach>
		   </div>
		 
	   </div>
	   
	   	   <!--弹出层时背景层DIV,修改收货地址-->  
 <div id="fade" class="black_overlay">  
</div>  
 <div id="MyDiv" class="white_content">  
  <div style="text-align: right; cursor: default; height: 30px;background-color:yellow;line-height:30px;">  
   <span style="font-size: 30px;padding-right:5px;color:red;cursor:pointer;" onclick="CloseDiv('MyDiv','fade')">x</span>  
  </div>  
  <div style="margin-top:20px;">
 <table style="border-collapse:separate; border-spacing:0px 10px;font-size:14px;">
	<tr>
	<td style="text-align:center;">
    收货地址：<br/><input type="text" id="rt"  placeholder="省/市/县(可选)/街道" style="height:80px;margin-top:10px;margin-left:30%;">
	</td>
	</tr>
</table>
 
 </div>
 <div style="text-align:center;margin-top:80px;">
 <input type="button" onclick="save()" value="保存" style="margin-right:100px;"> 
 <input type="button" onclick="CloseDiv('MyDiv','fade')" value="取消">
 </div>
 </div>
	   
	   <div class="receive">
	       <div class="info">
	             <strong>支付方式</strong>
		    </div>
             <div class="butt">
             
			   <input type="radio" checked="checked" name="payAway" value="0" style="border:1px solid #DCDCDC;margin-top:-5px;">网银支付
			   
		     </div>
		 </div>
		 <div class="downline"></div>
		 
		<div class="receive">
		      <div class="info">
	             <strong>订单信息</strong>
		      </div>
		    <div class="nav1">
			    <table>
				<tr>
				   <td class="nav11">商品</td>
			       <td class="nav12">数量</td>
			       <td class="nav12">单价</td>
			       <td class="nav12">小计</td>
				</tr>
				</table>
			</div>
			
		</div>
		<c:forEach items="${cl.ca}" var="c" varStatus="s">
		<c:if test="${c.tradingNumbers<=c.item.number}">
		<div class="shoper">
			    <span>店铺：<a href="#">${c.shopName}</a></span>
			    <input type="hidden" name="ca[${s.index}].shopName" value="${c.shopName}">
		</div>
		
		<div class="orderDe" style="border:1px solid #80ffff;">
		<table>
		   <tr>
			     <td class="test1"><a href="lookItem.do?id=${c.item.item_id}" style="float:left;"><img src="${pageContext.request.contextPath}${c.item.image}"/></a>
			   <!-- <input type="hidden" value="${c.item.image}" name="orderDeatail[${s.index}].item.image"> -->
		       <p style="width: 100px;overflow: hidden;white-space: nowrap;text-overflow: ellipsis;float:left;margin-top:20px;"> <a href="lookItem.do?id=${c.item.item_id}">${c.item.name}</a></p>
		        </td>
				 <td class="common" style="padding-left:0px;text-align:center;">${c.tradingNumbers}
				 <input type="hidden" name="ca[${s.index}].tradingNumbers" value="${c.tradingNumbers}">
				 </td>
				 <td class="common">${c.item.price}</td>
				 <td class="common" id="itemprice">${c.totalPrice}
				 <input type="hidden" name="ca[${s.index}].totalPrice" value="${c.totalPrice}">
				 <input type="hidden" name="ca[${s.index}].itemId" value="${c.itemId}">
				 <input type="hidden" name="ca[${s.index}].cartItemId" value="${c.cartItemId}">
				 </td>
				 
			 </tr>
		 </table>
		</div>
		</c:if>
		</c:forEach>
		<c:if test="${cl.sh.totalnumber!=0}">
		<div class="orderDe">
		    <table class="same">
			     <tr><td style="padding-top:15px;padding-bottom:15px;"><strong class="pay" id="total">${cl.sh.totalnumber}</strong>件商品，总商品金额：
			     <strong class="pay" id="ac">${cl.sh.total}</strong></td></tr>
			     <tr><td style="padding-bottom:15px;"> 运费：<strong class="pay">0.0</strong></td></tr>
			</table>
		</div>
		
		<div class="orderDe" style="margin-top:0px;border:1px solid #80ffff;">
		  <table  class="same" style="background-color:#f0ffff;">
			     <tr><td style="padding-top:15px;">实际支付： 
			     <span class="pay" id="actulpayment">${cl.sh.total}</span>
			     </td></tr>
			     <tr><td style="padding-top:15px;">寄送至：<span id="adr">##################</span></td></tr>
				 <tr><td style="padding-top:15px;padding-bottom:15px;">收货人:${username}</td></tr>
		  </table>
		</div>
		
		<div class="commit">
		    <input type="button" value="提交订单" onclick="che()"/>
		</div>
		</c:if>
    </div> 
    </form>
    
     <c:if test="${cl.sh.totalnumber!=nu}">
    <div class="containers">
       <div class="orderTitle" style="color:red;font-size:15px;">
	      <p>以下商品无法购买，请重新通过“修改购物车中的商品数量、立即购买”来购买此商品</p>
	   </div>
       <c:forEach items="${cl.ca}" var="cai" varStatus="s">
		<c:if test="${cai.tradingNumbers>cai.item.number}">
		<div class="shoper">
			    <span>店铺：<a href="#">${cai.shopName}</a></span>
		</div>
		<div class="orderDe" style="border:1px solid #80ffff;">
		<table>
		   <tr>
			   <td class="test1"><a href="lookItem.do?id=${cai.item.item_id}" style="float:left;"><img src="${pageContext.request.contextPath}${cai.item.image}"/></a>
		       <p style="width: 100px;overflow: hidden;white-space: nowrap;text-overflow: ellipsis;float:left;margin-top:20px;"> <a href="lookItem.do?id=${cai.item.item_id}">${cai.item.name}</a></p>
		       </td>
			   <td class="common" style="padding-left:0px;text-align:center;">${cai.tradingNumbers}</td>
			   <td class="common">${cai.item.price}</td>
			   <td class="common" id="itemprice">${cai.totalPrice}</td>
			   <td class="common">购买数量超过了限购数。也可能是库存不足。</td>
			 </tr>
		 </table>
		</div>
		</c:if>
		</c:forEach>
    </div>
    </c:if>
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