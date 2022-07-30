<%--
  Created by IntelliJ IDEA.
  User: gp
  Date: 2020/1/17
  Time: 23:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <meta charset="utf-8">
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.8.3.js"></script>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>Title</title>

    <script>
        $(function () {
            $.post("queryTypeAll.do",function (data) {
                var str = "";
                for (var i in data) {
                    str+="<option value='"+data[i].tid+"'>"+data[i].tname+"</option>"
                }

                $("#tid").append(str)

                $("#tid").val(${goods.type.tid})
            },"json")
        })
    </script>
</head>
<body>
    <form action="updateGoods.do" method="post" enctype="multipart/form-data">
        <input type="hidden" name="gid" value="${goods.gid }">
        商品名称：<input type="text" name="gname" value="${goods.gname}"><br>
        商品图片：<input type="file" name="file">
                <img alt="" width="60px" height="40px" src="lookImg.do?imgPath=${goods.image}">
                <br>
        商品描述：<textarea rows="10" cols="50" name="introduction">${goods.introduction}</textarea><br>
        商品价格：<input type="text" name="price" value="${goods.price}"><br>
        生产日期：<input type="date" name="gdate" value="${goods.gdate}"><br>
        商品类型：<select id="tid" name="type.tid" >
        <option>请选择商品类型</option>
    </select><br>
        <input type="submit" value="修改" >
    </form>
</body>
</html>
