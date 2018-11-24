<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; utf-8" isELIgnored="false" pageEncoding="utf-8" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>部门管理</title>
<link href="../../css/style.css" rel="stylesheet" type="text/css">
<link href="css/style_.css" rel="stylesheet" type="text/css">

<script>
function shanchu()
{
	var xg = confirm("是否确定删除这些员工？");
	if(xg == true)
	{
		alert("确定删除！！！");
	}
	else
	{
		alert("取消删除！！！");
	}
}

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
</script>
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<center>
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td height="25" align="center" valign="bottom" class="td06"> <table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
          <td width="2%" valign="middle" background="../../images/bg_03.gif">&nbsp;</td>
          <td width="2%" valign="middle" background="../../images/bg_03.gif"><img src="../../images/main_28.gif" width="9" height="9" align="absmiddle"></td>
          <td height="30" valign="middle" background="../../images/bg_03.gif"><div align="left"><font color="#FFFFFF">单位员工管理</font></div></td>
        </tr>
      </table></td>
    </tr>
  </table>
  <form name="form1" method="post" action="">
    <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0" class="table01">
      <tr>
        <td colspan="4" class="td_02"><SPAN class=td_title>员工查询</SPAN></td>
      </tr>
      <tr>
        <td width="10%" class="td_02">员工姓名</td>
        <td width="40%" class="td_02"><input name="textfield" type="text" class="input" style="width:95% "></td>
      <td width="10%" class="td_02">所属部门</td>
        <td width="40%" class="td_02"><select name="select" style="width:95% ">
          <option value="0" selected>--请选择--</option>
          <option value="1">人事部</option>
        </select></td>
      </tr>
      <tr>
        <td class="td_02">职&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;务</td>
        <td class="td_02"><select name="select" style="width:95% ">
          <option value="0" selected>--请选择--</option>
          <option value="1">部门经理</option>
                </select></td>
      <td class="td_02">&nbsp;</td>
        <td class="td_02"><input name="Submit2" type="reset" class="buttonface02" value=" 查  询 "></td>
      </tr>
    </table><br>
    <table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td class="td_page"><div align="right">
            <input name="Submit2" type="button" class="buttonface02" value="新增员工" onClick="location.href='${pageContext.request.contextPath}/jsp/person_manage/adduser.jsp'">
            <input name="Submit2" type="reset" class="buttonface02" value="删除选中的员工" onClick="shanchu()">
            
        </div></td>
      </tr>
    </table>
    <table width="95%"  border="0" cellpadding="0" cellspacing="0" class="table02" align="center">
      <tr>
        <td height="30" align="right"><div align="left"></div>
            <img src="../../images/1.gif" width="4" height="5" align="absmiddle"> 首页　
          <img src="../../images/2.gif" width="3" height="5" align="absmiddle"> 上一页　 <img src="../../images/2-2.gif" width="3" height="5" align="absmiddle"> 下一页　 <img src="../../images/3.gif" width="4" height="5" align="absmiddle"> 末页　　共 1 页 1 条记录</td>
      </tr>
    </table>
    <table width="95%" border="0" align="center" cellpadding="2" cellspacing="0" class="table01">
      <tr>
        <td width="5%" class="td_top"><input name="chk" type="checkbox" id="chk" onClick="selectAllByChk(chk,checkbox)" value="checkbox0"></td>
        <td width="10%" class="td_top">用户姓名</td>
        <td width="11%" class="td_top">用户邮箱</td>
        <td width="13%" class="td_top">用户手机</td>
        <td width="13%" class="td_top">修改员工</td>
      </tr>
      <c:forEach items="${userlist}" var="item">
        <tr>
          <td class="td_02"><input type="checkbox" name="checkbox" value="checkbox"></td>
          <td class="td_02"><font color="#000000"><a href="&#21592;&#24037;&#31649;&#29702;.htm">${item.uname}</a></font></td>
          <td class="td_02">${item.uemail}</td>
          <td class="td_02">${item.uphone}</td>
          <td class="td_02"><a href="员工修改.htm">修 改</a>&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/delUser/${item.uid}">删 除</a></td>
        </tr>
      </c:forEach>


    </table>
    <p>&nbsp;</p>
  </form>
</center>
</body>
</html>
