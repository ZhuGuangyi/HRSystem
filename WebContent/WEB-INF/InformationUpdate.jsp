<%@ page language="Java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.qingmai.entity.*"%>
    
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">    
    <title>更新员工信息</title>        
  <meta http-equiv="pragma" content="no-cache">
  <meta http-equiv="cache-control" content="no-cache">
  <meta http-equiv="expires" content="0">    
  <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
  <meta http-equiv="description" content="This is my page">
 </head>
 <body>
  <center>
   <h1>修改员工信息</h1>
 	<form action="<%=basePath %>updateEmployee.action" method="post">
 	    <input type="hidden" name="id" value="${requestScope.e.id}"/>
 		名字：<input type="text" name="name" value="${requestScope.e.name}"/><br/><br/>
 		年龄：<input type="text" name="age" value="${requestScope.e.age}"/><br/><br/>
 		学历：<input type="text" name="degree" value="${requestScope.e.degree}"/><br/><br/>
 		部门：<input type="text" name="department" value="${requestScope.e.department}"/><br/><br/>
 		职务：<input type="text" name="duty" value="${requestScope.e.duty}"/><br/><br/>
 		<input type="submit" value="提交"/>
 		<input type="reset" value="重置"/>
 	</form>
 	</center>
 </body>
</html>