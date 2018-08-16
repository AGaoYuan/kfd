    //定义全局变量记录页码信息
     var globalDate = {};
     //1页显示两条数据
     globalDate.pageSize=2;
     $(function () {
          //查询数据
         search();

     });
     //查询数据
     function search(date) {
         var str = "";
         $.ajax({
             type: "post",
             url: "<%=basePath%>mytlist.html",
             dataType: "json",
             async: true,
             data: date,
             success: function (data) {
                 if (data.result) {
                     var mydata = data.obj.list;
                     for (var i = 0; i < mydata.length; i++) {
                         var info = mydata[i];
                         str += "<li>";
                         str += "<a onclick=" + "doctorDetail(‘" + info.id + "‘)" + ">";
 //                        str+="<a href=‘mytdoctor_xq.html?id=‘"+info.id+">";
                         str += "<img src=" + info.photo + ">";
                         str += "<div class=‘yi_text‘>";
                         str += "<h2>" + info.name;
                         str += "<span>" + info.title + "</span>";
                         str += "</h2>";
                         str += "<h3>科室：" + info.department_one + "</h3>";
                         str += "<h3>";
                         str += "<em>评分：</em>";
                         str += "<span>";
                         if (info.total_score != null && info.total_score != "" && info.total_evaluate_num != null && info.total_evaluate_num != "") {
                             var pingfen = info.total_score / info.total_evaluate_num;  //评分
                             var j;
                             for (j=0; j < pingfen; j++) {
                                 str += "<img src=‘images/pc/icon_031.png‘>";
                             }
                             if(j<5){
                                 for(var k=0;k<5-j;k++){
                                     str += "<img src=‘images/pc/icon_032.png‘>";
                                 }
                             }
                         }
                         str += "</span>"
                         str += "</h3>";
                         str += "<h3>所在医院：" + info.hospital + "</h3>";
                         str += "<p>疾病擅长：" + info.skilful + "</p>";
                         str += "</div>";
                         str += "</a>";
                         str += "</li>";
                     }
                     $("#doctorUL").empty();
                     $("#doctorUL").append(str);
                     var page = data.obj.pages;  //总页数
                    var curr = data.obj.pageNum;    //当前页
                     laypage({
                         cont: "doctorDiv",  //分页需要显示的地方
                         pages: page,    //总页数
                         curr: curr,     //当前页
                         groups: 3,//连续显示分页数
                         skip: true,     //是否开启跳页
                         first: "首页",
                         last: "尾页",
                         skin:"molv",   //加载内置皮肤，也可以直接赋值16进制颜色值，如:#c00
                         prev: "<", //若不显示，设置false即可
                         next:">", //若不显示，设置false即可
                         jump: function (e, first) { //触发分页后的回调
                             if (!first) { //一定要加此判断，否则初始时会无限刷新
                                 globalDate.pageNum = e.curr;
                                 search(globalDate);
                             }
                         }
                     });
                 } else {
                     //错误
                     console.log("错误");
                 }
             }
         });
     }