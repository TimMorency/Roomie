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
    <title>Bills</title>
    <jsp:include page="head.jsp" />
</head>
<body>
<jsp:include page="loggedInHeader.jsp"></jsp:include>

<div style="width:70%; margin:auto;">
    <div style="width:45%; float:left; display:block;">
        <h2 style="text-align: center;">Rentals Bills</h2>
        <table class="table table-hover" style="overflow-y: scroll;">
            <tr>
                <th>Bill Name</th>
                <th>Bill Amount</th>
                <th>Due Date</th>
            </tr>
            <c:forEach items="${bills}" var="b">
                <tr>
                    <td>${b.bill_name}</td>
                    <td>${b.bill_amt}</td>
                    <td>${b.due_date}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div style="width:45%; float:right; display:block;">
        <h2 style="text-align: center;">My Bills</h2>
        <table class="table table-hover" style="overflow-y: scroll;">
            <tr>
                <th>My Amount Due</th>
                <th>My Amount Paid</th>
                <th>My Pay By Date</th>
            </tr>
            <c:forEach items="${userBills}" var="ub">
                <tr>
                    <td>${ub.split_amt}</td>
                    <td>${ub.paid_amt}</td>
                    <td>${pay_by}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>

<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
