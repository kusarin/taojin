<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>管理员界面</title>
</head>

<body>
<h1>管理员界面——${manager.account}</h1>
<div>
  <table width="90%" border="0">
    <tr>
      <td width="10%"><div align="center">
        <strong>管理员账户管理</strong>
      </div></td>
      <td width="10%"><div align="center">
        <a href="./lookComment.do?page=1"><strong>用户留言管理</strong></a>
      </div></td>
      <td width="10%"><div align="center">
        <a href="./findResourceFile.do" ><strong>文件资源管理</strong></a>
      </div></td>
      <td width="10%"><div align="center">
        <a href="./lookSR.do" ><strong>店铺认证管理</strong></a>
      </div></td>
      <td width="10%"><div align="center">
        <a href="./userManage.do" ><strong>用户信息管理</strong></a>
      </div></td>
      <td width="10%"><div align="center">
        <a href="./shopManage.do" ><strong>店铺信息管理</strong></a>
      </div></td>
      <td width="10%"><div align="center">
        <a href="./itemManage.do" ><strong>商品信息管理</strong></a>
      </div></td>
    </tr>
    </table>
   <h3> 欢迎你！管理员${manager.account}</h3>
    <table width="50%" border="0">
    <tr>
    	<td>
   			 <a href="addmanager.jsp"><strong>新增管理员</strong></a>
    	</td>
    </tr>
    <tr>
    	<td>
   			 <a href="updateMpassword.jsp"><strong>修改密码</strong></a>
    	</td>
    </tr>
    </table>
	</div>
</body>
</html>
