<%--
  Created by IntelliJ IDEA.
  User: Ha Duy Nam
  Date: 30-May-24
  Time: 11:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Books</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
</head>
<body>
<div class="container mt-5">
    <h2>Form Create Books</h2>
    <form action="/books/create" method="post">
        <div class="form-group">
            <label for="id">Id:</label>
            <input type="number" class="form-control" id="id" name="id" required />
        </div>
        <div class="form-group">
            <label for="name">Name:</label>
            <input type="text" class="form-control" id="name" name="name" required />
        </div>
        <div class="form-group">
            <label for="desc">Description:</label>
            <input type="text" class="form-control" id="desc" name="description" required />
        </div>
        <div class="form-group">
            <label for="price">Price:</label>
            <input type="text" class="form-control" id="price" name="price" required />
        </div>
        <div class="form-group">
            <label for="author">Author:</label>
            <input type="text" class="form-control" id="author" name="author" required />
        </div>
        <button type="submit" class="btn btn-primary">Save</button>
    </form>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</form>
</body>
</html>
