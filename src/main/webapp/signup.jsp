<%--
  Created by IntelliJ IDEA.
  User: Tim
  Date: 10/27/2016
  Time: 12:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="head.jsp"></jsp:include>
<script type="text/javascript">
    function checkDisplay() {
        if(event.srcElement.id == "optionsRadios1") {
            var ele = document.getElementById("ifRentalTrue");
            ele.style.display = "block";
            var ele2 = document.getElementById("ifRentalFalse");
            ele2.style.display = "none";
        } else if(event.srcElement.id == "optionsRadios2") {
            var ele = document.getElementById("ifRentalFalse");
            ele.style.display = "block";
            var ele2 = document.getElementById("ifRentalTrue");
            ele2.style.display = "none";
        }
    }
</script>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div style="width:80%;margin:auto;">
    <div>${errorMsg}</div>
    <form action="/signUp" method="post" style="">
        <div>
        <div class="form-group">
            <label for="FirstName">First Name</label>
            <input type="text" name="FirstName" class="form-control" id="FirstName" placeholder="first name" required>
        </div>
        <div class="form-group">
            <label for="LastName">Last Name</label>
            <input type="text" name="LastName" class="form-control" id="LastName" placeholder="last name" required>
        </div>
        <div class="form-group">
            <label for="Email1">Email address</label>
            <input type="email" name="Email1" class="form-control" id="Email1" placeholder="Email" required>
        </div>
        <div class="form-group">
            <label for="Phone">Phone</label>
            <input type="text" name="Phone" class="form-control" id="Phone" placeholder="phone" required>
        </div>
        <div class="radio" id="option1" onchange="checkDisplay()">
            <label>
                <input type="radio" name="optionsRadios" id="optionsRadios1" value="option1" required>
                Joining a House
            </label>
        </div>
        <div class="radio"  id="option" onchange="checkDisplay()">
            <label>
                <input type="radio" name="optionsRadios" id="optionsRadios2" value="option2" onselect="checkDisplay()">
                Creating a House
            </label>
        </div>
        <div id="ifRentalTrue" style="display:none;">
        <div class="form-group">
            <label for="RentalId">Rental Id</label>
            <input type="number" name="RentalId" class="form-control" id="RentalId" placeholder="Rental Id">
        </div>
        </div>
        <div id="ifRentalFalse" style="display:none;">
            <div class="form-group">
                <label for="Address">Address</label>
                <input type="text" name="Address" class="form-control" id="Address" placeholder="Address">
            </div>
            <div class="form-group">
                <label for="City">City</label>
                <input type="text" name="City" class="form-control" id="City" placeholder="City">
            </div>
            <div class="form-group">
                <label for="State">State</label>
                <input type="text" name="State" class="form-control" id="State" placeholder="State">
            </div>
            <div class="form-group">
                <label for="Zip">Zip Code</label>
                <input type="text" name="Zip" class="form-control" id="Zip" placeholder="Zip">
            </div>
            <div class="form-group">
                <label for="LeaseStart">Lease Start</label>
                <input type="date" name="LeaseStart" class="form-control" id="LeaseStart" placeholder="Lease Start">
            </div>
            <div class="form-group">
                <label for="LeaseEnd">Lease End</label>
                <input type="date" name="LeaseEnd" class="form-control" id="LeaseEnd" placeholder="Lease End">
            </div>
            <div class="form-group">
                <label for="Rent">Rent</label>
                <input type="number" name="Rent" class="form-control" id="Rent">
            </div>
        </div>
        <div class="form-group">
            <label for="UserName">User Name</label>
            <input type="text" name="UserName" class="form-control" id="UserName" placeholder="username" required>
        </div>
        <div class="form-group">
            <label for="Password">Password</label>
            <input type="password" name="Password" class="form-control" id="Password" required>
        </div>

        </div>
        <br/>
        <button type="submit" class="btn btn-default col-sm-offset-3"style="display: block;margin-bottom:4em;">Submit
        </button>
    </form>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>
