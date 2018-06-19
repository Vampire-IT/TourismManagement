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
    首页 &gt;投诉类别管理
</div>
<form action="/CTypeServlet" method="get">
    <div style="height:33px">
        &nbsp;&nbsp;投诉名称：
        <input type="text" name="cTName" value="${cTName}" size="20"/>
        &nbsp;投诉类别：
        <label>
            <select name="cTState">
                <option value="">--请选择--</option>
                <option
                        <c:if test="${cTState == 1 }">selected="selected"</c:if> value="1">启用
                </option>
                <option
                        <c:if test="${cTState == 0 }">selected="selected"</c:if> value="0">停用
                </option>
            </select>
        </label>
        &nbsp;
        <input type="submit" value="查询"/>
    </div>
</form>
<ul class="toolbar">
    <li><img src="../resources/images/icon/plus.png" alt=""><a href="system/type_add_edit.jsp">添加投诉</a></li>
</ul>
<table border="0" cellpadding="0" cellspacing="1" class="grid">
    <tr>
        <th width="6%">序号</th>
        <th width="25%">投诉名称</th>
        <th>描述</th>
        <th width="10%">状态</th>
        <th width="15%">操作</th>
    </tr>
    <c:forEach var="cType" items="${cTypeList}" varStatus="number">
        <tr>
            <td align="center">${number.count}</td>
            <td align="center">${cType.cTName}</td>
            <td align="center">${cType.cTDesc}</td>
            <c:if test="${cType.cTState == 1}">
                <td align="center">启用</td>
            </c:if>
            <c:if test="${cType.cTState == 0}">
                <td align="center">停用</td>
            </c:if>
            <td align="center">
                <div class="buttonStyle">
                    <a href="CTypeServlet?action=query&cTId=${cType.cTId}"><input type="button" value="修改"/></a>
                    <c:if test="${cType.cTState == 1}"><a
                            href="CTypeServlet?action=state&cTId=${cType.cTId}&cTState=${cType.cTState}"><input
                            type="button" value="停用"/></a></c:if>
                    <c:if test="${cType.cTState == 0}"><a
                            href="CTypeServlet?action=state&cTId=${cType.cTId}&cTState=${cType.cTState}"><input
                            type="button" value="启用"/></a></c:if>
                    <a href="CTypeServlet?action=delete&cTId=${cType.cTId}"><input type="button" value="删除"/></a>
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

