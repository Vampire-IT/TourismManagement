<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*,java.lang.*" %>
<html>
<%
    String loginType = (String)session.getAttribute("loginType");
%>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
    <link rel="stylesheet" type="text/css" href="../resources/css/page.css"/>
    <script type="text/javascript" src="../resources/js/jquery-1.9.0.min.js"></script>
    <script type="text/javascript" src="../resources/js/main.js"></script>

</head>

<body>
<div class="navBar">
    首页 &gt; 个人资料
</div>
<table border="0" cellpadding="0" cellspacing="1" class="form">
    <tr>
        <th colspan="4">个人信息&nbsp;</th>
    </tr>

    <tr>
        <td width="12%" class="title">用户名：</td>
        <td width="38%">${user.username}</td>
    </tr>
    <tr>
        <td class="title" width="12%">锁定状态：</td>
        <td>
            <c:if test="${user.lock == 1}">正常</c:if>
            <c:if test="${user.lock == 0}">锁定</c:if>
        </td>
    </tr>
    <tr>
        <td class="title">真实姓名：</td>
        <td>${user.realName}</td>
    </tr>
    <tr>
        <td class="title">用户类别：</td>
        <td>${user.userType}</td>
    </tr>
</table>
<table border="0" cellpadding="0" cellspacing="1" class="form" id="passwordshow" style="margin-top:-1px;">

</table>
<div class="buttonLine" id="buttonLine">
    <a href="LoginServlet?action=query&username=${user.username}"><input type="button" value="修改"/></a>&nbsp;&nbsp;
            <input type="button" onclick="location.href='/system/blank.jsp'" value="取消"/>

</div>
</body>
</html>
