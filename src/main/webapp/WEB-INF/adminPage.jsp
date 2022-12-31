<%--
  User: Wassim
  Date: 12/24/2022
  Time: 8:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib   prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <style> <%@include file="/WEB-INF/cssFiles/adminPage.css"%></style>
  <title>Admin Page</title>
</head>
<body>
<div class="navigation" id="home">
  <div class="container">
    <a href="/">
      <img src="/images/univconstantine2.png" alt="Univ Constanine2" />
    </a>
    <ul class="h">
      <li>
        <h5 class="link"><a href="./logout">LOGOUT</a></h5>
      </li>
      <li>
        <h5 class="link">${ user.getUser_name() }</h5>
      </li>
      <li>
        <h5 class="link">${ user.getRole() }</h5>
      </li>
      <li>
      <li>
        <a href="/editePage"><img class="link" src="./images/admin.svg" alt="Image of You" title="Edite Profile" /></a>
      </li>
      </li>
    </ul>
  </div>
</div>
<div class="all">
  <div class="menu-vertical">
    <button class="listUsers active">Liste des utilisateurs</button>
    <button class="addUsers">Ajouter utilisateur</button>
  </div>

  <div class="content">
    <div class="list">
      <form method="post" action="filteringUsers">
        <input class="search" name="filterStr" type="search" placeholder="Search" />
        <button type="submit">search</button>
      </form>
      <div class="def">
        <h4>Email</h4>
        <h4>Role</h4>
        <h4>User Name</h4>
        <h4></h4>
      </div>

      <div class="users">
          <c:forEach items="${ list }" var="list">
            <c:if test="${!list.role.equals('admin')}">
              <div class="user">
                <p class="email">${list.email}</p>
                <p class="role">${list.role}</p>
                <p class="userName">${list.user_name}</p>
                <div class="edit">
                  <button class="modifier" title="modifier">
                    <img src="/images/edit-pages-icon.svg" alt="edit" />
                  </button>
                  <form method="post" action="deleteUser">
                    <input type="text" hidden name="deleteEmail" value="${list.email}" />
                  <button type="submit" class="supprimer" title="supprimer">
                    <img src="/images/minus-group-icon.svg" alt="delete" />
                  </button>
                  </form>
                </div>
              </div>

            </c:if>
          </c:forEach>
      </div>
    </div>
    <div class="adduser">
        <div class="messages">
          <div class="message no">
            <h3>Your Inputs are incorect plz fill it proprly</h3>
          </div>
          <div class="message yes">
            <h3>The user is secced added to list</h3>
          </div>
        </div>
      <form name="update" action="addUpdateUser"  method="post" modelAttribute ="newUser">
        <div class="parts">
          <div class="part">
            <label>User Name</label><br />
            <input
                    type="text"
                    class="userName"
                    placeholder="User Name"
                    name="user_name"
            /><br />
            <label>Password</label><br />
            <input
                    type="password"
                    class="password"
                    placeholder="Password"
                    name="password"
            /><br />
            <label>Email</label><br />
            <input type="email" class="email" name="email" placeholder="Email" /><br />
            <label>Phone</label><br />
            <input type="text" name="phone" class="address" placeholder="Phone" /><br />
          </div>
          <div class="part">
            <label>Full Name</label><br />
            <input
                    type="text"
                    class="fullName"
                    name="surname"
                    placeholder="Full Name"
            /><br />
            <label>Role</label><br />
            <input type="text" class="role" name="role" placeholder="Role" /><br />
            <label>Name</label><br />
            <input type="text" class="sexe" name="name" placeholder="Name" /><br />
            <label>Module</label><br />
            <input type="text" class="module" name="module" placeholder="Module" /><br />
          </div>
        </div>
        <button class="submiteInfo" type="submit">submite Info</button>
      </form>

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
        <p>wassimdjaafar5@gmail.com</p>
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
  <h2>Wassim Oubaziz ©copyright2023</h2>
</div>

<script>
  <%@include file="/WEB-INF/jsfiles/adminPage.js"%>
</script>

</body>
</html>