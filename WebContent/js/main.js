;(function () {
	

	'use strict';

	// Placeholder 
	var placeholderFunction = function() {
		$('input, textarea').placeholder({ customClass: 'my-placeholder' });
	}
	
	// Placeholder 
	var contentWayPoint = function() {
		var i = 0;
		$('.animate-box').waypoint( function( direction ) {

			if( direction === 'down' && !$(this.element).hasClass('animated-fast') ) {
				
				i++;

				$(this.element).addClass('item-animate');
				setTimeout(function(){

					$('body .animate-box.item-animate').each(function(k){
						var el = $(this);
						setTimeout( function () {
							var effect = el.data('animate-effect');
							if ( effect === 'fadeIn') {
								el.addClass('fadeIn animated-fast');
							} else if ( effect === 'fadeInLeft') {
								el.addClass('fadeInLeft animated-fast');
							} else if ( effect === 'fadeInRight') {
								el.addClass('fadeInRight animated-fast');
							} else {
								el.addClass('fadeInUp animated-fast');
							}

							el.removeClass('item-animate');
						},  k * 200, 'easeInOutExpo' );
					});
					
				}, 100);
				
			}

		} , { offset: '85%' } );
	};
	// On load
	$(function(){
		placeholderFunction();
		contentWayPoint();

	});

}());

$(".tip").hide();
$(".email_tip").hide();
$("#email-success").hide();
$("#btn-sign-up").attr('disabled',true);
      function checkpas1(){//当第一个密码框失去焦点时，触发checkpas1事件
      	//alert("11");
        var pas1=document.getElementById("password").value;
        var pas2=document.getElementById("re-password").value;//获取两个密码框的值
        if(pas1!=pas2&&pas2!="")//此事件当两个密码不相等且第二个密码是空的时候会显示错误信息
          $(".tip").show();
        else
          $(".tip").hide();//若两次输入的密码相等且都不为空时，不显示错误信息。
      }
      function checkpas(){//当第一个密码框失去焦点时，触发checkpas2件
        var pas1=document.getElementById("password").value;
        var pas2=document.getElementById("re-password").value;//获取两个密码框的值
        if(pas1!=pas2){
          $(".tip").show();//当两个密码不相等时则显示错误信息
        }else{
          $(".tip").hide();
          $("#btn-sign-up").attr('disabled',false);
        }
        }
      function checkpas2(){//点击提交按钮时，触发checkpas2事件，会进行弹框提醒以防无视错误信息提交
        var pas3=document.getElementById("password").value;
        var pas4=document.getElementById("re-password").value;
        if(pas3!=pas4){
          alert("两次输入的密码不一致！");
          return false;
        }
      }
      function email_check(){
      	var email=$("#email").val();
      
    	if(!/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/ .test(email))
    	{
    		//alert("sss");
    		$(".email_tip").show();
    		$("#email").focus();
    		return false;
    	}
    	$(".email_tip").hide();
    	return true;
    }

    $("#btn-primary").click(function(){
    	var email=$("#email").val();
    	if(/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/ .test(email))
    	{
    		display_show('form-group-re-psw');
    		//alert("111");
    		$("#email").attr("readonly",true);
    	}
    	else
    		{
    			emai_check();
    			
    			//$("input[type=text]").prop('readonly','readonly');
    		}
    });
    $("#btn-email-send").click(function(){
    	var email=$("#email").val();
    	if(/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/ .test(email))
    		$("#email-success").show();
    });
    function display_show(obj){
	var oDiv=document.getElementById(obj);
	oDiv.style.display="block";
// alert(obj);
// $("#obj).css("display","block");

}
function display_hide(obj){
	var oDiv=document.getElementById(obj);
	oDiv.style.display="none";
// alert(obj);
// $(#obj).css("display","block");

}

/*function changeimg(){
  $("#upload_file").click();
//  setInterval(check(),10);

};
*/
/*function check(){
	  if ($("#upload_file").val().length > 0)
	{
		  $("#fileUp").click();
	}

}*/

// function emai_check() { 
// var email = document.getElementById("email").value; //获取邮箱地址 
// //判断邮箱格式是否正确 
// if(!/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/.test(email)) { 
// alert("邮箱格式错误!"); 
// document.getElementById("email").focus(); //让邮箱文本框获得焦点 
// return false; 
// } 
// return true; 
// } 
// /* 
// * 功能：判断用户输入的手机号格式是否正确 
// * 传参：无 
// * 返回值：true or false 
// */ 
// function checkMobile(s) { 
// var regu = /^[1][0-9][0-9]{9}$/; 
// var re = new RegExp(regu); 
// if (re.test(s)) { 
// return true; 
// } else { 
// return false; 
// } 
// } 
