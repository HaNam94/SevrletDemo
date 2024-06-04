<%@ page import="org.example.bookapp.entity.Student" %>
<%@ page import="org.example.bookapp.entity.Group" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Ha Duy Nam
  Date: 03-Jun-24
  Time: 9:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Group group = (Group) request.getAttribute("group");
    List<Student> students = (List<Student>) request.getAttribute("students");
%>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="card">
        <div class="card-header">
            <h2>Class Information</h2>
        </div>
        <div class="card-body">
            <h3>Class Name: <c:out value="${group.name}"/></h3>
            <h4>Student List:</h4>
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>#</th>
                    <th>Name</th>
                    <th>Email</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${students}" var="student" varStatus="status">
                    <tr>
                        <td><c:out value="${status.index + 1}"/></td>
                        <td><c:out value="${student.name}"/></td>
                        <td><c:out value="${student.email}"/></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <a href="/students/list" class="btn btn-primary">Back to List</a>
        </div>
    </div>
</div>


<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
</body>
</html>
