<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Home</title>
    <jsp:include page="head.jsp" />
    <style>
        td {
            width: 40%;
        }
    </style>
</head>
<body>
<jsp:include page="loggedInHeader.jsp"></jsp:include>
<div style="width:70%;margin:auto;">
    <h2>${rental.address}</h2>
    <ul style="width:40%;" class="list-group">

        <li class="list-group-item">Rental ID: ${rental.id}</li>
        <li class="list-group-item">Rental Mailing Address: ${rental.address} ${rental.city}
                ${rental.state} ${rental.zip}</li>

        <li class="list-group-item">Lease Start: ${rental.lease_start}</li>
        <li class="list-group-item">Lease End: ${rental.lease_end}</li>
    </ul>
</div>
<div style="width:70%; margin:auto;">
<div style="width:40%;display:inline-block;height:400px;overflow-y:scroll;vertical-align: top;" class="panel panel-default">
    <div class="panel-heading">
        <h3 class="panel-title">Bills</h3>
    </div>
    <div class="panel-body">
        <ul>
        <c:forEach items="${bills}" var="b">
            <li>${b.bill_name}: ${b.bill_amt}</li>
        </c:forEach>
        </ul>
    </div>
</div>
<div style="width:40%;display:inline-block;height:400px;overflow-y:scroll;vertical-align: top;" class="panel panel-default">
    <div class="panel-heading">
        <h3 class="panel-title">Chores</h3>
    </div>
    <div class="panel-body">
        <ul>
            <c:forEach items="${chores}" var="b">
                <li>${b.chore_name}: ${b.chore_description}</li>
            </c:forEach>
        </ul>
    </div>
</div>
    </div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>