<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 张
  Date: 2018/11/7
  Time: 14:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<link rel="stylesheet" href="/layui/css/layui.css">
<script type="text/javascript" src="js/jQuery1.11.1.js"></script>
<script src="/layui/layui.js"></script>
<script src="/layui/lay/modules/laypage.js"></script>
<script src="/layui/lay/modules/layer.js"></script>

<script type="text/javascript">
    function cha () {
        var content = $('#bb').val();
        if (content==null){
            location.href="/checks?action=showlist"
        }else {
            location.href="/checks?action=showlist&tvalue="+content
        }
    }
</script>

<style type="text/css">
    td {
        font-size: 20px;
        border-style: solid;
        border-width: 1.5px;
        text-align: center;
    }

    h2  {
        text-align: center;
    }
    h3
    {
        text-align: center;
    }

    table {
        margin: 10px auto;
    }

    body {
        background: cornflowerblue;
    }
    #PageSpace{
        text-align: center;
    }
</style>

<html>
<head>
    <title>Title</title>
</head>
<body>
<div class=main>
    <h2>常见问题检索</h2>

    <form action="/checks?action=showlist" method="post">
    <h3>请输入关键字检索：<input type="text" name="tvalue" id="bb"><input onclick="subForm()" type="button" value="确定" ><a href="/insertpro.jsp">添加常见问题</a></h3>
    </form>
    <table id="tb">
        <tr>
            <td>编号</td>
            <td>标题</td>
            <td>分类</td>
            <td>创建时间</td>
        </tr>

<%--        <c:forEach items="${list}" var="pro">
<tr>
            <td> <c:out value="${pro.id}"/></td>
            <td> <c:out value="${pro.title}"/></td>
            <td> <c:if test="${pro.classid==1}">Java</c:if>
                 <c:if test="${pro.classid==2}">C#/.NET</c:if>
                 <c:if test="${pro.classid==3}">C语言</c:if>
            </td>
            <td> <c:out value="${pro.createdate}"/></td>
        </c:forEach>
</tr>--%>

    </table>
    <%--设置Layui分页插件位置--%>
    <div id="PageSpace"></div>
</div>

<script type="text/javascript">
    //窗体加载事件
    var bb = null;
    window.onload=function(){
        //调用Ajax方法分页显示数据(1是当前页数)
        getListnews(1,bb);
        //toPage(1);
        //设置表格隔行变色
        $('#tb tr:odd').css("backgroundColor","pink");


    }
    //定义一个当前页数给分页插件使用,插件选中的页数，初始值为1
    var currentPageAllAppoint=1;

    function subForm() {
        bb = $('#bb').val();
        alert(bb);
        getListnews(1,bb);
    }

    //分页方法传当前页数
    function getListnews(pageNo,bb){
        $.ajax({
            type: "Post",  //请求方式为post
            url:"/checks?action=showlist",//请求servlet地址
            data:{"PageIndex":pageNo,"tvalue":bb}, /* 传的数据,可以是多个参数,我这里就传一个当前页数给servlet*/
            dataType:"json", //数据格式为json
            success:function(data){ //返回的数据"data"

                $("#tb #mtr").remove();
                //定义一个变量接受总数据行数，后面分页插件要使用
                var totalPageAllAppoint=data.totalRecords;
                //调用分页方法，把总数据行数往下传
                toPage(totalPageAllAppoint);
                //循环遍历数据
                $.each(data.list,function(i,item){
                    var type=item.classid==1?"Java":item.classid==2?"C#/.NET":item.classid==3?"C语言":"";
                    //append 追加显示数据
                    $("#tb").append(
                        "<tr id='mtr'>"+
                        "<td id='mtd'>"+item.id+ "</td>"+
                        "<td id='mtd'>"+item.title+
                        "</td>"+
                            "<td id='mtd'>"+type+"</td>"+
                        "<td id='mtd'>"+item.createdate+"</td>"+
                    "</tr>"
                    );
                })
                //请求失败走的函数
            },error:function(data){
                alert("请求失败");
            }
        });
    }

    //layui分页插件方法
    function toPage(totalPageAllAppoint){
        layui.use(['laypage','layer'],function(){
            var laypage=layui.laypage  //调插件
                ,layer=layui.layer;
            laypage.render({
                elem:'PageSpace'       //这里很重要     是将插件绑定到哪里   我绑定的是   “approve”  注意，这是id，不用写#approve
                ,count: totalPageAllAppoint  //这是传回来的总行数   ，插件内部会计算页数
                ,limit:2               //这是每页显示多少行，大小要跟你后台传回来的数据数量一样
                ,layout: ['count', 'prev', 'page', 'next', 'refresh', 'skip' ]
                ,groups:5               //这个自己看文档
                ,prev: '<em>←</em>'//这个自己看文档
                ,next: '<em>→</em>'//这个自己看文档
                ,theme: '#5d9aff'
                ,curr:currentPageAllAppoint  //这个很重要，  是分页选中的标识，上面的全局变量用在这里
                ,jump: function(obj,first){   //这个是获取插件的一些属性和值   点击页号的时候执行的函数  obj 包含了当前分页的所有参数 比如  console.log(obj.curr)
                    if(!first){               //必须要写一个判断，不然会循环调用  首次不执行，点击的时候才执行
                        var pageNo=obj.curr;   //这个是将选中的页数赋值给全局变量，然后下面的Ajax方法里面需要用到
                        currentPageAllAppoint=obj.curr;
                        getListnews(pageNo);  //调用Ajax分页方法，将选中的页数传到方法给后台
                    }
                }
            });
        });
    }
</script>
</body>
</html>
