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
    <title>Title</title>
</head>
<body>
    <c:if test="false">
        <h1>我是猪</h1>
    </c:if>

    <%
        //判断resquest中的一个list是否为空，不为空则遍历集合
        List list = new ArrayList();
        list.add("aaaa");
        request.setAttribute("list",list);
    %>
    <c:if test="${not empty list}">
        便利集合
    </c:if>


</body>
</html>
