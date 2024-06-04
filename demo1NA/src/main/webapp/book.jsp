<%--
  Created by IntelliJ IDEA.
  User: Ha Duy Nam
  Date: 29-May-24
  Time: 3:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book Manager</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h1 class="mt-4">Book Manager</h1>

    <!-- Form thêm sách -->
    <form action="books" method="post" class="mb-4">
        <input type="hidden" name="action" value="add">
        <div class="form-group">
            <label for="name">Name</label>
            <input type="text" class="form-control" id="name" name="name" required>
        </div>
        <div class="form-group">
            <label for="price">Price</label>
            <input type="number" class="form-control" id="price" name="price" required>
        </div>
        <div class="form-group">
            <label for="description">Description</label>
            <textarea class="form-control" id="description" name="description" required></textarea>
        </div>
        <div class="form-group">
            <label for="author">Author</label>
            <input type="text" class="form-control" id="author" name="author" required>
        </div>
        <button type="submit" class="btn btn-primary">Add Book</button>
    </form>

    <!-- Hiển thị danh sách sách -->
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Price</th>
            <th>Description</th>
            <th>Author</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="book" items="${books}">
            <tr>
                <td>${book.id}</td>
                <td>${book.name}</td>
                <td>${book.price}</td>
                <td>${book.description}</td>
                <td>${book.author}</td>
                <td>
                    <!-- Form cập nhật sách -->
                    <form action="books" method="post" style="display: inline;">
                        <input type="hidden" name="action" value="update">
                        <input type="hidden" name="id" value="${book.id}">
                        <input type="text" name="name" value="${book.name}" required>
                        <input type="number" name="price" value="${book.price}" required>
                        <input type="text" name="description" value="${book.description}" required>
                        <input type="text" name="author" value="${book.author}" required>
                        <button type="submit" class="btn btn-success btn-sm">Update</button>
                    </form>
                    <!-- Form xoá sách -->
                    <form action="books" method="post" style="display: inline;">
                        <input type="hidden" name="action" value="delete">
                        <input type="hidden" name="id" value="${book.id}">
                        <button type="submit" class="btn btn-danger btn-sm">Delete</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
