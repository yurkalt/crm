<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <title>Tourist info</title>
</head>
<body>
<p align="center"><a href="/tourist">Tourist menu</a></p>

<table border="1">
    <tr>
        <th bgcolor="#01DF3A"><b>ID</b></th>
        <th bgcolor="#01DF3A"><b>FIRST NAME</b></th>
        <th bgcolor="#01DF3A"><b>LAST NAME</b></th>
        <th bgcolor="#01DF3A"><b>PHONE</b></th>
        <th bgcolor="#01DF3A"><b>EMAIL</b></th>
        <th bgcolor="#01DF3A"><b>BIRTHDAY</b></th>
        <th bgcolor="#01DF3A"><b>SOURCE</b></th>
    </tr>
    <c:forEach items="${allTourists}" var="tourist">
        <tr>
            <td bgcolor="#E6E6E6">${tourist.id}</td>
            <td bgcolor="#E6E6E6">${tourist.firstName}</td>
            <td bgcolor="#E6E6E6">${tourist.lastName}</td>
            <td bgcolor="#E6E6E6">${tourist.phone}</td>
            <td bgcolor="#E6E6E6">${tourist.email}</td>
            <td bgcolor="#E6E6E6">${tourist.birthday}</td>
            <td bgcolor="#E6E6E6">${tourist.source}</td>
        </tr>
    </c:forEach>
</table>


</body>
</html>