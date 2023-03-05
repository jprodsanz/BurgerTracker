<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>
<html>
<head>
    <title>New Burger</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
<div class="container">
    <h1> Create a new burger! </h1>
    <form:form action="/burger/new" method="POST" modelAttribute="newBurger"  >
        <div class="mb-3">
            <form:label for="name" class="form-label" path="burgerName">Burger Name:</form:label>
            <form:input type="text" class="form-control" id="name" aria-describedby="burgerName" path="burgerName"/>
            <form:errors path="burgerName" class="text-danger"/>
        </div>
        <div class="mb-3">
            <form:label for="restaurant" class="form-label" path="restName">Restaurant Name:</form:label>
            <form:input type="text" class="form-control" id="restaurant" aria-describedby="restName" path="restName"/>
            <form:errors path="restName" class="text-danger"/>
        </div>
        <div class="mb-3">
            <form:label for="rating" class="form-label" path="rating">Rating:</form:label>
            <form:input type="number" class="form-control" id="rating" aria-describedby="rating" path="rating"/>
            <form:errors path="rating" class="text-danger"/>
        </div>
        <div class="mb-3">
            <form:label for="notes" class="form-label" path="notes">Notes:</form:label>
            <form:input type="text" class="form-control" id="notes" aria-describedby="notes" path="notes"/>
            <form:errors path="notes" class="text-danger"/>
        </div>

        <button type="submit" class="btn btn-primary">Create Burger</button>
    </form:form>
</div>

</body>
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</html>
