<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*,java.lang.*" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>投诉处理信息</title>
    <link rel="stylesheet" type="text/css" href="../resources/css/page.css"/>
    <script type="text/javascript" src="../resources/js/jquery-1.9.0.min.js"></script>
    <script type="text/javascript" src="../resources/js/main.js"></script>
</head>
<body>
<div class="navBar">
    首页 &gt; 投诉处理 &gt;投诉反馈${cId}"
</div>
<form action="/ComDisServlet" method="post">
    <table border="0" cellpadding="0" cellspacing="1" class="form">
        <input type="hidden" name="cId" value="${cId}">
        <tr>
            <th colspan="4">反馈信息&nbsp;</th>
        </tr>
        <tr>
            <td width="12%" class="title">反馈人：</td>
            <td width="38%"><label>
                <input type="text" name="fName" value="${feedback.fName}"/>
            </label></td>
        </tr>
        <tr>
            <td class="title">反馈内容：</td>
            <td colspan="3"><label>
                <textarea name="fCont" rows="3" cols="40">${feedback.fCont}</textarea>
            </label></td>
        </tr>
    </table>
    <div class="buttonLine">
        <c:choose>
            <c:when test="${update}">
                <input type="hidden" name="action" value="updateF">
                <input type="submit" value="确定"/>
            </c:when>
            <c:otherwise>
                <input type="hidden" name="action" value="insertF">
                <input type="submit" value="确定"/>
            </c:otherwise>
        </c:choose>

        <input onclick="location='/ComDisServlet'" type="button" value="取消"/>
    </div>
</form>
</body>
</html>
