<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <title>教员评分页面</title>
    <link rel="stylesheet" type="text/css" href="http://www.jq22.com/jquery/bootstrap-3.3.4.css">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
    <link href="/css/star-rating.css" media="all" rel="stylesheet" type="text/css"/>
    <!--suppress JSUnresolvedLibraryURL -->
    <script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
    <script src="/js/star-rating.js" type="text/javascript"></script>
<body>
<div class="container">
    <div class="page-header">
        <h2>请根据教员授课的状态，服装衣着，妆容等方面进行评定</h2>
    </div>
    <form action="/Teach?action=pingfen" method="post">
        <input id="kartik" class="rating" name="pingf" data-stars="5" data-step="0.1" title=""/>
       <input type="hidden" value="${stuid}" name="sid">
        <div class="form-group" style="margin-top:10px">
            <button type="submit" class="btn btn-primary">提交</button>
            <button type="reset" class="btn btn-default">重置</button>
        </div>
    </form>
    <hr>
    <script>
        jQuery(document).ready(function () {
            $('.btn-primary').on('click', function () {
                $("#kartik").rating('destroy');
               /* var name= $("#kartik").val();
                alert(name)*/
            });
        });
    </script>
</div>
</body>
</html>
