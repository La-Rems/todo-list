<nav>
    <div class="nav-wrapper">
        <ul id="nav-mobile" class="right hide-on-med-and-down">
            <c:if test="${user != null}">
            <li>Connecte en tant que : ${user.getFistnameAndLastname()} </li>
            <li><a href="disconnect">Se deconnecter</a></li>
            </c:if>
            <c:if test="${user == null}">
                <li><a class="" href="login">Se connecter</a> </li>
                <li><a class="" href="addUser">S'inscrire</a></li>
            </c:if>
        </ul>
    </div>
</nav>
