<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>留言</title>
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

<form action="addComment.do" method="post"> 
  <table> 
   <tr> 
    <td colspan="2">留言给我们！谢谢您参与网站的完善！</td> 
   </tr> 
   <input type="hidden" name="username" value="${user.username}" />
   <tr> 
    <td>内容：</td> 
    <td><input type="text" name="content" /> </td> 
   </tr> 
   <tr> 
    <td colspan="2">
    	<input type="submit" value="发布" /> 
    </td> 
   </tr> 
  </table> 
 </form>
</body>
</html>