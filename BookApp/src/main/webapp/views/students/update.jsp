<%@ page import="org.example.bookapp.entity.Group" %>
<%@ page import="org.example.bookapp.entity.Student" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Ha Duy Nam
  Date: 03-Jun-24
  Time: 9:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="card">
        <div class="card-header">
            Update student
        </div>
        <div class="card-body">
            <form action="/students/update" method="post">
                <input type="hidden" name="id" value="<c:out value="${student.id}"/>">
                <div class="mb-3">
                    <label for="name" class="form-label">Name</label>
                    <input type="text" name="name" class="form-control" id="name" placeholder="Name student" value="<c:out value="${student.name}"/>">
                </div>
                <div class="mb-3">
                    <label for="exampleFormControlInput1" class="form-label">Email address</label>
                    <input type="email" name="email" class="form-control" id="exampleFormControlInput1" placeholder="name@example.com" value="<c:out value="${student.email}"/>">
                </div>
                <div class="mb-3">
                    <label for="" class="form-label">Group</label>
                    <select name="group_id" id="" class="form-select" >
                        <c:forEach items="${groups}" var="group">
                            <option value="<c:out value="${group.id}"/>" <c:if test="${group.id == student.group.id}">selected</c:if>><c:out value="${group.name}"/></option>
                        </c:forEach>
                    </select>
                </div>
                <div>
                    <button class="btn btn-primary">Save</button>
                </div>

            </form>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
</body>
</html>
