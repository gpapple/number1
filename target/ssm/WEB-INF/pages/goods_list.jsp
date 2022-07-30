<%--
  Created by IntelliJ IDEA.
  User: gp
  Date: 2020/1/17
  Time: 21:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.8.3.js"></script>
<%--    <!-- 引入 Bootstrap -->--%>
<%--    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css" >--%>
<%--    <script src="<%=request.getContextPath()%>/bootstrap/js/bootstrap.min.js"></script>--%>
    <meta charset="utf-8">
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <title>Title</title>

    <script>
        function deleteGoods(gid) {
            $.post("deleteGoodsById.do",{"gid":gid},function (data) {
                if(data){
                    alert("删除成功");
                    location.href="queryGoodsAll.do";
                }
            },"json");
        }
        
        function delelteAll() {
            var gids = $("[name='gid']:checked").map(function () {
                return $(this).val();
            }).get().join(",");
            // alert(gids)
            $.post("deleteAll.do",{"gids":gids},function (data) {
                if(data=="ok"){
                    alert("批删成功")
                    location.href="queryGoodsAll.do";
                }
            })
        }
    </script>

    <script>
        $(function () {
            $("#qx").toggle(function () {
                $("[name='gid']").attr("checked",true);
            },function () {
                $("[name='gid']").attr("checked",false);
            })
        })
    </script>
</head>
<body>
   <form action="queryGoodsAll.do" method="post">
       商品名称：<input type="text" name="gname" value="${map.gname}">
       生产日期：<input type="date" name="starttime" value="${map.starttime}">~<input type="date" name="endtime" value="${map.endtime}">
       <input type="submit" value="搜索">
   </form>
    <table class="table">
        <tr>
            <td colspan="10">
                <input type="button" value="批删" onclick="delelteAll()">
                <a href="<%=request.getContextPath()%>/goods_add.jsp"><input type="button" value="添加"></a>
            </td>
        </tr>
        <tr >
            <td>
                <input type="checkbox" id="qx">
            </td>
            <td>编号</td>
            <td>商品图片</td>
            <td>商品名称</td>
            <td>商品介绍</td>
            <td>商品价格</td>
            <td>生产日期</td>
            <td>商品类型</td>
            <td>操作</td>
        </tr>

        <c:forEach items="${page.list}" var="g">
            <tr >
                <td>
                    <input type="checkbox" name="gid" value="${g.gid}">
                </td>
                <td>${g.gid}</td>
                <td>
                    <img alt="" width="60px" height="40px" src="lookImg.do?imgPath=${g.image}">
                </td>
                <td>${g.gname}</td>
                <td>${g.introduction}</td>
                <td>${g.price}</td>
                <td>${g.gdate}</td>
                <td>${g.type.tname}</td>
                <td>
                    <input type="button" value="删除" onclick="deleteGoods(${g.gid})">
                    <a href="queryGoodsById.do?gid=${g.gid}"><input type="button" value="修改"></a>
                </td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="10">
                <a href="?pageNum">首页</a>
                <a href="?pageNum=${page.pageNum-1 < 1?page.pageNum : page.pageNum-1 }">上一页</a>
                <a href="?pageNum=${page.pageNum+1 > page.totalPage?page.pageNum : page.pageNum+1 }">下一页</a>
                <a href="?pageNum=${page.totalPage }">尾页</a>
            </td>
        </tr>
    </table>
</body>
</html>
