<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>All Tours</title>
</head>
<body>
<p align="center"><a href="/tour">Tour menu</a></p>

<table>
    <tr>
        <th bgcolor="#01DF3A">ID</th>
        <th bgcolor="#01DF3A">START</th>
        <th bgcolor="#01DF3A">END</th>
        <th bgcolor="#01DF3A">TOURIST LIST</th>
        <th bgcolor="#01DF3A">HOTEL</th>
        <th bgcolor="#01DF3A">TO</th>
        <th bgcolor="#01DF3A">VISA</th>
        <th bgcolor="#01DF3A">AVIA</th>
        <th bgcolor="#01DF3A">PRICE</th>
        <th bgcolor="#01DF3A">CLOSURE</th>
        <th bgcolor="#01DF3A">FEEDBACK</th>
        <th bgcolor="#01DF3A">ACCOUNTING</th>
    </tr>
    <c:forEach items="${allTours}" var="tour">
        <tr>
            <td bgcolor="#E6E6E6"><b>${tour.id}</b></td>
            <td bgcolor="#E6E6E6">${tour.startDate}</td>
            <td bgcolor="#E6E6E6">${tour.endDate}</td>
            <td bgcolor="#E6E6E6">
                <table border="1">
                    <tr>
                        <th bgcolor="#7fffd4"><b>ID</b></th>
                        <th bgcolor="#7fffd4"><b>NAME</b></th>
                        <th bgcolor="#7fffd4"><b>SURNAME</b></th>
                        <th bgcolor="#7fffd4"><b>PHONE</b></th>
                        <th bgcolor="#7fffd4"><b>EMAIL</b></th>
                        <th bgcolor="#7fffd4"><b>BIRTHDAY</b></th>
                        <th bgcolor="#7fffd4"><b>SOURCE</b></th>
                    </tr>
                    <c:forEach items="${tour.touristList}" var="tourist">
                        <tr>
                            <td bgcolor="#F2F2F2">${tourist.id}</td>
                            <td bgcolor="#F2F2F2">${tourist.firstName}</td>
                            <td bgcolor="#F2F2F2">${tourist.lastName}</td>
                            <td bgcolor="#F2F2F2">${tourist.phone}</td>
                            <td bgcolor="#F2F2F2">${tourist.email}</td>
                            <td bgcolor="#F2F2F2">${tourist.birthday}</td>
                            <td bgcolor="#F2F2F2">${tourist.source}</td>
                        </tr>
                    </c:forEach>
                </table>
            </td>
            <td bgcolor="#E6E6E6">
                <table border="1">
                    <tr>
                        <th bgcolor="#dda0dd"><b>ID</b></th>
                        <th bgcolor="#dda0dd"><b>NAME</b></th>
                        <th bgcolor="#dda0dd"><b>RATE</b></th>
                        <th bgcolor="#dda0dd"><b>COUNTRY</b></th>
                        <th bgcolor="#dda0dd"><b>REGION</b></th>
                    </tr>
                    <tr>
                        <td bgcolor="#F2F2F2">${tour.hotel.id}</td>
                        <td bgcolor="#F2F2F2">${tour.hotel.name}</td>
                        <td bgcolor="#F2F2F2">${tour.hotel.rate}</td>
                        <td bgcolor="#F2F2F2"><a
                                href="getHotelsByCountry?country=${tour.hotel.country}">${tour.hotel.country}</a>
                        </td>
                        <td bgcolor="#F2F2F2"><a
                                href="getHotelsByRegion?region=${tour.hotel.region}">${tour.hotel.region}</a></td>
                    </tr>
                </table>
            </td>
            <td bgcolor="#E6E6E6">${tour.tourOperator}</td>
            <td bgcolor="#E6E6E6">${tour.visaRequired}</td>
            <td bgcolor="#E6E6E6">${tour.avia}</td>
            <td bgcolor="#E6E6E6">${tour.priceBrutto}</td>
            <td bgcolor="#E6E6E6">${tour.closureDate}</td>
            <td bgcolor="#E6E6E6"><a href="/feedback?tourId=${tour.id}">leave feedback</a></td>
            <td bgcolor="#E6E6E6"><a href="/getAccountingByTour?id=${tour.id}">update acts</a></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>