<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*,java.lang.*" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>景区查询详细</title>
    <link rel="stylesheet" type="text/css" href="../resources/css/page.css"/>
    <script type="text/javascript" src="../resources/js/jquery-1.9.0.min.js"></script>
    <script type="text/javascript" src="../resources/js/main.js"></script>
</head>

<body>
<div class="navBar">
    首页 &gt;景区查询
</div>
<table border="0" cellpadding="0" cellspacing="1" class="form">
    <tr>
        <th colspan="6">景区信息</th>
    </tr>
    <tr>
        <td width="100" class="title">景区名称：</td>
        <td>${scenic.sName}</td>
        <td width="100" class="title">景区类别：</td>
        <td>${scenic.sType}</td>
        <td width="100" class="title">标准价格：</td>
        <td>${scenic.sStanPrice}元</td>
    </tr>
    <tr>
        <td class="title">折扣价格：</td>
        <td>${scenic.sDiscPrice}元</td>
        <td class="title">联系电话：</td>
        <td>${scenic.sTel}<br/></td>
        <td class="title">景区网址：</td>
        <td>${scenic.sUrl}</td>
    </tr>
    <tr>
        <td class="title">乘车路线：</td>
        <td>${scenic.sBusRoute}</td>
        <td class="title">停车位：</td>
        <td>${scenic.sParkSpace}个</td>
        <td class="title">营业时间：</td>
        <td>${scenic.sOpening}</td>
    </tr>
</table>
<table border="0" cellpadding="0" cellspacing="1" class="form" style="margin-top:-1px;">
    <tr>
        <td width="100px" class="title">景区地址：</td>
        <td>${scenic.sAddr}</td>
    </tr>
    <tr>
        <td class="title">景区介绍：</td>
        <td>${scenic.sDesc}</td>
    </tr>
    <%--<tr>--%>
        <%--<td class="title">图片：</td>--%>
        <%--<td><img src="../resources/images/others/bashang1.png" width="339" height="276"/></td>--%>
    <%--</tr>--%>
</table>
<div class="buttonLine" style="clear:left;clear:right">
    <input type="button" value="返回" onclick="location.href='/ScenicServlet'"/>
</div>
</body>
</html>

