
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
     <div class="fh5co-form animate-box TSBox"> 
      <div class="panel panel-default"> 
       <div class="panel-heading">
         查询条件 
       </div>
       <div class="panel-body"> 

        <!-- <form id="formSearch" class="form-horizontal">  --> 
        <div class="form-group" style="margin-top:15px"> 
         <div class="col-md-6 form-groups"> 
          <label for="txt_search_travelPerson">出行人</label> 
          <input type="text" class="form-control" id="txt_search_travelPerson" /> 
         </div> 
         <div class="col-md-6 form-group"> 
          <label for="txt_search_place">地点</label> 
          <input type="text" class="form-control" id="txt_search_place" /> 
         </div> 
        <div class="form-group pull-right" style="position: relative; right: 1.5%"> 
          <button type="button" id="btn_query" class="btn btn-success" onclick="search()">查询</button> 
         </div> 
        </div> 
        <!-- </form> --> 
       </div> 
      </div> 
      <div class="row"> 
       <div class="col-md-12"> 
        <h2>已审核列表</h2> 
      <form id="deleteForm" action="deleteRecordIds"  method="post"    class="pull-right" style="position: relative; right: 2.5%">
       <!--   <button type="button" id="multi_delete" onclick="deleteTest()" class="btn btn-danger" style="height: 32px;">
          删除
        </button> -->
        <input name="deleteIds" id="deleteIds" style="display: none" />
      </form>
        
        <table id="auditHistory" class="table table-striped TSTable table-hover "> 
         <thead> 
          <tr> 
           <th>#</th> 
           <th>出行人</th> 
           <th>时间</th> 
           <th>地点</th> 
           <th>职位</th> 
           <th>报销金额</th> 
           <th>操作</th> 
           
          </tr> 
         </thead> 
         <tbody> 
		 <c:forEach  items="${travelRecords}" var="p"> 
          <tr>
           <td> <input type="checkbox" name="nCheckBoxId" id="nCheckBoxId" value="${p.id}" /></td> 
            <td>${p.employee.name}</td> 
           <td>${p.travelBeginDate}</td> 
           <td>${p.endPlace}</td> 
           <td>${p.employee.roleInfo.role}</td> 
           <td>${p.allFunding}</td> 
           <td> <a  class="tablelink" onclick="payModal('#ViewReimbursement','${p.employee.name}','${p.endPlace}',
                  '${p.travelBeginDate}','${p.daysCount}','${p.applyingFunding}','${p.advanceFunding}','${p.allFunding}','${p.attachment.fileName}','${p.attachment.fileType}','${p.costDescription}','${p.id}')"> 查看</a>  <!-- <a  class="tablelink" >删除</a> --> </td> 
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
         <input type="text" class="form-control" value="${xx.xx}" name="Name" required readonly />  
        </div> 
        <div class="col-md-6 form-group"> 
         <label>出行地点</label> 
         <input type="text" class="form-control" value="${xx.xx}" name="place" required readonly />  
        </div> 
        <div class="col-md-6 form-group"> 
         <label>出行时间</label> 
         <div class="input-append date form_datetime"> 
          <input id="trvealTime" type="text" value="${xx.xx}" class="form-control" name="trvealTime" required readonly/> 
          <span class="add-on"><i class="icon-th"></i></span> 
         </div> 
        </div> 
        <div class="col-md-6 form-group"> 
         <label>出差时长(天)</label> 
         <input id="totalTime" type="text" class="form-control" name="totalTime" required readonly  value="${xx.xx}" /> 
        </div> 
        <div class="col-md-12 form-group"> 
         <label>说明</label> 
         <textarea class="form-control" style="height:auto; border: 1px solid rgba(0, 0, 0, 0.1);" rows="5" name="description" required readonly placeholder="${xx.xx}" ></textarea> 
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

<!-- 模态框（Modal） -->
<div class="modal fade" id="delete" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h4 class="modal-title" id="myModalLabel">
					删除
				</h4>
			</div>
			<div class="modal-body">
				你将删除这条（些）记录的审批。
			</div>
			<form id = "deleteOneForm" class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭
        </button>
        <button type="button"  class="btn btn-primary" onclick="deleteIt()" style="height:32px ">
          确认
        </button>
        <input id="deleteOneId" style="display: none"/>
      </form>
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
	</div>
<div class="modal fade" id="ViewReimbursement" aria-hidden="true" style="display: none; " data-backdrop= tabindex="-1"> 
   <div class="modal-dialog"> 
    <div class="modal-content"> 
     <div class="modal-header"> 
      <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times; </button> 
      <h4 class="modal-title" id="myModalLabel">历史审批</h4> 
     </div> 
     <div class="modal-body"> 
      <form> 
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
         <input id="havePayment" type="text" class="form-control" name="havePayment" required readonly  /> 
        </div> 
        <div class="col-md-12 form-group"> 
         <label>报销金额</label> 
         <input id="payment" type="text" class="form-control" name="payment" required readonly  /> 
        </div> 
        <div class="col-md-12 form-group"> 
         <label>报销凭证</label> 
         <br>
        <a id="flie_address" href="">$ddd.pdf</a>
        </div> 
        <div class="col-md-12 form-group"> 
         <label>费用说明</label> 
         <textarea class="form-control" id="costDescription" style="height:auto; border: 1px solid rgba(0, 0, 0, 0.1);" rows="5" name="costDescription" required readonly ></textarea> 
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
   // var n=0;
   // function checkClick(){
   // 	if (n!=0) {}
   // }
   function deleteTest(){
      var data = "";
      $(":checkbox").each(function(){
        if($(this).is(':checked') == true){
          data+= "," + $(this).val();
        }
      });
      $("#deleteIds").val(data);
      $("#deleteForm").submit();

   }


  $("a[name='Reimbursement']").click(function(){
    id = $(this).parents("tr").find(":checkbox").val();  // 获取checkbox所在行的顺序
    $("#deleteIds").val(id);
    motai('#delete');
    
  });
  
  function deleteIt(){
    $("#deleteForm").submit();
  }
    
    function motai(obj){
        $(obj).modal({backdrop: 'static',keyboard:true});
    }

    function payModal(travel_modal,traverl_name,traverl_place,traverl_trvealtime,traverl_days,estimate_Pay,have_Pay,payment,flie_address,file_type,costDescription, id){
        
       $("#travel_Name").val(traverl_name);
           //职工号
         $("#travel_Place").val(traverl_place);
         $("#travel_trvealTime").val(traverl_trvealtime);
           //职工号
         $("#travel_totalTime").val(traverl_days);
          $("#estimatedDisbursement").val(estimate_Pay);
           $("#havePayment").val(have_Pay);
           $("#payment").val(payment);
           
           $("#flie_address").attr("href","downLoadFile?fileName="+flie_address+"."+file_type); 
           //$("#flie_address").html(""+file_address);
           document.getElementById("flie_address").innerHTML=flie_address;
           
           
           $("#flie_address").val(flie_address);
           $("#costDescription").val(costDescription);
          
      
         //$("#travel_description").val(detail);

        $(travel_modal).modal({backdrop: 'static',keyboard:true});
    }
    
    function search(){
    	var oTab=document.getElementById('auditHistory');
		var oTxtName=document.getElementById('txt_search_travelPerson');
		
		var oTxtPlace=document.getElementById('txt_search_place');
		
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