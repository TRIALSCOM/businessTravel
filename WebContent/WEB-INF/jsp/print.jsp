    <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <%@ page import="java.text.*,java.util.*" %>
    <%@ page import="com.businessTravel.domain.Employee" %>
      <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>

<!DOCTYPE html>
<!--[if gt IE 8]><!-->
<html class="no-js" lang="zh-CN">
 <!--<![endif]-->
 <head> 
  <meta charset="utf-8" /> 
  <meta http-equiv="X-UA-Compatible" content="IE=edge" /> 
  <title></title> 
  <meta name="viewport" content="width=device-width, initial-scale=1" /> 
  <!-- <link rel="shortcut icon" href="favicon.ico"> --> 
  <link rel="stylesheet" href="css/bootstrap.min.css" /> 
  <link rel="stylesheet" href="css/animate.css" /> 
  <link rel="stylesheet" href="css/style.css" /> 
  <link rel="stylesheet" href="css/sorie.css" /> 
  <!-- 日历--> 
  <link rel="stylesheet" media="all" type="text/css" href="css/bootstrap-datetimepicker.css" /> 
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
      <div class="panel panel-default"> 
       <div class="panel-heading">
         查询条件 
       </div> 
       <div class="panel-body"> 
        <!-- <form id="formSearch" class="form-horizontal">  --> 
        <div class="form-group" style="margin-top:15px"> 
         <div class="col-md-6 form-groups"> 
          <label for="txt_search_leavetime">时间</label> 
          <input type="text" class="form-control" id="txt_search_leavetime" /> 
         </div> 
         <div class="col-md-6 form-group"> 
          <label for="txt_search_place">地点</label> 
          <input type="text" class="form-control" id="txt_search_place" /> 
         </div> 
         <div class="form-group pull-right" style="position: relative; right: 1.5%"> 
          <button type="button" id="btn_query" class="btn btn-primary" onclick="search()">查询</button> 
         </div> 
        </div> 
        <!-- </form> --> 
       </div> 
      </div> 
      <div class="row"> 
       <div class="col-md-12"> 
        <h2>所有出差记录</h2> 
       
      <!--   <div class="pull-right">
         <button type="button" class="btn btn-primary" style="height:32px;">
                     打印全部
        </button>
        </div> -->
       
        
        <table id="dealHistory" class="table table-striped TSTable table-hover "> 
         <thead> 
          <tr> 
           <th>#</th> 
           <th>出行人</th> 
           <th>时间</th> 
           <th>地点</th> 
           <th>描述</th> 
           <th>状态</th> 
           <th>操作</th> 
           
          </tr> 
         </thead> 
         <tbody> 
		 <c:forEach  items="${travelRecords }" var="p"> 
          <tr> 
           <td> <input type="checkbox" name="nCheckBoxId" id="nCheckBoxId" value="${st.count-1}" /></td> 
           <td>${p.employee.name}</td> 
           
           <td>   <fmt:formatDate value="${p.travelBeginDate}" pattern='yyyy-MM-dd'/></td> 
        
              <%--    ${p.travelBeginDate} --%>
           <td>${p.endPlace}</td> 
           <td>${p.travelReason}</td> 
           <c:choose>
                <c:when test="${p.reviewBeginEnd==0}">
                <td>出差正在进行中</td> 
                </c:when>
                <c:when test="${p.reviewBeginEnd==1}">
                <td>出差记录正在审核</td>
                </c:when>
                <c:otherwise>
                   <td>出差已审核完成</td>
                </c:otherwise>
           </c:choose>
           
         <!--   name,place,trvealtime,days,detail -->
           
           <td> <%-- <a  class="tablelink"  type="button"   onclick="detailModal('#ViewHistoryDetails','${p.employee.name}','${p.endPlace}',
                  '${p.travelBeginDate}','${p.daysCount}','${p.travelReason}')"> 查看</a>  --%>
              <%-- <button type="button"  onclick="detailModal('#ViewHistoryDetails','${p.employee.name}','${p.endPlace}',
                  '${p.travelBeginDate}','${p.daysCount}','${p.travelReason}')"   class="btn btn-default">查看</button> --%>
                 <a class="tablelink" onclick="detailModal('#ViewHistoryDetails','${p.employee.name}','${p.endPlace}',
                  '${p.travelBeginDate}','${p.daysCount}','${p.travelReason}')"  >查看</a>
                
                 <a class="tablelink" href="printOneRecord?travelRecordId=${p.id}"  >打印</a>
                  
                 
                 
               <c:if test="${p.reviewBeginEnd==0}"><a id="Reimbursement" onclick="payModal('#ViewReimbursement','${p.employee.name}','${p.endPlace}',
                  '${p.travelBeginDate}','${p.daysCount}','${p.applyingFunding}','${p.advanceFunding}','${p.id}')"  class="tablelink">报销</a></c:if>    
                  
				<%-- <button type="button"  id="Reimbursement" onclick="payModal('#ViewReimbursement','${p.employee.name}','${p.endPlace}',
                  '${p.travelBeginDate}','${p.daysCount}','${p.applyingFunding}','${p.advanceFunding}','${p.id}')"  class="btn btn-warning">报销</button> --%>
           </td> 
          </tr> 
          </c:forEach>	  
         </tbody> 
        </table> 
       </div>  
       <!--   <div class="page">
            <div>
              <c:choose>
                <c:when test="${pageBean.pageNum ==1 }">
                  <a class="prev">上一页</a>
                </c:when>
                <c:otherwise>
                  <a href="/volt/admin/rentCheck?page=${pageBean.pageNum -1}"
                    class="prev">上一页</a>
                </c:otherwise>
              </c:choose>

              <c:forEach items="${pageBean.index}" var="index">
                <c:choose>
                  <c:when test="${pageBean.pageNum == index }">
                    <a style="background-color:orange;">${index}</a>
                  </c:when>
                  <c:otherwise>
                    <a href="/volt/admin/rentCheck?page=${index}" class="num">${index}</a>
                  </c:otherwise>
                </c:choose>
              </c:forEach>

              <c:choose>
                <c:when test="${pageBean.pageNum == pageBean.totalPage }">
                  <a class="next">下一页</a>
                </c:when>
                <c:otherwise>
                  <a href="/volt/admin/rentCheck?page=${pageBean.pageNum + 1}"
                    class="next">下一页</a>
                </c:otherwise>
              </c:choose>

              <span>共${pageBean.totalPage }页</span>
            </div>
          </div> --> 
      </div>
     </form> 
     <!-- END Sign In Form --> 
    </div> 
   </div> 
  </div> 
  <div class="modal fade" id="ViewHistoryDetails" aria-hidden="true" style="display: none; " data-backdrop="”static”" tabindex="-1"> 
   <div class="modal-dialog"> 
    <div class="modal-content"> 
     <div class="modal-header"> 
      <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times; </button> 
      <h4 class="modal-title" id="myModalLabel"> 行程详细 </h4> 
     </div> 
     <div class="modal-body"> 
      <form> 
       <div class="row"> 
        <div class="col-md-6 form-group"> 
         <label>出行人</label> 
         <input type="text" id="Name" class="form-control"  name="Name" required readonly />  
        </div> 
        <div class="col-md-6 form-group"> 
         <label>出行地点</label> 
         <input type="text" class="form-control" id="Place"  name="Place" required readonly />  
        </div> 
        <div class="col-md-6 form-group"> 
         <label>出行时间</label> 
         <div class="input-append date form_datetime"> 
          <input id="trvealTime" type="text"  class="form-control" name="trvealTime" required readonly/> 
          <span class="add-on"><i class="icon-th"></i></span> 
         </div> 
        </div> 
        <div class="col-md-6 form-group"> 
         <label>出差时长(天)</label> 
         <input id="totalTime" type="text" class="form-control" name="totalTime" required readonly   /> 
        </div> 
        <div class="col-md-12 form-group"> 
         <label>说明</label> 
         <textarea class="form-control" id="description" style="height:auto; border: 1px solid rgba(0, 0, 0, 0.1);" rows="5" name="description" required readonly  ></textarea> 
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
<div class="modal fade" id="ViewReimbursement" aria-hidden="true" style="display: none; " data-backdrop="”static”" tabindex="-1"> 
   <div class="modal-dialog"> 
    <div class="modal-content"> 
     <div class="modal-header"> 
      <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times; </button> 
      <h4 class="modal-title" id="myModalLabel"> 报销</h4> 
     </div> 
     <div class="modal-body"> 
     
     
      <form action="fillInAllFunding" method="post"  enctype="multipart/form-data" > 
       <div class="row"> 
        <div class="col-md-6 form-group"> 
         <label>出行人</label> 
         <input type="text" class="form-control"  id="travel_Name" name="travel_Name" required readonly />  
        </div> 
        <div class="col-md-6 form-group"> 
         <label>出行地点</label> 
         <input type="text" class="form-control"  id="travel_Place" name="travel_Place" required  readonly />  
        </div> 
        <div class="col-md-6 form-group"> 
         <label>出行时间</label> 
         <div class="input-append date form_datetime"> 
         
          <input id="travel_trvealTime" type="text"  class="form-control" name="travel_trvealTime" required readonly /> 
         
