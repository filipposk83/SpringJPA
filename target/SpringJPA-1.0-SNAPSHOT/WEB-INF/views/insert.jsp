<%-- 
    Document   : newtrainer
    Created on : 7 Ιουλ 2019, 10:25:59 μμ
    Author     : filippos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert a Trainer</title>
    </head>
    <body>
        <h1>Insert a Trainer</h1><br>
        <form:form action="insertTrainer" method="POST" modelAttribute="Trainer">
            First Name : <form:input path="firstName" /><br>
            Last Name : <form:input path="lastName" /><br>
            Subject : <form:input path="subject" /><br>
            <form:hidden path="trainerId" />
            <input type="submit" value="Save" />
        </form:form>
    </body>
</html>
