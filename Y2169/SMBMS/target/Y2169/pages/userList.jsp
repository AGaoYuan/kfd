<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>超市账单管理系统</title>
    <link rel="stylesheet" href="pages/css/public.css"/>
    <link rel="stylesheet" href="pages/css/style.css"/>

    <script type="text/javascript" src="js/jquery.js"></script>

    <script type="text/javascript">
        function del(id){
            $('#url').val(id);
            $('.zhezhao').css('display', 'block');
            $('#removeUse').fadeIn();
        }

        function urlSubmit(){
            var  id=$('#url').val();
            location.href="/UserServlet?action=deleteUser&id="+id;
        }
        
        function findUser() {
            $('#findForm').submit();
        }
        
    </script>

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
                    <li><a href="providerList.jsp">供应商管理</a></li>
                    <li  id="active"><a href="/UserServlet?action=user">用户管理</a></li>
                    <li><a href="password.jsp">密码修改</a></li>
                    <li><a href="/UserServlet?action=logout">退出系统</a></li>
                </ul>
            </nav>
        </div>
        <div class="right">
            <div class="location">
                <strong>你现在所在的位置是:</strong>
                <span>用户管理页面</span>
            </div>
            <div class="search">
                <form id="findForm" action="/UserServlet?action=user" method="post">
                <span>用户名：</span>
                <input type="text" name="uname" value="${Uname==null?"":Uname}" placeholder="请输入用户名"/>
                <input type="button" onclick="findUser()" value="查询"/>
                    <a href="pages/userAdd.jsp">添加用户</a>
                </form>
            </div>
            <!--用户-->
            <table class="providerTable" cellpadding="0" cellspacing="0">
                <tr class="firstTr">
                    <th width="10%">用户编码</th>
                    <th width="20%">用户名称</th>
                    <th width="10%">性别</th>
                    <th width="10%">年龄</th>
                    <th width="10%">电话</th>
                    <th width="10%">用户类型</th>
                    <th width="30%">操作</th>
                </tr>
                <c:forEach items="${list}" var="item">
                <tr>
                    <td>${item.userCode}</td>
                    <td>${item.userName}</td>
                    <td>${item.gender>1?"男":"女"}</td>
                    <td>${item.age}</td>
                    <td>${item.phone}</td>
                    <td><c:if test="${item.userRole==1}">
                        系统管理员
                        </c:if>
                        <c:if test="${item.userRole==2}">
                            经理
                        </c:if>
                        <c:if test="${item.userRole==3}">
                            普通员工
                        </c:if>
                    </td>
                    <td>
                        <a href="/UserServlet?action=findUser&uid=${item.id}"><img src="pages/img/read.png" alt="查看" title="查看"/></a>
                        <a href="/UserServlet?action=updatefinduser&uid=${item.id}"><img src="pages/img/xiugai.png" alt="修改" title="修改"/></a>
                        <a href="#" class="removeUser" onclick="del(${item.id})"><img src="pages/img/schu.png" alt="删除" title="删除"/></a>
                    </td>
                </tr>
                </c:forEach>
            </table>

        </div>
    </section>

<!--点击删除按钮后弹出的页面-->
<div class="zhezhao"></div>
<div class="remove" id="removeUse">
    <div class="removerChid">
        <h2>提示</h2>
        <div class="removeMain">
            <input type="hidden" id="url"/>
            <p>你确定要删除该用户吗？</p>
            <a href="#" onclick="urlSubmit()" id="yes">确定</a>
            <a href="#" id="no">取消</a>
        </div>
    </div>
</div>

    <footer class="footer">
        版权归北大青鸟
    </footer>

<script src="pages/js/jquery.js"></script>
<script src="pages/js/js.js"></script>
<script src="pages/js/time.js"></script>

</body>
</html>