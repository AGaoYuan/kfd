<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>权限管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<!-- 配置文件 -->  
    <script type="text/javascript" src="bootstrap/js/ajax.js"></script> 
    <jsp:include page="/console/common/css.jsp" />
 	<jsp:include page="/console/common/js.jsp" /> 
  </head>
  
  <body>
    <jsp:include page="/console/common/console-header.jsp" />
    <!-- 内容 -->
	<div id="page-wrapper">
    	<div id="page-inner">
     		<div id="searchDiv">
     			<form class="form-inline" action="servlet/SearchUserServlet">
     				<div class="form-group">
    					<label class="sr-only" for="usernmae">Search</label>
    					<div class="input-group">
      						<div class="input-group-addon">@</div>
      						<input type="text" class="form-control" id="username" name="username" placeholder="输入用户名"/>
      						<div class="input-group-addon">.scau</div>
    					</div>
     				</div>
     				<button type="submit" class="btn btn-primary">点我搜索</button>
     			</form>
     			<hr/>
     		</div>
     		<div id="infoDiv">
     			<table class="table table-striped">
     				<tr>
     					<th>用户名</th>
     					<th>姓名</th>
     					<th>发布新闻权限</th>
     					<th>发布通知权限</th>
     				</tr>
     				
     				<c:forEach items="${users}" var="list">
     					<tr>
     						<td>${list.username}</td>
     						<td>${list.name }</td>
     						<td >
     							<c:if test="${list.isNews ==1}">
     								<button class="btn btn-danger" value="closeNews" onclick="authorityChange(this,'${list.username}');">关闭</button>
     							</c:if>
     							<c:if test="${list.isNews ==0}">
     								<button class="btn btn-info" value="openNews" onclick="authorityChange(this,'${list.username}');">开启</button>
     							</c:if>
     						</td>
     						<td >
     							<c:if test="${list.isNotice ==1}">
     								<button class="btn btn-danger"  value="closeNotice" onclick="authorityChange(this,'${list.username}');">关闭</button>
     							</c:if>
     							<c:if test="${list.isNotice ==0}">
     								<button class="btn btn-info" value="openNotice" onclick="authorityChange(this,'${list.username}');">开启</button>
     							</c:if>
     						</td>		
     					</tr>				     				
     				</c:forEach>
     			</table>
     		</div>
    	</div>
    </div>
  </body>
</html>

<%
	//清除session,释放空间
	session.removeAttribute("users");
 %>
