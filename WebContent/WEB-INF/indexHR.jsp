<%@ page language="Java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">    
    <title>人力资源管理系统</title>        
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
		height: 100%;
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
	
	
	</style>
 </head>
 <body>
   <div class="head">人力资源管理系统</div>
<div class="mid">
	<div class="left" >
		<div class="leftTop">您好，${sessionScope.name}
	    <br><br>
	  <a href="back.action">退出</a>
	</div>
	<div class="leftSelect">
		<ul id="select">
			<li id="membermanage">人员管理
			<p class="member"><a href="<%=basePath %>forward.action?flag=InfoEntry">人员信息录入</a></p>
			<p class="member"><a href="<%=basePath %>forward.action?flag=InfoOverview">人员信息查看</a></p>
			</li>
			<li id="employ">招聘管理
			<p class="employ"><a href="#招聘信息录入.html">招聘信息录入</a></p>
			<p class="employ"><a href="#招聘信息查看.html">招聘信息查看</a></p></li>
			<li id="train">培训管理
			<p class="train"><a href="#培训信息录入.html">培训信息录入</a></p>
			<p class="train"><a href="#培训信息查看.html">培训信息查看</a></p>
			</li>
			<li id="ap">奖惩管理
			<p class="ap"><a href="#奖惩信息录入.html">奖惩信息录入</a></p>
			<p class="ap"><a href="#奖惩信息查看.html">奖惩信息查看</a></p>
			</li>
			<li id="salary">薪金管理
			<p class="salary"><a href="#薪金信息录入.html">薪金信息录入</a></p>
			<p class="salary"><a href="#薪金信息查看.html">薪金信息查看</a></p>
			</li>



		</ul>


	</div>
</div>
 </body>
</html>