<%--
  Created by IntelliJ IDEA.
  User: Legion
  Date: 12/29/2022
  Time: 7:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edite Profile | E-learning Platform</title>
    <style>
        <%@include file="/WEB-INF/cssFiles/editeProfile.css"%>
    </style>
</head>
<body>
<div class="adduser">
    <form name="update" action="editePage"  method="post" modelAttribute ="newUser">
        <div class="parts">
            <div class="part">
                <label>User Name</label><br />
                <input
                        type="text"
                        class="userName"
                        placeholder="User Name"
                        name="user_name"
                        value="${user.getUser_name()}"
                /><br />
                <label>Password</label><br />
                <input
                        type="password"
                        class="password"
                        placeholder="Password"
                        name="password"
                        value="${user.getPassword()}"
                /><br />
                <label>Email</label><br />
                <input type="email" class="email" name="email" placeholder="Email" value="${user.getEmail()}"/><br />
                <label>Phone</label><br />
                <input type="text" name="phone" class="address" placeholder="Phone" value="${user.getPhone()}" /><br />
            </div>
            <div class="part">
                <label>Full Name</label><br />
                <input
                        type="text"
                        class="fullName"
                        name="surname"
                        placeholder="Full Name"
                        value="${user.getSurname()}"
                /><br />
                <input type="text" class="role" name="role" placeholder="Role" value="${user.getRole()}" hidden/><br />
                <label>Name</label><br />
                <input type="text" class="sexe" name="name" placeholder="Name" value="${user.getName()}"/><br />
                <input type="text" class="module" name="module" placeholder="Module" value="${user.getModule()}" hidden/><br />
            </div>
        </div>
        <button class="submiteInfo" type="submit">submite Info</button>
    </form>

</div>
</div>
</div>
</body>
</html>
