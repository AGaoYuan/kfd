<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Plateau新闻</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/jigsaw.css">
<!--                       CSS                       -->

<!-- Reset Stylesheet -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/background/resources/css/reset.css"
	type="text/css" media="screen" />
<!-- Main Stylesheet -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/background/resources/css/style.css"
	type="text/css" media="screen" />
<!-- Invalid Stylesheet. This makes stuff look pretty. Remove it if you want the CSS completely valid -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/background/resources/css/invalid.css"
	type="text/css" media="screen" />
<!--                       Javascripts                       -->
<!-- jQuery -->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/background/resources/scripts/jquery-1.3.2.min.js"></script>
<!-- jQuery Configuration -->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/background/resources/scripts/simpla.jquery.configuration.js"></script>
<!-- Facebox jQuery Plugin -->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/background/resources/scripts/facebox.js"></script>
<!-- jQuery WYSIWYG Plugin -->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/background/resources/scripts/jquery.wysiwyg.js"></script>
	
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jigsaw.js"></script>
	
</head>
<script type="text/javascript">
	function checkForm() {
		var userName = document.getElementById("userName").value;
		var password = document.getElementById("password").value;
		var verify = document.getElementById("verify").value;
		if (userName == null || userName == "") {
			document.getElementById("error").innerHTML = "用户名不能为空！";
			return false;
		}
		if (password == null || password == "") {
			document.getElementById("error").innerHTML = "密码不能为空！";
			return false;
		}
		if (verify == null || verify == "") {
			document.getElementById("error").innerHTML = "验证码不能为空！";
			return false;
		}
		return true;
	}
</script>

<!-- 触发JS刷新-->
<!-- <script type="text/javascript">
	function changeImg() {
		var img = document.getElementById("img");
		img.src = "${pageContext.request.contextPath}/AuthImage?date="
				+ new Date().getTime();
	}
</script> -->


<body id="login">
	<div id="login-wrapper" class="png_bg">
		<div id="login-top">
			<h2>Plateau新闻-后台管理</h2>
		</div>
		<div id="login-content">
			<form id="sub" action="/News/UserInfoServlet?action=login" method="post"
				onsubmit="return checkForm()">
				<p>
					<label>用户名：</label> <input class="text-input" type="text"
						id="userName" name="uname" value="${userName }" />
				</p>

				<div class="clear"></div>
				<p>
					<label>密码：</label> <input class="text-input" type="password"
						id="password" name="upwd" value="${password }" />
				</p>
				<div class="clear"></div>
				
				<div class="container">
				<div id="captcha" style="position: relative"></div>
				<div id="msg"></div>
				</div>
				
				<%-- <div class="mydiv">
      			<p>
         			<label>验证码：</label>
        			<input class="text-input" type="text" id="verify" name="VerifyCode" value="" />
        			<img id="img" src="${pageContext.request.contextPath}/AuthImage" />
        			<a href='#' onclick="javascript:changeImg()" style="color:white;"><label style="color:blue;">看不清？</label></a>
  	  			</p>
   				</div>
   				<div class="clear"></div>
      			<br> --%>

				<font id="error" color="red">${error }</font> <input class="button"
					type="submit" value="登录" />
			</form>

		</div>

	</div>
</body>
<style type="text/css">
#msg {
  Color:red;
  font-size: 14px;
  text-align: center;
}

</style>
<script type="text/javascript">
jigsaw.init(document.getElementById('captcha'), function () {
	document.getElementById('msg').innerHTML = "验证成功！";
	
})
</script>

</html>
