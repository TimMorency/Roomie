<%--
  Created by IntelliJ IDEA.
  User: Tim
  Date: 12/5/2016
  Time: 9:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Your Chores</title>
    <jsp:include page="head.jsp" />
</head>
<body>
<jsp:include page="loggedInHeader.jsp"></jsp:include>

<div class="panel panel-default" style="width: 70%; margin:auto;">
    <!-- Default panel contents -->
    <div class="panel-heading">${chore.chore_name}</div>
    <div class="panel-body">
        <p></p>
    </div>
    <form method="get" action="/admin/ucUp">
    <!-- List group -->
    <ul class="list-group">
        <li class="list-group-item">Description: ${chore.chore_description}</li>
        <li class="list-group-item">Due Date: ${uchore.due_date}</li>
        <li class="list-group-item">Completed: <input type="checkbox" name="complete" /></li>
        <li class="list-group-item">
            <input type="hidden" name="ucid" value="${uchore.id}">
            <button TYPE="SUBMIT" VALUE="Submit" class="form-control">Submit</button></li>
    </ul>
    </form>
</div>

<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
