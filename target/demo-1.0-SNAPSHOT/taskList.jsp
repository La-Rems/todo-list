<%--
  Created by IntelliJ IDEA.
  User: Rémi BONNABAUD
  Date: 28/06/2021
  Time: 09:59
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<head>
    <%@ include file="include/header.jsp" %>
    <title>Title</title>
</head>
<body>
<%@ include file="include/navbar.jsp" %>

<div class="row">
    <div class="col s4 m4">
        <p style="text-align: center;">Tâches en attentes</p>
        <c:forEach items="${taskList}" var="task">
            <div class="row">
                <div class="col s12 m12">
                    <div class="card blue darken-3">
                        <div class="card-content white-text">
                            <span class="card-title">${task.title}</span>
                            <p>Identifiant : ${task.id}</p>
                            <p>Description : ${task.content}</p>
                            <p>Date max : ${task.endAt}</p>
                            <p>Statut : ${task.status}</p>
                            <p>Auteur : ${task.user.getFistnameAndLastname()}</p>
                            <a class="modal-trigger" href="#modal${task.id}"><i style="position: absolute; top: 5px;right: 5px; color: white;" class="material-icons">highlight_off</i></a>
                            <a href="updateTask?id=${task.id}"><i style="position: absolute;right: 20px;bottom: 20px;font-size: 30px; color: #f57c00;" class="fas fa-check-circle"></i></a>
                        </div>
                    </div>
                </div>
            </div>

            <div id="modal${task.id}" class="modal">
                <div class="modal-content">
                    <p>Supression de la tâche</p>
                    <p>Vous êtes sur le point de retirer la tâche : ${task.title} de votre liste</p>
                    <p>Confirmez-vous votre choix ?</p>
                    <form action="<c:url value="taskList"/>" method="post">
                        <input name="id" type="hidden" value="${task.id}">
                        <div class="modal-footer">
                            <input class="waves-effect waves-green btn-flat" type="submit" value="Oui">
                            <a href="#!" class="modal-close waves-effect waves-green btn-flat">Retour</a>
                        </div>
                    </form>
                </div>
            </div>
        </c:forEach>
    </div>

    <div class="col s4 m4">
        <p style="text-align: center;">Tâches en cours</p>
        <c:forEach items="${taskInProgressList}" var="task">
            <div class="row">
                <div class="col s12 m12">
                    <div class="card blue darken-3">
                        <div class="card-content white-text">
                            <span class="card-title">${task.title}</span>
                            <p>Identifiant : ${task.id}</p>
                            <p>Description : ${task.content}</p>
                            <p>Date max : ${task.endAt}</p>
                            <p>Statut : ${task.status}</p>
                            <p>Auteur : ${task.user.getFistnameAndLastname()}</p>
                            <a class="modal-trigger" href="#modal${task.id}"><i style="position: absolute; top: 5px;right: 5px; color: white;" class="material-icons">highlight_off</i></a>
                            <a href="finishTask?id=${task.id}"><i style="position: absolute;right: 20px;bottom: 20px;font-size: 30px; color: #f57c00;" class="fas fa-check-circle"></i></a>
                        </div>
                    </div>
                </div>
            </div>

            <div id="modal${task.id}" class="modal">
                <div class="modal-content">
                    <p>Supression de la tâche</p>
                    <p>Vous êtes sur le point de retirer la tâche : ${task.title} de votre liste</p>
                    <p>Confirmez-vous votre choix ?</p>
                    <form action="<c:url value="taskList"/>" method="post">
                        <input name="id" type="hidden" value="${task.id}">
                        <div class="modal-footer">
                            <input class="waves-effect waves-green btn-flat" type="submit" value="Oui">
                            <a href="#!" class="modal-close waves-effect waves-green btn-flat">Retour</a>
                        </div>
                    </form>
                </div>
            </div>
        </c:forEach>
    </div>

    <div class="col s4 m4">
        <p style="text-align: center;">Tâches en terminées</p>
        <c:forEach items="${taskFinishList}" var="task">
            <div class="row">
                <div class="col s12 m12">
                    <div class="card blue darken-3">
                        <div class="card-content white-text">
                            <span class="card-title">${task.title}</span>
                            <p>Identifiant : ${task.id}</p>
                            <p>Description : ${task.content}</p>
                            <p>Date max : ${task.endAt}</p>
                            <p>Statut : ${task.status}</p>
                            <p>Auteur : ${task.user.getFistnameAndLastname()}</p>
                            <a class="modal-trigger" href="#modal${task.id}"><i style="position: absolute; top: 5px;right: 5px; color: white;" class="material-icons">highlight_off</i></a>
                        </div>
                    </div>
                </div>
            </div>

            <div id="modal${task.id}" class="modal">
                <div class="modal-content">
                    <p>Supression de la tâche</p>
                    <p>Vous êtes sur le point de retirer la tâche : ${task.title} de votre liste</p>
                    <p>Confirmez-vous votre choix ?</p>
                    <form action="<c:url value="taskList"/>" method="post">
                        <input name="id" type="hidden" value="${task.id}">
                        <div class="modal-footer">
                            <input class="waves-effect waves-green btn-flat" type="submit" value="Oui">
                            <a href="#!" class="modal-close waves-effect waves-green btn-flat">Retour</a>
                        </div>
                    </form>
                </div>
            </div>
        </c:forEach>
    </div>
</div>

<a href="addTask" class="btn-floating btn-large waves-effect waves-light red"><i class="material-icons">add</i></a>


<%@ include file="include/footer.jsp" %>

</body>
</html>
