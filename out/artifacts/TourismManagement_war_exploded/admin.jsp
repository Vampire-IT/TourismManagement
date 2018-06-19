<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*,java.lang.*,javax.servlet.http.HttpSession" %>
<html>
<%
    String loginName = (String)session.getAttribute("loginName");
    String loginType = (String)session.getAttribute("loginType");
%>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>旅游局管理系统</title>
    <link rel="stylesheet" type="text/css" href="resources/css/main.css"/>
    <script type="text/javascript" src="resources/js/Jquery.js"></script>
    <script type="text/javascript" src="resources/js/main.js"></script>
</head>

<body>
<!--顶部Banner-->
<div id="main_topDiv">
    <div id="main_topMenuDiv"> 当前用户：${loginName}&nbsp;&nbsp;用户权限：${loginType}&nbsp;&nbsp;
        <a target="mainIFrame" href="LoginServlet?action=show&loginName=${loginName}">个人资料</a>&nbsp;&nbsp;
        <a href="LoginServlet?action=exit">退出系统</a>
    </div>
    <div id="main_topLineDiv"></div>
</div>
<!--左侧菜单栏-->
<div id="main_leftDiv">
    <div id="main_menuTopButton">
        <div></div>
        <img src="resources/images/tb_split.gif" width="1" height="38" alt=""/>
        <div></div>
    </div>
    <div class="main_sysTitle"><img src="resources/images/icon01.gif" width="11" height="6" alt=""/>旅游局管理功能</div>
    <div id="main_leftMenuListDiv">
        <div id="main_leftMenuIconDiv"></div>
        <ul id="main_leftMenuListUl">
            <li>用户管理<a href="/UserServlet"></a></li>
            <li>投诉类别管理<a href="/CTypeServlet"></a></li>
        </ul>
    </div>
    <div class="main_sysTitle"></div>
</div>
</div>
<div id="main_frameDiv">
    <iframe name="mainIFrame" title="mainIFrame" id="mainIFrame" frameborder="0" scrolling="yes" src="about:blank" allowtransparency="true"></iframe>
</div>
</body>
</html>
