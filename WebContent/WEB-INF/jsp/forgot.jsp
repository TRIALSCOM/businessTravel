	<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
	<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Minimal and Clean Sign up / Login and Forgot Form by FreeHTML5.co</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<link rel="shortcut icon" href="favicon.ico">

	
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/animate.css">
	<link rel="stylesheet" href="css/style.css">

	<!-- Modernizr JS -->
	<script src="js/modernizr-2.6.2.min.js"></script>
	<!-- FOR IE9 below -->
	<!--[if lt IE 9]>
	<script src="js/respond.min.js"></script>
	<![endif]-->

	</head>
	<body>

		<div class="container">
			<div class="row">
				<div class="col-md-4 col-md-offset-4">
					

					<!-- Start Sign In Form -->
					<form action="forgetPassword" method="post" class="fh5co-form animate-box" data-animate-effect="fadeIn">
						<h2>忘记密码</h2>
						<div id="email-sent">
						<div class="form-group-sentrequest">
						<div class="form-group">
							<div class="alert alert-success" id="email-success" role="alert">你的邮件已经发送</div>
						</div>
						</div>
						</div>
						<div class="form-group">
							<label for="email" class="sr-only">邮件</label>
							<input type="email" class="form-control" name="email" id="email" onblur="email_check()" placeholder="邮件" autocomplete="off">
							<p class="email_tip"><font color="red">邮箱格式错误</font></p>
						</div>
						<p><font color="red">${msg}</font></p>
						<div id="password-container">
						<div class="form-group-re-password">
						<div class="form-group">
							<label for="password" class="sr-only">密码</label>
							<input type="password" class="form-control" id="password" placeholder="请输入新密码" autocomplete="off">
						</div>
						<div class="form-group">
							<label for="re-check-password" class="sr-only">确认密码</label>
							<input type="password" class="form-control" id="re-check-password" placeholder="请确认密码" autocomplete="off">
						</div>
						</div>
						</div>
						<div class="form-group">
							<input type="submit" value="发送邮箱" id="btn-email-send" class="btn btn-primary">
						</div>
						<div class="form-group">
							<p><a href="index">登录</a> or <a href="sign-up">注册</a></p>
						</div>
					</form>
					<!-- END Sign In Form -->


				</div>
			</div>
			<!-- <div class="row" style="padding-top: 60px; clear: both;">
				<div class="col-md-12 text-center"><p><small>&copy; All Rights Reserved. Designed by <a href="javascript:;">差旅管理平台</a></small></p></div>
			</div> -->
		</div>
	<div style="padding-top: 60px; clear: both;">
				<div class="col-md-12 text-center" style="bottom: 10%;position:absolute;" ><p><small>&copy; All Rights Reserved. Designed by <a href="javascript:;">差旅管理平台</a></small></p></div>
			</div>
	
	<!-- jQuery -->
	<script src="js/jquery.min.js"></script>
	<!-- Bootstrap -->
	<script src="js/bootstrap.min.js"></script>
	<!-- Placeholder -->
	<script src="js/jquery.placeholder.min.js"></script>
	<!-- Waypoints -->
	<script src="js/jquery.waypoints.min.js"></script>
	<!-- Main JS -->
	<script src="js/main.js"></script>

	</body>
</html>

