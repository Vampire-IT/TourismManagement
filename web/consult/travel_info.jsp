<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*,java.lang.*" %>
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
    首页 &gt; 旅行社查询
</div>

<table border="0" cellpadding="0" cellspacing="1" class="form">
    <tr>
        <th colspan="6">旅行社信息</th>
    </tr>
    <tr>
        <td width="100" class="title">旅行社：</td>
        <td>${travel.tName}&nbsp;</td>
        <td width="100" class="title">联系人：</td>
        <td>${travel.tLinkman}</td>
        <td width="100" class="title">联系电话：</td>
        <td> ${travel.tTel}</td>
    </tr>
    <tr>
        <td class="title">传真号码：</td>
        <td>${travel.tFax}</td>
        <td class="title">腾讯QQ：</td>
        <td>${travel.tQq}</td>
        <td class="title">电子邮件:</td>
        <td>${travel.tEmail}</td>
    </tr>
</table>
<table border="0" cellpadding="0" cellspacing="1" class="form" style="margin-top:-1px;">
    <tr>
        <td width="100" class="title">联系地址：</td>
        <td> ${travel.tAddr}</td>
    </tr>
    <tr>
        <td class="title">介绍：</td>
        <td>
            ${travel.tDesc}
        </td>
    </tr>
</table>

<div class="buttonLine" id="buttonLine">
    <input name="button" type="button" value="返回" onclick="location.href='/TravelServlet'"/>
</div>
</body>
</html>

