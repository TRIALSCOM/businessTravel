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
          <form class="fh5co-form animate-box TSBox"  action="searchHotelByCondition" method="post">
            
            
            <div class="row">
              <div class="col-md-12">
                <h1>酒店预定</h1>  
              </div>
            <p> <font color="red"> ${msg}</font> </p>
              <div class="col-md-3 form-group">
                 
                <label>城市</label>
                  <select  class="selectpicker show-tick form-control"  value="${addHtCity}"  id = "addHtCity"  required data-live-search="true" name="addHtCity">
                  </select>
              </div>
              <div class="col-md-3 form-group">
                <label>入住日期</label>
                <div class="input-append date form_datetime" data-date-format="yyyy-mm-dd">
                  <input id = "addHtStartTime" type="text" value="${addHtStartTime}"   class="form-control" name="addHtStartTime" required />
                  <span class="add-on"><i class="icon-th"></i></span>
                </div>
              </div>
               <div class="col-md-3 form-group">
                <label>离店日期</label>
                <div class="input-append date form_datetime" data-date-format="yyyy-mm-dd">
                  <input id = "addHtEndTime" type="text" class="form-control" value="${addHtEndTime}"  name="addHtEndTime"  value="addHtEndTime" required />
                  <span class="add-on"><i class="icon-th"></i></span>
                </div>
              </div>  
               <div class="col-md-3 form-group">
                 <label>房间类型</label>
                 <select  class="selectpicker show-tick form-control" id = "roomType"  value="${roomType}" required data-live-search="true" name="roomType">
                 </select>
              </div>  
              <div class="form-group col-md-12" style="position: relative; right: 0.3%">
                <button type="submit" name="submit" class="btn btn-primary pull-right" style="font-weight:bold; height: 2.5vw" onclick="">查询</button>
              </div>

              <div class="col-md-12">
              
                <table id="hotelTable" class = "table table-striped TSTable table-hover "> 
                  <thead>
                    <tr>
                      <th>名称</th>
                      <th>星级</th>
                      <th>单价</th>
                      <th>总费用</th>
                      <th></th>
                    </tr>
                  </thead>
                  <tbody>
                    <c:forEach items="${sessionScope.hotelBuyViewObjects}" var="ht" varStatus="status">
                      <tr>
                        <td style="display: none;">${xx.xx}</td>
                        <td>${ht.hotelName}</td>
                        <td>${ht.grade}</td>
                        <td>${ht.perCost}</td>
                        <td>${ht.totalCost}</td>
                        <td>
                        <input type="text"  name="getValue"  value="${getValue}" id="getValue" style="display: none;">                           
                          <a href="bookingHotelSelected?index=${status.index}" type="button"  class="btn btn-info pull-right" style="font-weight:bold; height: 2vw">预定 </a>
                        </td>
                      </tr>
                    </c:forEach>
                  </tbody>
                </table>
                 <div class="form-group pull-right" style="position: relative; right: 0.5%">
                <a type="button" href="confirmSelect" class="btn btn-primary" style="font-weight:bold; height: 30px; line-height:20px">确认</a>
              </div>
              </div>
            </div>
          </form>
          <!-- END Sign In Form -->
        </div>
      </div>
    </div>
    
     <div class="modal fade" id="check-info" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
          &times;
        </button>
        <h4 class="modal-title" id="myModalLabel">
          提醒
        </h4>
      </div>
      <div class="modal-body">
        你已订酒店成功，将于<span id="time">3</span>秒后关闭此框。
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭
        </button> 
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal -->
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
      city  = $('#addHtCity');
      setCitySelectOptions(city);
      roomtype = $("#roomType");
      starLevel = $("#starLevel");
      setRoomType(roomtype);
      initTimeController("yyyy-mm-dd");
      $("#addHtCity").val($("#addHtCity").attr("value"));
      $("#roomType").val($("#roomType").attr("value"));

    });
    
    
    
    

    function motai(obj){
        delay();
        $(obj).modal({backdrop: 'static',keyboard:true});
    }
    function delay() { 
      var delay = document.getElementById('time').innerHTML;
      var oDiv=document.getElementById('check-info');
      var t = setTimeout("delay()", 1000);
          if (delay > 0) {
              delay--;
              document.getElementById('time').innerHTML = delay;
          } else {
          $("#check-info").modal('hide');
       
          }        
    } 
    
    window.onload = function(){

        if (document.getElementById('getValue').value==1) {
          motai('#check-info');

        }   
      
      }
   
  </script>
</html>