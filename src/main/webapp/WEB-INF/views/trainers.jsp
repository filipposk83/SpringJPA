<%-- 
    Document   : trainers
    Created on : 5 Ιουλ 2019, 10:14:40 πμ
    Author     : filippos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Trainers</title>
    </head>
    <body>
        <h1>Trainers List</h1>
        <c:forEach var="tr" items="${listofTrainers}">
            <p>  ${tr.trainerId} / ${tr.firstName} ${tr.lastName} (${tr.subject})  <a href="delete/${tr.trainerId}" target="_blank">Delete</a> | <a href="update/${tr.trainerId}" target="_blank">Update</a></p>
        </c:forEach>
        <h2>${success}</h2>
        <a href="/SpringJPA">Go to Main Menu</a>
    </body>
</html>
