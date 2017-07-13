<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>
    <script type="text/javascript">
    
         function validate (){
    	  //var form=document.register;
	      var userName=document.getElementById("loginName").value;
	      var password=document.getElementById("password").value;
	      var repassword=document.getElementById("repassword").value; 
	      if(userName.length<2){
	    	 document.getElementById("loginName").focus();
	      	 alert("用户的长度必须大于2");
	        document.getElementById("loginName").focus();
	       return false;
	      }
	     if(password!=repassword){
	     document.getElementById("password").focus();
	      	alert("两次密码输入不一致");
	    
	      	return false;
	      }	 
	return true;
}
    
    </script>
</head>
<body>

               <form  name="register" action="index"  onSubmit="return validate()" >
     用户名            <input type="text" name="loginName"  id="loginName"    /> <br>
     密码               <input type="password" name="password"   id="password" /> <br>
     确认密码        <input type="password" name="repassword"  id="repassword"  />  <br>
               <input type="submit" value="注册"  />
               </form>
</body>
</html>