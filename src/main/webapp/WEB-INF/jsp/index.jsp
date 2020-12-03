<%-- index.jsp --%>

<!DOCTYPE HTML>

<html>
    <head>
        <title>Covid-19 Application</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="stylesheet.css">
    </head>
    <body>
        <header>
            <br>
            <h3>University of Georgia</h3>
            <h1>COVID-19 Resource Site</h1>
        </header>
        <nav>
            <hr>
            <a href="index" style="padding-right: 1.5%; padding-left: 1.5%; color: #e10000;">HOME</a>
            <a href="contacttracing" style="padding-right: 1.5%; padding-left: 1.5%;">CONTACT TRACING</a>
            <a href="donations.html" style="padding-right: 1.5%; padding-left: 1.5%;">DONATIONS</a>
            <a href="testingsites.html" style="padding-right: 1.5%; padding-left: 1.5%;">TESTING SITES</a>
            <a href="symptomchecker.html" style="padding-right: 1.5%; padding-left: 1.5%;">SYMPTOM CHECKER</a>
            <a href="settings" style="padding-right: 1.5%; padding-left: 1.5%;">SETTINGS</a>
            <a href="logout" style="padding-right: 1.5%; padding-left: 1.5%;">LOG OUT</a>
            <hr>
            <hr>
        </nav>
        <br>
        <h2>
            <br>
            Welcome to the University of Georgia COVID-19 Resource Site!<br><br>
            <div style="font-size: smaller;">This site is meant to provide you with the resources and information<br>you need to stay healthy and safe.</div>
            <br>
        </h2>
        <br>
        <div class="make-account-container">
            <hr><br>
            <h2 style="color: black;">Update you buildings!<br><br>Update your recently visited buildings to recieve alerts of positive tests in the area.</h2>
            <br>
            <h2><a href="settings" style="color: black; border: solid; border-color: #e10000; padding:.5%;">Change Settings</a></h2>
            <br><hr>
        </div>
        <div class="grid-container">
            <div class="grid-item">
                <div style="font-size: larger;"><b>CONTACT TRACING</b></div><br>
                To better serve students, we have created a way for students to submit a
                positive test and track where outbreaks of COVID-19 are occuring on campus.<br>
            </div>
            <div class="grid-item">
                <div style="font-size: larger;"><b>DONATIONS</b></div><br>
                We encourage you to donate to one of the several organizations around
                Athens and affiliated with UGA to help our community.<br>
            </div>
            <div class="grid-item">
                <div style="font-size: larger;"><b>TESTING SITES</b></div><br>
                We have provided a number of COVID-19 testing locations around Athens for your benefit.<br>
            </div>
            <div class="grid-item">
                <div style="font-size: larger;"><b>SYMPTOM CHECKER</b></div><br>
                Login to the site to check your symptoms. If you may have COVID-19, we have
                provided several testing locations under the Testing Sites page.<br>
            </div>
            <div class="grid-item">
                <a href="contacttracing">Contact Tracing</a>
            </div>
            <div class="grid-item">
                <a href="donations.html">Donations</a>
            </div>
            <div class="grid-item">
                <a href="testingsites.html">Testing Sites</a>
            </div>
            <div class="grid-item">
                <a href="symptomchecker.html">Symptom Checker</a>
            </div>
        </div>
        <br><hr><br>
    </body>
</html>
