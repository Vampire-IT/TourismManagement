<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*,java.lang.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>修改用户信息</title>
    <link rel="stylesheet" type="text/css" href="../resources/css/page.css"/>
    <script type="text/javascript" src="../resources/js/main.js"></script>
</head>

<body>
<div class="navBar">
    首页 &gt; 个人信息 &gt; 修改
</div>
<form action="/LoginServlet" method="post">
    <table border="0" cellpadding="0" cellspacing="1" class="form">
        <tr>
            <th colspan="4">个人信息&nbsp;</th>
        </tr>
        <tr>
            <td width="12%" class="title">用户名：</td>
            <td width="38%">${user.username}&nbsp;</td>
            <td class="title">真实姓名：</td>
            <td><input name="rName" type="text" value="${user.realName}"/></td>
        </tr>
        <tr>
            <td class="title">原密码：</td>
            <td><input name="oldPassword" readonly="readonly" type="text" value="${user.password}"/></td>
            <td class="title">新密码：</td>
            <td><input name="newPassword" type="text" value=""/></td>
        </tr>
        <tr>
            <td class="title">用户类别：</td>
            <td>${user.userType}</td>
        </tr>
    </table>
    <div class="buttonLine">
                <input type="hidden" name="action" value="update">
                <input type="submit" value="确定"/>
        <input type="button" onclick="location.href='/system/blank.jsp'" value="取消"/>


    </div>
</form>
</body>
</html>
