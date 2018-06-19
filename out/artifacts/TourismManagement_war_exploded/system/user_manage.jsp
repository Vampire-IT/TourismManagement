<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*,java.lang.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    首页 &gt;用户管理
</div>
<div style="height:33px">
    <form action="/UserServlet" method="get">
        &nbsp;&nbsp;真实姓名：<input type="text" name="realName" value="${realName}" size="20"/> &nbsp;&nbsp;
        用户类别：
        <label>
            <select name="userType">
                <option value="">--请选择--</option>
                <option
                        <c:if test="${userType == '系统管理员' }">selected="selected"</c:if> value="系统管理员">系统管理员
                </option>
                <option
                        <c:if test="${userType == '服务人员' }">selected="selected"</c:if> value="服务人员">服务人员
                </option>
                <option
                        <c:if test="${userType == '投诉处理' }">selected="selected"</c:if> value="投诉处理">投诉处理
                </option>
            </select>
        </label>
        &nbsp;&nbsp;
        状态：
        <label>
            <select name="lock">
                <option value="">--请选择--</option>
                <option
                        <c:if test="${lock == 1 }">selected="selected"</c:if> value="1">正常
                </option>
                <option
                        <c:if test="${lock == 0 }">selected="selected"</c:if> value="0">锁定
                </option>
            </select>
        </label>
        <input type="submit" value="查询"/>
    </form>
</div>
<ul class="toolbar">
    <li><img src="../resources/images/icon/plus.png" alt=""><a href="/CheckServlet?action=add">添加用戶</a></li>
</ul>
<table border="0" cellpadding="0" cellspacing="1" class="grid">
    <tr>
        <th>序号</th>
        <th>用户名</th>
        <th>真实姓名</th>
        <th>用户类别</th>
        <th>锁定状态</th>
        <th>最后登录时间</th>
        <th width="30%">操作</th>
    </tr>
    <c:forEach var="user" items="${userList}" varStatus="number">
        <tr>
            <td align="center">${number.count}</td>
            <td align="center">${user.username}</td>
            <td align="center">${user.realName}</td>
            <td align="center">${user.userType}</td>
            <c:if test="${user.lock == 1}">
                <td align="center">正常</td>
            </c:if>
            <c:if test="${user.lock == 0}">
                <td align="center">锁定</td>
            </c:if>
            <td align="center">${user.lastLoginTime}</td>
            <td align="center">
                <div class="buttonStyle">
                    <a href="UserServlet?action=query&username=${user.username}"><input type="button" value="修改"/></a>
                    <c:if test="${user.lock == 1}"><a
                            href="UserServlet?action=lock&username=${user.username}&userLock=${user.lock}"><input
                            type="button" value="锁定"/></a></c:if>
                    <c:if test="${user.lock == 0}"><a
                            href="UserServlet?action=lock&username=${user.username}&userLock=${user.lock}"><input
                            type="button" value="解锁"/></a></c:if>
                    <a href="UserServlet?action=delete&username=${user.username}"><input type="button" value="删除"/></a>
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

