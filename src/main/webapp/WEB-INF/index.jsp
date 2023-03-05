<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Burgers</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
<div class="container">
    <h1 class="text-center"> Welcome to Burgerpledia  </h1>
    <p> <a href="/burger/new" class="btn btn-outline-primary">Add Burger</a></p>
    <table class="table table-striped table-bordered text-center">
        <thead class="table-dark">
        <tr>
            <th scope="col">Burger Name</th>
            <th scope="col">Restaurant</th>
            <th scope="col">Rating (out of 5) </th>
            <th scope="col">Notes </th>
            <th scope="col">Actions </th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="burger" items="${burgers}">
            <tr>
                <td><c:out value="${burger.burgerName}"/></td>
                <td><c:out value="${burger.restName}"/></td>
                <td><c:out value="${burger.rating}"/></td>
                <td><c:out value="${burger.notes}"/></td
            </tr>

<%--            <td>--%>
<%--                <a href="/burger/${burger.id}/delete" class="btn btn-danger">Delete</a>--%>
<%--            </td>--%>

            <td>
                <form action="/burger/${burger.id}" method="POST">
                    <input type="hidden" name="_method" value="delete"/>
                    <button class="btn btn-danger">Delete</button>
                </form>
                <a href="/burger/${burger.id}" class="btn btn-primary">Update</a>
            </td>

        </c:forEach>

        </tbody>
    </table>
</div>

</body>
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</html>
