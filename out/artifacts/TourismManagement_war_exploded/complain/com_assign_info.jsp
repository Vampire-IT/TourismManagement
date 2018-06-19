<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*,java.lang.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>投诉分派</title>
    <link rel="stylesheet" type="text/css" href="../resources/css/page.css"/>
    <script type="text/javascript" src="../resources/js/jquery-1.9.0.min.js"></script>
    <script type="text/javascript" src="../resources/js/main.js"></script>
</head>

<body>
<div class="navBar">
    首页 &gt; 分配处理
</div>
<form action="/AssignServlet" method="get">
    <div style="height:33px">
        &nbsp; 处理人：
        <input type="text" value="${uName}" name="uName" size="20" style="width:120px;"/>
        &nbsp;&nbsp;
        <input type="submit" value="查询"/>
    </div>
</form>

<ul class="toolbar">
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
        <th>处理人</th>
        <th>结果</th>
    </tr>
    <c:forEach var="assign" items="${assignList}" varStatus="number">
        <tr>
            <td>${number.count}</td>
            <td>${assign.cId}</td>
            <td>${assign.cName}</td>
            <td>${assign.cTel}</td>
            <td>${assign.cTargetType}</td>
            <td>${assign.cTarget}</td>
            <td>${assign.cTName}</td>
            <td>${assign.username}</td>

            <td>
                <c:if test="${assign.result == 1 }"><a href="ComDisServlet?action=show&cId=${assign.cId}&flag=a"><input type="button" value="查看"/></a></c:if>
                <c:if test="${assign.result == 0 }">未处理</c:if>
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

