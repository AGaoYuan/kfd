function getXHR(){
	var xmlhttp;
	
	if (window.XMLHttpRequest){// code for IE7+, Firefox, Chrome, Opera, Safari
	  xmlhttp=new XMLHttpRequest();
	}else{// code for IE6, IE5
	  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
	
	if(xmlhttp!=null)
		return xmlhttp;
	else{
		alert("你的浏览器不支持AJAX,请使用现代浏览器,如Chrome、Firefox等,或升级你的浏览器，以保证正常使用")
		return false;
	}
		
}

function getVerifyCode(){
	var codeImage = document.getElementById("codeImage");
	
	var xhr = getXHR();
	
	xhr.open("POST","servlet/VerifyCodeServlet");
	xhr.setRequestHeader("CONTENT-TYPE","application/x-www-form-urlencoded");
	xhr.send(null);
	
	xhr.onreadystatechange = function(){
		if (xhr.readyState == 4 && xhr.status == 200) {
			codeImage.src = "servlet/VerifyCodeServlet?time="+
				new Date().getTime();
		}
	}
}
	
function login(){
	var xhr = getXHR();

	var f = document.getElementById("loginForm");	//得到登陆表单
	var username = f.username.value;
	var password = f.password.value;
	var verification = f.verification.value;
	
	var param = "username="+username+"&"+"password="+password+"&"+"verification="+verification;

	console.log("param:"+param);
	
	xhr.open("POST","servlet/LoginServlet");
	xhr.setRequestHeader("CONTENT-TYPE","application/x-www-form-urlencoded");
	xhr.send(param);
	
	xhr.onreadystatechange = function(){
		if (xhr.readyState == 4 && xhr.status == 200) {
			var rt = xhr.responseText;
			console.log(rt);
			if (rt == "login000") {	//登陆成功
				location.href = "console/main.jsp";
				return true;
			}else if (rt == "login001") {	//账号或密码错误
				alert("账号或密码错误");
			}else if (rt == "login002") {	//验证码错误
				alert("验证码错误");
			}else if (rt == "login003") {	//格式错误
				alert("错误，请检查输入是否为空");
			}		
			//重新得到验证码
			getVerifyCode();
			return false;
		}
	}
}

function newsRelease(){
	var xhr = getXHR();

	var f = document.getElementById("newsReleaseForm");	//得到表单
	
	var title = f.title.value;
	var type = f.type.value;
	var content = f.content.value;
	
	title = encodeURIComponent(title);
	type = encodeURIComponent(type);
	content = encodeURIComponent(content);
	
	var param = "title="+title+"&"+"type="+type+"&"+"content="+content;
	
	console.log("param:"+param);
	
	xhr.open("POST","servlet/NewsReleaseServlet");
	xhr.setRequestHeader("CONTENT-TYPE","application/x-www-form-urlencoded");
	xhr.send(param);
	
	xhr.onreadystatechange = function(){
		if (xhr.readyState == 4 && xhr.status == 200) {
			var rt = xhr.responseText;
			console.log(rt);
			
			if (rt == "release000") {	//发布成功
				alert("发布成功");
				location.href = "console/newsRelease.jsp";
			}else if (rt == "release001") {	//发布失败
				alert("发布失败，请重试！");
			}
		}
	}
}

function noticeRelease(){
	var xhr = getXHR();

	var f = document.getElementById("noticeReleaseForm");	//得到表单
	
	var title = f.title.value;
	var receiver = f.receiver.value;
	var content = f.content.value;
	
	title = encodeURIComponent(title);
	receiver = encodeURIComponent(receiver);
	content = encodeURIComponent(content);
	
	var param = "title="+title+"&"+"receiver="+receiver+"&"+"content="+content;

	console.log("param:"+param);
	
	xhr.open("POST","servlet/NoticeReleaseServlet");
	xhr.setRequestHeader("CONTENT-TYPE","application/x-www-form-urlencoded");
	xhr.send(param);
	
	xhr.onreadystatechange = function(){
		if (xhr.readyState == 4 && xhr.status == 200) {
			var rt = xhr.responseText;
			console.log(rt);
			
			if (rt == "release000") {	//发布成功
				alert("发布成功");
				location.href = "console/noticeRelease.jsp";
			}else if (rt == "release001") {	//发布失败
				alert("发布失败，请重试！");
			}
		}
	}
}

//权限改变
function authorityChange(the,username){
	console.log(the.value);
	console.log(username);
	
	var isNews;
	var isNotice ;
	switch(the.value){
	case "closeNews":
		isNews = 0;
		break;
	case "openNews":
		isNews = 1;
		break;
	case "closeNotice":
		isNotice = 0;
		break;
	case "openNotice":
		isNotice = 1;
		break;
	}
	
	var param = "username="+username+"&&isNews="+isNews+"&&isNotice="+isNotice;
	
	var xhr = getXHR();
	xhr.open("POST", "servlet/AuthorityChangeServlet");
	xhr.setRequestHeader("CONTENT-TYPE","application/x-www-form-urlencoded");
	xhr.send(param);
	
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			var message = xhr.responseText;
			switch(message){
			case "true":
				var className = the.className;
				console.log(className);
				if(className=="btn btn-danger"){
					the.className = "btn btn-info";
					the.innerHTML = "开启";
					if(the.value=="closeNews"){
						the.value="openNews";
					}else if(the.value=="closeNotice"){
						the.value = "openNotice";
					}
				}else if(className=="btn btn-info"){
					the.className = "btn btn-danger";
					the.innerHTML = "关闭";
					if(the.value=="openNews"){
						the.value="closeNews";
					}else if(the.value=="openNotice"){
						the.value = "closeNotice";
					}
				}
				break;
			case "false":
				alert("更新失败！");
				break;
			}
			
		}
	}
	
}


function test(){
	alert("测试");
}
