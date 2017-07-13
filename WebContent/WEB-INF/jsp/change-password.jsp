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
					<form action="changePassword" method="post" class="fh5co-form animate-box" data-animate-effect="fadeIn">
						<h2>修改密码</h2>
	
						<div id="container">
						<div class="form-group-password">
						<div class="form-group">
							<label for="password" class="sr-only">请输入原密码密码</label>
							<input type="password" class="form-control" id="input_psw" placeholder="请输入原密码密码" autocomplete="off" onblur="confim_psw('${sessionScope.employee.password}')">
							<p id="error_psw" style="display: none;"><font color="red">原密码错误，请重新输入</font></p>
						</div>
						<div class="form-group">
							<label for="password" class="sr-only">密码</label>
							<input type="password" class="form-control" id="password" name="password" placeholder="请输入新密码" autocomplete="off" readonly>
						</div>
						<div class="form-group">
							<label for="re-check-password" class="sr-only">确认密码</label>
							<input type="password" class="form-control" id="re-check-password" placeholder="请确认密码" autocomplete="off" readonly>
						</div>
						</div>
						</div>
						<div class="form-group">
						  
							<input type="submit" value="确认" id="btn-psw-send"  class="btn btn-primary" readonly>
							<a type="button"  class="btn btn-warning"  href="frameWork" style=" height: 50px;
							text-align:center;
  padding-top: 14px;
  padding-right: 20px;
  padding-left: 20px;
  border: none;background: #FFBB00;" >取消</a>
						</div>
					</form>
					<!-- END Sign In Form -->


				</div>
			</div>
			<div class="row" style="padding-top: 60px; clear: both;">
				
			</div>
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
	<script type="text/javascript">
		function confim_psw(psw) {
			var input_psw=document.getElementById('input_psw');
           //  alert(psw);
           //  alert(input_psw.value);
			if (input_psw.value==psw) {
				document.getElementById('error_psw').style.display="none";
				document.getElementById('password').readOnly=false;
				document.getElementById('re-check-password').readOnly=false;
				document.getElementById('btn-psw-send').readOnly=false;
			}else{
				document.getElementById('error_psw').style.display="block";
			}
			// body...
		}
	</script>
</html>

