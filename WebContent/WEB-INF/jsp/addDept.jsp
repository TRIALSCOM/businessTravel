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
          <form  action="addDeptMessage"  method="post" class="fh5co-form animate-box TSBox">
            
            
            <div class="row">
              <div class="col-md-12">
                <h1>部门管理</h1>
              </div>
              
              
              <div class="col-md-4 form-group">
                <label>部门名称</label>
                 <input id = "addDeptName" type="text" class="form-control" name="addDeptName" required/>
              </div>
              <div class="col-md-4 form-group">
                <label>部门代码</label>
                <input id = "addDeptCode" type="text" class="form-control" name="addDeptCode" required/>
              </div>  
              <div class="col-md-4 form-group">
                <label>公司代码</label>
                <input id = "addCompanyCode" type="text" class="form-control" name="addCompanyCode" required/>
              </div>
              <div class="col-md-12 form-group"> 
              <label>简介</label> 
             <textarea class="form-control" style="height:auto; border: 1px solid rgba(0, 0, 0, 0.1);" rows="5" name="description"  placeholder="请填写部门简介" ></textarea> 
              </div>  
              <div class="form-group col-md-12" style="position: relative; right: 0.3%">
                <button type="submit" name="submit" class="btn btn-primary pull-right" style="font-weight:bold; height: 2.5vw">新建</button>
              </div>

              <div class="col-md-12">
              
                <table id="ticketTable" class = "table table-striped TSTable table-hover "> 
                  <thead>
                    <tr>
                      <th>部门名称</th>
                      <th>部门代码</th>
                      <th>公司代码</th>
                      <th>操作</th>
                    </tr>
                  </thead>
                  <tbody>
                    <c:forEach items="${depts}" var="per">
                      <tr>
                        <td>${per.name}</td>
                        <td>${per.code}</td>
                        <td>${per.companyInfo.id}</td>
                        <td> <a class="tablelink" onclick="viewModal('#view_modal','${per.name}','${per.code}','${per.companyInfo.id}','${per.description}','${per.id}')"> 查看</a>  <a  class="tablelink" onclick="change_modal('#change_modal','${per.description}','${per.id}')" name="change_modal">修改</a> </td> 
                      </tr>
                    </c:forEach>
                  </tbody>
                </table>
                 <div class="form-group pull-right" style="position: relative; right: 0.5%">
              </div>
              </div>
            </div>
          </form>
          <!-- END Sign In Form -->
        </div>
      </div>
    </div>

<!--motai-->

<div class="modal fade" id="view_modal" aria-hidden="true" style="display: none; " data-backdrop= tabindex="-1"> 
   <div class="modal-dialog"> 
    <div class="modal-content"> 
     <div class="modal-header"> 
      <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times; </button> 
      <h4 class="modal-title" id="myModalLabel">查看部门详情</h4> 
     </div> 
     <div class="modal-body"> 
      <form> 
       <div class="row"> 
        <div class="col-md-6 form-group"> 
         <label>部门名称</label> 
         <input type="text" class="form-control"  id="dept_Name" name="dept_Name" required readonly />  
        </div> 
        <div class="col-md-6 form-group"> 
         <label>部门代码</label> 
         <input type="text" class="form-control"  id="dept_Code" name="dept_Code" required  readonly />  
        </div> 
         <div class="col-md-6 form-group"> 
         <label>公司代码</label> 
         <input type="text" class="form-control"  id="company_Code" name="company_Code" required  readonly />  
        </div> 
        <div class="col-md-12 form-group"> 
         <label>部门简介</label> 
         <textarea class="form-control" id="dept_Description" style="height:auto; border: 1px solid rgba(0, 0, 0, 0.1);" rows="5" name="dept_Description" required readonly ></textarea> 
        </div> 
       </div> 
       </form>
     </div> 
     <div class="modal-footer"> 
      <button type="button" class="btn btn-default" data-dismiss="modal">关闭 </button> 
     </div> 
    </div>
    <!-- /.modal-content --> 
   </div>
   <!-- /.modal-dialog --> 
</div> 




<div class="modal fade" id="change_modal" aria-hidden="true" style="display: none; " data-backdrop= tabindex="-1"> 
   <div class="modal-dialog"> 
    <div class="modal-content"> 
     <div class="modal-header"> 
      <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times; </button> 
      <h4 class="modal-title" id="myModalLabel">修改部门简介</h4> 
     </div> 
     <div class="modal-body"> 
      <form  action="modifyDept" method="post"> 
         <div class="row"> 
        <input type="text" id="deptId" name="deptId" style="display:none;">
        <div class="col-md-12 form-group"> 
         <label>部门简介</label> 
         <textarea class="form-control" id="dept_Description" style="height:auto; border: 1px solid rgba(0, 0, 0, 0.1);" rows="5" name="dept_Description" required  ></textarea> 
        </div> 
       </div> 
         <div class="modal-footer"> 
       <button type="submit" class="btn btn-info">修改</button>
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭 </button> 
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


    function viewModal(view_modal,dept_Name,dept_Code,company_Code,dept_Description,id){
        
       $("#dept_Name").val(dept_Name);
           //职工号
         $("#dept_Code").val(dept_Code);
         $("#company_Code").val(company_Code);
          $("#dept_Description").val(dept_Description);

          $("#deptId").val(id);
      
         //$("#travel_description").val(detail);

        $(view_modal).modal({backdrop: 'static',keyboard:true});
    }
    function change_modal(change_modal,dept_Description,id){
        
       
          $("#dept_Description").val(dept_Description);

          $("#deptId").val(id);
      
         //$("#travel_description").val(detail);

        $(change_modal).modal({backdrop: 'static',keyboard:true});
    }
    
   
  </script>
</html>