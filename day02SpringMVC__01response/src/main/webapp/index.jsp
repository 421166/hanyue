<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020/8/21
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>标题</title>
    <script src="./js/jquery-3.3.1.min.js"></script>
    <script>
        $(function () {
            //发送ajax请求
            $("#btn").click(function () {
                //alert("haha");
              /* $.post("user/testAjax",{"username":"hehe","password":"123","age":12},function (data) {
                    //应该获取服务器响应的json数据  然后进行解析
                    alert(data.username);
                    alert(data.age);
                },"application/json");*/
                *$.ajax({
                    type:"post",
                    url:"user/testAjax",
                    contentType:"application/json;charset=utf-8",
                    data:'{"username":"hehe","password":"123","age":12}',
                    dataType:"json",
                    success:function (data) {
                        //应该获取服务器响应的json数据  然后进行解析
                        alert(data.username);
                        alert(data.age);
                    }
                });
            });
        });
    </script>
</head>
<body>
     <a href="user/testString">testString</a>
     <hr>
     <a href="user/testVoid">testVoid</a>
     <hr>
     <a href="user/testModelAndView">testModelAndView</a>
     <hr>
     <a href="user/testForwardOrRedirect">testForwardOrRedirect</a>
     <hr>
     <button id="btn">发送ajax请求</button>
</body>
</html>
