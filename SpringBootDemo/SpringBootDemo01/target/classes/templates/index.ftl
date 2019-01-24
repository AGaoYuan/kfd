
<link rel="stylesheet" href="/layui/css/layui.css">
<script type="text/javascript" src="/layui/layui.js"></script>
<script src="/layui/lay/modules/laypage.js"></script>
<script src="/layui/lay/modules/layer.js"></script>
<script src="/js/jQuery1.11.1.js"></script>
<script type="text/javascript">

    window.onload=function(){
        //调用Ajax方法分页显示数据(1是当前页数)
        getPageLists(1,null);
        //toPage(1);

        $('#myin').click(function () {
            $('.ap').toggle();
        })
    }

    function subForm() {
        var uname = $('#title').val();
        /*alert(uname);*/
        getPageLists(1,uname);
    }



    //分页方法传当前页数
    function getPageLists(pageNo,uname){
        $.ajax({
            type: "post",  //请求方式为post
            url:"/userList",//请求servlet地址
            data:{"PageIndex":pageNo,"uname":uname}, /* 传的数据,可以是多个参数,我这里就传一个当前页数给servlet*/
            dataType:"json", //数据格式为json
            success:function(data){ //返回的数据"data"
                $("#mytable #mtr").remove();
                //定义一个变量接受总数据行数，后面分页插件要使用
                var totalPageAllAppoint=data.total;
                //调用分页方法，把总数据行数往下传
                toPage(totalPageAllAppoint,uname);
                //循环遍历数据
                $.each(data.list,function(i,item){
                    //append 追加显示数据
                    $("#mytable").append(
                            "<tr id='mtr'>"+
                            "<td>"+item.title+"</td>"+
                            "<td>"+item.summary+"</td>"+
                            "<td><p class='ap'>"+item.author+"</p></td>"+
                            "<td>"+item.createdate+"</td>"+
                            "</tr>"
                    );
                })
                //请求失败走的函数
            },error:function(data){
                /*alert(data.total);*/
                alert("请求失败");
            }
        });
    }

    //定义一个当前页数给分页插件使用,插件选中的页数，初始值为1
    var currentPageAllAppoint=1;

    //layui分页插件方法
    function toPage(totalPageAllAppoint,uname){
        layui.use(['laypage','layer'],function(){
            var laypage=layui.laypage  //调插件
                    ,layer=layui.layer;
            laypage.render({
                elem:'PageSpace'       //这里很重要     是将插件绑定到哪里   我绑定的是   “approve”  注意，这是id，不用写#approve
                ,count: totalPageAllAppoint  //这是传回来的总行数   ，插件内部会计算页数
                ,limit:2               //这是每页显示多少行，大小要跟你后台传回来的数据数量一样
                ,layout: ['count', 'prev', 'page', 'next', 'refresh', 'skip' ]
                ,groups:5               //这个自己看文档
                ,first: '首页'
                ,prev: '<em>←</em>'//这个自己看文档
                ,next: '<em>→</em>'//这个自己看文档
                ,last: '尾页'
                ,theme: '#5d9aff'
                ,curr:currentPageAllAppoint  //这个很重要，  是分页选中的标识，上面的全局变量用在这里
                ,jump: function(obj,first){   //这个是获取插件的一些属性和值   点击页号的时候执行的函数  obj 包含了当前分页的所有参数 比如  console.log(obj.curr)
                    if(!first){               //必须要写一个判断，不然会循环调用  首次不执行，点击的时候才执行
                        var pageNo=obj.curr;   //这个是将选中的页数赋值给全局变量，然后下面的Ajax方法里面需要用到
                        currentPageAllAppoint=obj.curr;
                        getPageLists(pageNo,uname);  //调用Ajax分页方法，将选中的页数传到方法给后台
                    }
                }
            });
        });
    }
</script>
<style type="text/css">
    #mydiv{
        text-align: center;
    }

</style>

<div id="mydiv">
    <#--<form method="post" action="/findByName">-->
        帖子标题：<input type="text" id="title" name="title">
        <input type="button" onclick="subForm()" value="查询"/>
        <input type="button" id="myin"  value="显示隐藏"/>
    <#--</form>-->

    <table id="mytable" align="center" valign="center" border="1">
        <tr>
            <td>标题</td>
            <td>内容摘要</td>
            <td>作者</td>
            <td>发布时间</td>
        </tr>

 <#--   <#list Reallist as item>
        <tr>
            <td>${item.id}</td>
            <td>${item.projectName}</td>
            <td>${item.name}</td>
            <td>${item.cardId}</td>
            <td>${item.houseType}</td>
            <td>${item.area}</td>
            <td>${item.buildTime?string("yyyy-MM-dd")}</td>
        </tr>
    </#list>-->
    </table>
    <div id="PageSpace"></div>

</div>

