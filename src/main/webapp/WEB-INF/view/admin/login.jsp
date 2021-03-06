<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="/WEB-INF/inc/globalConfig.jsp" %>
<!DOCTYPE html>    
<html>
<%@include file="/WEB-INF/view/util/header.jsp" %>
<script src="${path }/js/pngfix.js" type="text/javascript"></script>
<link href="${path }/css/common.css" rel="stylesheet">
<script src="${path }/js/login.js" type="text/javascript"></script>
<script src="${path }/js/jquery.md5.js" type="text/javascript"></script>
	<script>

		jQuery(document).ready(function() {     
 				$("#loginBtn").click("click",function(e){
					var username=$("#username").val();
					var ud=$("#userpswd").val();
					var pwd = $.md5(ud);
					if(username==null ||username=="" || ud==""|| ud==null){
						//nullid nullid
						 $("#nullid").css("display","block");
						return false;
					}else{
						$("#nullid").css("display","none");
					}
					$.ajax({  
			            type: "POST", 
			            url: "/collection/base/login", 
			            cache: false, //将不会从浏览器缓存中加载请求信息。 
			            data:{'name':username,'password':pwd},    
			            dataType: 'json', 
			            success: function(data,statusText){
			              if(data.status==0){
			            	  window.location.href="/collection/admin/list";
			              }else{
			            	 $("#errid").css("display","block");
			              }
			            }, 
			            error: function(XMLHttpRequest, textStatus, errorThrown){ 
			                  alert( "系统异常!");
			                  //alert( textStatus);
			                  //alert( XMLHttpRequest);
			                  //alert( errorThrown);
			            } 
			           }); 
					
				}); 
		});
		
		document.onkeyup = function(e){      //onkeyup是javascript的一个事件、当按下某个键弹起 var _key;                                                 //的时触发  
		    if (e == null) { // ie  
		        _key = event.keyCode;  
		    } else { // firefox              //获取你按下键的keyCode  
		        _key = e.which;          //每个键的keyCode是不一样的  
		    }  
		      
		    if(_key == 13){   //判断keyCode是否是13，也就是回车键(回车的keyCode是13)  
		     //if (validator(document.loginform)){ //这个因该是调用了一个验证函数  
		         document.getElementById('loginBtn').click();    //验证成功触发一个Id为btnLogin的  
		        //}                                                                        //按钮的click事件，达到提交表单的目的  
		    }  
		};  
	</script>
<body>
	<div class="wrap">
		<!--header begin-->
			<%@include file="/WEB-INF/view/admin/util/banner.jsp" %>
		<!--header end-->
		<!--content begin-->
		<div id="content" class="png-bg">
			<div class="content-login png-bg">
				<div class="login-wrap">
					<h2 class="png-bg">登录</h2>
					<form action="" name="loginForm">
						<ul class="login-con">
							<li>
								<label class="login-icon studentNo-icon png-bg" for="username">用户名</label>
								<label class="login-tip" for="username">用户名</label>
								<input type="text" id="username" class="login-input studentNo" />
							</li>
							<li>
								<label class="login-icon pswd-icon png-bg" for="userpswd">密码</label>
								<label class="login-tip pswdtip" for="userpswd">密码</label>
								<input type="password" id="userpswd" class="login-input pswd" />
							</li>
							<li class="error-tips" id="errid" style="display:none;">用户名或密码输入错误</li>
							<li class="error-tips" id="nullid" style="display:none;">请输入用户名或密码</li>
							<li class="last"><input type="button" id="loginBtn" class="login-btn png-bg" value="登&nbsp;录" /></li>
						</div>
					</form>
				</div>
			</div>
		</div>
		<!--content end-->
		<!--footer begin-->
		<%@include file="/WEB-INF/view/util/foot.jsp" %>
		<!--footer end-->
	</div>
</body>
</html>
