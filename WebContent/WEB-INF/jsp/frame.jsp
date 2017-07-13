<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<meta charset="utf-8">
<head>
    <title>差旅管理平台</title>
</head>
<body>
<div style="width: 100%">

<!-- 左侧菜单栏 -->

<div id="main-Container">

<div id="sidebar" class="col-md-2 column">

<!-- 创建菜单树 -->

<div class="col-md-12">

                <ul id="main-nav" class="nav nav-tabs nav-stacked" style="">

                    <li>

                        <a href="#systemSetting" class="nav-header collapsed" data-toggle="collapse">

                            <i class="glyphicon glyphicon-cog"></i>出差管理

                               <span class="pull-right glyphicon glyphicon-chevron-down"></span>

                        </a>

                        <ul id="systemSetting" class="nav nav-list collapse secondmenu" style="height: 0px;">

                            <li><a href="#" onclick="menuClick('business.html')"><i class="glyphicon glyphicon-user"></i>出行预定</a></li>

                            <li><a href="#" onclick="menuClick('index.html')"><i class="glyphicon glyphicon-th-list"></i>打印订单</a></li>
                            <li><a href="#" onclick="menuClick('${base}toTestList')"><i class="glyphicon glyphicon-th-list"></i>申请预支付</a></li>

                        </ul>

                    </li>

                    <li>

                        <a href="#systemSetting1" class="nav-header collapsed" data-toggle="collapse">

                            <i class="glyphicon glyphicon-cog"></i>index1

                               <span class="pull-right glyphicon glyphicon-chevron-down"></span>

                        </a>

                        <ul id="systemSetting1" class="nav nav-list collapse secondmenu" style="height: 0px;">

                            <li><a href="#"><i class="glyphicon glyphicon-asterisk"></i>ccc</a></li>

                            <li><a href="#"><i class="glyphicon glyphicon-edit"></i>ddd</a></li>

                            <li><a href="#"><i class="glyphicon glyphicon-eye-open"></i>eee</a></li>

                        </ul>

                    </li>

                </ul>

            </div>


</div>

<div class="col-md-10 column">

<div class="breadcrumbs" id="breadcrumbs">

<!-- 面包屑导航 -->

<ul class="breadcrumb">

<li>

<a href="${base}toLoginIndex">Home</a>

</li>

<li class="active">Dashboard</li>

</ul>

</div>




<!-- 内容展示页 -->

<div>

<iframe id="iframe-page-content" src="index.html" width="100%"  frameborder="no" border="0" marginwidth="0"
marginheight=" 0" scrolling="yes" allowtransparency="no"></iframe>

</div>

</div><!-- /.main-content -->

</div><!-- /.main-container -->

</div>

</body>
<link rel="stylesheet" href="css/bootstrap.min.css">

<script src="js/jquery.min.js"></script>

<script src="js/bootstrap.min.js"></script>
另外添加一段js代码：
<script type="text/JavaScript">
function reinitIframe(){
                var iframe = document.getElementById("iframe-page-content");//id改为你的iframe的id
                try{
                    var bHeight = iframe.contentWindow.document.body.scrollHeight;
                    var dHeight = iframe.contentWindow.document.documentElement.scrollHeight;
                    var height = Math.max(bHeight, dHeight);
                    iframe.height =  height;
                }catch (ex){}
            }
            window.setInterval("reinitIframe()", 200);

$(function() {

var height=document.documentElement.clientHeight;

document.getElementById('iframe-page-content').style.height=height+'px';

});

var menuClick = function(menuUrl) {

$("#iframe-page-content").attr('src',menuUrl);

};

</script>
</html>





