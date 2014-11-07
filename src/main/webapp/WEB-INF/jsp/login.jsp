<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <head>
  <title>用户登录</title>
  <%
  response.setHeader("Pragma","No-cache");  
  response.setHeader("Cache-Control","No-cache");  
  response.setDateHeader("Expires", -1);  
  response.setHeader("Cache-Control", "No-store"); 
  %>
  <link rel="stylesheet" type="text/css" href="css/easyui.css">
<script src='js/lib/jquery.min.js'></script>
<script src='js/lib/jquery.easyui.min.js'></script>
  <style type="text/css">
html {
	height: 100%;
	margin: 0;
	padding: 0;
}

body {
	height: 100%;
	margin: 0;
	padding: 0;
}

.floater {
	float: left;
	height: 50%;
	margin-bottom: -234px;
}

.login_center {
	width: 100%;
	clear: both;
	height: 468px;
	position: relative;
}

.main {
	background-image: url('images/panel.jpg');
	background-repeat: no-repeat;
	width: 808px;
	height: 468px;
}

table {
	height: 70px;
	width: 70%;
	float: left;
	margin-top: 400px;
	margin-left: 100px;
}

.text_input {
	background-color: #fff;
	border: 1px solid #b5b8c8;
}

.clear {
	clear: both;
}
</style>
 </head>
 <body>
  <div class="floater"></div>
  <div align="center" class="login_center">
   <div class="login_div">
    <div class="main">
     <form action="login.action" method="post">
      <table>
       <tr>
        <td>
         账号:
        </td>
        <td>
         <input type="text" name="loginName" class="text_input" />
        </td>
        <td>
         密码:
        </td>
        <td>
         <input type="password" name="pwd" class="text_input" />
        </td>
        <td>
         <input type="submit" value="登录" class="button" />
        </td>
       </tr>
      </table>
     </form>
    </div>
    <div class="clear"></div>
   </div>
  </div>
  <script type="text/javascript">
  (function () {
		//process login timeout problem
		var loginPage = '/login.action';
		if (top.location.pathname != loginPage) {
			top.location.href = loginPage;
		}
	    
		var form = $('form');
		form.submit(function (e) {
			e.preventDefault();
			if (form.form("validate")) {
				$.post("login.action", form.serialize(), function (data) {
					if (data ) {
						location.href = '/'
					} else {
						$.messager.alert('登录失败', data ? data : '登录失败!')
					}
				})
			}
		})
	})();
 </script>
 </body>
</html>
