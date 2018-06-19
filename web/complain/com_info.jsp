<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*,java.lang.*" %>
<%@ page import="com.priv.tm.active.CTypeActive" %>
<%@ page import="com.priv.tm.base.CType" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>投诉处理</title>
    <link rel="stylesheet" type="text/css" href="../resources/css/page.css"/>
    <script type="text/javascript" src="../resources/js/jquery-1.9.0.min.js"></script>
    <script type="text/javascript" src="../resources/js/main.js"></script>
</head>

<body>

<div class="navBar">
    首页 &gt; 投诉处理 &gt; 信息
</div>
<table border="0" cellpadding="0" cellspacing="1" class="form">
    <tr>
        <th colspan="4">投诉信息&nbsp;</th>
    </tr>
    <tr>
        <td width="12%" class="title">投诉单号：</td>
        <td width="38%">${complain.cId}&nbsp;
        </td>
        <td width="12%" class="title">投诉人：</td>
        <td width="38%">${complain.cName}</td>
    </tr>
    <tr>
        <td class="title">投诉电话：</td>
        <td>${complain.cTel}</td>
        <td class="title">投诉对象类别：</td>
        <td><label>${complain.cTargetType}</label></td>
    </tr>
    <tr>
        <td class="title">投诉对象：</td>
        <td>${complain.cTarget}</td>
        <td class="title">投诉类别：</td>
        <td>${complain.cTName}</td>
    </tr>
    <tr>
        <td class="title">投诉内容：</td>
        <td colspan="3"><label>${complain.cCont}</label></td>
    </tr>
    <tr>
        <td class="title">记录人：</td>
        <td>${complain.cRecorder}&nbsp;</td>
        <td class="title">记录时间：</td>
        <td>${complain.cTime}</td>
    </tr>
    <tr>
        <td class="title">备注：</td>
        <td colspan="3"><label>${complain.cRemark}</label></td>
    </tr>
</table>
<table border="0" cellpadding="0" cellspacing="1" class="form">
    <tr>
        <th colspan="4">处理信息&nbsp;</th>
    </tr>
    <tr>
        <td width="12%" class="title">处理人：</td>
        <td width="38%">${dispose.dName}&nbsp;</td>
        <td width="12%" class="title">处理时间：</td>
        <td width="38%"><label>${dispose.dTime}</label></td>
    </tr>
    <tr>
        <td width="12%" class="title">处理结果：</td>
        <td width="38%"><label>${dispose.dFinish}</label></td>
        <td width="12%" class="title">处理内容：</td>
        <td width="38%"><label>${dispose.dCont}</label></td>
    </tr>
</table>
<table border="0" cellpadding="0" cellspacing="1" class="form">
    <tr>
        <th colspan="4">反馈信息&nbsp;</th>
    </tr>
    <tr>
        <td width="12%" class="title">反馈人：</td>
        <td width="38%"><label>${feedback.fName}</label></td>
        <td width="12%" class="title">反馈时间：</td>
        <td width="38%"><label>${feedback.fTime}</label></td>
    </tr>
    <tr>
        <td class="title">反馈内容：</td>
        <td colspan="3"><label>${feedback.fCont}</label></td>
    </tr>
</table>
<div class="buttonLine">


    <c:choose>
        <c:when test="${temp}">
            <input type="button" onclick="location='/AssignServlet'" value="返回"/>
        </c:when>
        <c:otherwise>
            <input type="button" onclick="location='/ComDisServlet'" value="返回"/>
        </c:otherwise>
    </c:choose>

</div>
</body>
</html>
