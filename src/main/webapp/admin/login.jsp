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
<div style="width:70%;margin:auto;height:250px;display: block;">
    <h2>${rental.address}</h2>
    <ul style="width:40%;display:inline-block;" class="list-group">

        <li class="list-group-item">Rental ID: ${rental.id}</li>
        <li class="list-group-item" id="addr" >Rental Mailing Address: ${rental.address} ${rental.city}
                ${rental.state} ${rental.zip}</li>

        <li class="list-group-item">Lease Start: ${rental.lease_start}</li>
        <li class="list-group-item">Lease End: ${rental.lease_end}</li>
    </ul>
    <div style="width:45%;float: right; height:200px;vertical-align: top;" id="map"></div>
    <script>
        function initMap() {
            console.log(document.getElementById("addr").textContent.substr(24, document.getElementById("addr").textContent.length));
            var lat1 = 0;
            var long1 = 0;
            var geocoder = new google.maps.Geocoder();
            var address = document.getElementById("addr").textContent.substr(24, document.getElementById("addr").textContent.length);

            geocoder.geocode( { 'address': address}, function(results, status) {

                console.log(status);
                if (status == google.maps.GeocoderStatus.OK) {
                    console.log(results[0].geometry.location.lat());
                    var lat2 = results[0].geometry.location.lat();
                    var long2 = results[0].geometry.location.lng();
                    var uluru = {lat: lat2, lng: long2};
                    var map = new google.maps.Map(document.getElementById('map'), {
                        zoom: 4,
                        center: uluru
                    });
                    var marker = new google.maps.Marker({
                        position: uluru,
                        map: map
                    });
                }
            });
        }
    </script>
    <script async defer
            src="https://maps.googleapis.com/maps/api/js?key=AIzaSyANwYkPCE4GVcTROxvzPL-zh3NGu1nK_os&callback=initMap">
    </script>
</div>
<br/>
<div style="width:70%; margin:auto;margin-top:15px;display: block;">
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