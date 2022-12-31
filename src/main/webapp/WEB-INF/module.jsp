<%--
  Created by IntelliJ IDEA.
  User: Legion
  Date: 12/29/2022
  Time: 8:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib   prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <style><%@include file="/WEB-INF/cssFiles/module.css"%></style>
    <title>Module Page</title>
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
<c:if test="${user.role.equals('teacher')}">
    <div class="updateAddModule">
        <form action="addModule" method="post" modelAttribute ="newModule">
            <table>
                <thead>
                <tr>
                    <th scope="col">Due Date</th>
                    <th scope="col">File</th>
                    <th scope="col">File Name</th>
                    <th scope="col">Type</th>
                    <th scope="col">Period</th>
                    <th scope="col"></th>
                </tr>
                </thead>
                <tbody>
                <tr>

                    <input type="hidden" name="moduleName" value="${list[0].getModuleName()}" hidden/>
                    <td data-label="Due Date">
                        <input type="text" class="inp week" name="week" placeholder="Date" required/>
                    </td>
                    <td data-label="File">
                        <input type="text" class="inp file" name="file" placeholder="Link" required/>
                    </td>
                    <td data-label="File">
                        <input type="text" class="inp pdfName" name="pdfName" placeholder="File Name" required/>
                    </td>
                    <td data-label="Type">
                        <select name="type" required class="typek">
                            <option value="COUR">COUR</option>
                            <option value="TD">TD</option>
                            <option value="TP">TP</option>
                        </select>
                    </td>
                    <td data-label="Period"><input type="text" class="inp period" name="period" placeholder="Period" required/></td>
                    <td data-label="edit">
                        <button class="bb" title="save" type="submit">
                            Save
                        </button>
                        <button type="reset" class="bb">Reset</button>
                    </td>
                </tr>
                </tbody>
            </table>
        </form>
    </div>
</c:if>
        <table class="tt">
                <caption>${list[0].getModuleName()}</caption>
            <thead>
            <tr>
                <th scope="col">Due Date</th>
                <th scope="col">File</th>
                <th scope="col">Type</th>
                <th scope="col">Period</th>
                <c:if test="${user.role.equals('teacher')}">
                    <th scope="col"></th>
                </c:if>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${ info }" var="info">
                <tr>
                    <td data-label="Due Date">${info.getWeek()}</td>
                    <td data-label="File">
                        <img
                                src="./images/pdf.png"
                                alt=" "
                                width="25px"
                                height="25px"
                        />
                        <a href="${info.getFile()}" target="_blank">${info.getPdfName()}</a>
                    </td>
                    <td data-label="Type">
                            ${info.getType()}
                    </td>
                    <td data-label="Period">${info.getPeriod()}</td>
                    <c:if test="${user.role.equals('teacher')}">
                        <td data-label="edit">
                            <button class="modifier" title="modifier">
                                <img src="/images/edit-pages-icon.svg" alt="edit" />
                            </button>
                            <form method="post" action="deleteModule">
                                <input type="hidden" name="module" value="${info.getModuleName()}" />
                                <input type="hidden" name="pdfName" value="${info.getPdfName()}" />
                                <input type="hidden" name="type" value="${info.getType()}" />
                                <button type="submit" class="supprimer" title="delete" type="submit">
                                    <img src="/images/minus-group-icon.svg" alt="delete" />
                                </button>
                            </form>
                        </td>
                    </c:if>
                </tr>
            </c:forEach>
            </tbody>
        </table>


<script>
    <%@include file="/WEB-INF/jsfiles/module.js"%>
</script>
</body>
</html>
