window.onload = function() {
	var a = false;
	var b = false;
	var c = false;
	var d = false;
	var e = false;
	var flag = true;
	/**
	 * 验证用户名
	 */
	document.getElementById("username").onblur = function() {
		// 根据输入框的id属性获得输入框中的内容
		var username = document.getElementById("username").value;
		var divname = document.getElementById("uname");
		if (username == "") {
			divname.innerHTML = "<font color='red'>用户名不能为空!</font>";
			a=false;
			return a;
		}else{
			a = true;
		}
		var regex = /^[a-zA-Z0-9_]+$/;
		if (!regex.test(username)) {
			divname.innerHTML = "<font color='red'>* 用户名只能是数字、字母、下划线组成</font>";
			a=false;
			return a;
		}else{
			a = true;
		}
		if (a) {
			//divname.innerHTML = "<font color='green'>√</font>";
			//使用jquery ajax判断用户名是否已经注册
			//$就是jQuery
			$.ajax({
				type:"post",//请求方式
				data:{"name":username,"flag":"checkName"},//请求参数(发送到服务器的数据)
				//date:{"name":username,"age":age}多组数据
				url:"ajax.action",//请求路径
				dataType:"text",//预期服务器返回的类型
				success:function(successmsg){
					//alert(successmsg);
					//将内容显示在页面上
					$("#uname").html(successmsg);
					if(successmsg == "<font color='green'>用户可以使用</font>"){
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

	/**
	 * 验证密码
	 */
	document.getElementById("password").onblur = function() {
		var password = document.getElementById("password").value;
		var divname = document.getElementById("upwd");
		if (password == "") {
			divname.innerHTML = "<font color='red'>* 密码不能为空</font>";
			b=false;
			return b;
		}else{
			b=true;
		}
		if (password.length < 6 && password.length >= 0) {
			divname.innerHTML = "<font color='red'>* 密码至少为6位</font>";
			b=false;
			return b;
		}else{
			b=true;
		}
		if (b) {
			divname.innerHTML = "<font color='green'>√</font>";
		}
		return b;
	}

	/**
	 * 验证确认密码
	 */
	document.getElementById("confirmPwd").onblur = function() {
		var password = document.getElementById("password").value;
		var conPwd = document.getElementById("confirmPwd").value;
		var divname = document.getElementById("uConPwd");
		if (conPwd == "") {
			divname.innerHTML = "<font color='red'>* 确认密码不能为空</font>";
			c = false;
			return c;
		}else{
			c=true;
		}
		if (password != conPwd) {
			divname.innerHTML = "<font color='red'>* 初始密码必须和确认密码一致</font>";
			c = false;
			return c;
		}else{
			c=true;
		}
		if (c) {
			divname.innerHTML = "<font color='green'>√</font>";
		}
		return c;
	}

	/**
	 * 验证电话号码
	 */
	document.getElementById("phone").onblur = function() {
		var phone = document.getElementById("phone").value;
		var divname = document.getElementById("uphone");
		if (phone == "") {
			divname.innerHTML = "<font color='red'>* 电话号码不能为空</font>";
			d = false;
			return d;
		}else{
			d=true;
		}
		var regex = /^\d{11}$/;
		if (!regex.test(phone)) {
			divname.innerHTML = "<font color='red'>* 电话号码必须是11位数字！</font>";
			d = false;
			return d;
		}else{
			d=true;
		}
		if (d) {
			divname.innerHTML = "<font color='green'>√</font>";
		}
		return d;
	}

	/**
	 * 验证电子邮箱
	 */
	document.getElementById("email").onblur = function() {
		var email = document.getElementById("email").value;
		var divname = document.getElementById("uemail");
		if (email == "") {
			divname.innerHTML = "<font color='red'>* E-mail不能为空</font>";
			e = false;
			return e;
		}else{
			e=true;
		}
		var regex = /^[-_A-Za-z0-9]+@([_A-Za-z0-9]+\.)+[A-Za-z0-9]{2,3}$/;
		if (!regex.test(email)) {
			divname.innerHTML = "<font color='red'>* E-mail格式不正确</font>";
			e = false;
			return e;
		}else{
			e=true;
		}
		if (e) {
			$.ajax({
				type:"post",//请求方式
				data:{"email":email,"flag":"checkEmail"},//请求参数(发送到服务器的数据)
				//date:{"name":username,"age":age}多组数据
				url:"ajax.action",//请求路径
				dataType:"text",//预期服务器返回的类型
				success:function(successmsg){
					//alert(successmsg);
					//将内容显示在页面上
					$("#uemail").html(successmsg);
					if(successmsg == "<font color='green'>邮箱可以使用</font>"){
						e = true;
					}else{
						e = false;//禁用提交按钮
						return e;
					}
				},//请求成功后的回调函数
				error:function(errmsg){
					alert("错误："+errmsg);//请求失败后的回调函数	
				}
			});
		}
		
		return e;
	}

	/**
	 * 验证QQ号码
	 */
	document.getElementById("qqNum").onblur = function() {
		var qqNum = document.getElementById("qqNum").value;
		var divname = document.getElementById("uqnum");
		for (var i = 0; i < qqNum.length; i++) {
			if (!(/^\d+$/).test(qqNum)) {
				divname.innerHTML = "<font color='red'>* QQ号码只能是数字！</font>";
				flag = false;
				return flag;
			}
		}
		if (flag) {
			divname.innerHTML = "<font color='green'>√</font>";
		}
		return flag;
	}

	/**
	 * 检查所有输入验证
	 */
	document.getElementsByTagName("form")[0].onsubmit = function() {
		return a&&b&&c&&d&&e&&flag;
	}
	
}