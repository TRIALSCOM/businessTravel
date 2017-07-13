<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
	<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>sign up</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<!-- <link rel="shortcut icon" href="favicon.ico"> -->

	
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
					

					
					<form action="signUp" method="post" class="fh5co-form animate-box" data-animate-effect="fadeIn">
						<h2>注 册</h2>
						<div class="form-group-signrequest">
							<div class="alert alert-success" role="alert">Your info has been saved.</div>
						</div>
						<div class="form-group">
							<label for="email" class="sr-only">邮箱</label>
							<input type="text" class="form-control" onblur="email_check()" name="email" id="email" placeholder="邮箱" autocomplete="off">
							<p class="email_tip"><font color="red">邮箱格式错误</font></p>
							<button type="button" data-gta="{segment:'active registration'}" class="btn btn-primary anim-blue-all submit" id="btn-primary" style="width: 300px;height: 40px;position: relative;bottom: -20px" onclick="display_hide('btn-primary')">
           				 即刻开始<span class="icon icon-circle-right2"></span>
         					 </button>
							<!-- <div class="enter" onclick="display('form-group-re-psw')"><img src="images/en.png"></div> -->

								<p><font color="red">${msg}</font></p>
						</div>

						<!-- <div class="form-group">
							<label for="email" class="sr-only">邮箱</label>
							<input type="email" class="form-control" id="email" placeholder="邮箱/手机" autocomplete="off">
						</div> -->
						<div class="form-group-re-password" id="form-group-re-psw">
						<div class="form-group">
							<label for="loginName" class="sr-only">用户名</label>
							<input type="text" onblur="checkpas1();" class="form-control" id="loginName" name="loginName" placeholder="用户名" autocomplete="off">
						
						</div>
		
						<div class="form-group">
							<label for="password" class="sr-only">密码</label>
							<input type="password" onblur="checkpas1();" class="form-control" id="password" name="password" placeholder="密码" autocomplete="off">
						</div>
						<div class="form-group">
							<label for="re-password" class="sr-only">Re-type Password</label>
							<input type="password" class="form-control" id="re-password" name="re-password"  onChange="checkpas();"  placeholder="确认密码" autocomplete="off">
							<p class="tip"><font color="red">两次输入的密码不一致</font></p>
						</div>
						</div>
						<div class="form-group">
							<label for="remember"><input type="checkbox" id="remember"> 记住我</label>
						</div>
						<div class="form-group">
							<p>已有帐号? <a href="index.html">登录</a></p>
						</div>
						<div class="form-group">
							<input type="submit" value="注册" class="btn btn-primary" id="btn-sign-up" onclick="display_show('form-group-re-password')">
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

