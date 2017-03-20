<%@ page language="Java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">    
    <title>员工信息查看</title>        
  <meta http-equiv="pragma" content="no-cache">
  <meta http-equiv="cache-control" content="no-cache">
  <meta http-equiv="expires" content="0">    
  <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
  <meta http-equiv="description" content="This is my page">
  <script type="text/javascript" src="http://www.w3school.com.cn/jquery/jquery.js"></script>
	<script type="text/javascript">
	$(document).ready(function(){
		$("#membermanage").click(function(){
			$(".member").slideToggle("slow");
		});
	});
	$(document).ready(function(){
		$("#employ").click(function(){
			$(".employ").slideToggle("slow");
		});
	});
	$(document).ready(function(){
		$("#train").click(function(){
			$(".train").slideToggle("slow");
		});
	});

	$(document).ready(function(){
		$("#ap").click(function(){
			$(".ap").slideToggle("slow");
		});
	});
	$(document).ready(function(){
		$("#salary").click(function(){
			$(".salary").slideToggle("slow");
		});
	});

	function deleteEmployee(id){
		if(confirm("是否删除此人？")){
			//根据name删除员工
			window.location.href="deleteEmployee.action?id="+id;
		}
	}
	function changePage(currentPage1){
		window.location.href="selectEmployee.action?currentPage1="+currentPage1;
		
	}

	</script>
	<style type="text/css">
	body{
		height: 100%;
		width: 100%;
		position: absolute;
		padding-left: 0px;

	}
	.head{
		height: 15%;
		
		font-size: 50px;
		line-height: 90px;

	}

	.mid{
		height: 70%;
		background-color: #80ffff;
	}
	.left{
		height: 70%;
		width: 15%;
		float:left;
		background-color: white;
		border-top-style: solid;
		border-left-style: solid;
		border-right-style: solid;
		border-top-color : black;
		border-top-width: 1px;
	}
	.leftTop{
		background-color:#b8b8dc;
		height: 15%;
		width: 100%;
		border-bottom-style: solid;
		text-align: center;
	}
	
	ul{
		text-align: : center;
		display: block;
		height: 80px;
		list-style: none;


	}
	li{
		border-bottom:  solid;
		
		color: black;
		text-align: center;
		border-width: 1px;
		width:100px 

	}
	
	p{
		display: none;
		font-size: 10px;
		text-align: center;
	}
 	.right{
 		float: right;
 		width: 80%;
 		height:70%;
 		
 	}
	</style>
 </head>
 <body style="
    margin-top: 0px;
    margin-left: 0px;
">
<div class="head">人力资源管理系统</div>
	<div class="right">	
	<form action="<%=basePath%>selectEmployee.action" method="post">
		<span style="color: #6a6aff">人员信息查看</span>&nbsp;
		<b>名字</b><input type="text" style="width:60px" name="name" value="${sessionScope.e.name}">&nbsp;
		<b>部门</b><input type="text" style="width:60px" name="department" value="${sessionScope.e.department}">&nbsp;
		<b>职务</b><input type="text" style="width:60px" name="duty" value="${sessionScope.e.duty}">&nbsp;
		<input type="submit" value="搜索" />
	</form>
		<table width="1000px;" border="0" style="text-align: center;">
		<tr>
		<td colspan="7" bgcolor="#4a4aff" align="center" ><h1>人员信息列表</h1></td>
		</tr>
		<tr bgcolor="#b9b9ff">
		<th>名字</th>
		<th>年龄</th>
		<th>性别</th>
		<th>学历</th>
		<th>部门</th>
		<th>职务</th>
		<th>操作执行</th>
		</tr>
		<c:forEach var="e" items="${requestScope.lists}">
				<tr>
					
					<td id="n">${e.name}</td>
					<td>${e.age}</td>
					<td>${e.sex}</td>
					<td>${e.degree}</td>
					<td>${e.department}</td>
					<td>${e.duty}</td>
					<td><a
						href="<%=basePath%>forward.action?flag=updateEmployee&id=${e.id}">更新</a>
						| <a href="javascript:deleteEmployee(${e.id})">删除</a>  | <a href="lookPicture.action">查看照片</a></td>
				</tr>
			</c:forEach>
		</table>
		<a href="add.action">增加</a>
		
		<div><br><br>
		<span style="text-align: right">
			当前页${requestScope.currentPage}/${requestScope.pageCount}
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span> <span style="text-align: right">
			<input type="button" value="首页" onclick="changePage(${1})"/>
			<input type="button" value="上一页" onclick="changePage(${requestScope.currentPage - 1})"/> 
			<input type="button" value="下一页" onclick="changePage(${requestScope.currentPage + 1})" /> 
			<input type="button" value="末页" onclick="changePage(${requestScope.pageCount})"/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			跳转到第 <select id="pageIndex">
				<option value="1" selected="selected">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
		</select> </span>
	</div>
	</div>		
	
	<div class="left">
		<div class="leftTop">您好，${sessionScope.name}
	    <br><br>
	  <a href="back.action">退出</a>
	</div>
	<div class="leftSelect">
		<ul id="select">
		<!-- onchang事件 -->
			<li id="membermanage">人员管理
			<p class="member"><a href="<%=basePath %>forward.action?flag=InfoEntry">人员信息录入</a></p>
			<p class="member"><a href="<%=basePath %>forward.action?flag=InfoOverview">人员信息查看</a></p>
			</li>
			<li id="employ">招聘管理
			<p class="employ"><a href="#">招聘信息录入</a></p>
			<p class="employ"><a href="#">招聘信息查看</a></p></li>
			<li id="train">培训管理
			<p class="train"><a href="#">培训信息录入</a></p>
			<p class="train"><a href="#">培训信息查看</a></p>
			</li>
			<li id="ap">奖惩管理
			<p class="ap"><a href="#">奖惩信息录入</a></p>
			<p class="ap"><a href="#">奖惩信息查看</a></p>
			</li>
			<li id="salary">薪金管理
			<p class="salary"><a href="#">薪金信息录入</a></p>
			<p class="salary"><a href="#">薪金信息查看</a></p>
			</li>
		</ul>
	</div>
</div>
 </body>
</html>