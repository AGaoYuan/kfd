<h1>第一个使用freemarker做的Ftl页面</h1>
${name}------${age}----

<#if sex="0">
男
<#else>
女
</#if>
<form method="post" action="/index">
    <input name="name" value="123">
    <input name="age" value="12">
    <input type="submit" value="提交">
</form>