<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*,java.lang.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>景区查询</title>
    <link rel="stylesheet" type="text/css" href="../resources/css/page.css"/>
    <script type="text/javascript" src="../resources/js/jquery-1.9.0.min.js"></script>
    <script type="text/javascript" src="../resources/js/main.js"></script>
    <script type="text/javascript" src="../resources/js/My97DatePicker/WdatePicker.js"></script>

</head>

<body>
<form action="/ScenicServlet" method="get">
    <div class="navBar">
        首页 &gt; 景区查询
    </div>
    <div style="height:33px">
        &nbsp;&nbsp;地址：
        <input type="text" name="sAddr" value="${sAddr}" size="20"/>
        &nbsp;&nbsp;景区名称：
        <input type="text" name="sName" value="${sName}" size="20"/>
        <input type="submit" value="查询"/>
    </div>
</form>
<ul class="toolbar">
    <li><img src="../resources/images/icon/plus.png" alt=""><a href="consult/scenic_add_edit.jsp">添加景区</a></li>
</ul>
<table border="0" cellpadding="0" cellspacing="1" class="grid">
    <tr>
        <th>序号</th>
        <th>景区名称</th>
        <th>景区类别</th>
        <th>门票价格</th>
        <th>联系电话</th>
        <th>景区地址</th>
        <th>乘车路线</th>
        <th>营业时间</th>
        <th>操作</th>
    </tr>
    <c:forEach var="scenic" items="${scenicList}" varStatus="number">
        <tr>
            <td>${number.count}</td>
            <td>${scenic.sName}</td>
            <td>${scenic.sType}</td>
            <td>${scenic.sDiscPrice}元</td>
            <td>${scenic.sTel}</td>
            <td>${scenic.sAddr}</td>
            <td>${scenic.sBusRoute}</td>
            <td>${scenic.sOpening}</td>
            <td>
                <a href="ScenicServlet?action=show&sId=${scenic.sId}"><input type="button" value="详细"/></a>
                <a href="ScenicServlet?action=query&sId=${scenic.sId}"><input type="button" value="修改"/></a>
                <a href="ScenicServlet?action=delete&sId=${scenic.sId}"><input type="button" value="删除"/></a>
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

