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

	<script src="js/modernizr-2.6.2.min.js"></script>

	</head>
	<body>

		<div class="container">
		
			<div class="row">
				<div class="col-md-4 col-md-offset-4">
					

					<!-- Start Sign In Form -->
					<form action="bindInfoAlready" method="post" class="fh5co-form animate-box" data-animate-effect="fadeIn">
						<h2>绑定信息</h2>
						<div class="form-group">
							<label for="CompanyId" class="sr-only">公司代号</label>
							<input type="text" class="form-control" id="CompanyId"  name="deptId" value="${sessionScope.employee.dept.id}" placeholder="部门代号" autocomplete="off">
						</div>
						<div class="form-group">
							<label for="WorkeId" class="sr-only">职工号</label>
							<input type="text" class="form-control" id="WorkeId" placeholder="职工号"  value="${sessionScope.employee.employeeNumber }"   name="workeId" autocomplete="off">
						</div>
						<div class="form-group">
							<label for="remember"><input type="checkbox" id="remember"> 记住我</label>
						</div>
						
						<div class="form-group">
							<input type="submit" value="&nbsp绑定 &nbsp" class="btn btn-primary">
						</div>
					</form>
					<!-- END Sign In Form -->

				</div>
			</div>
			<div class="row" style="padding-top: 60px; clear: both;">
				<div class="col-md-12 text-center"><p><small>&copy; All Rights Reserved. Designed by <a href="javascript:;">差旅管理平台</a></small></p></div>
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

  <script type="text/javascript">
	window.onload=checkWheather('#CompanyId','#WorkId');
	function checkWheather (obj1,obj2) {
		if($(obj1).val().isEmpty())
		$(obj1).prop("readonly",false);
		if($(obj2).val().isEmpty())
		$(obj2).prop("readonly",false);
		// body...
	}
	</script>


	</body>
</html>

