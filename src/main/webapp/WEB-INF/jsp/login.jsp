<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<meta charset="utf-8">


<!-- Webjars for Bootstrap and Jquery -->

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="stylesheet_login.css">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
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
            <a href="login">CONTACT TRACING</a>
            <a href="donations_loggedout.html">DONATIONS</a>
            <a href="testingsites_loggedout.html">TESTING SITES</a>
            <a href="login" style="color: #e10000;">LOGIN</a>
            <hr>
            <hr>
        </nav>
        <br>

        <%--@elvariable id="login" type=""--%>
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
    </body>
</html>

