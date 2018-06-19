<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<c:choose>
    <c:when test="${update}">
        <div class="navBar">
            首页 &gt; 景区 &gt; 修改
        </div>
    </c:when>
    <c:otherwise>
        <div class="navBar">
            首页 &gt; 景区 &gt; 添加
        </div>
    </c:otherwise>
</c:choose>
<form action="/ScenicServlet" method="post">
    <table border="0" cellpadding="0" cellspacing="1" class="form">
        <tr>
            <th colspan="6">景区信息</th>
        </tr>
        <tr>
            <td width="100" class="title">景区名称：</td>
            <td><input name="sName" type="text" value="${scenic.sName}"/></td>
            <td width="100" class="title">景区类别：</td>
            <td><input name="sType" type="text" value="${scenic.sType}"/></td>
            <td width="100" class="title">标准价格：</td>
            <td><input name="sStanPrice" type="text" value="${scenic.sStanPrice}"/>元</td>
        </tr>
        <tr>
            <td class="title">折扣价格：</td>
            <td><input name="sDiscPrice" type="text" value="${scenic.sDiscPrice}"/>元</td>
            <td class="title">联系电话：</td>
            <td><input name="sTel" type="text" value="${scenic.sTel}"/><br/></td>
            <td class="title">景区网址：</td>
            <td><input name="sUrl" type="text" value="${scenic.sUrl}"/></td>
        </tr>
        <tr>
            <td class="title">乘车路线：</td>
            <td><input name="sBusRoute" type="text" value="${scenic.sBusRoute}"/></td>
            <td class="title">停车位：</td>
            <td><input name="sParkSpace" type="text" value="${scenic.sParkSpace}"/>个</td>
            <td class="title">营业时间：</td>
            <td><input name="sOpening" type="text" value="${scenic.sOpening}"/></td>
        </tr>
    </table>
    <table border="0" cellpadding="0" cellspacing="1" class="form" style="margin-top:-1px;">
        <tr>
            <td width="100px" class="title">景区地址：</td>
            <td><input name="sAddr" type="text" value="${scenic.sAddr}"/></td>
        </tr>
        <tr>
            <td class="title">景区介绍：</td>
            <td>
                <textarea name="hDesc" id="" cols="100" rows="5">${scenic.sDesc}</textarea>
            </td>
        </tr>
        <%--<tr>--%>
        <%--<td class="title">图片：</td>--%>
        <%--<td><img src="../resources/images/others/bashang1.png" width="339" height="276"/></td>--%>
        <%--</tr>--%>
    </table>
    <div class="buttonLine" style="clear:left;clear:right">
        <c:choose>
            <c:when test="${update}">
                <input type="hidden" name="action" value="update">
                <input type="hidden" name="sId" value="${scenic.sId}">
                <input type="submit" value="确定"/>
            </c:when>
            <c:otherwise>
                <input type="hidden" name="action" value="insert">
                <input type="submit" value="确定"/>
            </c:otherwise>
        </c:choose>
        <input type="button" value="返回" onclick="location.href='/ScenicServlet'"/>
    </div>
</form>
</body>
</html>

