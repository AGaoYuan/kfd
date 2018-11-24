<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; utf-8" isELIgnored="false" pageEncoding="utf-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>Untitled Document</title>
<link href="../../css/style.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/layer/theme/default/layer.css">
  <style type="text/css">
    body{
      font-size: 15px;
    }
  </style>
    <script language="JavaScript" type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.min.js"></script>
<script language="JavaScript" type="text/javascript" src="../../js/tree.js"></script>

    <%--Layer弹层 js--%>
    <script type="text/javascript" src="${pageContext.request.contextPath}/layer/layer.js"></script>
    <script type="text/javascript">
        /*$(function () {
            //文本框的id column
           $("#bind").click(function () {
                layer.open({
                    type: 2,//风格
                    title: '班级-老师绑定', //标题
                    shadeClose: true, //点击阴影部分，是否能关闭弹层
                    shade: 0.6, //透明度
                    area: ['60%', '90%'],//显示的区域
                    content: '/jsp/person_manage/classteacherbindset.jsp',  //content:
                    scrollbar: true
                });
            });
        });*/

        //班级点击绑定按钮弹出模态框 并请求Servlet保存班级id
        function showTeacher(dicid) {
            //alert(dicid);
            //location.href="/UserInfoServlet?action=SaveDicid&dicid="+dicid;
            layer.open({
                type: 2,//风格
                title: '班级-老师绑定', //标题
                shadeClose: true, //点击阴影部分，是否能关闭弹层
                shade: 0.6, //透明度
                area: ['60%', '90%'],//显示的区域
                content: '${pageContext.request.contextPath}/UserInfoServlet?action=SaveDicid&dicid='+dicid,  //content:
                scrollbar: true
            });
        }

    </script>
</head>

<body>
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td align="center" valign="top" class="td03"><br>
      <table width="98%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td height="25" class="F01"><p><img src="../../images/index_35.gif" width="15" height="16" align="absmiddle">班级-老师绑定</p>
          </td>
        </tr>
        <tr>
          <td height="2" background="../../images/index_39.gif"><img src="../../images/spacer.gif" width="1" height="1"></td>
        </tr>
      </table>
        <table width="90%" border="0" cellpadding="0" cellspacing="0" class="td01">
            <td>
            	<table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td>
                      <table width="96%"  border="0" align="center" cellpadding="0" cellspacing="0">
                      </table>
                      <br>
                      <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0" class="table01">
                        <tr>
                          <td colspan="6" align="center"><h2>班级-老师绑定</h2></td>
                        </tr>
                        <tr>
                          <td width="17%" class="td_top" align="center">班级名称</td>
                          <td width="15%" align="center" class="td_top">绑定</td>
                        </tr>
                         <c:forEach items="${list}" var="item">
                              <tr>
                                  <input type="hidden" name="dicid" value="${item.dicid}">
                                  <td class="td07" align="center">${item.dicname}</td><%--id="bind"--%>
                                  <td align="center" class="td07"><a href="#" onclick="showTeacher(${item.dicid})">绑定</a>&nbsp;</td>
                              </tr>

                          </c:forEach>
                      </table>
                      <p>&nbsp;</p>

                <p>&nbsp;</p></td>
  </tr>
</table>
            </td>
        </table>
    </td>
  </tr>
</table>
</body>
</html>
