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
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css">
        <script type="text/javascript" language="javascript" src="https://code.jquery.com/jquery-3.3.1.js"></script>
        <script type="text/javascript" language="javascript" src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>   
        <script type="text/javascript">
            $(document).ready(function() {
                $('#trainers').DataTable();
            });
        </script>
    </head>
    <body>
        <h1>Trainers List</h1>
        <table border="1" id="trainers">
            <thead>
                <tr>
                    <th>Trainer Id</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Subject</th>
                    <th>Delete</th>
                    <th>Update</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="tr" items="${listofTrainers}">
                    <tr>
                        <td>${tr.trainerId}</td>
                        <td>${tr.firstName}</td>
                        <td>${tr.lastName}</td>
                        <td>${tr.subject}</td>
                        <td><a href="delete/${tr.trainerId}" target="_blank">Delete</a></td>
                        <td><a href="update/${tr.trainerId}" target="_blank">Update</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <h2>${success}</h2>
        <a href="/SpringJPA">Go to Main Menu</a>
    </body>
</html>
