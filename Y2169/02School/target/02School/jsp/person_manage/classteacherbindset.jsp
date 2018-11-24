<%@ page language="java" contentType="text/html; utf-8" isELIgnored="false" pageEncoding="utf-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>绑定设置</title>
<link href="../../css/style.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/layer/theme/default/layer.css">
    <link rel="stylesheet" type="text/css" href="/css/jquery.tagsinput.css">
  <style type="text/css">
    body{
      font-size: 15px;
    }
  </style>
    <script language="JavaScript" type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.min.js"></script>
<script language="JavaScript" type="text/javascript" src="../../js/tree.js"></script>

    <%--Layer弹层 js--%>
    <script type="text/javascript" src="/layer/layer.js"></script>
    <script type="text/javascript" src="/js/jquery.tagsinput.js"></script>
    <script type="text/javascript">
        //拿到班级id和老师id进行添加绑定
        function addTeacher(uname,uid) {
           /* alert(uid);*/
            var cid = $('#cid').val();
            //改变为Tag标签
            $("#tags_1").addTag(uname);
            $("#SaveBind").click(function () {
               $.ajax({
                   url:"/UserInfoServlet?action=SaveBind",
                   type:"post",
                   data:{"cid":cid,"tid":uid},
                   //添加成功后进行提示
                   success:function (data) {
                        if ("y"==data){
                            layer.msg("bind success")
                            //alert("成功！");
                        }else{
                            alert("bind fail");
                        }
                   },
                   error:function () {
                       layer.msg("bind error")
                   }
               })
            });
        }
        //初始化拿到所有老师进行绑定，拼接到页面上
        $(function () {
            $.ajax({
                url:'/UserInfoServlet?action=findUserAll',
                type:"post",
                dataType:"json", //数据格式为json
                success:function (data) {
                    $.each(data.list,function(i,item){
                        //append 追加显示数据
                        $("#list-context").append("<tr><td class='td07' align='center'>"+item.uname+"</td><td align='center' class='td07'><a href='#' id='bind' onclick='addTeacher(&quot"+item.uname+"&quot,+"+item.uid+")'>添加</a>&nbsp;</td></tr>")
                    })
                }
            });
/**/

            $('#tags_1').tagsInput({
                width:'auto',
                onAddTag:function(tag){
                    console.log('增加了'+tag.uid)
                },
            });//这样做的目的是，使tags_1能够变成标签.

            $('[name=tags_2]').tagsInput({width:'auto'});//这样做的目的是，使tags_2能够变成标签。
        });
    </script>
</head>

<body>
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td align="center" valign="top" class="td03"><br>
      <table width="98%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td height="25" class="F01"><p><img src="../../images/index_35.gif" width="15" height="16" align="absmiddle">绑定设置</p>
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
                          <td colspan="6" align="center"><h2>绑定设置</h2></td>
                        </tr>
                        <tr>
                          <td width="17%" class="td_top" align="center">老师名称</td>
                          <td width="15%" align="center" class="td_top">添加</td>
                        </tr>
                          <tbody id="list-context">
                          </tbody>
                      </table>
                      <p>&nbsp;</p>
                    <input id="tags_1"type="text" class="tags" value=""/>
                    <!--  <input name="tags_2" type="hidden" th:each="userinfo:${userList}" th:value="${userinfo.uname}"/>-->
                    <table>
                        <tr>
                            <span style="font-size: 15px;">班级已有教员： <td style="font-size: 13px;" th:each="userinfo:${userList}" th:text="${userinfo.uname}"></td></span>
                        </tr>
                    </table>
                <p>&nbsp;</p></td>
  </tr>
                    <%--隐藏域，保存班级的id--%>
                    <input type="hidden" id="cid" value="${Dicid}"/>
</table><input id="SaveBind" type="button" value="绑定"/>
            </td>
        </table>
    </td>
  </tr>
</table>

</body>
</html>
