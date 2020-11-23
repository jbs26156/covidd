<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Webjars for Bootstrap and Jquery -->

<head>
    <link rel="stylesheet" href="stylesheet_registration.css">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
            integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous"></script>
    <title>Registration</title>
</head>
<body>
    <header>
        <br>
        <h3>University of Georgia</h3>
        <h1>COVID-19 Resource Site</h1>
    </header>
    <nav>
        <hr>
        <a href="index.html">HOME</a>
        <a href="login">CONTACT TRACING</a>
        <a href="donations_loggedout.html">DONATIONS</a>
        <a href="testingsites_loggedout.html">TESTING SITES</a>
        <a href="login">LOGIN</a>
        <hr>
        <hr>
    </nav>
    <br>
<%--@elvariable id="accountForm" type=""--%>

<form:form method="POST" modelAttribute="accountForm">
    <div class="MyForm form-group">
        <h2>Sign Up</h2>
        <label for="firstName">First Name: </label>
        <form:input type="text" class="MyInput" id="firstName" placeholder="John" path="firstName" /><br><br>
        <label for="lastName">Last Name: </label>
        <form:input type="text" class="MyInput" id="lastName" path="lastName" placeholder="Doe" /><br><br>
        <label for="username">Username: </label>
        <form:input type="text" class="MyInput" id="userName" placeholder="johndoe" path="userName" /><br><br>
        <label for="password">Password: </label>
        <form:password class="MyInput" id="password" placeholder="Enter password" autocomplete="false" path="password" /><br><br>
        <label for="email">Email: </label>
        <form:input type="email" class="MyInput" id="email" path="email" placeholder="johndoe@example.com" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" /><br><br>
        <label for="phoneNumber">Phone Number: </label>
        <form:input type="tel" class="MyInput" id="phoneNumber" path="phoneNumber" placeholder="123-456-7890" pattern="[0-9]{3}-[0-9]{3}-[0-9]{4}" /><br><br>
        <label for="isPhoneAlert">Phone Alerts (yes/no): </label>
        <form:input type="text" class="MyInput" id="isPhoneAlert" path="isPhoneAlert" placeholder="yes or no" /><br><br>
        <label for="isEmailAlert">Email Alerts (yes/no): </label>
        <form:input type="text" class="MyInput" id="isEmailAlert" path="isEmailAlert" placeholder="yes or no" /><br><br>
        <form:button type="submit" class="from-control">Submit</form:button>

    </div>

</form:form>
<c:if test="${not empty responseString}">
    <c:out value="${responseString}"></c:out>
</c:if>

</body>
</html>
