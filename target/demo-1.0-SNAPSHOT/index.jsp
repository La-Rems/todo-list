<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title> Sign In</title>
    <%@ include file="include/header.jsp" %>
</head>
<body>
<%@ include file="include/navbar.jsp" %>
<h1><%= "Bienvenue sur TodoList" %>
</h1>
<br/>
<a class="waves-effect waves-light btn light-blue" href="login">Se connecter</a>
<a class="waves-effect waves-light btn deep-orange" href="addUser">S'inscrire</a>
<%@ include file="include/footer.jsp" %>
</body>
</html>