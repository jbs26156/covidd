<%-- contacttracing.jsp --%>

<%-- spring form handler --%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
    <head>
        <title>Contact Tracing</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="stylesheet_contacttracing.css"/>
    </head>
    <body>
    <header>
        <br>
        <h3>University of Georgia</h3>
        <h1>COVID-19 Resource Site</h1>
    </header>
    <nav>
        <hr>
        <a href="index_loggedin.html" style="padding-right: 1.5%; padding-left: 1.5%;">HOME</a>
        <a href="contacttracing" style="padding-right: 1.5%; padding-left: 1.5%; color: #e1000;">CONTACT TRACING</a>
        <a href="donations.html" style="padding-right: 1.5%; padding-left: 1.5%;">DONATIONS</a>
        <a href="testingsites.html" style="padding-right: 1.5%; padding-left: 1.5%;">TESTING SITES</a>
        <a href="symptomchecker.html" style="padding-right: 1.5%; padding-left: 1.5%;">SYMPTOM CHECKER</a>
        <a href="settings" style="padding-right: 1.5%; padding-left: 1.5%;">SETTINGS</a>
        <a href="index.html" style="padding-right: 1.5%; padding-left: 1.5%;">LOG OUT</a>
        <hr>
        <hr>
    </nav>
    <br>
    <h2>Please update your recent buildings: </h2><br>
    <div class="grid">
        <div class="griditem">
        <form:form method="POST" modelAttribute="selectForm" class="buildingSelectionForm">
                <form:label for="building1" path="building1">Building 1</form:label>
                <form:select path="building1">
                    <form:option value="none" label="---SELECT---"/>
                    <form:options items="${buildingsList}"/>
                </form:select><br><br>
                <form:label for="building2" path="building2">Building 2</form:label>
                <form:select path="building2">
                    <form:option value="none" label="---SELECT---"/>
                    <form:options items="${buildingsList}"/>
                </form:select><br><br>
                <form:label for="building3" path="building3">Building 3</form:label>
                <form:select path="building3">
                    <form:option value="none" label="---SELECT---"/>
                    <form:options items="${buildingsList}"/>
                </form:select><br><br>
                <form:label for="building4" path="building4">Building 4</form:label>
                <form:select path="building4">
                    <form:option value="none" label="---SELECT---"/>
                    <form:options items="${buildingsList}"/>
                </form:select><br><br>
                <form:label for="building5" path="building5">Building 5</form:label>
                <form:select path="building5">
                    <form:option value="none" label="---SELECT---"/>
                    <form:options items="${buildingsList}"/>
                </form:select>
         </div>
         <div class="griditem">
                <form:label for="building6" path="building6">Building 6</form:label>
                <form:select path="building6">
                    <form:option value="none" label="---SELECT---"/>
                    <form:options items="${buildingsList}"/>
                </form:select><br><br>
                <form:label for="building7" path="building7">Building 7</form:label>
                <form:select path="building7">
                    <form:option value="none" label="---SELECT---"/>
                    <form:options items="${buildingsList}"/>
                </form:select><br><br>
                <form:label for="building8" path="building8">Building 8</form:label>
                <form:select path="building8">
                    <form:option value="none" label="---SELECT---"/>
                    <form:options items="${buildingsList}"/>
                </form:select><br><br>
                <form:label for="building9" path="building9">Building 9</form:label>
                <form:select path="building9">
                    <form:option value="none" label="---SELECT---"/>
                    <form:options items="${buildingsList}"/>
                </form:select><br><br>
                <form:label for="building10" path="building10">Building 10</form:label>
                <form:select path="building10">
                    <form:option value="none" label="---SELECT---"/>
                    <form:options items="${buildingsList}"/>
                </form:select><br><br>
                <form:button class="submitButton" id="submitButton" type="submit">Submit</form:button>
        </form:form>
        </div>
    </div>
    </body>
</html>