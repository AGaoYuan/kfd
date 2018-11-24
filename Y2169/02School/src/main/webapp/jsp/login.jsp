<%@ page language="java" contentType="text/html; utf-8" isELIgnored="false" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>信息管理系统</title>
  <link rel="stylesheet" href="../css/login.css">
  <script type="text/javascript" src="../js/jquery.min.js"></script>
</head>
<body class="login-bg">
    <canvas id="fullstarbg">你的浏览器不支持canvas标签</canvas>
    <div class="login">
        <div class="message">信息管理系统登录</div>
        <div id="darkbannerwrap"></div>   
        <form method="post" class="layui-form" action="/UserInfoServlet?action=login">
            <input name="uname" value="微冷的雨" placeholder="用户名"  type="text" lay-verify="required" class="layui-input" >
            <hr class="hr15">
            <input name="upwd" value="1" lay-verify="required" placeholder="密码"  type="password" class="layui-input">
            <hr class="hr15">
            <input value="登录" lay-submit lay-filter="login" style="width:100%;" type="submit">
            <hr class="hr20" >
        </form>
    </div>


</body>
</html>