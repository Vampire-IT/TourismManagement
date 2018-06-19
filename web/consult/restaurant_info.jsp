<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*,java.lang.*" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>饭店查询详细</title>
    <link rel="stylesheet" type="text/css" href="../resources/css/page.css"/>
    <script type="text/javascript" src="../resources/js/jquery-1.9.0.min.js"></script>
    <script type="text/javascript" src="../resources/js/main.js"></script>
</head>

<body>
<div class="navBar">
    首页 &gt;饭店查询
</div>
<table border="0" cellpadding="0" cellspacing="1" class="form">
    <tr>
        <th colspan="6">饭店信息</th>
    </tr>
    <tr>
        <td width="100px" class="title">饭店名称：</td>
        <td>${restaurant.rName}&nbsp;</td>
        <td width="100px" class="title">人均价格：</td>
        <td>${restaurant.rAvgPrice}元<br/></td>
        <td width="100px" class="title">联系电话：</td>
        <td>${restaurant.rTel}</td>
    </tr>
    <tr>
        <td class="title">饭店网址：</td>
        <td>${restaurant.rUrl}</td>
        <td class="title">乘车路线：</td>
        <td>${restaurant.rBusRoute}</td>
        <td class="title">停车位：</td>
        <td>${restaurant.rParkSpace}个</td>
    </tr>
    <tr>
        <td class="title">营业时间：</td>
        <td>${restaurant.rOpening}</td>
        <td class="title">饭店地址：</td>
        <td colspan="3">${restaurant.rAddr}</td>
    </tr>
</table>
<table border="0" cellpadding="0" cellspacing="1" class="form" style="margin-top:-1px;">
    <tr>
        <td width="100px" class="title">酒店介绍：</td>
        <td>${restaurant.rDesc}
        </td>
    </tr>
    <%--<tr>--%>
        <%--<td class="title">图片：</td>--%>
        <%--<td><img src="../resources/images/others/xianggelila2.png" width="279" height="204"/></td>--%>
    <%--</tr>--%>
</table>
<div class="buttonLine" style="clear:left;clear:right">
    <input type="button" value="返回" onclick="location.href='/RestServlet'"/>
</div>
</body>
</html>

