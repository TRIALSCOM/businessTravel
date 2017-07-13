	<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.text.*" %>
    <%@ page import="com.businessTravel.domain.Employee" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> 
<html class="no-js"> <!--<![endif]-->
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
			<div class="col-md-7 col-md-offset-2">
			
					<!-- Start Sign In Form -->
			<form class="fh5co-form animate-box" action="changeInfoComplete"  method="post" enctype="multipart/form-data">
			<div class="col-md-7 col-md-offset-5">
			<input type="file" id="upload_file" name="file" style="display: none;" accept="image/jpeg, image/gif" />
			<div class="form-group" style="float: left;border-radius:100%; height: 80px; overflow:hidden;" >
			
			<c:choose>
			   <c:when test="${not empty fileName }">
			         <img class="mui-icon-image" id="changeImg" src="resources/${fileName}" style="height: 80px; width:80 px;cursor:pointer;" onclick="changeimg()" />			   
               </c:when>
			    <c:otherwise>
			         <img class="mui-icon-image" id="changeImg" src="images/2.jpg" style="height: 80px; width:80 px;cursor:pointer;" onclick="changeimg()" />			   			        
                </c:otherwise> 
			</c:choose>
			</div>
			</div>
            <div class="form-group">
                   <input type="button" id="fileUp"  style="display: none;" value="上传" />
                <label>姓名</label>
                <input type="text" class="form-control" name="name" value="${sessionScope.employee.name}" placeholder="这里需要原姓名"disabled="ture" />
            </div>
             <div class="col-md-6 form-group">
                <label>电话</label>
                <input type="text" class="form-control" name="phone"  value="${sessionScope.employee.phone}"  placeholder="这里需要原电话" />
            </div>
            <div class="col-md-6 form-group">
                <label>邮箱</label>
                <input type="text" class="form-control" name="email"  value="${sessionScope.employee.email}" placeholder="这里需要原邮箱" />
            </div>
            <div class="col-md-6 form-group">
                <label>真实姓名</label>
                <input type="text" class="form-control" name="realName"  value="${sessionScope.employee.realName}" placeholder="这里需要原年龄" />
            </div>
            
            <%
                    String dateString="";
                    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
                	Employee employee=(Employee)request.getSession().getAttribute("employee");
                	Date  date=employee.getBirthday();
             //  date=sdf.format( (Employee)request.getSession().getAttribute("employee"));
             //${sessionScope.employee.birthday}
                if(date!=null)
                   dateString=sdf.format(date);   
            %>
            
            <div class="col-md-6 form-group">
                <label>生日</label>
                <!-- <input type="date" class="form-control" name="birthday" value="" placeholder="这里需要原生日" /> -->               
                  <div class="input-append date form_datetime">
            <%--       value=<%=dateString %> --%>
                  <input id = "birthday" type="text" class="form-control" name="birthday"  
                 value="<fmt:formatDate value='${sessionScope.employee.birthday}' pattern='yyyy-MM-dd'/>"    required readonly/>
                  <span class="add-on"><i class="icon-th"></i></span>
                </div>
            </div>

             <div class="col-md-6 form-group">
                <label>地址</label>
                <input type="text" class="form-control" name="address" value="${sessionScope.employee.address}"   placeholder="这里需要原地址" />
            </div>
            <div class="col-md-6 form-group">
                <label>银行卡号</label>
                <input type="text" class="form-control" name="bankCard"  value="${sessionScope.employee.bankCard }" placeholder="这里需要原银行卡号" />
            </div>
            <div class="col-md-6 form-group">
                <label>QQ号</label>
                <input type="text" class="form-control" name="qqNum" value="${sessionScope.employee.qqNum}" placeholder="这里需要原QQ号" />
            </div>           
           
            <div class="col-md-6 form-group">
                <label>学位</label>
                <input type="text" class="form-control" name="education" value="${sessionScope.employee.education}" placeholder="学位" />
            </div>
            
            <div class="form-group col-md-offset-8" >
                <a type="button" href="closeChangeInfoToFrame" class="btn btn-default" style="width: 80px; height: 40px; font-weight:bold; ">关闭</a>
                <button type="submit" name="submit" class="btn btn-primary" style="width: 80px; height: 40px; font-weight:bold; ">修改</button>
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
	
	
	 <script src="js/business.js" charset="utf-8"></script>
  <!-- 日历-->
  <script src="js/bootstrap-datetimepicker.js"></script>
  <script src="js/bootstrap-datetimepicker.zh-CN.js"></script>

    <script type="text/javascript" src="js/ajaxfileupload.js"></script>
<script type="text/javascript">
    $(function() {
    	 initTimeController("yyyy-mm-dd");
         $("#fileUp").click(function() {
            if ($("#upload_file").val().length > 0) {
                ajaxFileUpload();
            } else {
                alert("请选择图片");
            }
        }); 
    });
    
    
    function changeimg(){
    	  $("#upload_file").click();
    	  setInterval(check(),10);
    	};

    	function check(){
    		
    		  $("#upload_file").change(function(){
    			  if($(this).val()){
    			  /*   $("#fileUp").click(function() {
		          //  if ($("#upload_file").val().length > 0) {
		                ajaxFileUpload();
		          //  } else {
		          //      alert("请选择图片");
		           // }
		        });  */
    				  $("#fileUp").click();
		        
    			  } })
    		
    	}  
    
    
    function ajaxFileUpload() {
        $.ajaxFileUpload({
            url : 'tempimg', //用于文件上传的服务器端请求地址
            secureuri : false, //一般设置为false
            fileElementId : 'upload_file', //文件上传空间的id属性  <input type="file" id="file" name="file" />
            type : 'post',
            dataType : 'HTML', //返回值类型 一般设置为json
            success : function(data, status) //服务器成功响应处理函数
            {
                $("#changeImg").attr("src", data);
                if (typeof (data.error) != 'undefined') {
                    if (data.error != '') {
                        alert(data.error);
                    } else {
                        alert(data.msg);
                    }
                }
            },
            error : function(data, status, e)//服务器响应失败处理函数
            {
                alert(e);
            }
        })
        return false;
    }
</script>
	</body>
</html>

