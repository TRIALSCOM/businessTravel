	<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
  <meta charset="utf-8">
  <script type="text/javascript">  
    function delayURL() { 
      var delay = document.getElementById('time').innerHTML;
      var t = setTimeout("delayURL()", 3000);
          if (delay > 0) {
              delay--;
              document.getElementById('time').innerHTML = delay;
          } else {
       clearTimeout(t); 
              window.location.href = "index.html";
          }        
    } 
    window.onload = function(){

      delayURL();    
    
    }
</script>
  <head>
    <title></title>
  </head>
  <style type="text/css">.user-info {
  padding:0;
  font-family:Helvetica Neue,Microsoft Yahei,Hiragino Sans GB,WenQuanYi Micro Hei,sans-serif;
  text-align:center;
  word-break:normal;
  font-weight:normal;
  margin:20px auto;
  color:#383838;
  font-size:20px;
}
.welcome-info {
  /*margin:0;*/
  padding:0;
  font-family:Helvetica Neue,Microsoft Yahei,Hiragino Sans GB,WenQuanYi Micro Hei,sans-serif;
  text-align:center;
  word-break:normal;
  font-weight:normal;
  display:inline;
  color:#808080;
  font-size:20px;
}
.success-info {
  padding:0;
  font-family:Helvetica Neue,Microsoft Yahei,Hiragino Sans GB,WenQuanYi Micro Hei,sans-serif;
  text-align:center;
  word-break:normal;
  font-weight:normal;
  display:block;
  width:200px;
  height:54px;
  margin:30px auto;
  font-size:20px;
  line-height:54px;
  border-radius:2px;
  background:#3da8f5;
  text-decoration:none;
  color:#fff;
  border:0;
  cursor:pointer;
}
.transformation-info {
  margin:0;
  padding:0;
  font-family:Helvetica Neue,Microsoft Yahei,Hiragino Sans GB,WenQuanYi Micro Hei,sans-serif;
  font-size:14px;
  text-align:center;
  word-break:normal;
  font-weight:normal;
}
.link-info {
  margin:0;
  padding:0;
  font-family:Helvetica Neue,Microsoft Yahei,Hiragino Sans GB,WenQuanYi Micro Hei,sans-serif;
  font-size:14px;
  text-align:center;
  word-break:normal;
  font-weight:normal;
  color:#3da8f5;
}
</style>
  
  <body>
    <h2 class="user-info">${loginName}您好</h2>
    <h2 class="user-info">欢迎使用 BusinessTravel，请验证邮箱，如果此操作并不是由您发起的，请忽略此邮件。</h2>
    <a class="success-info">${msg}</a>
    <p class="transformation-info">系统<span id="time">3</span>秒后将跳转到登录界面，如果未自动跳转，请点击以下链接
      <br>
      <a href="index" class="link-info" style="" target="_blank">点此跳转至登录页面</a></p>
  </body>

</html>
