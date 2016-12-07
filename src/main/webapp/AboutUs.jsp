<%--
  Created by IntelliJ IDEA.
  User: Tim
  Date: 12/6/2016
  Time: 6:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>How it Works</title>
</head>
<jsp:include page="head.jsp"></jsp:include>
<body>
<jsp:include page="header.jsp"></jsp:include>
<h2>Roomie</h2>
<br/>
<p>Roomie is a website designed to help track bills and chores with your roommates. It allows you to create bills and
split them with your room mates and create chores to assign to your room mates. A simple tracking website used to
help sort out every day life with room mates.
</p>
<p>
    It starts with creating a Rental, this would be your apartment/ townhouse or what ever you share with your room mates.
    You will also create a user here, this user will automatically be assigned to your rental. From here room mates can join
    by entering in the rental id in when signing up their user, this assigns them to your rental. The rental Id can be found on
    the home page when logged in.
</p>
<p>
    Once all of your users are added you can create Bills and chores and start assigning them to people. To Create a bill
    or a chore go to the Add Bill / Chore tab here you can create a bill that you and your room mates have to pay or a chore
    that some one has to complete.
</p>
<p>
    Once a bill is created you can split it with multiple people in your apartment, Roomie will automatically split it for
    you based on the bills amount and how many people the bill is split with. After the bill is created and split each room
    mate can go to their Bills page and select the Bill under my bill. Each time they pay a little bit of the bill off it
    will be added to their amount paid and once the bill has been completely paid it will be removed from their bill list.
</p>
<p>
    Chores are a little different. You can create a chore and assign it more than once, for instance you dont just clean
    the bathroom once, you'll have to do it multiple times throughout the year. So we can create the Chore clean the bathroom
    on the Add bills / chore tab and then assign it on the Assign Chores tab. When assigning a chore you select a Room mate
    to assign it to, then you select the chore you want to assign and lastly you select a date it needs to be completed by.
    From there the user can go into their chores tab and see what chores need to be completed and by when. By clicking on
    the chore they can mark it complete after the chore has been completed and then the chore will be removed from their
    upcoming chore list.
</p>
<p>
    Thanks for reading now go out and organize with your messy room mates, good luck and have fun.
</p>
<jsp:include page="footer.jsp"/>
</body>
</html>
