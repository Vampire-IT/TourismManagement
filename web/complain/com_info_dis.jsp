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
    首页 &gt; 投诉处理 &gt;处理信息
</div>
<form action="/ComDisServlet" method="post">
    <input type="hidden" name="cId" value="${cId}">
    <table border="0" cellpadding="0" cellspacing="1" class="form">
        <tr>
            <th colspan="4">处理信息&nbsp;</th>
        </tr>
        <tr>
            <td width="12%" class="title">处理人：</td>
            <td width="38%"><input type="text" name="dName" value="${dispose.dName}"/>&nbsp;</td>
        </tr>
        <tr>
            <td class="title">处理结果：</td>
            <td colspan="3"><label>
                <select name="dFinish">
                    <option value="">--请选择--</option>
                    <option <c:if test="${dispose.dFinish == 1}">selected="selected"</c:if> value="1">完成</option>
                    <option <c:if test="${dispose.dFinish == 0}">selected="selected"</c:if> value="0">未完成</option>
                </select>
            </label></td>
        </tr>
        <tr>
            <td class="title">处理内容：</td>
            <td colspan="3"><label>
                <textarea name="dCont" rows="3" cols="40">${dispose.dCont}</textarea>
            </label></td>
        </tr>
    </table>
    <div class="buttonLine">
        <c:choose>
            <c:when test="${update}">
                <input type="hidden" name="action" value="updateD">
                <input type="submit" value="确定"/>
            </c:when>
            <c:otherwise>
                <input type="hidden" name="action" value="insertD">
                <input type="submit" value="确定"/>
            </c:otherwise>
        </c:choose>
        <input onclick="location='/ComDisServlet'" type="button" value="取消"/>
    </div>
</form>
</body>
</html>
