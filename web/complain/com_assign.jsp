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
<form action="/AssignServlet" method="post">
    <table border="0" cellpadding="0" cellspacing="1" class="form">
        <tr>
            <th colspan="6">投诉分派</th>
        </tr>
        <tr>
            <td width="12%" class="title">投诉单号：</td>
            <td width="38%">${complain.cId}&nbsp;</td>
        </tr>
        <tr>
            <td width="12%" class="title">投诉人：</td>
            <td width="38%">${complain.cName}&nbsp;</td>
        </tr>
        <tr>
            <td width="12%" class="title">投诉对象类别：</td>
            <td width="38%">${complain.cTargetType}&nbsp;</td>
        </tr>
        <tr>
            <td width="12%" class="title">投诉对象：</td>
            <td width="38%">${complain.cTarget}&nbsp;</td>
        </tr>
        <tr>
            <td width="12%" class="title">投诉类别：</td>
            <td width="38%">${complain.cTName}&nbsp;</td>
        </tr>
        <tr>
            <td width="12%" class="title">处理人：</td>
            <td width="38%">
                <select name="uName">
                    <option value="">请选择处理人员</option>
                    <c:forEach var="user" items="${userList }">
                        <option value="${user.username }">${user.username }</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
    </table>
    <div class="buttonLine">
        <input type="hidden" name="cId" value="${complain.cId}">
        <input type="hidden" name="action" value="insert">
        <input name="button" type="submit" value="提交"/>
        <input type="button" onclick="location='com_manage.jsp'" value="取消"/>
    </div>
</form>
</body>
</html>