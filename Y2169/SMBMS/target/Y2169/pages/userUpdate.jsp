<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>超市账单管理系统</title>
    <link rel="stylesheet" href="pages/css/public.css"/>
    <link rel="stylesheet" href="pages/css/style.css"/>
</head>
<body>
<!--头部-->
<header class="publicHeader">
    <h1>超市账单管理系统</h1>

    <div class="publicHeaderR">
        <p><span>下午好！</span><span style="color: #fff21b"> ${user.userName}</span> , 欢迎你！</p>
        <a href="/UserServlet?action=logout">退出</a>
    </div>
</header>
<!--时间-->
<section class="publicTime">
    <span id="time">2015年1月1日 11:11  星期一</span>
    <a href="#">温馨提示：为了能正常浏览，请使用高版本浏览器！（IE10+）</a>
</section>
<!--主体内容-->
<section class="publicMian ">
    <div class="left">
        <h2 class="leftH2"><span class="span1"></span>功能列表 <span></span></h2>
        <nav>
            <ul class="list">
                <li><a href="billList.jsp">账单管理</a></li>
                <li ><a href="providerList.jsp">供应商管理</a></li>
                <li id="active"><a href="/UserServlet?action=user">用户管理</a></li>
                <li><a href="password.jsp">密码修改</a></li>
                <li><a href="/UserServlet?action=logout">退出系统</a></li>
            </ul>
        </nav>
    </div>
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>用户管理页面 >> 用户修改页面</span>
        </div>
        <div class="providerAdd">
            <form action="/UserServlet?action=update" method="post">
                <!--div的class 为error是验证错误，ok是验证成功-->
                <div>
                    <label for="userName">用户名称：</label>
                    <input type="text" name="userName" id="userName" value="${USER.userName}" placeholder=""/>
                    <span >*</span>
                </div>

                <div>
                    <label >用户性别：</label>
                    <select name="gender">
                        <option value="2" <c:if test="${USER.gender==2}">selected</c:if>>男</option>
                        <option value="1" <c:if test="${USER.gender==1}">selected</c:if>>女</option>
                    </select>
                </div>
                <div>
                    <label for="data">出生日期：</label>
                    <input type="date" name="data" id="data" value="${birthday}" placeholder=""/>
                    <span >*</span>
                </div>
                <div>
                    <label for="userphone">用户电话：</label>
                    <input type="text" name="userphone" id="userphone" value="${USER.phone}" placeholder=""/>
                    <span >*</span>
                </div>
                <div>
                    <label for="userAddress">用户地址：</label>
                    <input type="text" name="userAddress" id="userAddress" value="${USER.address}" placeholder=""/>
                </div>
                <div>
                    <label >用户类别：</label>
                    <input type="radio" name="userRole" value="1" <c:if test="${USER.userRole==1}">checked</c:if>/>管理员
                    <input type="radio" name="userRole" value="2" <c:if test="${USER.userRole==2}">checked</c:if>/>经理
                    <input type="radio" name="userRole" value="3" <c:if test="${USER.userRole==3}">checked</c:if>/>普通用户

                    <input type="hidden" name="Uid" value="${USER.id}">
                </div>
                <div class="providerAddBtn">
                    <!--<a href="#">保存</a>-->
                    <!--<a href="userList.html">返回</a>-->
                    <input type="submit" value="保存" onclick="history.back(-1)"/>
                    <input type="button" value="返回" onclick="history.back(-1)"/>
                </div>
            </form>
        </div>

    </div>
</section>
<footer class="footer">
    版权归北大青鸟
</footer>
<script src="pages/js/time.js"></script>

</body>
</html>