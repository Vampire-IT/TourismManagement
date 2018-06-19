<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*,java.lang.*" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>修改用户信息</title>
    <link rel="stylesheet" type="text/css" href="../resources/css/page.css"/>
    <script type="text/javascript" src="../resources/js/jquery-1.9.0.min.js"></script>
    <script type="text/javascript" src="../resources/js/main.js"></script>
</head>

<body>
<c:choose>
    <c:when test="${update}">
        <div class="navBar">
            首页 &gt; 投诉类别管理 &gt; 修改
        </div>
    </c:when>
    <c:otherwise>
        <div class="navBar">
            首页 &gt; 投诉类别管理 &gt; 添加
        </div>
    </c:otherwise>
</c:choose>
<form action="/CTypeServlet" method="post">
    <table border="0" cellpadding="0" cellspacing="1" class="form">
        <tr>
            <th colspan="4">添加投诉类别</th>
        </tr>
        <tr>
            <td width="12%" class="title">投诉名称：</td>
            <td width="29%"><input name="cTName" type="text" value="${CType.cTName}"/>
            <td width="12%" class="title">描述：</td>
            <td width="47%"><textarea name="cTDesc" cols="30" rows="4">${CType.cTDesc}</textarea></td>
        </tr>

    </table>
    <div class="buttonLine">
        <c:choose>
            <c:when test="${update}">
                <input type="hidden" name="action" value="update">
                <input type="hidden" name="cTId" value="${CType.cTId}">
                <input type="hidden" name="cTState" value="${CType.cTState}">
                <input type="submit" value="确定"/>
            </c:when>
            <c:otherwise>
                <input type="hidden" name="action" value="insert">
                <input type="submit" value="确定"/>
            </c:otherwise>
        </c:choose>
        <input type="button" onclick="location.href='/CTypeServlet'" value="取消"/>
    </div>
</form>
</body>
</html>
