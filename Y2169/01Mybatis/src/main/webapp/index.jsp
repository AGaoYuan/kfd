<%@ page import="cn.happy.entity.UserInfo" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<html>
<body>
<%
    List<UserInfo> list = (List<UserInfo>) request.getAttribute("list");
    for (UserInfo item:list) {

%>
<h2><%= item.getUname() %></h2>
<%
    }%>
</body>
</html>
