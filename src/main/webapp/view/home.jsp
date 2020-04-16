<%@ page isELIgnored="false" contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:template>
    <jsp:attribute name="corpo">
        <div class="jumbotron">
            <h1 class="display-4">Livraria Est&aacute;cio</h1>
            <p class="lead">Seja bem-vindo &agrave; Livraria Est&aacute;cio. 📚</p>
            <hr class="my-4">
            <p>Deseja fazer uma busca pelo seu livro ou produto preferido? Comece por aqui.</p>
            <a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/produto-listar" role="button">Buscar produtos</a>
        </div>
    </jsp:attribute>
</t:template>
