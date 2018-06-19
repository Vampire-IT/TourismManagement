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
            首页 &gt; 实景演出 &gt; 修改
        </div>
    </c:when>
    <c:otherwise>
        <div class="navBar">
            首页 &gt; 实景演出 &gt; 添加
        </div>
    </c:otherwise>
</c:choose>
<form action="/PerfServlet" method="post">
    <table border="0" cellpadding="0" cellspacing="1" class="form">
        <tr>
            <th colspan="6">实景演出信息</th>
        </tr>
        <tr>
            <td width="100px" class="title">演出名称：</td>
            <td><input name="pName" type="text" value="${performance.pName}"/>&nbsp;</td>
            <td width="100px" class="title">门票价格：</td>
            <td><input name="pPrice" type="text" value="${performance.pPrice}"/>元</td>
            <td width="100px" class="title">联系电话：</td>
            <td><input name="pTel" type="text" value="${performance.pTel}"/></td>
        </tr>
        <tr>
            <td class="title">演出地址：</td>
            <td><input name="pAddr" type="text" value="${performance.pAddr}"/></td>
            <td class="title">乘车路线：</td>
            <td><input name="pBusRoute" type="text" value="${performance.pBusRoute}"/></td>
            <td class="title">营业时间：</td>
            <td><input name="pOpening" type="text" value="${performance.pOpening}"/></td>
        </tr>
    </table>
    <table border="0" cellpadding="0" cellspacing="1" class="form" style="margin-top:-1px;">
        <tr>
            <td width="100px" class="title">演出介绍：</td>
            <td>
                <textarea name="pDesc" id="" cols="100" rows="5">${performance.pDesc}</textarea>
            </td>
        </tr>
        <%--<tr>--%>
        <%--<td class="title">图片：</td>--%>
        <%--<td><img src="../resources/images/others/guodegang2.png" width="186" height="206"/></td>--%>
        <%--</tr>--%>
    </table>
    <div class="buttonLine" id="buttonLine">
        <c:choose>
            <c:when test="${update}">
                <input type="hidden" name="action" value="update">
                <input type="hidden" name="pId" value="${performance.pId}">
                <input type="submit" value="确定"/>
            </c:when>
            <c:otherwise>
                <input type="hidden" name="action" value="insert">
                <input type="submit" value="确定"/>
            </c:otherwise>
        </c:choose>
        <input name="button" type="button" value="返回" onclick="location.href='/PerfServlet'"/>
    </div>
</form>
</body>
</html>

