<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: 唐绍权
  Date: 2020/3/11
  Time: 16:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>星期几</title>
</head>
<body>

    <%
        //完成数字判断星期几
        //1. 存一个数字
        //2. 用choose选出数字  相当于Switch
        //3. 用When 标签判断   相当于case
        //4. 用otherwise标签做其他情况说明    相当于default

        request.setAttribute("number",1);
    %>
    <c:choose>
        <c:when test="${number == 1}"> 星期一</c:when>
        <c:when test="${number == 2}"> 星期二</c:when>
        <c:when test="${number == 3}"> 星期三</c:when>
        <c:when test="${number == 4}"> 星期四</c:when>
        <c:when test="${number == 5}"> 星期五</c:when>
        <c:when test="${number == 6}"> 星期六</c:when>
        <c:when test="${number == 7}"> 星期七</c:when>


        <c:otherwise>有误！</c:otherwise>

    </c:choose>


</body>
</html>
