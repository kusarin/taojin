<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf8" />
<title>京东商城导航条</title>
<style type="text/css">
.my_left_category{
width:150px;
font-size:12px;
font-family:arial,sans-serif;
letter-spacing:2px;
}
.my_left_category h1{
background-image:url(images/spring_06.gif);
height:20px;
background-repeat:no-repeat;
font-size:14px;
font-weight:bold;
padding-left:15px;
padding-top:8px;
margin:0px;
color:#FFF;
}
.my_left_category .my_left_cat_list{
width:148px;
border-color:#b60134;
border-style:solid;
border-width:0px 1px 1px 1px;
line-height:13.5pt;
}
.my_left_category .my_left_cat_list h2 {
margin:0px;
padding:3px 5px 0px 9px;
}
.my_left_category .my_left_cat_list h2 a {
color:#d6290b;
font-weight:bold;
font-size:14px;
line-height:22px;
}
.my_left_category .my_left_cat_list h2 a:hover {
color:#d6290b;
font-weight:bold;
font-size:14px;
line-height:22px;
}
.my_left_category .h2_cat{
width:148px;
height:26px; 
background-image:url(images/my_menubg.gif);
background-repeat:no-repeat; 
line-height:26px;
font-weight:normal;
color:#333333;
position:relative;
}
.my_left_category .h2_cat_1{
width:148px;
height:26px; 
background-image:url(images/my_menubg_1.gif);
background-repeat:no-repeat; 
line-height:26px;
font-weight:normal;
color:#333333;
position:relative;
}
.my_left_category a{
font:12px;
text-decoration:none;
color:#333333;
}
.my_left_category a:hover{
text-decoration:underline;
color:#ff3333;
}
.my_left_category h3{
margin:0px; 
padding:0px;
height:26px; 
font-size:12px; 
font-weight:normal;
display:block; 
padding-left:8px;
}
.my_left_category h3 span{color:#999999; width:145px; float:right;}
.my_left_category h3 a{ line-height:26px;}
.my_left_category .h3_cat{
display:none;
width:204px;
position:absolute; 
left:123px; 
margin-top:-26px; 
cursor:auto;
}
.my_left_category .shadow{
position:inherit;
background:url(images/shadow_04.gif) left top;
width:204px;
}
.my_left_category .shadow_border{
position:inherit; 
width:200px; 
border:1px solid #959595; margin-top:1px; 
border-left-width:0px; 
background:url(images/shadow_border.gif) no-repeat 0px 21px; 
background-color:#ffffff; 
margin-bottom:3px
}
.my_left_category .shadow_border ul{margin:0; padding:0; margin-left:15px}
.my_left_category .shadow_border ul li {
list-style:none;
padding-left:10px;
background-image:url(images/my_cat_sub_menu_dot.gif);
background-repeat:no-repeat;
background-position:0px 8px;
float:left;
width:75px;
height:26px;
overflow:hidden;
letter-spacing:0px;
} 
.my_left_category .active_cat{ z-index:99;background-position:0 -25px;cursor:pointer;}
.my_left_category .active_cat h3 { font-weight:bold}
.my_left_category .active_cat h3 span{ display:none;} 
.my_left_category .active_cat div{display:block;} 
</style>
</head>
<body>
<div class="my_left_category">
<h1>店铺分类导航</h1>
<div class="my_left_cat_list">
<h2><a href="#">按店铺类别</a></h2>
<div class="h2_cat" onmouseover="this.className='h2_cat active_cat'" onmouseout="this.className='h2_cat'">
<h3><a href="#">电子产品</a></h3>
<div class="h3_cat">
<div class="shadow">
<div class="shadow_border">
<ul>
<li><a href="#">LOGO设计</a></li>
<li><a href="#">网站设计</a></li>
<li><a href="#">网站广告</a></li>
<li><a href="#">推广</a></li>
<li><a href="#">建网站</a></li>
<li><a href="#">网站推广</a></li>
<li><a href="#">网站建设</a></li>
<li><a href="#">SEO</a></li>
</ul>
</div>
</div>
</div> 
</div> 
<div class="h2_cat" onmouseover="this.className='h2_cat active_cat'" onmouseout="this.className='h2_cat'">
<h3><a href="#">韩国男装</a></h3>
<div class="h3_cat">
<div class="shadow">
<div class="shadow_border">
<ul>
<li><a href="#">LOGO设计</a></li>
<li><a href="#">网站设计</a></li>
<li><a href="#">网站广告</a></li>
<li><a href="#">推广</a></li>
<li><a href="#">建网站</a></li>
<li><a href="#">网站推广</a></li>
<li><a href="#">网站建设</a></li>
<li><a href="#">SEO</a></li>
</ul>
</div>
</div> 
</div> 
</div> 
<div class="h2_cat" onmouseover="this.className='h2_cat active_cat'" onmouseout="this.className='h2_cat'">
<h3><a href="#">脚本之家</a></h3>
<div class="h3_cat">
<div class="shadow">
<div class="shadow_border">
<ul>
<li><a href="#">LOGO设计</a></li>
<li><a href="#">源码下载</a></li>
<li><a href="#">最新更新</a></li>
<li><a href="#">下载排行</a></li>
<li><a href="#">ASP</a></li>
<li><a href="#">PHP</a></li>
<li><a href="#">AJAX</a></li>
<li><a href="#">DELPHI</a></li>
</ul>
</div>
</div> 
</div> 
</div> 
<!-- again -->
<h2><a href="#">按品牌选货</a></h2>
<div class="h2_cat" onmouseover="this.className='h2_cat active_cat'" onmouseout="this.className='h2_cat'">
<h3><a href="#" style="color:#ff3333;">热销推荐</a></h3>
<div class="h3_cat">
<div class="shadow">
<div class="shadow_border">
<ul>
<li><a href="#">LOGO设计</a></li>
<li><a href="#">网站设计</a></li>
<li><a href="#">网站广告</a></li>
<li><a href="#">推广</a></li>
<li><a href="#">建网站</a></li>
<li><a href="#">网站推广</a></li>
<li><a href="#">网站建设</a></li>
<li><a href="#">SEO</a></li>
</ul>
</div>
</div>
</div> 
</div> 
<div class="h2_cat" onmouseover="this.className='h2_cat active_cat'" onmouseout="this.className='h2_cat'">
<h3><a href="#">网站建设</a></h3>
<div class="h3_cat">
<div class="shadow">
<div class="shadow_border">
<ul>
<li><a href="#">LOGO设计</a></li>
<li><a href="#">网站设计</a></li>
<li><a href="#">推广</a></li>
<li><a href="#">建网站</a></li>
<li><a href="#">网站推广</a></li>
<li><a href="#">推广</a></li>
<li><a href="#">LOGO设计</a></li>
<li><a href="#">网站设计</a></li>
<li><a href="#">网站广告</a></li>
<li><a href="#">推广</a></li>
<li><a href="#">建网站</a></li>
<li><a href="#">网站推广</a></li>
<li><a href="#">网站建设</a></li>
<li><a href="#">LOGO设计</a></li>
<li><a href="#">网站设计</a></li>
<li><a href="#">网站建设</a></li>
<li><a href="#">SEO</a></li>
</ul>
</div>
</div> 
</div> 
</div> 
<div class="h2_cat" onmouseover="this.className='h2_cat active_cat'" onmouseout="this.className='h2_cat'">
<h3><a href="#">网站程序</a></h3>
<div class="h3_cat">
<div class="shadow">
<div class="shadow_border">
<ul>
<li><a href="#">PHP</a></li>
<li><a href="#">ASP</a></li>
<li><a href="#">JSP</a></li>
<li><a href="#">ASP.Net</a></li>
</ul>
</div>
</div> 
</div> 
</div> 
<div class="h2_cat_1" onmouseover="this.className='h2_cat_1 active_cat'" onmouseout="this.className='h2_cat_1'">
<h3><a href="#">其他网站</a></h3>
</div>
<!-- again -->
<h2><a href="#">按价格选货</a></h2>
<div class="h2_cat" onmouseover="this.className='h2_cat active_cat'" onmouseout="this.className='h2_cat'">
<h3><a href="#">低端价位</a></h3>
<div class="h3_cat">
<div class="shadow">
<div class="shadow_border">
<ul>
<li><a href="#">50元以下</a></li>
<li><a href="#">50-100元</a></li>
</ul>
</div>
</div>
</div> 
</div> 
<div class="h2_cat" onmouseover="this.className='h2_cat active_cat'" onmouseout="this.className='h2_cat'">
<h3><a href="#">中高端价位</a></h3>
<div class="h3_cat">
<div class="shadow">
<div class="shadow_border">
<ul>
<li><a href="#">100-150元</a></li>
<li><a href="#">150-200元</a></li>
<li><a href="#">200-300元</a></li>
<li><a href="#">300元以上</a></li>
</ul>
</div>
</div> 
</div> 
</div> 
<!-- again -->
<h2><a href="#">超值特价区</a></h2>
<h2><a href="#">现货区</a></h2>
<!--测试复制end--> 
</div>
</div> 
</body>
</html>