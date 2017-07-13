	
	<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
	<!DOCTYPE html>
	<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
	<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title></title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<!-- <link rel="shortcut icon" href="favicon.ico"> -->

	
	
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/animate.css">
	<link rel="stylesheet" href="css/style.css">

	<script src="js/modernizr-2.6.2.min.js" ></script>

	</head>
	<body>

		<div class="container">
		
			<div class="row">
				<div class="col-md-4 col-md-offset-4">
					

					<!-- Start Sign In Form -->
					<form action="login" method="post" class="fh5co-form animate-box" data-animate-effect="fadeIn">
						<!-- <h2>登录</h2> -->
						<p><font color="red">${changeMsg}</font></p>
						<p><font color="red">${signUpTips}</font></p>
						<div class="form-group">
							<label for="loginName" class="sr-only">用户名/邮箱/电话号</label>
							<input type="text" class="form-control" name="loginName"  id="loginName" placeholder="用户名/邮箱/电话号" autocomplete="off">
						</div>
						<div class="form-group">
							<label for="password" class="sr-only">密码</label>
							<input type="password" class="form-control" name="password" id="password" placeholder="密码" autocomplete="off">
						</div>
						<div class="form-group">
							<label for="remember"><input type="checkbox" id="remember"> 记住我</label>
							<p> <font color="red">${requestScope.message }</font></p>
						</div>
										
						<div class="form-group">
							<p>未注册? <a href="sign-up">注册</a> | <a href="forgot">忘记密码?</a></p>
						</div>
						<div class="form-group">
							<input type="submit" value="&nbsp登录 &nbsp" class="btn btn-primary">
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
	<script src="js/jquery.min.js" charset="utf-8" ></script>
	<!-- Bootstrap -->
	<script src="js/bootstrap.min.js" charset="utf-8" ></script>
	<!-- Placeholder -->
	<script src="js/jquery.placeholder.min.js" charset="utf-8" ></script>
	<!-- Waypoints -->
	<script src="js/jquery.waypoints.min.js" charset="utf-8" ></script>
	<!-- Main JS -->
	<script src="js/main.js" charset="utf-8" ></script>
	


   
	</body>
</html>

