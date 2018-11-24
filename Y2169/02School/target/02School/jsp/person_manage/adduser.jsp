<%@ page language="java" contentType="text/html; utf-8" isELIgnored="false" pageEncoding="utf-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>员工管理</title>
<link href="../../css/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" language="JavaScript1.2" src="../../js/stm31.js"></script>
<script>
function windowOpen(theURL,winName,features,width,hight,scrollbars,top,left) 
{
  var parameter="top="+top+",left="+left+",width="+width+",height="+hight;
  if(scrollbars=="no")
 {parameter+=",scrollbars=no";}
  else
 {parameter+=",scrollbars=yes";}
  window.open(theURL,winName,parameter);
}
function tianjia()
{
	var xg = confirm("是否确定添加此员工信息？");
	if(xg == true)
	{
		alert("确定添加！！！");
	}
	else
	{
		alert("取消添加！！！");
	}
}
</script>
<SCRIPT language=JavaScript type=text/JavaScript>

function selectAllByChk(chk,checkbox) {     
	var size = checkbox.length;
    if(size == null)
        checkbox.checked =chk.checked;
    else{
        for (i = 0; i < checkbox.length; i++) {
            checkbox[i].checked =chk.checked;
        }
	}
}

</SCRIPT>
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<center>
  <form action="${pageContext.request.contextPath}/addUser" method="post">
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td height="25" align="center" valign="bottom" class="td06"> <table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
          <td width="2%" valign="middle" background="../../images/bg_03.gif">&nbsp;</td>
          <td width="2%" valign="middle" background="../../images/bg_03.gif"><img src="../../images/main_28.gif" width="9" height="9" align="absmiddle"></td>
          <td height="30" valign="middle" background="../../images/bg_03.gif"><div align="left"><font color="#FFFFFF">员工添加</font></div></td>
        </tr>
      </table></td>
    </tr>
  </table>
  <br>
  <table width="95%"  border="0" cellpadding="0" cellspacing="0" class="td_page">
    <tr>
      <td width="10%" height="30" align="left">用户姓名</td>
      <td width="40%" height="30"><input name="uname" type="text" class="input" style="width:95% "></td>
      <td width="10%" align="left">用户密码</td>
      <td width="40%" valign="middle"><input name="upwd" type="password" class="input" style="width:95% ">
      </td>
    </tr>
    <tr>
      <td width="10%" height="30" align="left">用户昵称</td>
      <td width="40%" height="30"><input name="unickname" type="text" class="input" style="width:95% "></td>
      <td width="10%"   align="left">性别</td>
      <td width="40%"><select name="ugender" size="1" class="box" style="width:95%">
          <option value="男" selected>男　　　　　　　　　　　　　</option>
          <option value="女">女　　　　　　　　　　　　</option>
        </select>
      </td>
    </tr>
    <tr>
      <td width="10%" height="30" align="left">用户邮箱</td>
      <td width="40%" height="30"><input name="uemail" type="text" class="input" style="width:95% "></td>
      <td width="10%" align="left">用户手机</td>
      <td width="40%" valign="middle"><input name="uphone" type="password" class="input" style="width:95% ">
      </td>
    </tr>
    <tr>
      <td width="10%" height="30" align="left"> 所属角色</td>
      <td width="40%" height="30"><font>
        <select name="uroleid" size="1" class="box" style="width:95%">
          <option value="1" selected>财务部　　　　　　　　　　　　　</option>
          <option value="2">市场部　　　　　　　　　　　　</option>
        </select>
      </font></td>
      <td width="10%" align="left">所属年级</td>
      <td width="40%" valign="middle"><select name="ugradeid" size="1" class="box" style="width:95%">
          <option value="1" selected>经理　　　　　　　　　　　　　</option>
          <option value="2">主任　　　　　　　　　　　　</option>
          <option value="3">一般员工　　　　　　　　　　　　</option>
        </select>
      </td>
    </tr>

    <tr>
      <td width="10%" height="30" align="left"> 出生日期</td>
      <td width="40%" height="30"><font>
        <input name="ubirthday" type="text" class="input" style="width:95% ">
      </font></td>
      <td width="10%" height="30" align="left"> 身份证号</td>
      <td width="40%" height="30"><font>
        <input name="uidentityid" type="text" class="input" style="width:95% ">
      </font></td>
    </tr>




  </table><br>
  <table width="95%"  border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td align="right" class="td_page"><div>
          <input name="Submit" type="submit" class="buttonface02"  value="  添加  ">
&nbsp;
        <input name="Submit" type="reset" class="buttonface02" value="  重置  ">	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="&#21592;&#24037;&#31649;&#29702;.htm">返回上一页</a>
		&nbsp;&nbsp;&nbsp;&nbsp;
      </div></td>
    </tr>
  </table>
  </form>
</center>
</body>
</html>

