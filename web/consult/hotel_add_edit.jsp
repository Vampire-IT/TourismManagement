<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*,java.lang.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>住宿查询详细</title>
    <link rel="stylesheet" type="text/css" href="../resources/css/page.css"/>
    <script type="text/javascript" src="../resources/js/jquery-1.9.0.min.js"></script>
    <script type="text/javascript" src="../resources/js/main.js"></script>
</head>

<body>
<c:choose>
    <c:when test="${update}">
        <div class="navBar">
            首页 &gt; 住宿 &gt; 修改
        </div>
    </c:when>
    <c:otherwise>
        <div class="navBar">
            首页 &gt; 住宿 &gt; 添加
        </div>
    </c:otherwise>
</c:choose>
<form action="/HotelServlet" method="post">
<table border="0" cellpadding="0" cellspacing="1" class="form">
    <tr>
        <th colspan="6">酒店信息</th>
    </tr>
    <tr>
        <td width="100px" class="title">酒店名称：</td>
        <td><input name="hName" type="text" value="${hotel.hName}"/>&nbsp;</td>
        <td width="100px" class="title">酒店星级：</td>
        <td>
            <select name="hRating">
                <option value="">请选择</option>
                <option
                        <c:if test="${hRating == '快捷' }">selected="selected"</c:if> value="快捷">快捷
                </option>
                <option
                        <c:if test="${hRating == '三星' }">selected="selected"</c:if> value="三星">三星
                </option>
                <option
                        <c:if test="${hRating == '四星' }">selected="selected"</c:if> value="四星">四星
                </option>
                <option
                        <c:if test="${hRating == '五星' }">selected="selected"</c:if> value="五星">五星
                </option>
            </select>
        </td>
        <td width="100px" class="title">标准价格：</td>
        <td><input name="hStanPrice" type="text" value="${hotel.hStanPrice}"/>元</td>
    </tr>
    <tr>
        <td class="title">折扣价格：</td>
        <td><input name="hDiscPrice" type="text" value="${hotel.hDiscPrice}"/>元</td>
        <td class="title">联系电话：</td>
        <td><input name="hTel" type="text" value="${hotel.hTel}"/><br/></td>
        <td class="title">酒店网址：</td>
        <td><input name="hUrl" type="text" value="${hotel.hUrl}"/></td>
    </tr>
    <tr>
        <td class="title">乘车路线：</td>
        <td><input name="hBusRoute" type="text" value="${hotel.hBusRoute}"/></td>
        <td class="title">停车位：</td>
        <td><input name="hParkSpace" type="text" value="${hotel.hParkSpace}"/>个</td>
        <td class="title">营业时间：</td>
        <td><input name="hOpening" type="text" value="${hotel.hOpening}"/></td>
    </tr>
</table>
<table border="0" cellpadding="0" cellspacing="1" class="form" style="margin-top:-1px;">
    <tr>
        <td width="100px" class="title">酒店地址：</td>
        <td><input name="hAddr" type="text" value="${hotel.hAddr}"/></td>
    </tr>
    <tr>
        <td class="title">酒店介绍：</td>
        <td><textarea name="hDesc" id="" cols="100" rows="5">${hotel.hDesc}</textarea>
        </td>
    </tr>
    <%--<tr>--%>
        <%--<td class="title">图片：</td>--%>
        <%--<td><img src="../resources/images/others/xianggelila2.png" width="279" height="204"/></td>--%>
    <%--</tr>--%>
</table>
<div class="buttonLine" style="clear:left;clear:right">
    <c:choose>
        <c:when test="${update}">
            <input type="hidden" name="action" value="update">
            <input type="hidden" name="hId" value="${hotel.hId}">
            <input type="submit" value="确定"/>
        </c:when>
        <c:otherwise>
            <input type="hidden" name="action" value="insert">
            <input type="submit" value="确定"/>
        </c:otherwise>
    </c:choose>
    <input type="button" value="返回" onclick="location.href='/HotelServlet'"/>
</div>
</form>
</body>
</html>

