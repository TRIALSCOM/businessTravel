<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>

<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="js/ajaxfileupload.js"></script>
</head>
<body>

    <p>
        <input type="file" id="file" name="file" />
    </p>
    <input type="button" id="fileUp" value="上传" />
    <p>
        <img id="imgPerson" alt="XX" src="" />
    </p>
</body>
</html>
<script type="text/javascript">
    $(function() {
        $("#fileUp").click(function() {
            if ($("#file").val().length > 0) {
                ajaxFileUpload();
            } else {
                alert("请选择图片");
            }
        });
    });
    function ajaxFileUpload() {
        $.ajaxFileUpload({
            url : 'tempimg', //用于文件上传的服务器端请求地址
            secureuri : false, //一般设置为false
            fileElementId : 'file', //文件上传空间的id属性  <input type="file" id="file" name="file" />
            type : 'post',
            dataType : 'HTML', //返回值类型 一般设置为json
            success : function(data, status) //服务器成功响应处理函数
            {
                $("#imgPerson").attr("src", data);
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