<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE HTML>
<html>
	<head>
		<title><spring:message code="main.title"></spring:message>
		</title>
		<link rel="stylesheet" type="text/css" href="css/easyui.css">
		<link rel="stylesheet" type="text/css" href="css/icon.css">
		<link rel="stylesheet" type="text/css" href="css/common.css">
		<script src='js/lib/jquery.min.js'></script>
		<script src='js/lib/jquery.easyui.min.js'></script>
		<script src='js/lib/jquery.easyui.patch.js'></script>
		<script src='js/lib/easyui-lang-zh_CN.js'></script>
	</head>
	<body class="easyui-layout" fit=true>
		<div region="north" class="easyui-layout ">
			<div class="head">
				<!--head start  -->
				<div class="title">
					<img class='logo'
						src="${pageContext.request.contextPath}images/logo.png"
						width="65px" height="65px" alt="公司logo">
					<div class="text">
						<span><spring:message code="main.title" /> </span>
					</div>
					<div class="text_en">
						<span><spring:message code="main.title.small" /> </span>
					</div>
				</div>
				<div class="account">
					<div id="userInfo">
						欢迎您：
						<a href="javaScript:editInfo();" title="修改个人信息 ">${user.loginName}</a>
						<a href="javaScript:editpass();" id="editpass">修改密码</a>
						<a href="javaScript:loginOut();" id="loginOut">[退出]</a>
					</div>
				</div>
			</div>
		</div>
		<div region="center" border=false>
			<div class="easyui-layout" fit=true>
				<div region="center" data-options="href:'video/index.action'"></div>
				<div region="east" data-options="width:700,href:'video/index.action'"></div>
			</div>
		</div>
		<div region="south"
			style="height: 30px; background-color: #84daff; text-align: center; font-size: 15px;">
			<div style="margin: 5px auto">
				<spring:message code="main.copywright" />
			</div>
		</div>
	</body>
</html>
