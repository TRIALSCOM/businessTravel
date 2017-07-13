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
          <div class="fh5co-form animate-box TSBox">
            
            
            <div class="row">
              <div class="col-md-12">
                <h1>用户管理</h1>
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
                    <c:forEach items="${employeeList}" var="per">
                      <tr>
                      <%--   <td style="display: none;">${per.xx}</td> --%>
                        <td>${per.name}</td>
                        <td>${per.employeeNumber}</td>
                        <td>${per.dept.name}</td>
                        <td>${per.roleInfo.role}</td>
                      <%--   <c:if test="${per.activeStatus=='Y'}" >
                        <td><p>激活</p></td>
                        </c:if> --%>
                     <c:choose>
                        <c:when test="${per.activeStatus=='Y'}"> <td>激活 </td>   </c:when>
                       
                        <c:otherwise> <td>未激活</td>  </c:otherwise>
                     </c:choose>
                        <td>
                        
<%--                       '${per.name}',  '${per.employeeNumber}','${per.dept.name}','${per.roleInfo.role}','${per.activeStatus}'
 --%>                          <a onclick="motai('#userDetail',  '${per.name}',  '${per.employeeNumber}','${per.dept.name}','${per.roleInfo.role}','${per.activeStatus}')" type="button"  class="btn btn-info pull-right" style="font-weight:bold; height: 2vw; background-color: rgb(88,177,88); border: none;">
                            <span class="glyphicon glyphicon-pencil" style="color: #ffffff  ;"></span>
                          </a>
                        </td>
                      </tr>
                    </c:forEach>
                  </tbody>
                </table>
              </div>
            </div>
          </div>
          <!-- END Sign In Form -->
        </div>
      </div>
    </div>


  <div class="modal fade" id="userDetail" aria-hidden="true" style="display: none; " data-backdrop="”static”" tabindex="-1"> 
   <div class="modal-dialog"> 
    <div class="modal-content"> 
     <div class="modal-header"> 
      <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times; </button> 
      <h4 class="modal-title" id="myModalLabel">员工详情</h4> 
     </div> 
     <div class="modal-body"> 
      <form  action="modifyEmployeeInfo"  method="post"  > 
       <div class="row"> 
        <div class="col-md-3 form-group"> 
         <label>姓名</label> 
         <input id = "userDetailName" name="userDetailName" type="text" class="form-control"  required readonly />  
        </div> 
        <div class="col-md-3 form-group"> 
         <label>员工号</label> 
         <input id = "userDetailRoleCode" name="userDetailRoleCode"  type="text" class="form-control"  required readonly />  
        </div> 
        <div class="col-md-3 form-group"> 
         <label>部门</label> 
          <select class="selectpicker show-tick form-control"  name="userDetailDept"  id = "userDetailDept" required data-live-search="true"  data-live-search="true">
           <c:forEach items="${depts}" var="per">
                <option value="${per.id}">${per.name}</option>
             </c:forEach> 
          </select>
        </div> 
        <div class="col-md-3 form-group"> 
         <label>职位</label> 
          <select class="selectpicker show-tick form-control"  id = "userDetailRole" name="userDetailRole"  required data-live-search="true"  data-live-search="true">
                   
          </select>
        </div> 
        <div class="col-md-3 form-group"> 
         <labe>状态</label> 
          <select class="selectpicker show-tick form-control"  id = "userDetailStatus" name="userDetailStatus" required data-live-search="true"  data-live-search="true">
            <option value="Y">激活</option>
            <option value="N">未激活</option>
          </select>
        </div> 
       </div> 
        <div class="modal-footer"> 
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭 </button> 
        <button type="submit" class="btn btn-info">确定 </button> 
       <!--   data-dismiss="modal" -->
         </div> 
      </form> 
     </div> 
    
    </div>
    <!-- /.modal-content --> 
   </div>
   <!-- /.modal-dialog --> 
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
      userDetailRole = $("#userDetailRole");
      setRole(userDetailRole);
      //$("#userDetailRole").val("高级开发员");
    });
     function motai(modal,	 name,employeeNumber,deptName,role,activeStatus){
    
       // alert(per);
      //姓名
     //  if(per.name != null)
            $("#userDetailName").val(name);
        //职工号
     //  if(per.employeeNumber!=null)
          $("#userDetailRoleCode").val(employeeNumber);
         //部门
    //   if(per.dept!=null&&per.dept.name!=null)
           $("#userDetailDept").val(deptName);
        //职位
    //      if(per.roleInfo.role!=null)
          $("#userDetailRole").val(role);
              //状态
     //    if(per.activeStatus!=null)
          $("#userDetailStatus").val(activeStatus);  

        $(modal).modal({backdrop: 'static',keyboard:true}); 
    }
    function motaiTest(modal){
        $(modal).modal({backdrop: 'static',keyboard:true});
    }
  </script>
</html>