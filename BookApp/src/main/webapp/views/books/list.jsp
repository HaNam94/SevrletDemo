<%@ page import="org.example.bookapp.entity.Book" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Ha Duy Nam
  Date: 30-May-24
  Time: 11:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% List<Book> books = (List<Book>) request.getAttribute("books"); %>
<html>
<head>
    <title>Book List</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        tr:hover {
            background-color: #f1f1f1;
        }
    </style>
</head>
<body>
<div class="container mt-5">
    <h2>Book List</h2>
    <a href="/books/create" class="btn btn-primary mb-3">Add New Book</a>
    <table class="table table-bordered table-hover">
        <thead class="thead-light">
        <tr>
            <th>#</th>
            <th>Name</th>
            <th>Description</th>
            <th>Price</th>
            <th>Author</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:set var="i" value="1"/>
        <c:forEach items="${books}" var="book">
            <tr>
                <td><c:out value="${i}"/></td>
                <td><c:out value="${book.name}"/> </td>
                <td><c:out value="${book.description}"/> </td>
                <td><c:out value="${book.price}"/> </td>
                <td><c:out value="${book.author}"/> </td>
                <td><a href="${pageContext.request.contextPath}/books/delete?id=<c:out value="${book.id}"/>"
                       class="btn btn-danger btn-sm">Delete</a></td>
            </tr>
            <c:set var="i" value="${i + 1}"/>
        </c:forEach>
        </tbody>
    </table>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