<%--         <input type="text" name="travel_trvealTime" id="travel_trvealTime" size="20" value="<fmt:formatDate value='' pattern='yyyy-MM-dd'/>"  class="form-control"   required readonly />
 --%>         
          <span class="add-on"><i class="icon-th"></i></span> 
         </div> 
        </div> 
        <div class="col-md-6 form-group"> 
         <label>出差时长(天)</label> 
         <input id="travel_totalTime" type="text" class="form-control" name="travel_totalTime" required readonly  /> 
        </div>
        <div class="col-md-6 form-group">  
         <label>预计报销金额</label> 
         <input id="estimatedDisbursement" type="text" class="form-control" name="estimatedDisbursement" required  readonly  /> 
        </div> 
        <div class="col-md-6 form-group"> 
        <label>已预支付金额</label> 
         <input id="havePayment" type="text" class="form-control" name="havePayment" required readonly /> 
        </div> 
        <div class="col-md-12 form-group"> 
         <label>报销金额</label> 
         <input id="payment" type="text" class="form-control" name="allFunding" required="required" placeholder="填写需要报销金额" /> 
        </div> 
         <div class="col-md-12 form-group"> 
         <label>报销凭证</label> 
         <input id="payment_flie" type="file" class="form-control" name="file" required="required" placeholder="上传车票、发票等" /> 
        
        <div class="col-md-12 form-group"> 
         <label>费用说明</label> 
         <textarea class="form-control" id="costDescription" style="height:auto; border: 1px solid rgba(0, 0, 0, 0.1);" rows="5" name="costDescription" required="required"  placeholder="填写报销费用说明" ></textarea> 
        </div> 
       </div> 
       
        <input type="text" id="travelRecordId" name="travelRecordId" style="display: none;">
        <div class="modal-footer"> 
      <button type="button" class="btn btn-default" data-dismiss="modal">关闭 </button> 
      <button type="submit" class="btn btn-primary" style="height: 32px;">
          提交更改
        </button>
     </div> 
     </div>
      </form> 
     </div> 
    
    </div>
    <!-- /.modal-content --> 
   </div>
   <!-- /.modal-dialog --> 
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
   <!-- business JS --> 
   <script src="js/business.js"></script> 
   <!-- 日历--> 
   <script src="js/bootstrap-datetimepicker.js"></script> 
   <script src="js/bootstrap-datetimepicker.zh-CN.js"></script> 
   <script src="js/verify.js"></script> 
   <script type="text/javascript">
  
    function detailModal(detail_modal,name,place,trvealtime,days,detail){

        
         $("#Name").val(name);
           //职工号
           
         $("#Place").val(place);
           
         $("#trvealTime").val(trvealtime);
         
         
         
           //职工号
         $("#totalTime").val(days);
         $("#description").val(detail);
           //职工号
        

         $(detail_modal).modal({backdrop: 'static',keyboard:true});
         // //姓名

    }
    function payModal(travel_modal,traverl_name,traverl_place,traverl_trvealtime,traverl_days,estimate_Pay,have_Pay,travelRecordId){
        
        $("#travel_Name").val(traverl_name);
           //职工号
         $("#travel_Place").val(traverl_place);
         $("#travel_trvealTime").val(traverl_trvealtime);
           //职工号
         $("#travel_totalTime").val(traverl_days);
          $("#estimatedDisbursement").val(estimate_Pay);
           $("#havePayment").val(have_Pay);
           $("#travelRecordId").val(travelRecordId);
        

         //$("#travel_description").val(detail);

        $(travel_modal).modal({backdrop: 'static',keyboard:true});
    }
    
    
    function search(){
        var oTab=document.getElementById('dealHistory');
      var oTxtName=document.getElementById('txt_search_leavetime');
      
      var oTxtPlace=document.getElementById('txt_search_place');
      
      //alert(oTxPlace);
      for (var i = oTab.tBodies[0].rows.length - 1; i >= 0; i--) {
          var sTab=oTab.tBodies[0].rows[i].innerHTML.toLowerCase().split("</td>");
          var sTxtName=oTxtName.value.toLowerCase();
          var show = true;
          var sArrName=sTxtName.split(' ');
          if (oTxtName.value!="") {
            for(var j=0;j<sArrName.length;j++)
            {
              if(sTab[1].search(sArrName[j])==-1)
              {
              // oTab.tBodies[0].rows[i].style.background='';
                show = false;
              }
              
            }
          }
          var sTxtPlace=oTxtPlace.value.toLowerCase();
          var sArrPlace=sTxtPlace.split(' ');
          if (oTxtPlace.value!="") {
            for(var j=0;j<sArrPlace.length;j++)
            {
              if(sTab[3].search(sArrPlace[j])==-1)
              {
                show=false;

              }
              
            }
          }
          if(show)
          {
            
            oTab.tBodies[0].rows[i].style.display='table-row';
          }
          else{
            oTab.tBodies[0].rows[i].style.display='none';
          }
          
      };
    }
  </script>
    </body>
