<%@ page isELIgnored="false" contentType="text/html" pageEncoding="UTF-8" %>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="${pageContext.request.contextPath}">Livraria Est&aacute;cio</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText"
            aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarText">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-item nav-link" href="${pageContext.request.contextPath}/produto-listar">Produtos</a>
            </li>
        </ul>
        <span class="navbar-text">
            <strong>${pageContext.request.session.getAttribute("nomeUsuarioLogado")}</strong>
        </span>
    </div>
</nav>