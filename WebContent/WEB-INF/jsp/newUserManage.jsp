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
   <!-- 日历-->
  <link rel="stylesheet"  media="all" type="text/css" href="css/bootstrap-datetimepicker.css">
   <style type="text/css">
    .jq22-header{margin-bottom: 15px;font-family: "Segoe UI", "Lucida Grande", Helvetica, Arial, "Microsoft YaHei", FreeSans, Arimo, "Droid Sans", "wenquanyi micro hei", "Hiragino Sans GB", "Hiragino Sans GB W3", "FontAwesome", sans-serif;}
    .jq22-icon{color: #fff;}
  </style>
  <!--[if IE] -->
</head>
<body>
  <div class="container TSContainerPosition">
      <div class="row">
      
        <div class="col-md-12 col-xs-12 col-lg-12  TSBoxPosition">
  
          <!-- Start Sign In Form -->
          <form class="fh5co-form animate-box TSBox">
            
            
            <div class="row">
              <div class="col-md-12">
                <h1>新用户管理</h1>
              </div>
              <div class="col-md-12">
              
                <table id="usetTable" class = "table table-striped TSTable table-hover "> 
                  <thead>
                    <tr>
                      <th>姓名</th>
                      <th>员工号</th>
                      <th>部门</th>
                      <th>职位</th> 
                      <th>状态</th>
                      <th></th>
                    </tr>
                  </thead>
                  <tbody>
                    <c:forEach items="${employeesActiveN }" var="per">
                      <tr>
                        <td style="display:none">${per.id}</td>
                        <td>${per.name}</td>
                        <td>${per.employeeNumber}</td>
                        <td>${per.dept.name}</td>
                        <td>${per.roleInfo.role}</td>
                        <c:choose>
                        <c:when test="${per.activeStatus=='Y'}"> <td>激活 </td>   </c:when>
                       
                        <c:otherwise> <td>未激活</td>  </c:otherwise>
                     </c:choose>
                        <td>
                          <a href="doNewUserManage?id=${per.id}" type="submit"  class="btn btn-info pull-right" style="font-weight:bold; height: 2.3vw">激活</a>
                        </td>
                      </tr>
                    </c:forEach>
                  </tbody>
                </table>
              </div>
            </div>
          </form>
          <!-- END Sign In Form -->
        </div>
      </div>
    </div>

   </div>
</body>

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
   <!-- business JS -->
  <script src="js/business.js"></script>
  <!-- 日历-->
  <script src="js/bootstrap-datetimepicker.js"></script>
  <script src="js/bootstrap-datetimepicker.zh-CN.js"></script>
  <script src="js/verify.js"></script>
  <script src="js/sorie.js"></script>
  <script type="text/javascript">

    $(function(){
    });
   
  </script>
</html>