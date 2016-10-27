<!DOCTYPE html>
<html lang="en">
<jsp:include page="head.jsp"></jsp:include>
<body>
<jsp:include page="header.jsp"></jsp:include>
<FORM ACTION="j_security_check" METHOD="POST">
<div style="width:80%;margin:auto;">
    <div class="form-group">
        <label for="UserName">User name</label>
        <input type="text" class="form-control" id="UserName" placeholder="UserName" NAME="j_username">
    </div>
    <div class="form-group">
        <label for="Password">Password</label>
        <input type="PASSWORD" class="form-control" id="Password" placeholder="Password" NAME="j_password">
    </div>
    <input TYPE="SUBMIT" VALUE="Log In" class="form-control" />
    </div>
</FORM>
<jsp:include page="footer.jsp"/>
</body>
</html>