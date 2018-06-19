<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*,java.lang.*" %>
<%@ page import="com.priv.tm.active.CTypeActive" %>
<%@ page import="com.priv.tm.base.CType" %>
<%
    CTypeActive cTypeActive = new CTypeActive();
    List<CType> cTypeList = cTypeActive.findCT(null, "1");
    request.setAttribute("cTypeList", cTypeList);
%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>投诉登记</title>
    <link rel="stylesheet" type="text/css" href="../resources/css/page.css"/>
    <script type="text/javascript" src="../resources/js/jquery-1.9.0.min.js"></script>
    <script type="text/javascript" src="../resources/js/main.js"></script>
</head>

<body>
<c:choose>
    <c:when test="${update}">
        <div class="navBar">
            首页 &gt; 投诉管理 &gt; 修改
        </div>
    </c:when>
    <c:otherwise>
        <div class="navBar">
            首页 &gt; 投诉管理 &gt; 登记
        </div>
    </c:otherwise>
</c:choose>
<form action="/ComServlet" method="post">
    <table border="0" cellpadding="0" cellspacing="1" class="form">
        <tr>
            <th colspan="4">投诉信息&nbsp;</th>
        </tr>
        <tr>
            <td width="12%" class="title">投诉单号：</td>
            <td width="38%"><input type="text" <c:if test="${update}">readonly="readonly"</c:if> name="cId"
                                   value="${complain.cId}"/>&nbsp;
            </td>
            <td width="12%" class="title">投诉人：</td>
            <td width="38%"><input type="text" name="cName" value="${complain.cName}"/></td>
        </tr>
        <tr>
            <td class="title">投诉电话：</td>
            <td><input type="text" name="cTel" value="${complain.cTel}"/></td>
            <td class="title">投诉对象类别：</td>
            <td><label>
                <select name="cTargetType">
                    <option value="">--请选择--</option>
                    <option
                            <c:if test="${complain.cTargetType == '住宿'}">selected="selected"</c:if> value="住宿">住宿
                    </option>
                    <option
                            <c:if test="${complain.cTargetType == '景区'}">selected="selected"</c:if> value="景区">景区
                    </option>
                    <option
                            <c:if test="${complain.cTargetType == '饭店'}">selected="selected"</c:if> value="饭店">饭店
                    </option>
                    <option
                            <c:if test="${complain.cTargetType == '实景演出'}">selected="selected"</c:if> value="实景演出">实景演出
                    </option>
                    <option
                            <c:if test="${complain.cTargetType == '旅行社'}">selected="selected"</c:if> value="旅行社">旅行社
                    </option>
                </select>
            </label></td>
        </tr>
        <tr>
            <td class="title">投诉对象：</td>
            <td><input type="text" name="cTarget" value="${complain.cTarget}"/></td>
            <td class="title">投诉类别：</td>
            <td>
                <select name="cType">
                    <c:forEach var="cType" items="${cTypeList }">
                        <c:choose>
                            <c:when test="${(cType.cTId).equals(complain.cType) }">
                                <option value="${cType.cTId }" selected="selected">${cType.cTName }</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${cType.cTId }">${cType.cTName }</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select>
        </tr>
        <tr>
            <td class="title">投诉内容：</td>
            <td colspan="3"><label>
                <textarea name="cCont" cols="100" rows="5">${complain.cCont}</textarea>
            </label></td>
        </tr>
        <tr>
            <td class="title">记录人：</td>
            <td><input type="text" name="cRecorder" value="${complain.cRecorder}"/>&nbsp;</td>
            <td class="title"></td>
            <td></td>
            <%--<td class="title">记录时间：</td>--%>
            <%--<td>--%>
            <%--<input type="text" name="textfield3"/></td>--%>
            <%--</tr>--%>
        <tr>
            <td class="title">备注：</td>
            <td colspan="3"><label>
                <textarea name="cRemark" cols="100" rows="5">${complain.cRemark}</textarea>
            </label></td>
        </tr>
    </table>
    <div class="buttonLine">
        <c:choose>
            <c:when test="${update}">
                <input type="hidden" name="action" value="update">
                <input type="hidden" name="cId" value="${complain.cId}">
                <input type="submit" value="确定"/>
            </c:when>
            <c:otherwise>
                <input type="hidden" name="action" value="insert">
                <input type="submit" value="确定"/>
            </c:otherwise>
        </c:choose>
        <input type="button" onclick="location='/ComServlet'" value="取消"/>
    </div>
</form>
</body>
</html>
