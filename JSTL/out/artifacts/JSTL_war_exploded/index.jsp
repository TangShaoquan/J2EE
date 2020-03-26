<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="dmain.User" %><%--
  Created by IntelliJ IDEA.
  User: 唐绍权
  Date: 2020/3/11
  Time: 16:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>案例</title>
  </head>
  <body>
  <%
    List list = new ArrayList();
    list.add(new User("张三","23","男"));
    list.add(new User("张1","23","男"));
    list.add(new User("张2","23","男"));
    list.add(new User("张3","23","男"));
    list.add(new User("张4","23","男"));

    request.setAttribute("list",list);

  %>
  <table border="1" align="center" width="500">
    <tr>
      <th>编号</th>
      <th>姓名</th>
      <th>年龄</th>
      <th>性别</th>
    </tr>
    <%--数据行--%>
    <c:forEach items="${list}" var="user" varStatus="s">
      <tr>
        <td>${s.count}</td>
        <td>${user.name}</td>
        <td>${user.age}</td>
        <td>${user.gender}</td>
      </tr>
    </c:forEach>
  </table>

  </body>
</html>
