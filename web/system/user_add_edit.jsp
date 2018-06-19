<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*,java.lang.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>修改用户信息</title>
    <link rel="stylesheet" type="text/css" href="../resources/css/page.css"/>
    <script type="text/javascript" src="../resources/js/main.js"></script>
    <script type="text/javascript">
        //定义一个变量用于存放XMLHttpRequest对象
        var xmlHttp;

        //该函数用于创建一个XMLHttpRequest对象
        function createXMLHttpRequest() {
            if (window.ActiveXObject) {
                xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
            }
            else if (window.XMLHttpRequest) {
                xmlHttp = new XMLHttpRequest();
            }
        }

        function beginCheck() {
            var tempUsername = document.getElementById("uName").value;
            if (tempUsername == "") {
                document.getElementById("check").innerHTML = "";
                return;
            }
            createXMLHttpRequest();
            xmlHttp.onreadystatechange = processor;
            xmlHttp.open("GET", "CheckServlet?username=" + tempUsername);
            xmlHttp.send(null);
        }

        function processor() {
            var responseContext;
            if (xmlHttp.readyState == 4) {
                if (xmlHttp.status == 200) {
                    responseContext = xmlHttp.responseText;
                    if (responseContext.indexOf("true") != -1) {
                        document.getElementById("check").innerHTML = "正确";
                    } else {
                        document.getElementById("check").innerHTML = "代码已存在";
                    }
                }
            }
        }
    </script>
</head>

<body>
<c:choose>
    <c:when test="${update}">
        <div class="navBar">
            首页 &gt; 用户管理 &gt; 修改
        </div>
    </c:when>
    <c:otherwise>
        <div class="navBar">
            首页 &gt; 用户管理 &gt; 添加
        </div>
    </c:otherwise>
</c:choose>
<form action="/UserServlet" method="post">
    <table border="0" cellpadding="0" cellspacing="1" class="form">
        <tr>
            <th colspan="4">用户信息&nbsp;</th>
        </tr>
        <tr>
            <td width="12%" class="title">用户名：</td>
            <td width="38%">
                <input
                        <c:if test="${update}">readonly="readonly"</c:if>
                        <c:if test="${!update}">onblur="beginCheck()"</c:if> id="uName" name="uName" type="text"
                        value="${user.username}"/>&nbsp;
                <label id="check">&nbsp;</label>
            </td>
            <td class="title">真实姓名：</td>
            <td><input name="rName" type="text" value="${user.realName}"/></td>
        </tr>
        <tr>
            <c:choose>
                <c:when test="${update}">
                    <td class="title">原密码：</td>
                    <td><input name="oldPassword" readonly="readonly" type="text" value="${user.realName}"/></td>
                    <td class="title">新密码：</td>
                    <td><input name="newPassword" type="text" value=""/></td>
                </c:when>
                <c:otherwise>
                    <td width="12%" class="title">密码：</td>
                    <td width="38%"><input name="password" type="password"/></td>
                </c:otherwise>
            </c:choose>
        </tr>
        <tr>
            <td class="title">用户类别：</td>
            <td>
                <select name="userType">
                    <option value="">--请选择--</option>
                    <option
                            <c:if test="${user.userType == '系统管理员' }">selected="selected"</c:if> value="系统管理员">系统管理员
                    </option>
                    <option
                            <c:if test="${user.userType == '服务人员' }">selected="selected"</c:if> value="服务人员">服务人员
                    </option>
                    <option
                            <c:if test="${user.userType == '投诉处理' }">selected="selected"</c:if> value="投诉处理">投诉处理
                    </option>
                </select></td>
            <td class="title">锁定标志：</td>
            <td>
                <input
                        <c:if test="${user.lock == 1 || user.lock == null }">checked="checked"</c:if> type="radio"
                        name="lock" value="1"/>正常
                <input
                        <c:if test="${user.lock == 0 }">checked="checked"</c:if> type="radio" name="lock" value="0"/>锁定
            </td>
        </tr>
    </table>
    <div class="buttonLine">
        <c:choose>
            <c:when test="${update}">
                <input type="hidden" name="action" value="update">
                <input type="submit" value="确定"/>
            </c:when>
            <c:otherwise>
                <input type="hidden" name="action" value="insert">
                <input type="submit" value="确定"/>
            </c:otherwise>
        </c:choose>


        <input type="button" onclick="location.href='/UserServlet'" value="取消"/>


    </div>
</form>
</body>
</html>
