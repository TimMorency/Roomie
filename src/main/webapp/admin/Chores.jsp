<%--
  Created by IntelliJ IDEA.
  User: Tim
  Date: 11/28/2016
  Time: 10:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Chores</title>
    <jsp:include page="head.jsp" />
</head>
<body>
<jsp:include page="loggedInHeader.jsp"></jsp:include>

<div style="width:70%; margin:auto;">
    <div style="width:45%; float:left; display:block;">
        <h2 style="text-align: center;">Rentals Chores</h2>
        <table class="table table-hover" style="overflow-y: scroll;">
            <tr>
                <th>Chore Name</th>
                <th>Chore Description</th>
                <th>ID</th>
            </tr>
            <c:forEach items="${chores}" var="b">
                <tr>
                    <td>${b.chore_name}</td>
                    <td>${b.chore_description}</td>
                    <td>${b.id}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div style="width:45%; float:right; display:block;">
        <h2 style="text-align: center;">My Chores</h2>
        <table class="table table-hover" style="overflow-y: scroll;">
            <tr>
                <th>My Chore</th>
                <th>Due Date</th>
                <th>Completed</th>
            </tr>
            <c:forEach items="${uChores}" var="ub">
                <tr>
                    <td><a href="/admin/uc?userchore=${ub.id}">${ub.chore_id}</a></td>
                    <td>${ub.due_date}</td>
                    <td>${ub.completed}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>

<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
