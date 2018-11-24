<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 张
  Date: 2018/11/7
  Time: 14:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<script type="text/javascript" src="js/jquery-migrate-1.2.0.js"></script>
<script type="text/javascript" src="js/jQuery1.11.1.js"></script>
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
        background: pink;
    }
</style>

<html>
<head>
    <title>Title</title>
</head>
<body>
<div class=main>
    <h2>常见问题检索</h2>

    <form action="/BookServlet?action=showlist" method="post">
    <h3>请输入图书名称检索：<input type="text" name="bookName" id="bb">
        <select id="sel" name="catename">
            <option value="请选择分类">请选择分类</option>
            <option value="国家历史">国家历史</option>
            <option value="名家作品">名家作品</option>
            <option value="四大名著">四大名著</option>
            <option value="小说">小说</option；>
        </select>
        <input type="button" onclick="find()" value="确定" ><a href="/insertpro.jsp">添加常见问题</a></h3>
    </form>
    <table id="mytab">
        <tr>
            <td>图书编号</td>
            <td>图书图片</td>
            <td>图书名称</td>
            <td>图书作者</td>
            <td>图书分类</td>
            <td>图书价格</td>
            <td>发布时间</td>
        </tr>
      <%--  <c:forEach items="${list}" var="pro">
<tr>
            <td> <c:out value="${pro.id}"/></td>
            <td> <c:out value="${pro.title}"/></td>
            <td> <c:out value="${pro.content}"/></td>
            <td> <c:out value="${pro.createdate}"/></td>
        </c:forEach>
</tr>--%>
    </table>
</div>

<script type="text/javascript">

    function find() {
        var bookName = $('#bb').val();
        var sel = $('#sel').val();
        getBook(bookName,sel);
    }

    $(function () {
        find();
    });
        function getBook(bookName,sel) {
            $.ajax({
                type: "Post",  //请求方式为post
                url:"/BookServlet?action=showlist",//请求servlet地址
                data:{"catename":sel,"bookName":bookName}, /* 传的数据,可以是多个参数,我这里就传一个当前页数给servlet*/
                dataType:"json", //数据格式为json
                success:function(data){ //返回的数据"data"
                    $("#mytab #mtr").remove();
                    //循环遍历数据
                    $.each(data,function(i,item){
                        var type=null;
                        if(item.bookcategory==1){
                            type = "国家历史";
                        }else if(item.bookcategory==2){
                            type="名家作品";
                        }else if(item.bookcategory==3){
                            type="四大名著";
                        }else if(item.bookcategory==4){
                            type="小说";
                        }
                        //append 追加显示数据
                        $("#mytab").append(
                            "<tr id='mtr'>"+
                            "<td id='mtd'>"+item.bookid+ "</td>"+
                            "<td id='mtd'><img src='image/"+item.bookpicture+"'></td>"+
                            "<td id='mtd'>"+item.bookname+ "</td>"+
                            "<td id='mtd'>"+item.bookauthor+"</td>"+
                            "<td id='mtd'>"+type+"</td>"+
                            "<td id='mtd'>"+item.bookprice+"</td>"+
                            "<td id='mtd'>"+item.bookdatetime+"</td>"+
                            "</tr>"
                        );
                    })
                    //请求失败走的函数
                },error:function(data){
                    alert("请求失败");
                }
            });
        }

</script>

</body>
</html>
