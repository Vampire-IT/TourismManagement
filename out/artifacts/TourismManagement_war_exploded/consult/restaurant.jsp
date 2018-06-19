<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*,java.lang.*" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>饭店查询</title>
    <link rel="stylesheet" type="text/css" href="../resources/css/page.css"/>
    <script type="text/javascript" src="../resources/js/jquery-1.9.0.min.js"></script>
    <script type="text/javascript" src="../resources/js/main.js"></script>
    <script type="text/javascript" src="../resources/js/My97DatePicker/WdatePicker.js"></script>

</head>

<body>
<div class="navBar">
    首页 &gt;饭店查询
</div>
<form action="/RestServlet" method="get">
<div style="height:33px">
    &nbsp;&nbsp;地址：
    <input type="text" name="rAddr" value="${rAddr}" size="20" style="width:120px;"/>
    &nbsp;&nbsp;
    饭店名称：
    <input type="text" name="rName" value="${rName}" size="20" style="width:120px;"/>
    <input type="submit" value="查询"/>
</div>
</form>
<ul class="toolbar">
    <li><img src="../resources/images/icon/plus.png" alt=""><a href="consult/restaurant_add_edit.jsp">添加饭店</a></li>
</ul>
<table border="0" cellpadding="0" cellspacing="1" class="grid">
    <tr>
        <th>序号</th>
        <th>饭店名称</th>
        <th>人均价格</th>
        <th>联系电话</th>
        <th>饭店网址</th>
        <th>饭店地址</th>
        <th>乘车路线</th>
        <th>营业时间</th>
        <th>操作</th>
    </tr>
    <c:forEach var="rest" items="${restaurantList}" varStatus="number">
        <tr>
            <td>${number.count}</td>
            <td>${rest.rName}&nbsp;</td>
            <td>${rest.rAvgPrice}元</td>
            <td>${rest.rTel}</td>
            <td>${rest.rUrl}</td>
            <td>${rest.rAddr}</td>
            <td>${rest.rBusRoute}</td>
            <td>${rest.rOpening}</td>
            <td>
                <a href="RestServlet?action=show&rId=${rest.rId}"><input type="button" value="详细"/></a>
                <a href="RestServlet?action=query&rId=${rest.rId}"><input type="button" value="修改"/></a>
                <a href="RestServlet?action=delete&rId=${rest.rId}"><input type="button" value="删除"/></a>
            </td>
        </tr>
    </c:forEach>
</table>
<div class="navBar2" style="text-align:right">
    共 19 条记录 每页10条 当前为第1/2页 首页 | 上一页 | <a href="javascript:toPage('2')">下一页</a> | <a
        href="javascript:toPage('4')">末页</a> | 转到
    <select onchange="document.getElementById('pageNoid').value=this.value;document.getElementById('form2').submit();"
            size="1" name="pageNo">
        <option value="1" selected="selected">1</option>
        <option value="2">2</option>
        <option value="3">3</option>
        <option value="4">4</option>
        <option value="5">5</option>
        <option value="6">6</option>
        <option value="7">7</option>
        <option value="8">8</option>
        <option value="9">9</option>
        <option value="10">10</option>
    </select>
    页


</div>
</body>
</html>

