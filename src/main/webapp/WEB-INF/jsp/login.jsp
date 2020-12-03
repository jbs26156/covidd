<%-- login.jsp --%>

<%-- spring form handler --%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="stylesheet_login.css">
        <title>Login</title>
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
            <a href="symptomchecker_loggedout.html">SYMPTOM CHECKER</a>
            <a href="donations_loggedout.html">DONATIONS</a>
            <a href="testingsites_loggedout.html">TESTING SITES</a>
            <a href="login" style="color: #e10000;">LOGIN</a>
            <hr>
            <hr>
        </nav>
        <br>
        <%-- form modelAttribute="login" --%>
        <form:form method="POST" modelAttribute="login">
            <div class="MyForm form-group">
                <h2>Login</h2>
                <label for="email">Email: </label>
                <form:input type="email" class="MyInput" id="email" path="email" placeholder="johndoe@example.com" /><br><br>
                <label for="password">Password: </label>
                <form:password class="MyInput" id="password" placeholder="Enter password" autocomplete="false" path="password" /><br><br>
                <form:button type="submit" class="from-control" >Submit</form:button>
            </div>
        </form:form>
        <h3 style="margin-top: 5%;">Dont have an account yet? Create one <a href="registration">here</a>.</h3>
        <%-- response statement for registration errors --%>
        <div style="color: white; text-align: center">
            <c:if test="${not empty responseString}">
                <c:out value="${responseString}"></c:out>
            </c:if>
        </div>
    </body>
</html>

