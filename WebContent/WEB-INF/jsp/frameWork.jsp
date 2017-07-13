	<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html >
  <!--[if gt IE 8]><!--> <html class="no-js" lang="zh-CN"> <!--<![endif]-->
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title></title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  

  <!-- <link rel="shortcut icon" href="favicon.ico"> -->

  
  
  <link rel="stylesheet" href="css/bootstrap.min.css">
  <link rel="stylesheet" href="css/animate.css">
  <link rel="stylesheet" href="css/style.css">
  <link rel="stylesheet" href="css/sorie.css">
  <!--[if IE] -->
</head>

<body>
    <div class="container" style="padding: 0px">
      <div class="row">
        <!-- Header start-->
　　    <div class="TSHeader">

         <div  class="pull-left" style="margin-left: 10px;margin-top:-5px; text-decoration:none" >
            <a id="logo" href="home.html" style="text-decoration:none" ><img src="images/logo1.png" style="height: 70%;width: 70%;" ></a>
          </div>

         <!--  <div class = "col-md-9 col-xs-6 col-lg-19 TSHeaderTitle">TS</div> -->
          <div class ="col-md-3 col-xs-6 col-lg-3 pull-right">
             <a id = "headerRightButton2"  href="logOut"   type="button" class="TSPrimaryButton">注销</a>
            <a id = "headerRightButton1" href="goToChangeInfo"          type="button" class="TSPrimaryButton">个人信息</a>  
            <a id = "headerRightButton2"  href="change-password"   type="button" class="TSPrimaryButton">修改密码</a>
          
          </div>
        </div>
        <!-- Header end-->  
      </div>

      <div class="row TSBodyContainer">
        <!-- Menu start-->  
        <div class="col-xs-2 col-md-2 col-lg-2 TSNavigationContainer">
          <div id="treeview1" class="col-xs-12 col-md-12 col-lg-12"></div>
        </div>
        <!-- Menu end--> 
        <!-- iframe start--> 
        <iframe id ="mainFrame" src="business.html" class="col-sm-10 col-xs-10 col-md-10 col-lg-10 TSIframe"></iframe>
        <!-- iframe end--> 
      </div>
  </div> 

<!-- <div style="padding-top: 60px; clear: both;">
        <div class="col-md-12 text-center" style="bottom: 3%;position:absolute;" ><p><small>&copy; All Rights Reserved. Designed by <a href="javascript:;">差旅管理平台</a></small></p></div>
      </div> -->


 <input  type="text" class="form-control"  id = "frameWorkRole"  style="display:none"
          value="${sessionScope.employee.roleInfo.role}"  readonly />
     

  <script src="js/jquery-3.1.1.min.js"></script>
  <script src="js/bootstrap-treeview.js"></script>
  <script src="js/menu.js"></script>
  <script src="js/modernizr-2.6.2.min.js"></script>
  <script type="text/javascript">
    $(function(){
      menuFunc($("#frameWorkRole").val());
    });
  </script>
  
  
  
</body>
</html>