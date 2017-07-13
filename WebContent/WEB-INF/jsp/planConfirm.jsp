  <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
     <%@ page import="java.util.*" %>
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
          <form class="fh5co-form animate-box TSBox" action="confirmTravelRecord" method="post">
            
            
            <div class="row">
              <div class="col-md-12">
                <h1>出差方案确认</h1>
              </div>
              <div class="col-md-12">
                <h2>基本信息</h2>
              </div>
              
              <div class="col-md-4 form-group">
                <label>姓名</label>
                <input  type="text" class="form-control"  id = "confirmName" value="${sessionScope.employee.name}"  readonly name="confirmName" />
             <!--  </input> -->
              </div>
              <div class="col-md-4 form-group">
                <label>职位</label>
                <input  type="text" class="form-control"  id = "confirmRole"  value="${sessionScope.employee.roleInfo.role }" readonly name="confirmRole" />
               <!--  </input> -->
              </div>  
              <div class="col-md-4 form-group">
                <label>始发地</label>
                <input  type="text" class="form-control"  id = "confirmBeginPlace"  value="${sessionScope.travelRecord.beginPlace}" readonly name="confirmBeginPlace" />
              
              </div>  
              <div class="col-md-4 form-group">
                <label>目的地</label>  
                <input  type="text" class="form-control"  id = "confirmEndPlace"  value="${sessionScope.travelRecord.endPlace }" readonly name="confirmEndPlace" />
              
              
              </div>
              <div class="col-md-4 form-group">
                <label>出发日期</label>
<%--                 <input id = "startTime" type="text" class="form-control" value="${sessionScope.travelRecord.travelBeginDate }" required />
 --%>         
                  <div class="input-append date form_datetime" data-date-format="yyyy-mm-dd">
                  
             
                   
                  <input type="text" name="travelBeginDate" id="startTime" size="20" value="<fmt:formatDate value='${sessionScope.travelRecord.travelBeginDate }' pattern='yyyy-MM-dd'/>"  class="form-control"   required  />
                  </div> 
         </div>
              
              
              <div class="col-md-4 form-group">
                <label>出差时长(天)</label>
                <input id = "totalTime" type="text" class="form-control" value="${sessionScope.travelRecord.daysCount}" readonly onblur="checkTotalTime()"/>
  
              </div>
              <div class="col-md-12 form-group">
                <label>说明</label>
                <textarea class="form-control"     style="height:auto; border: 1px solid rgba(0, 0, 0, 0.1);" rows="5"  readonly name="description" >${sessionScope.travelRecord.travelReason} </textarea>
              </div>
              <div class="col-md-12">
                <div class="row">
                  <h2 class = "col-md-6">车票</h2>
                  <div class="form-group col-md-6" style="position: relative; right: 0.3%">
                    <a type="button"  href="addTicket"  class="btn btn-primary pull-right" style="font-weight:bold; height: 2.5vw" onclick="">添加车票</a>
                  </div>
                 </div>
                <table id="ticketTable" class = "table table-striped TSTable table-hover "> 
                  <thead>
                    <tr>
                      <th>车次</th>
                      <th>发站</th>
                      <th>到站</th>
                      <th>发时</th>
                      <th>到时</th>
                      <th>类型</th>
                      <th>票价</th>

                    </tr>
                  </thead>
                  <tbody>
                    <c:forEach items="${sessionScope.ticketBookings }" var="ticketBooking">
                      <tr>
                        <td>${ticketBooking.beginStation.trainTimes.trainName}</td>
                        <td>${ticketBooking.beginStation.stationName}</td>
                        <td>${ticketBooking.endStation.stationName}</td>
                        <td>${ticketBooking.beginStation.leaveTime}</td>
                        <td>${ticketBooking.endStation.arriveTime}</td>
                        <td>${ticketBooking.seatCategory}</td>
                        <td>${ticketBooking.totalCost}</td>
                      </tr>
                    </c:forEach>
                  </tbody>
                </table>
              </div>
              
              <div class="col-md-12">
                 <div class="row">
                  <h2 class = "col-md-6">酒店</h2>
                  <div class="form-group col-md-6" style="position: relative; right: 0.3%">
                    <a type="button" href="addHotel" class="btn btn-primary pull-right" style="font-weight:bold; height: 2.5vw" onclick="">添加酒店</a>
                  </div>
                 </div>
                <table id="hotelTable" class = "table table-striped TSTable table-hover "> 
                  <thead>
                    <tr>
                      <th>名称</th>
                      <th>星级</th>
                      <th>房间类型</th>
                      <th>城市</th>
                      <th>入住日期</th>
                      <th>离店日期</th>
                      <th>单价</th>
                      <th>总费用</th>
                    </tr>
                  </thead>
                  <tbody>
                    <c:forEach items="${sessionScope.hotelBookings}" var="hotelBooking">
                      <tr>
                        <td>${hotelBooking.hotel.name}</td>
                        <td>${hotelBooking.hotel.grade}</td>
                        <td>${hotelBooking.bedCategory}</td>
                        <td>${hotelBooking.hotel.cityName}</td>                   
                        <td>${hotelBooking.startDate}</td>
                        <td>${hotelBooking.endDate}</td>
                        <td>${hotelBooking.perCost}</td>
                        <td>${hotelBooking.totalCost}</td>
                      </tr>
                    </c:forEach>
                  </tbody>
                </table>
              </div>
              <div class="col-md-12">
                <h2>费用</h2>
                <div class="col-md-6 form-group">
                  <label>总费用(元)</label>
                  <input id = "totalPay" type="text" class="form-control"  value="${sessionScope.travelRecord.applyingFunding}"  name="totalPay" readonly/>
                </div>
                <div class="col-md-6 form-group">
                  <label>预申请费用(元)</label>
                  <input id = "prePay" type="text" class="form-control" name="prePay" />
                </div>
              </div>
              <div class="form-group pull-right" style="position: relative; right: 1.5%">
                <button type="submit" name="submit" class="btn btn-primary" style="font-weight:bold;" >确认并支付</button>
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
   <!-- business JS -->
  <script src="js/business.js"></script>
  <!-- 日历-->
  <script src="js/bootstrap-datetimepicker.js"></script>
  <script src="js/bootstrap-datetimepicker.zh-CN.js"></script>
  <script src="js/verify.js"></script>
  <script type="text/javascript">

    $(function(){
      beginPlace  = $('#beginPlace');
      endPlace = $('#endPlace');
      setCitySelectOptions(beginPlace);
      setCitySelectOptions(endPlace);
   
    });
   
  </script>
</html>