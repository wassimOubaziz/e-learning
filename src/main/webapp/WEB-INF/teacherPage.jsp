<%--
  Created by IntelliJ IDEA.
  User: Wassim
  Date: 12/28/2022
  Time: 8:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib   prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>R-Learn | E-learning Platform</title>
    <style><%@include file="/WEB-INF/cssFiles/teacherPage.css"%></style>
    <meta name="viewport" content="width=device-width, initial-scale=1" />
</head>

<body>
<div class="navigation" id="home">
    <div class="container">
        <a href="/">
            <img src="./images/univconstantine2.png" alt="Univ Constanine2" />
        </a>
        <ul class="h">
            <li>
                <h5 class="link"><a href="./logout">LOGOUT</a></h5>
            </li>
            <li>
                <h5 class="link">${user.getUser_name()}</h5>
            </li>
            <li>
                <h5 class="link">${user.getRole()}</h5>
            </li>
            <li>
                <a href="/editePage"><img class="link" src="./images/student.svg" alt="Image of You" title="Edite Profile" /></a>
            </li>
        </ul>
    </div>
</div>

<div class="menu">
    <input type="checkbox" id="toggle" />
    <label id="show-menu" for="toggle">
        <div class="hou">
            <div class="btn">
                <i class="material-icons md-36 toggleBtn menuBtn">module</i>
                <i class="material-icons md-36 toggleBtn closeBtn">close</i>
            </div>
        </div>
        <c:forEach var="i" begin="0" end="${listModule.size()-1}" step="1">
        <div class="btn">
            <form action="getModulePage" method="get">
                <input id="hid" type="text" name="module" value="${listModule[i]}" hidden/>
                <button type="submit">
                        ${listModule[i]}
                </button>
            </form>
        </div>
        </c:forEach>
    </label>
</div>
<div class="contact" id="contact">
    <div class="container">
        <div class="section-title">
            <h2>quick contact</h2>
        </div>
        <div class="content">
            <div class="location hg">
                <img src="./images/location.jpg" alt="icon" />
                <h5>Our Location</h5>
                <p>Address: Contantine, Nouvle ville</p>
            </div>
            <div class="phone hg">
                <img src="./images/phone.jpg" alt="icon" />
                <h5>Phone Number</h5>
                <p>0123456789</p>
            </div>
            <div class="email hg">
                <img src="./images/email.jpg" alt="icon" />
                <h5>Email Id</h5>
                <p>wassimdjaafar5@gmail.com</p>
            </div>
            <div class="time hg">
                <img src="./images/time.jpg" alt="icon" />
                <h5>Elerning Time</h5>
                <p>24h/24h</p>
            </div>
        </div>
    </div>
</div>
<div class="footer">
    <h2>Houcine Ghedjati ©copyright2023</h2>
</div>

<script>

    function myFunction() {
    var x = document.getElementById("myTopnav");
    if (x.className === "topnav") {
        x.className += " responsive";
    } else {
        x.className = "topnav";
    }
}

</script>
</body>
</html>
