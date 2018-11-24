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


</style>

<html>
<head>
    <title>Title</title>
</head>
<body>
<div class=main>
    <h2>添加新问题</h2>

            <form action="/checks?action=add" method="post">
                <h3>分类：<input type="text" name="type" ></h3>
                <h3>标题：<input type="text" name="title" ></h3>
                <h3>内容：<input type="text" name="con" ></h3>

               <h3><input type="submit" value="确定" ></h3>

            </form>

</div>

</body>
</html>
