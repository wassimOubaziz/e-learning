<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <mvc:resources mapping="/resources/**" location="/resources/" />
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <style><%@include file="/WEB-INF/cssFiles/index.css"%></style>
    <title>E-learning</title>
</head>
<body>
<div class="navigation" id="home">
    <div class="container">
        <a href="/">
            <img src="../images/univconstantine2.png" alt="Univ Constanine2" >
        </a>
        <ul class="h">
            <li>
                <a href="#home" class="link"> SHOW </a>
            </li>
            <li>
                <a href="#service" class="link"> SERVICE </a>
            </li>
            <li>
                <a href="./login" class="link"> <%= request.getAttribute("home").equals(true) ? "HOME" : "SIGN-IN" %> </a>
            </li>
            <li>
                <a href="#contact" class="link"> CONTACT </a>
            </li>
        </ul>
        <button class="mobile-btn">
            <img src="/images/navBar.svg" alt="navBar" >
        </button>
        <div class="mobile">
            <ul>
                <li>
                    <a href="#home" class="link"> HOME </a>
                </li>
                <li>
                    <a href="#service" class="link"> SERVICE </a>
                </li>
                <li>
                    <a href="./login" class="link"> <%= request.getAttribute("home").equals(true) ? "HOME" : "SIGN-IN" %> </a>
                </li>
                <li>
                    <a href="#contact" class="link"> CONTACT </a>
                </li>
            </ul>
        </div>
    </div>
</div>
<div class="home">
    <div class="container">
        <div class="home-container">
            <h3>ELEARNING</h3>
            <h1>PERFECT START</h1>
            <h2>FOR YOU</h2>
            <div class="sign-in_button">
                <a href="./login">
                    <button><%= request.getAttribute("home").equals(true) ? "HOME" : "SIGN-IN" %></button>
                </a>
            </div>
        </div>
        <div class="image">
            <img src="/images/smart.png" alt="smart" />
        </div>
    </div>
</div>
<h2 class="section-title" id="service">OUR ACTIVITIES</h2>
<div class="service">
    <div class="container">
        <div class="teacher">
            <div class="logo">
                <img src="/images/teacher.svg" alt="teacher logo" />
            </div>
            <div class="content">
                <h3>FOR TEACHERS</h3>
                <ul>
                    <li>see all the students</li>
                    <li>filter students</li>
                    <li>see all the lessons</li>
                    <li>delete lessons</li>
                </ul>
                <div class="sign-in_button">
                    <a href="./login">
                        <button><%= request.getAttribute("home").equals(true) ? "HOME" : "SIGN-IN" %></button>
                    </a>
                </div>
            </div>
        </div>
        <div class="teacher student">
            <div class="logo">
                <img src="/images/student.svg" alt="student logo" />
            </div>
            <div class="content">
                <h3>FOR STUDENT</h3>
                <ul>
                    <li>access to all the lesson</li>
                    <li>every thing is organised</li>
                    <li>easy to use</li>
                    <li>useful features</li>
                </ul>
                <div class="sign-in_button">
                    <a href="./login">
                        <button><%= request.getAttribute("home").equals(true) ? "HOME" : "SIGN-IN" %></button>
                    </a>
                </div>
            </div>
        </div>
        <div class="teacher admin">
            <div class="logo">
                <img src="/images/admin.svg" alt="admin logo" />
            </div>
            <div class="content">
                <h3>FOR ADMINISTARATION</h3>
                <ul>
                    <li>access to all Students, Teachers and Admins</li>
                    <li>every thing is organised</li>
                    <li>easy to use</li>
                </ul>
                <div class="sign-in_button">
                    <a href="./login">
                        <button><%= request.getAttribute("home").equals(true) ? "HOME" : "SIGN-IN" %></button>
                    </a>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="contact" id="contact">
    <div class="container">
        <div class="section-title">
            <h2>quick contact</h2>
        </div>
        <div class="content">
            <div class="location hg">
                <img src="/images/location.jpg" alt="icon" />
                <h5>Our Location</h5>
                <p>Address: Contantine, Nouvle ville</p>
            </div>
            <div class="phone hg">
                <img src="/images/phone.jpg" alt="icon" />
                <h5>Phone Number</h5>
                <p>0123456789</p>
            </div>
            <div class="email hg">
                <img src="/images/email.jpg" alt="icon" />
                <h5>Email Id</h5>
                <p>exemple@gmail.com</p>
            </div>
            <div class="time hg">
                <img src="/images/time.jpg" alt="icon" />
                <h5>Elerning Time</h5>
                <p>24h/24h</p>
            </div>
        </div>
    </div>
</div>
<div class="footer">
    <h2>UNIV-CONSTANTINE2 ©copyright2023</h2>
</div>

<script>
    <%@include file="/WEB-INF/jsfiles/index.js"%>
</script>

</body>
</html>
