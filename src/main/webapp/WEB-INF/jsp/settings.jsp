<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html xmlns:th="http://www.thymeleaf.org">
    <head>
        <title>Settings</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../css/stylesheet.css"/>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@700&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <body>
        <header>
            <br>
            <h3>University of Georgia</h3>
            <h1>COVID-19 Resource Site</h1>
        </header>
        <nav>
            <hr>
            <a href="index_loggedin.jsp" style="padding-right: 1.5%; padding-left: 1.5%;">HOME</a>
            <a href="contacttracing_loggedout.html" style="padding-right: 1.5%; padding-left: 1.5%;">CONTACT TRACING</a>
            <a href="donations.html" style="padding-right: 1.5%; padding-left: 1.5%;">DONATIONS</a>
            <a href="testingsites.html" style="padding-right: 1.5%; padding-left: 1.5%;">TESTING SITES</a>
            <a href="symptomchecker.html" style="padding-right: 1.5%; padding-left: 1.5%;">SYMPTOM CHECKER</a>
            <a href="notifications.html" style="padding-right: 1.5%; padding-left: 1.5%;">NOTIFICATIONS</a>
            <a href="settings.html" style="padding-right: 1.5%; padding-left: 1.5%;">SETTINGS</a>
            <a href="index.jsp" style="padding-right: 1.5%; padding-left: 1.5%;">LOG OUT</a>
            <hr>
            <hr>
        </nav>
        <br>
        <form:form method="POST" modelAttribute="selectForm">
            <form:label for="building1">Building 1</form:label>
            <form:select path="building1">
                <form:option value="Aderhold">Aderhold</form:option>
                <form:option value="PeabodyHall">Peabody Hall</form:option>
             </form:select>
            <form:label for="building2">Building 2</form:label>
                <form:select path="building2">
                    <form:option value="MLC">MLC</form:option>
                    <form:option value="Law">Law School</form:option>
                </form:select>
        <form:button class="finalButton" id="finalButton">Submit</form:button>
    </form:form>
    </body>
</html>