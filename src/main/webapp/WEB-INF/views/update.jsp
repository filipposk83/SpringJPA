<%-- 
    Document   : update
    Created on : 8 Ιουλ 2019, 6:40:58 μμ
    Author     : filippos
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update a Trainer</title>
    </head>
    <body>
        <h1>Update a Trainer</h1><br>
        <form:form  action="updateform" method="POST" modelAttribute="trainer">
            First Name : <form:input path="firstName" /><br>
            Last Name : <form:input path="lastName" /><br>
            Subject : <form:input path="subject" /><br>
            <form:hidden path="trainerId" />
            <input type="submit" value="Update" />
        </form:form>
    </body>
</html>
