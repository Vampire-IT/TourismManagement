<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*,java.lang.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>住宿查询详细</title>
    <link rel="stylesheet" type="text/css" href="../resources/css/page.css"/>
    <script type="text/javascript" src="../resources/js/jquery-1.9.0.min.js"></script>
    <script type="text/javascript" src="../resources/js/main.js"></script>
</head>

<body>
<div class="navBar">
    首页 &gt; 住宿查询
</div>
<table border="0" cellpadding="0" cellspacing="1" class="form">
    <tr>
        <th colspan="6">酒店信息</th>
    </tr>
    <tr>
        <td width="100px" class="title">酒店名称：</td>
        <td>${hotel.hName}&nbsp;</td>
        <td width="100px" class="title">酒店星级：</td>
        <td>${hotel.hRating}</td>
        <td width="100px" class="title">标准价格：</td>
        <td>${hotel.hStanPrice}元</td>
    </tr>
    <tr>
        <td class="title">折扣价格：</td>
        <td>${hotel.hDiscPrice}元</td>
        <td class="title">联系电话：</td>
        <td>${hotel.hTel}<br/></td>
        <td class="title">酒店网址：</td>
        <td>${hotel.hUrl}</td>
    </tr>
    <tr>
        <td class="title">乘车路线：</td>
        <td>${hotel.hBusRoute}</td>
        <td class="title">停车位：</td>
        <td>${hotel.hParkSpace}个</td>
        <td class="title">营业时间：</td>
        <td>${hotel.hOpening}</td>
    </tr>
</table>
<table border="0" cellpadding="0" cellspacing="1" class="form" style="margin-top:-1px;">
    <tr>
        <td width="100px" class="title">酒店地址：</td>
        <td>${hotel.hAddr}</td>
    </tr>
    <tr>
        <td class="title">酒店介绍：</td>
        <td>${hotel.hDesc}
        </td>
    </tr>
    <%--<tr>--%>
        <%--<td class="title">图片：</td>--%>
        <%--<td><img src="../resources/images/others/xianggelila2.png" width="279" height="204"/></td>--%>
    <%--</tr>--%>
</table>
<div class="buttonLine" style="clear:left;clear:right">
    <input type="button" value="返回" onclick="location.href='/HotelServlet'"/>
</div>
</body>
</html>

