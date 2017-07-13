//设置城市下拉菜单选项
var setCitySelectOptions = function(obj){
	obj.append("<option value='"+"北京"+"'>"+"北京"+"</option>");
	obj.append("<option value='"+"武汉"+"'>"+"武汉"+"</option>");
	obj.append("<option value='"+"成都"+"'>"+"成都"+"</option>");
	obj.append("<option value='"+"南昌"+"'>"+"南昌"+"</option>");
	obj.append("<option value='"+"上海"+"'>"+"上海"+"</option>");
	obj.append("<option value='"+"莆田"+"'>"+"莆田"+"</option>");
	obj.append("<option value='"+"西安"+"'>"+"西安"+"</option>");
	obj.append("<option value='"+"南京"+"'>"+"南京"+"</option>");
	obj.append("<option value='"+"深圳"+"'>"+"深圳"+"</option>");
	obj.append("<option value='"+"哈尔滨"+"'>"+"哈尔滨"+"</option>");
	obj.append("<option value='"+"运城"+"'>"+"运城"+"</option>");
	obj.append("<option value='"+"重庆"+"'>"+"重庆"+"</option>");
	obj.append("<option value='"+"成都"+"'>"+"成都"+"</option>");
	obj.append("<option value='"+"广州"+"'>"+"广州"+"</option>");
	obj.append("<option value='"+"烟台"+"'>"+"烟台"+"</option>");
	obj.append("<option value='"+"兰州"+"'>"+"兰州"+"</option>");
	obj.append("<option value='"+"厦门"+"'>"+"厦门"+"</option>");
	obj.append("<option value='"+"昆明"+"'>"+"昆明"+"</option>");
	obj.append("<option value='"+"长沙"+"'>"+"长沙"+"</option>");
	obj.append("<option value='"+"福州"+"'>"+"福州"+"</option>");
	obj.append("<option value='"+"天津"+"'>"+"天津"+"</option>");
	obj.append("<option value='"+"郑州"+"'>"+"郑州"+"</option>");
	obj.append("<option value='"+"长春"+"'>"+"长春"+"</option>");
	obj.append("<option value='"+"石家庄"+"'>"+"石家庄"+"</option>");
	obj.append("<option value='"+"徐州"+"'>"+"徐州"+"</option>");
	obj.append("<option value='"+"贵阳"+"'>"+"贵阳"+"</option>");
	obj.append("<option value='"+"阜阳"+"'>"+"阜阳"+"</option>");
	obj.append("<option value='"+"合肥"+"'>"+"合肥"+"</option>");
	obj.append("<option value='"+"济南"+"'>"+"济南"+"</option>");
	obj.append("<option value='"+"枣庄"+"'>"+"枣庄"+"</option>");
	obj.append("<option value='"+"杭州"+"'>"+"杭州"+"</option>");
	obj.append("<option value='"+"安阳"+"'>"+"安阳"+"</option>");
	obj.append("<option value='"+"怀化"+"'>"+"怀化"+"</option>");
	obj.append("<option value='"+"宜春"+"'>"+"宜春"+"</option>");
	obj.append("<option value='"+"宜昌"+"'>"+"宜昌"+"</option>");
	obj.append("<option value='"+"嘉兴"+"'>"+"嘉兴"+"</option>");
	obj.append("<option value='"+"宁波"+"'>"+"宁波"+"</option>");
	obj.append("<option value='"+"无锡"+"'>"+"无锡"+"</option>");
	obj.append("<option value='"+"唐山"+"'>"+"唐山"+"</option>");
	obj.append("<option value='"+"温州"+"'>"+"温州"+"</option>");
	obj.append("<option value='"+"沈阳"+"'>"+"沈阳"+"</option>");
	obj.append("<option value='"+"太原"+"'>"+"太原"+"</option>");
	obj.append("<option value='"+"珠海"+"'>"+"珠海"+"</option>");
};

//初始化日历控件
var initTimeController = function(formate){
  
   $(".form_datetime").datetimepicker({
   	  minView: "month",
      format: formate,
      autoclose: true,
      todayBtn: true,
      language:'zh-CN',
      pickerPosition:"bottom-right"
    });
};

function checkInfo(){

	if($("#startTime").val() == "" || $("#totalTime").val() == ""){
		$("#businessTip").show();
	}
	else{
		$("#businessTip").hide();
		if(!verifyNum($("#totalTime").val())){
			$("#mainFrame").attr("src", "planConfirm.html");
		}
	}
}

function checkTotalTime() {
	if(verifyNum($("#totalTime").val())){
		$("#totalTimeTip").show();	
	}
	else{
		$("#totalTimeTipe").hide();
	}
}

