<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*,java.lang.*" %>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>欢迎登录旅游业务管理平台</title>
    <link href="resources/css/login.css" rel="stylesheet" type="text/css"/>
    <script language="JavaScript" src="resources/js/jquery-1.9.0.min.js"></script>
    <script language="javascript">
        $(function () {
            $('.loginbox').css({
                'position': 'absolute',
                'left': ($(window).width() - 692) / 2
            });
            $(window).resize(function () {
                $('.loginbox').css({
                    'position': 'absolute',
                    'left': ($(window).width() - 692) / 2
                });
            })
        });
    </script>

</head>

<body style="background-color:#4D7600; background-image:url(images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">

<div id="main_topDiv">
    <div id="main_topMenuDiv"></div>
    <div id="main_topLineDiv"></div>
</div>

<div class="loginbody">

    <span class="systemlogo"></span>

    <div class="loginbox">
        <form action="/LoginServlet" method="post">
            <ul>
                <li><input name="loginUser" type="text" class="loginuser" value="${userName}"
                           onclick="JavaScript:this.value=''"/><label>${userMassage}</label></li>
                <li><input name="loginPwd" type="password" class="loginpwd" value="" placeholder=""
                           onclick="JavaScript:this.value=''"/><label>${pwdMassage}</label></li>
                <li><input name="" type="submit" class="loginbtn" value="登录"/>
                </li>
                <li><label>${lockMassage}</label></li>
            </ul>
        </form>
    </div>

</div>

</body>

</html>