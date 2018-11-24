<%@ page language="java" contentType="text/html; utf-8" isELIgnored="false" pageEncoding="utf-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>学校信息管理</title>
</head>

<frameset rows="89,*" cols="*" frameborder="no" border="0" framespacing="0">
  <frame src="${pageContext.request.contextPath}/jsp/top.jsp" name="topFrame" scrolling="No" noresize="noresize" id="topFrame" title="topFrame" />
  <frameset cols="200,10,*" frameborder="no" border="0" framespacing="0" id="oa_frame">
    <frame src="${pageContext.request.contextPath}/jsp/left.jsp" name="leftFrame" scrolling="yes" noresize="noresize" id="leftFrame" title="leftFrame" />
    <frame src="${pageContext.request.contextPath}/jsp/middle.jsp" name="middleFrame" scrolling="No" noresize="noresize" id="middleFrame" title="middleFrame" />
    <frame src="${pageContext.request.contextPath}/jsp/main.jsp" name="mainFrame" scrolling="yes" id="mainFrame" title="mainFrame" />
  </frameset>
</frameset>
<noframes><body>
</body>
</noframes></html>
