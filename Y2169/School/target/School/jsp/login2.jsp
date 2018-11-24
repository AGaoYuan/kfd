<%@ page language="java" contentType="text/html; utf-8" isELIgnored="false" pageEncoding="utf-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>五道口学院【信息管理系统】</title>
<link href="../css/style.css" rel="stylesheet" type="text/css">
<style type="text/css">
<!--
body {
	background-color: #f8f8f8;
}
-->
</style>
<script language="javascript">
function login()
{
	var name=document.getElementById("name").value;
	var pwd=document.getElementById("pwd").value;
	if(name==""){
			alert("请输入用户名称！");
			document.getElementById("name").focus();
			return false;
		}
	if(pwd==""){
			alert("请输入用户密码！");
			document.getElementById("pwd").focus();
			return false;
		}
	if(name=="admin" && pwd=="admin")
	{	
		location.href="index.htm";
	  return true;
	}
}
</script>
</head>

<body>
<form  style="width:500px;margin: 150px auto;" name="form1" method="post">
  <h1 style="font-family:KaiTi;font-size: 30px;">&nbsp;<img src="../images/login.jpg" alt=""></h1>
<table width="100%"  style="border: 1px solid red"  border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td><div align="center">
      <p><br>
      </p>
      <table width="100%"  border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td>
            <table width="100%"   border="0" cellpadding="0" cellspacing="0">
            <tr>
              <td valign="top"><table width="100%"  border="0" cellspacing="0" cellpadding="0">
                <tr>
                  <td ><font size="2">用户名称</font></td>
                  <td ><input name="name" id="name" type="text" class="box" size="20"></td>
                </tr>
                <tr>
                  <td ><font size="2">登录密码</font></td>
                  <td><input name="pwd" id="pwd" type="password" class="box" size="20">
                    <input name="Submit" type="button" class="buttonface" value="登 录" onClick="return login()"></td>
                </tr>
              </table></td>
              </tr>
          </table></td>
        </tr>
      </table>
      <p>&nbsp;</p>
    </div></td>
  </tr>
</table>
</form>
</body>
</html>
