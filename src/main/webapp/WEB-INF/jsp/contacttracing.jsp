<!DOCTYPE html>

<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="utf-8" />
    <title>Contact Tracing</title>
    <link rel="stylesheet" href="stylesheet_contacttracing.css">
    <script>
        function response() {
            alert("Thank you! You are helping to keep Athens a safe and healthy place!");
        }
        
        function getCampusBuildings() {
                var y = document.getElementById("dateTested");
                var z = document.getElementById("finalButton");
                z.style.display = "block";
                y.style.display = "block";
            
                if (document.getElementById("northCampus").checked) {
                    var x = document.getElementById("northBuildings");
                      if (x.style.display === 'none') {
                        x.style.display = 'block';
                      }
                      else {
                        x.style.display = "none";  
                      }
                }
                if (document.getElementById("southCampus").checked) {
                    var x = document.getElementById("southBuildings");
                      if (x.style.display === 'none') {
                        x.style.display = 'block';
                      }
                      else {
                        x.style.display = "none";  
                      }
                }
                if (document.getElementById("eastCampus").checked) {
                    var x = document.getElementById("eastBuildings");
                      if (x.style.display === 'none') {
                        x.style.display = 'block';
                      }
                      else {
                        x.style.display = "none";  
                      }
                }
                if (document.getElementById("westCampus").checked) {
                    var x = document.getElementById("westBuildings");
                      if (x.style.display === 'none') {
                        x.style.display = 'block';
                      }
                      else {
                        x.style.display = "none";  
                      }
                }
        }
    </script>
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
        <a href="contacttracing_loggedout">CONTACT TRACING</a>
        <a href="donations.html">DONATIONS</a>
        <a href="testingsites.html">TESTING SITES</a>
        <a href="login.">LOGIN</a>
        <hr>
        <hr>
    </nav>
    <br>
    <h3>
        If you currently have or have recently had COVID-19, help us track and prevent the spread
        of the virus by filling out our contact tracing form.
    </h3>
    <br /><br />
    <form class="generalLocationForm">
        <label for="generalLocation">
            <h3>If applicable, where have you been on campus?</h3>
        </label><br />
                <div class="grid">
                    <div class-="griditem">
                        <label for="northCampus">North Campus</label>
                        <input type="checkbox" id="northCampus" />
                    </div>
                    <div class="griditem">
                        <label for="southCampus">South Campus</label>
                        <input type="checkbox" id="southCampus" />
                    </div>
                    <div class="griditem">
                        <label for="eastCampus">East Campus</label>
                        <input type="checkbox" id="eastCampus" />
                    </div>
                    <div class="griditem">
                        <label for="westCampus">West Campus</label>
                        <input type="checkbox" id="westCampus" />
                    </div>
                </div>
    </form>
    <br/>
    <button onclick="getCampusBuildings()">Submit</button>
    <br/><br />
    <form name="contactTracingForm" action="#" th:action="" >
        <div class="dateTested" id="dateTested">
            <label for="dateTested">When did you test positive for COVID-19?</label>
            <input type="date" id="dateTested" required/><br />
         </div>
        <div class="northBuildings" id="northBuildings" style="display: none; color: white;">
            <h3>North Campus Buildings</h3>
            <div class="grid">
                <div class="griditem">
                    <label for="administrationBuilding">Administration Building</label>
                    <input type="checkbox" id="administrationBuilding" />
                </div>
                <div class="griditem">
                    <label for="peabodyHall">Peabody Hall</label>
                    <input type="checkbox" id="peabodyHall" />
                </div>
                <div class="griditem">
                    <label for="newCollege">New College</label>
                    <input type="checkbox" id="newCollege" />
                </div>
                <div class="griditem">
                    <label for="mainLibrary">Main Library</label>
                    <input type="checkbox" id="mainLibrary" />
                </div>
            </div>
        </div>
        <div class="southBuildings" id="southBuildings" style="display: none; color: white;">
            <h3>South Campus Buildings</h3>
            <div class="grid">
                <div class="griditem">
                    <label for="Aderhold Hall">Aderhold Hall</label>
                    <input type="checkbox" id="aderholdHall" />
                </div>
            </div>
        </div>
        <div class="eastBuildings" id="eastBuildings" style="display: none; color: white;">
            <h3>East Campus Buildings</h3>
            <div class="grid">
                <div class="griditem">
                    <label for="ramseyStudentCenter">Ramsey Student Center</label>
                    <input type="checkbox" id="ramseyStudentCenter" />
                </div>
            </div>
        </div>
        <div class="westBuildings" id="westBuildings" style="display: none; color: white;">
            <h3>West Campus Buildings</h3>
            <div class="grid">
                <div class="griditem">
                    <label for="amosHall">Amos Hall</label>
                    <input type="checkbox" id="amosHall" />
                </div>
            </div>

        </div>
        <button class="finalButton" id="finalButton" onclick="response()">Submit</button>
    </form>
</body>
</html>