<%--
  Created by IntelliJ IDEA.
  User: Rémi BONNABAUD
  Date: 29/06/2021
  Time: 13:55
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
<form action="<c:url value="addUser"/>" method="post">
    <label>Prénom : </label>
    <input name="firstname" type="text">
    <label>Nom : </label>
    <input name="lastname" type="text">
    <label>Email : </label>
    <input name="pseudo" type="email">
    <label>Mot de passe : </label>
    <input name="password" type="password">
    <input type="submit" value="Envoyer">
</form>
<%@ include file="include/footer.jsp" %>
</body>
</html>