</html>   
   <!-- <table data-toggle="table" data-url="data1.json"  data-height="246"> --> 
   <!--  <div class="panel-body" style="padding-bottom:0px;"> 
    <div col-md-12=""> 
     <div class="panel panel-default"> 
      <div class="panel-heading">
       查询条件
      </div> 
      <div class="panel-body"> 
       <form id="formSearch" class="form-horizontal"> 
        <div class="form-group" style="margin-top:15px"> 
         <label class="control-label col-sm-1" for="txt_search_leavetime">时间</label> 
         <div class="col-sm-3"> 
          <input type="text" class="form-control" id="txt_search_leavetime" /> 
         </div> 
         <label class="control-label col-sm-1" for="txt_search_place">地点</label> 
         <div class="col-sm-3"> 
          <input type="text" class="form-control" id="txt_search_leavetime" /> 
         </div> 
         <div class="col-sm-4" style="text-align:left;"> 
          <button type="button" style="margin-left:50px" id="btn_query" class="btn btn-primary">查询</button> 
         </div> 
        </div> 
       </form> 
      </div> 
     </div> 
    </div> 
    </div> 
    <div id="toolbar" class="btn-group"> 
     <button id="btn_add" type="button" class="btn btn-default"> <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>打印 </button> 
     <button id="btn_delete" type="button" class="btn btn-default"> <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除 </button> 
    </div>  --> 

 