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
          <form class="fh5co-form animate-box TSBox"  action="goBusinessPlan" method="post" >
            <div class="row">
              
            </div>
            <p>
              <font color="red">${msg}</font>
            </p>
            <div class="row">
              <div class="col-md-12">
                <h2>出差计划</h2>
              </div>
              <div class="col-md-6 form-group">

                <label>始发地</label>
                <select  class="selectpicker show-tick form-control" id = "beginPlace"  required data-live-search="true" name="beginPlace">
          
                </select>
              </div>  
              <div class="col-md-6 form-group">
                <label>目的地</label>  
                <select class="selectpicker show-tick form-control"  id = "endPlace" required data-live-search="true"  data-live-search="true" name="endPlace">
                </select>
              </div>
              <div class="col-md-6 form-group">
                <label>出发日期</label>
                <div class="input-append date form_datetime" data-date-format="yyyy-mm-dd">
                  <input id = "startTime" type="text" class="form-control" name="travelBeginDate" required readonly/>
                  <span class="add-on"><i class="icon-th"></i></span>
                </div>
              
              </div>
              <div class="col-md-6 form-group">
                <label>出差时长(天)</label>
                <input id = "totalTime" type="text" class="form-control" name="daysCount" required onblur="checkTotalTime()"/>
                <p id="totalTimeTip" style="display: none"><font color="red">只能为数字</font></p>
              </div>
              <div class="col-md-12 form-group">
                <label>说明</label>
                <textarea class="form-control" style="height:auto; border: 1px solid rgba(0, 0, 0, 0.1);" rows="5" name="travelReason" ></textarea>
                <p id="businessTip" style="display: none"><font color="red">请确保信息完整</font></p>
              </div>
              
              <div class="form-group pull-right" style="position: relative; right: 1.5%">
                <button type="submit" name="submit" class="btn btn-primary" style="font-weight:bold;" onclick="checkInfo()">出差</button>
              </div>
            </div>
          </form>
          <!-- END Sign In Form -->
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
 
  <!-- 日历-->
  <script src="js/bootstrap-datetimepicker.js"></script>
  <script src="js/bootstrap-datetimepicker.zh-CN.js"></script>
  <script src="js/verify.js"></script>
  
    <!-- business JS -->
  <script src="js/business.js"></script>
  
  <script type="text/javascript">

    $(function(){
      beginPlace  = $('#beginPlace');
      endPlace = $('#endPlace');
      setCitySelectOptions(beginPlace);
      setCitySelectOptions(endPlace);
      initTimeController("yyyy-mm-dd");
    });
   
  </script>
</html>

