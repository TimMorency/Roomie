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
<body>
<jsp:include page="header.jsp"></jsp:include>
<div style="width:80%;margin:auto;">
    <form>
        <div class="form-group">
            <label for="FirstName">First Name</label>
            <input type="text" class="form-control" id="FirstName" placeholder="first name">
        </div>
        <div class="form-group">
            <label for="LastName">Last Name</label>
            <input type="text" class="form-control" id="LastName" placeholder="last name">
        </div>
        <div class="form-group">
            <label for="Email1">Email address</label>
            <input type="email" class="form-control" id="Email1" placeholder="Email">
        </div>
        <div class="form-group">
            <label for="Phone">Phone</label>
            <input type="text" class="form-control" id="Phone" placeholder="phone">
        </div>
        <div class="form-group">
            <label for="UserName">User Name</label>
            <input type="text" class="form-control" id="UserName" placeholder="username">
        </div>
        <div class="form-group">
            <label for="Password">Password</label>
            <input type="password" class="form-control" id="Password" >
        </div>
    </form>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>
