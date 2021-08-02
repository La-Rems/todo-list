<%--
  Created by IntelliJ IDEA.
  User: Rémi BONNABAUD
  Date: 28/06/2021
  Time: 10:30
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
    <%@ include file="include/header.jsp" %>
</head>
<body>
<%@ include file="include/navbar.jsp" %>
<form action="<c:url value="addTask"/>" method="post">
    <label>Title: </label>
    <input name="title" type="text">
    <label>Description: </label>
    <input name="content" type="text">
    <input type="submit" value="Envoyer">
</form>
<%@ include file="include/footer.jsp" %>
</body>
</html>
