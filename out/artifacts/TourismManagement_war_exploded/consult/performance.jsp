<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*,java.lang.*" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>无标题文档</title>
    <link rel="stylesheet" type="text/css" href="../resources/css/page.css"/>
    <script type="text/javascript" src="../resources/js/jquery-1.9.0.min.js"></script>
    <script type="text/javascript" src="../resources/js/main.js"></script>
    <script type="text/javascript" src="../resources/js/My97DatePicker/WdatePicker.js"></script>

</head>

<body>
<div class="navBar">
    首页 &gt; 实景演出查询
</div>
<form action="/PerfServlet" method="get">
    <div style="height:33px">
        &nbsp;&nbsp;地址：&nbsp;
        <input type="text" name="pAddr" value="${pAddr}" size="20" style="width:120px;"/>
        &nbsp;&nbsp;
        演出名称：&nbsp;
        <input type="text" name="pName" value="${pName}" size="20" style="width:120px;"/>
        <input type="submit" value="查询"/>
    </div>
</form>
<ul class="toolbar">
    <li><img src="../resources/images/icon/plus.png" alt=""><a href="consult/performance_add_edit.jsp">添加演出</a></li>
</ul>
<table border="0" cellpadding="0" cellspacing="1" class="grid">
    <tr>
        <th>序号</th>
        <th>演出名称</th>
        <th>门票价格</th>
        <th>联系电话</th>
        <th>演出地址</th>
        <th>乘车路线</th>
        <th>营业时间</th>
        <th>操作</th>
    </tr>
    <c:forEach var="perf" items="${performanceList}" varStatus="number">
        <tr>
            <td height="48">${number.count}</td>
            <td>${perf.pName}</td>
            <td>${perf.pPrice}元</td>
            <td>${perf.pTel}</td>
            <td>${perf.pAddr}</td>
            <td>${perf.pBusRoute}</td>
            <td>${perf.pOpening}</td>
            <td>
                <div class="buttonStyle">
                    <a href="PerfServlet?action=show&pId=${perf.pId}"><input type="button" value="详细"/></a>
                    <a href="PerfServlet?action=query&pId=${perf.pId}"><input type="button" value="修改"/></a>
                    <a href="PerfServlet?action=delete&pId=${perf.pId}"><input type="button" value="删除"/></a>
                </div>
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

