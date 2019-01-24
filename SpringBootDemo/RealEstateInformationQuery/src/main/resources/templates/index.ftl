
<style type="text/css">
    #mydiv{
        text-align: center;
    }

</style>

<div id="mydiv">
    <form method="post" action="/findByName">
             帖子标题：<input type="text" name="title">
        <input type="submit" value="查询"/>
    </form>

<table id="mytable" align="center" valign="center" border="1">
    <tr>
        <td>ID</td>
        <td>项目名称</td>
        <td>产权人</td>
        <td>身份证号</td>
        <td>房屋类型</td>
        <td>使用面积</td>
        <td>建造时间</td>
    </tr>

<#list Reallist as item>
<tr>
    <td>${item.id}</td>
    <td>${item.projectName}</td>
    <td>${item.name}</td>
    <td>${item.cardId}</td>
    <td>${item.houseType}</td>
    <td>${item.area}</td>
    <td>${item.buildTime?string("yyyy-MM-dd")}</td>
</tr>
</#list>
</table>

</div>

