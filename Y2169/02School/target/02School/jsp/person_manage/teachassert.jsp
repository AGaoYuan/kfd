<%@ page language="java" contentType="text/html; utf-8" isELIgnored="false" pageEncoding="utf-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>教员评价</title>
<link rel="stylesheet" type="text/css" href="http://www.jq22.com/jquery/bootstrap-3.3.4.css">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
<link href="/css/star-rating.css" media="all" rel="stylesheet" type="text/css"/>
<link href="../../css/style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/layer/theme/default/layer.css">

<style type="text/css">
    body{
        font-size: 15px;
    }
    #Udiv{
        width:60%;
    }
</style>
    <script language="JavaScript" type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.min.js"></script>
    <script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
    <script language="JavaScript" type="text/javascript" src="../../js/tree.js"></script>
    <script src="/js/star-rating.js" type="text/javascript"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/layer/layer.js"></script>

    <script>
        window.onload=function () {
            //发送Ajax请求，给教员名称下拉框赋值
            $.ajax({
                url:"/UserInfoServlet?action=findClassCondition",
                type:"post",
                dataType:"json",
                success:function (data) {
                    //拼接数据
                    $('#selClasses').append("<option>"+data.dicname+"</option>");
                    getTeacherByDicId(data.dicid);
                }
            });
        }
        function getTeacherByDicId(dicid) {
            //发送Ajax请求，给教员名称下拉框赋值
            $.ajax({
                url:"/UserInfoServlet?action=findTeacherCondition",
                type:"post",
                data:{"cid":dicid},
                dataType:"json",
                success:function (data) {
                    //拼接数据
                    $.each(data,function(i,item) {
                        $('#selTeacher').append("<option>"+item.uname+"</option>");
                    })
                }
            });
        }

        /*获取纯文本*/
        function getContentTxt() {
            var arr = [];
            arr.push(UE.getEditor('editor').getContentTxt());
            layer.open({
                type: 1,
                skin: 'layui-layer-rim', //加上边框
                shadeClose: true,//点击阴影部分，是否能关闭弹层
                area: ['480px', '280px'], //宽高
                content: arr.join("\n")
            });
        }
        /*设置为可以编辑*/
        function setEnabled() {
            UE.getEditor('editor').setEnabled();
            enableBtn();
        }
        /*设置为不可以编辑*/
        function setDisabled() {
            UE.getEditor('editor').setDisabled('fullscreen');
            disableBtn("enable");
        }

    </script>

</head>


<body>
<table width="98%" border="0" cellspacing="0" cellpadding="0">
    <tr>
        <td height="25" class="F01"><p><img src="../../images/index_35.gif" width="15" height="16" align="absmiddle">学员对教员授课评估表</p>
        </td>
    </tr>
    <tr>
        <td height="2" background="../../images/index_39.gif"><img src="../../images/spacer.gif" width="1" height="1"></td>
    </tr>
</table>
<div style="margin: 20px;">
    <form action="/Teach?action=pingfen" method="post">
    <span>教员名称：</span>
    <select id="selTeacher">
        <%--<option>刘亚超</option>
        <option>李祥云</option>--%>
    </select>
    <span>所带班级：</span>
    <select id="selClasses">

    </select>
    <span>培训课程名称：</span><input name="courseName"/>

    <span style="margin-bottom: 20px;margin-right: 20px;">评价人:<input name="assertName" style="text-align:center;border:0px;border-bottom: 1px solid black;"/></span>
    <fieldset>
        <legend>学员对教员授课评估表</legend>
        此次问卷是调研学员对教员授课水平、授课方式等进行打分，方便我们了解教员日常授课水平以及提升方向。<br/>
        打分说明：9-10分优秀；7-8分良好；6分及格；5分以下不及格，0分为极差。<br/>
        特别提示：本次问卷采用匿名调研，请您按实际情况反馈，谢谢合作！

        <ol>
            <li>请对教员授课期间专业化形象打分，从教员妆容、制服（衣着）、配饰等方面进行评定</li>

            <li>请对教员的语言表达进行打分，从语速、发音、普通话等方面进行评定</li>
            <li>请对教员课堂呈现进行打分，从教员授课技巧、活动组织、教学演示等方面进行评定</li>
            <li>请对教员授课内容进行打分，从知识点讲解、重难点讲解、授课内容是否容易掌握进行评定</li>
            <li>请对教员师德师风进行打分，从正能量传递、关注课堂纪律，授课是否有激情方面进行评定</li>
            <div>
                <input id="kartik" class="rating" name="pingf" data-stars="10" data-step="0.1" title=""/>
                <input type="hidden" value="${stuid}" name="sid">
            </div>
            <li>对教员授课相关的其他建议
                <%--Ueditor编辑器位置--%>
                <textarea id="editor" style="width: 90%;height:400px;"></textarea>
                <%--设置Ueditor功能--%>
                <input type="button" class="btn btn-default" onclick="getContentTxt()" value="获得纯文本"/>
                <input type="button" class="btn btn-default" id="enable" onclick="setEnabled()" value="可以编辑">
                <input type="button" class="btn btn-default" onclick="setDisabled()" value="不可编辑">
            </li>
        </ol>
        <div class="form-group" style="margin-top:10px">
            <%--提价表单--%>
            <button type="submit" class="btn btn-primary">提交</button>
            <%--清除页面--%>
            <input type="reset" class="btn btn-default" onclick="clearLocaldata()" value="重置">
        </div>
        <%--<input type="button" value="提交"/>--%>
    </fieldset>
    </form>
</div>


<script>
    jQuery(document).ready(function () {
        $('.btn-primary').on('click', function () {
            $("#kartik").rating('destroy');
             var name= $("#kartik").val();
             alert(name);
        });


        $('.btn-default').click(function () {
            var clear = UE.getEditor('editor');
            clear.setContent('');

        });
    });


</script>

<script type="text/javascript" src="/ueditor/ueditor.config.js"></script>
<script type="text/javascript" src="/ueditor/ueditor.all.min.js"> </script>
<!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
<!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
<script type="text/javascript" src="/ueditor/lang/zh-cn/zh-cn.js"></script>
<script type="text/javascript">
    //实例化编辑器
    //建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
    var ue = UE.getEditor('editor');
</script>
</body>
</html>
