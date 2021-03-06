<%--
  Created by IntelliJ IDEA.
  User: Tim
  Date: 11/28/2016
  Time: 10:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Chores or Bills</title>
    <jsp:include page="head.jsp" />
</head>
<body>
<jsp:include page="loggedInHeader.jsp"></jsp:include>


<div style="margin:auto; width:70%;">
<div style="width:45%; float: left;">
<form action="/admin/choreIn" method="get">
    <h2>Add a Chore</h2>
    <div class="form-group" style="width: 60%; float: left; margin: 2em;">
        Chore Name
        <input type="text" class="form-control" name="choreName" required>
    </div>
    <div class="form-group" style="width: 60%; float: left; margin: 2em;">
        Chore Description
        <input type="text" class="form-control" id="choreDescription" name="choreDescription" required>
    </div>

    <button TYPE="SUBMIT" VALUE="Submit" class="form-control">Submit</button>
</form>
</div>

    <div style="width:45%; float: right;">
        <form action="/admin/billIn" method="POST">
            <h2>Add a Bill</h2>
            <div class="form-group" style="width: 60%; float: left; margin: 2em;">
                Bill Name
                <input type="text" class="form-control" id="billName" name="billName" required>
            </div>
            <div class="form-group" style="width: 60%; float: left; margin: 2em;">
                Amount
                <input type="number" class="form-control" id="Amt" name="amt" required>
            </div>
            <div class="form-group" style="width: 60%; float: left; margin: 2em;">
                <label for="DueDate1">Due Date</label>
                <input type="date" class="form-control" id="DueDate1" name="DueDate1" required>
            </div>
            <button TYPE="SUBMIT" VALUE="Submit" class="form-control">Submit</button>
        </form>
    </div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
