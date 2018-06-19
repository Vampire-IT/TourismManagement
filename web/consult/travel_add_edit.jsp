<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<c:choose>
    <c:when test="${update}">
        <div class="navBar">
            首页 &gt; 旅行社 &gt; 修改
        </div>
    </c:when>
    <c:otherwise>
        <div class="navBar">
            首页 &gt; 旅行社 &gt; 添加
        </div>
    </c:otherwise>
</c:choose>
<form action="/TravelServlet" method="post">
    <table border="0" cellpadding="0" cellspacing="1" class="form">
        <tr>
            <th colspan="6">旅行社信息</th>
        </tr>
        <tr>
            <td width="100" class="title">旅行社：</td>
            <td><input name="tName" type="text" value="${travel.tName}"/>&nbsp;</td>
            <td width="100" class="title">联系人：</td>
            <td><input name="tLinkman" type="text" value="${travel.tLinkman}"/></td>
            <td width="100" class="title">联系电话：</td>
            <td><input name="tTel" type="text" value="${travel.tTel}"/></td>
        </tr>
        <tr>
            <td class="title">传真号码：</td>
            <td><input name="tFax" type="text" value="${travel.tFax}"/></td>
            <td class="title">腾讯QQ：</td>
            <td><input name="tQq" type="text" value="${travel.tQq}"/></td>
            <td class="title">电子邮件:</td>
            <td><input name="tEmail" type="text" value="${travel.tEmail}"/></td>
        </tr>
    </table>
    <table border="0" cellpadding="0" cellspacing="1" class="form" style="margin-top:-1px;">
        <tr>
            <td width="100" class="title">联系地址：</td>
            <td><input name="tAddr" type="text" value="${travel.tAddr}"/></td>
        </tr>
        <tr>
            <td class="title">介绍：</td>
            <td>
                <textarea name="tDesc" cols="100" rows="5">${travel.tDesc}</textarea>
            </td>
        </tr>
    </table>

    <div class="buttonLine" id="buttonLine">
        <c:choose>
            <c:when test="${update}">
                <input type="hidden" name="action" value="update">
                <input type="hidden" name="tId" value="${travel.tId}">
                <input type="submit" value="确定"/>
            </c:when>
            <c:otherwise>
                <input type="hidden" name="action" value="insert">
                <input type="submit" value="确定"/>
            </c:otherwise>
        </c:choose>
        <input name="button" type="button" value="返回" onclick="location.href='/TravelServlet'"/>
    </div>
</form>
</body>
</html>

