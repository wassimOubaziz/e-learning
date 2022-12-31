<%--
  User: Wassim
  Date: 12/24/2022
  Time: 7:38 PM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <style> <%@include file="/WEB-INF/cssFiles/login.css"%></style>
    <title>Sign-In</title>
</head>
<body>
<div class="messages">
    <div class="message no">
        <h3>Your user Name Or password is not in data base</h3>
    </div>
    <div class="message yes">
        <h3>You secced your log-in, will turn you to correct page</h3>
    </div>
</div>
<div class="container">
    <form name="login" action="home" method="post">
        <div class="content">
            <div class="home">
                <a title="return to home page" href="/">home</a>
            </div>
            <h1>LOGIN</h1>
            <div class="user k">
                <label>Email</label>
                <input
                        class="userName"
                        type="text"
                        name="email"
                        required
                        placeholder="Email"
                />
            </div>
            <div class="password k">
                <label>Password</label>
                <input
                        class="password"
                        type="password"
                        name="password"
                        required
                        placeholder="Password"
                />
            </div>
            <button type="submit">LOGIN</button>
        </div>
    </form>
</div>
</body>
</html>
