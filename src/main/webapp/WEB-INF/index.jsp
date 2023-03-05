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
    <p> <a href="/burger/new">Add Burger</a></p>
    <table class="table table-striped table-bordered text-center">
        <thead class="table-dark">
        <tr>
            <th scope="col">Burger Name</th>
            <th scope="col">Restaurant</th>
            <th scope="col">Rating (out of 5) </th>
            <th scope="col">Notes </th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="burger" items="${burgers}">
            <tr>
                <td><c:out value="${burger.burgerName}"/></td>
                <td><c:out value="${burger.restName}"/></td>
                <td><c:out value="${burger.rating}"/></td>
                <td><c:out value="${burger.notes}"/></td
                        <
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</html>
