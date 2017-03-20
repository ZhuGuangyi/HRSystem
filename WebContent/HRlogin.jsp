<%@ page language="Java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">    
    <title>登录页面</title>        
  <meta http-equiv="pragma" content="no-cache">
  <meta http-equiv="cache-control" content="no-cache">
  <meta http-equiv="expires" content="0">    
  <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
  <meta http-equiv="description" content="This is my page">
  <style type="text/css">
div{
	width: 250px;
	height: 300px;
	
	margin:auto;
	border-style: solid;
	border-width: 5px;
	border-color: grey;
	background-color: #c1ffe4;
	position: relative;
	top: 100px
}
h1{
	text-align: center;
	
}
p{
	font-size: 50px;

	text-align: center;
	
}
body{
	background-color: #f0f0f0;
}
</style>
<script type="text/javascript">
  window.onload=function(){
	 var imgNode=document.getElementsByTagName("img")[0];
	 imgNode.src="createcode.action?a="+Math.random();
	 imgNode.onclick=function(){
		 changeImage();
	 }
  }
	 function changeImage(){
		 var imgNode=document.getElementsByTagName("img")[0];
		 imgNode.src="createcode.action?a="+Math.random();
	 }

	 
  </script>
 </head>
 <body>
 <p>欢迎使用人力资源管理系统</p>

<div id="login">
<h1>登录信息</h1>
  <table align="center">
<form action="loginCL.action" method="post">
   <tr>
    <td>用户名:</td>
    <td><input type="text" name="name"  size="15px" /></td>
   </tr>
   <tr>
    <td>密码:</td>
    <td><input type="password" name="pass" size="15px" /></td>
   </tr>
   <br/>
   <tr>
     <td>验证码:</td>
    <td><input type="text" name="code" size="15px" /></td>
   </tr>
   <tr>
   <td><img alt="验证码图片" src="createcode.action"></td>
   <td>
 <a href="javascript:changeImage()"><h5>看不清，换一张</h5></a></td>
   </tr>
   <tr align="center">
   <td colspan="2">
     <input type="submit" name="submit" value="登陆"/>
     <input type="reset" name="reset" value="重置">
   </td>
   </tr>
 </form>
   </table>
   <c:set var="noLogin" value="${sessionScope.noLogin}"></c:set>
 <c:if test="${!empty requestScope.err}">
 	<font size="5" color="red" style="align:center">${requestScope.err}</font>
 </c:if>
 
 <c:if test="${!empty noLogin}">
 	<font size="5" color="red" style="align:center">${noLogin}</font>
 	<c:remove var="noLogin"/>
 </c:if>
</div>

 </body>
</html>