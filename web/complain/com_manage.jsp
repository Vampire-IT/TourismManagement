<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*,java.lang.*" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>投诉管理</title>
    <link rel="stylesheet" type="text/css" href="../resources/css/page.css"/>
    <script type="text/javascript" src="../resources/js/jquery-1.9.0.min.js"></script>
    <script type="text/javascript" src="../resources/js/main.js"></script>
</head>

<body>
<div class="navBar">
    首页 &gt;投诉管理
</div>
<form action="/ComServlet" method="get">
    <div style="height:33px">
        &nbsp;&nbsp;投诉对象：
        <input type="text" value="${cTarget}" name="cTarget" size="20" style="width:120px;"/>
        &nbsp;&nbsp;
        投诉人：
        <input type="text" name="cName" value="${cName}" size="20" style="width:120px;"/>
        &nbsp;&nbsp;
        <input type="submit" value="查询"/>
    </div>
</form>
<ul class="toolbar">
    <li><img src="../resources/images/icon/plus.png" alt=""><a href="complain/com_add_edit.jsp">登记投诉</a></li>
</ul>
<table border="0" cellpadding="0" cellspacing="1" class="grid">
    <tr>
        <th>序号</th>
        <th>投诉单号</th>
        <th>投诉人</th>
        <th>联系电话</th>
        <th>投诉对象类别</th>
        <th>投诉对象</th>
        <th>投诉类别</th>
        <th>操作</th>
    </tr>
    <c:forEach var="complain" items="${complainList}" varStatus="number">
        <tr>
            <td>${number.count}</td>
            <td>${complain.cId}</td>
            <td>${complain.cName}</td>
            <td>${complain.cTel}</td>
            <td>${complain.cTargetType}</td>
            <td>${complain.cTarget}</td>
            <td>${complain.cTName}</td>
            <td>
                <a href="ComServlet?action=query&cId=${complain.cId}"><input type="button" value="修改"/></a>
                <a href="AssignServlet?action=assign&cId=${complain.cId}"><input type="button" value="分派"/></a>
                <a href="ComServlet?action=delete&cId=${complain.cId}"><input type="button" value="删除"/></a>
            </td>
        </tr>
    </c:forEach>
</table>
<div class="navBar2" style="text-align:right">
    共 19 条记录 每页10条 当前为第1/2页 首页 | 上一页 | <a href="javascript:toPage('2')">下一页</a> | <a
        href="javascript:toPage('4')">末页</a> | 转到
    <select onchange="document.getElementById('pageNoid').value=this.value;document.getElementById('form2').submit();"
            size="1" name="pageNo">
        <option value="1" selected="selected">1</option>
        <option value="2">2</option>
        <option value="3">3</option>
        <option value="4">4</option>
        <option value="5">5</option>
        <option value="6">6</option>
        <option value="7">7</option>
        <option value="8">8</option>
        <option value="9">9</option>
        <option value="10">10</option>
    </select>
    页


</div>
</body>
</html>

