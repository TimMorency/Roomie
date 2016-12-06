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
    <title>Your Bills</title>
    <jsp:include page="head.jsp" />
</head>
<body>
<jsp:include page="loggedInHeader.jsp"></jsp:include>

<div class="panel panel-default" style="width: 70%; margin:auto;">
    <!-- Default panel contents -->
    <div class="panel-heading">${bill.bill_name}</div>
    <div class="panel-body">
        <p></p>
    </div>
    <form method="get" action="/admin/ubUp">
    <!-- List group -->
    <ul class="list-group">
        <li class="list-group-item">Due Date: ${ubill.pay_by}</li>
        <li class="list-group-item">Your Amount: ${ubill.split_amt}</li>
        <li class="list-group-item">Paid: ${ubill.paid_amt}</li>
        <li class="list-group-item">Pay: <input type="number" id="amt" name="amt"></li>
        <li class="list-group-item">
            <input type="hidden" name="ubid" value="${ubill.id}">
            <button TYPE="SUBMIT" VALUE="Submit" class="form-control">Submit</button></li>
    </ul>
    </form>
</div>

<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
