<%@ page language="Java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>员工信息录入</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript"
	src="http://www.w3school.com.cn/jquery/jquery.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#membermanage").click(function() {
			$(".member").slideToggle("slow");
		});
	});
	$(document).ready(function() {
		$("#employ").click(function() {
			$(".employ").slideToggle("slow");
		});
	});
	$(document).ready(function() {
		$("#train").click(function() {
			$(".train").slideToggle("slow");
		});
	});

	$(document).ready(function() {
		$("#ap").click(function() {
			$(".ap").slideToggle("slow");
		});
	});
	$(document).ready(function() {
		$("#salary").click(function() {
			$(".salary").slideToggle("slow");
		});
	});

	window.onload = function() {
		var a = false;
		document.getElementById("id").onblur = function() {
			var id = document.getElementById("id").value;
			var divid = document.getElementById("uid");
			if (id == "") {
				divid.innerHTML = "<font color='red'>ID不能为空!</font>";
				a = false;
				return a;
			} else {
				a = true;
			}
			var regex = /^\d+$/;
			if (!regex.test(id)) {
				divname.innerHTML = "<font color='red'>* ID只能是数字组成</font>";
				a = false;
				return a;
			} else {
				a = true;
			}
			if (a) {
				$.ajax({
					type:"post",
				    data:{"id":id,"flag":"checkId"},
					url:"ajax.action",
					datatype:"text",
					success:function(successmsg){
						$("#uid").html(successmsg);
						if(successmsg == "<font color='green'>ID可以使用</font>"){
							a = true;
						}else{
							a = false;//禁用提交按钮
							return a;
						}
					},//请求成功后的回调函数
					error:function(errmsg){
						alert("错误："+errmsg);//请求失败后的回调函数	
					}
				});
			}
			return a;
		}
		document.getElementsByTagName("form")[0].onsubmit = function() {
			return a;
		}
	}
</script>
<style type="text/css">
body {
	height: 100%;
	width: 100%;
	position: absolute;
	padding-left: 0px;
}

.head {
	height: 15%;
	font-size: 50px;
	line-height: 90px;
}

.mid {
	height: 70%;
	background-color: #80ffff;
}

.left {
	height: 70%;
	width: 15%;
	float: left;
	background-color: white;
	border-top-style: solid;
	border-left-style: solid;
	border-right-style: solid;
	border-top-color: black;
	border-top-width: 1px;
}

.leftTop {
	background-color: #b8b8dc;
	height: 15%;
	width: 100%;
	border-bottom-style: solid;
	text-align: center;
}

ul {
	text-align: : center;
	display: block;
	height: 80px;
	list-style: none;
}

li {
	border-bottom: solid;
	color: black;
	text-align: center;
	border-width: 1px;
	width: 100px
}

p {
	display: none;
	font-size: 10px;
	text-align: center;
}

.right {
	float: right;
	width: 80%;
	height: 70%;
}
</style>
</head>
<body style="margin-top: 0px; margin-left: 0px;">
	<div class="head">人力资源管理系统</div>
	<div class="right">
		<!--  <input id="savebtn" type="button" value="保存"> <input id="backbtn" type="button" value="返回"> -->
		<span style="color: red">${requestScope.success}</span> <br> <br>
		<br> <br>
		<!-- 姓名、性别、学历、学位、部门、职务、人员状态（在职/兼职/离职）、图片（正装照/身份证扫描/学历证书扫描），除此之外，还可以选择定义行业背景、技术特长，等等。 -->
		<form action="informationEntry.action" method="post"
			enctype="multipart/form-data">
			<fieldset>
				<legend>人员信息</legend>
				姓名：<input type="text" id="name" name="name"> 年龄：<input
					type="text" id="age" name="age"> 性别：<input type="radio"
					name="sex" id="sex" value="男">男<input type="radio"
					name="sex" id="sex" value="女">女 学历：<select
					style="width: 80px" id="degree" name="degree"><option>本科</option>
					<option>硕士</option>
					<option>博士</option>
					<option>其它</option></select><br> <br> 部门：<input type="text"
					id="department" name="department"> 职务：<input type="text"
					id="duty" name="duty"> 员工状态：<input type="radio"
					name="state" id="state" value="在职">在职<input type="radio"
					name="state" value="兼职">兼职<input type="radio" name="state"
					value="离职">离职<br> <br> 照片：<input type="file"
					name="photo" value="浏览"> 员工ID：<input type="text" name="id"
					id="id"> <span id="uid">* ID只能是数字组成</span>
				<!-- 不可重复 -->
				<br> <br>
				<div style="width: 700px; line-height: 60px;">
					<label>人员简介：</label>
					<textarea style="width: 700px; height: 100px;" name="introduction"
						value=""></textarea>
				</div>
				<br> <br> <input id="savebtn2" type="submit" value="保存">
				<input id="reset" type="button" value="重置">
			</fieldset>
		</form>
	</div>
	<div class="left">
		<div class="leftTop">
			您好，${sessionScope.a.name} <br> <br> <a href="back.action">退出</a>
		</div>
		<div class="leftSelect">
			<ul id="select">
				<!-- onchang事件 -->
				<li id="membermanage">人员管理
					<p class="member">
						<a href="<%=basePath%>forward.action?flag=InfoEntry">人员信息录入</a>
					</p>
					<p class="member">
						<a href="<%=basePath%>forward.action?flag=InfoOverview">人员信息查看</a>
					</p>
				</li>
				<li id="employ">招聘管理
					<p class="employ">
						<a href="#">招聘信息录入</a>
					</p>
					<p class="employ">
						<a href="#">招聘信息查看</a>
					</p>
				</li>
				<li id="train">培训管理
					<p class="train">
						<a href="#">培训信息录入</a>
					</p>
					<p class="train">
						<a href="#">培训信息查看</a>
					</p>
				</li>
				<li id="ap">奖惩管理
					<p class="ap">
						<a href="#">奖惩信息录入</a>
					</p>
					<p class="ap">
						<a href="#">奖惩信息查看</a>
					</p>
				</li>
				<li id="salary">薪金管理
					<p class="salary">
						<a href="#">薪金信息录入</a>
					</p>
					<p class="salary">
						<a href="#">薪金信息查看</a>
					</p>
				</li>
			</ul>
		</div>
	</div>
</body>
</html>