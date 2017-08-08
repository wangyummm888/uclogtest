<!DOCTYPE html>
<html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/common.jsp"/>
<head>
	<meta charset="utf-8">
	<title>消息回复--layui后台管理模板</title>
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="format-detection" content="telephone=no">
	<link rel="stylesheet" href="${path}/layui/css/layui.css" media="all" />
	<link rel="stylesheet" href="//at.alicdn.com/t/font_tnyc012u2rlwstt9.css" media="all" />
	<link rel="stylesheet" href="${path}/css/message.css" media="all" />
</head>
<body class="childrenBody">
	<form class="layui-form">
		<div class="replay_edit">
			<textarea class="layui-textarea" id="msgReply"></textarea>
			<a class="layui-btn send_msg">发送</a>
		</div>
		<table class="layui-table msg_box" lay-skin="line">
			<colgroup>
				<col width="50%">
				<col width="30%">
				<col>
			</colgroup>
			<tbody class="msgReplyHtml"></tbody>
		</table>
	</form>
	<script type="text/javascript" src="${path}/layui/layui.js"></script>
	<script type="text/javascript" src="message.js"></script>
</body>
</html>