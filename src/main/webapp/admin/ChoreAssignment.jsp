<%--
  Created by IntelliJ IDEA.
  User: Tim
  Date: 12/3/2016
  Time: 10:55 PM
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

<div style="margin:auto; width:70%;">

    <form methoid="get" action="/admin/userchore">
        <div style="width:45%;display:inline-block;height:400px;overflow-y:scroll;vertical-align: top;" class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title">Select RoomMate</h3>
            </div>
            <div class="panel-body">
                <c:forEach items="${users}" var="u">
                    <input type="radio" id="${u.id}" name="roommate" value="${u.id}"/>${u.id}: ${u.firstName} ${u.lastName}
                    <br />
                </c:forEach>
            </div>
        </div>
        <div style="width:45%;display:inline-block;height:400px;overflow-y:scroll;vertical-align: top;float:right;"
             class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title">Assign to Chore</h3>
            </div>
            <div class="panel-body">
                <c:forEach items="${chores}" var="c">
                    <input type="radio" id="${c.id}" name="chore" value="${c.id}"/>${c.id}: ${c.chore_name}
                    <br />
                </c:forEach>
            </div>
        </div>
        <br/>
        Chore Due Date:
        <input type="date" name="DueDate1" id="date" class="form-control"
        style="width: 50%;" required>
        <br/>
        <button TYPE="SUBMIT" VALUE="Submit" class="form-control">Submit</button>
    </form>

</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
