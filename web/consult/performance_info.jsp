<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*,java.lang.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>无标题文档</title>
    <link rel="stylesheet" type="text/css" href="../resources/css/page.css"/>
    <script type="text/javascript" src="../resources/js/jquery-1.9.0.min.js"></script>
    <script type="text/javascript" src="../resources/js/main.js"></script>
</head>

<body>
<div class="navBar">
    首页 &gt; 实景演出查询
</div>

<table border="0" cellpadding="0" cellspacing="1" class="form">
    <tr>
        <th colspan="6">实景演出信息</th>
    </tr>
    <tr>
        <td width="100px" class="title">演出名称：</td>
        <td>${performance.pName}&nbsp;</td>
        <td width="100px" class="title">门票价格：</td>
        <td>${performance.pPrice}元</td>
        <td width="100px" class="title">联系电话：</td>
        <td>${performance.pTel}</td>
    </tr>
    <tr>
        <td class="title">演出地址：</td>
        <td>${performance.pAddr}</td>
        <td class="title">乘车路线：</td>
        <td>${performance.pBusRoute}</td>
        <td class="title">营业时间：</td>
        <td>${performance.pOpening}</td>
    </tr>
</table>
<table border="0" cellpadding="0" cellspacing="1" class="form" style="margin-top:-1px;">
    <tr>
        <td width="100px" class="title">演出介绍：</td>
        <td>
            ${performance.pDesc}
        </td>
    </tr>
    <%--<tr>--%>
        <%--<td class="title">图片：</td>--%>
        <%--<td><img src="../resources/images/others/guodegang2.png" width="186" height="206"/></td>--%>
    <%--</tr>--%>
</table>
<div class="buttonLine" id="buttonLine">
    <input name="button" type="button" value="返回" onclick="location.href='/PerfServlet'"/>
</div>
</body>
</html>

