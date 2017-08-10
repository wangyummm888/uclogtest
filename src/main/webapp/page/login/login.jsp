<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/common.jsp"/>
<html>
<head>
	<meta charset="utf-8">
	<title>登录--日志管理后台管理</title>
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="format-detection" content="telephone=no">
	<link rel="stylesheet" href="${path}/layui/css/layui.css" media="all" />
	<link rel="stylesheet" href="${path}/css/login.css" media="all" />
</head>
<body>
	<video class="video-player" preload="auto" autoplay="autoplay" loop="loop" data-height="1080" data-width="1920" height="1080" width="1920">
	    <source src="${path}/page/login/login.mp4" type="video/mp4">
	</video>
	<div class="video_mask"></div>
	<div class="login">
	    <h1>logtest-管理登录</h1>
	    <form class="layui-form" action="${path}/login/login.do" method="post">
	    	<div class="layui-form-item">
				<input class="layui-input" name="loginName" placeholder="用户名" lay-verify="required" type="text" autocomplete="off">
		    </div>
		    <div class="layui-form-item">
				<input class="layui-input" name="passWord" placeholder="密码" lay-verify="required" type="password" autocomplete="off">
		    </div>
		    <div class="layui-form-item form_code">
				<input class="layui-input" name="code" placeholder="验证码" lay-verify="required" type="text" autocomplete="off">
				<div class="code"><img src="${path}/login/getVerifyCode.do" width="116" height="36" onclick="changeImg()" id="img" name="img"></div>
		    </div>
			<button class="layui-btn login_btn" lay-submit="" lay-filter="login">登录</button>
		</form>
	</div>
	<script type="text/javascript" src="${path}/layui/layui.js"></script>
	<script type="text/javascript" src="${path}/page/login/login.js"></script>
	<script type="text/javascript">
		function changeImg(){
			var img = document.getElementById("img");
			img.src = "${path}/login/getVerifyCode.do?date=" + new Date();
		}
	</script>
</body>
</html>