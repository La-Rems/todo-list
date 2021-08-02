<%--
  Created by IntelliJ IDEA.
  User: Rémi BONNABAUD
  Date: 28/06/2021
  Time: 13:33
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@ include file="include/header.jsp" %>
</head>
<body>
<%@ include file="include/navbar.jsp" %>

<form action="<c:url value="login"/>" method="post">
    <div class="row">
        <div class="input-field col s6">
            <input name="emailForm" id="email" type="email" class="validate">
            <label class="active" for="email">Email : </label>

        </div>
    </div>
    <div class="row">
        <div class="input-field col s6">
            <input name="passwordForm" id="password" type="password" class="validate">
            <label class="active" for="password">Mot de passe : </label>
        </div>
    </div>
    <button class="btn waves-effect waves-light teal darken-3" type="submit" name="action">Submit
        <i class="material-icons right">send</i>
    </button>
</form>

<%@ include file="include/footer.jsp" %>


</body>
</html>
