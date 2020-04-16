<%@ page isELIgnored="false" contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<t:template>
    <jsp:attribute name="titulo">Detalhes do produto</jsp:attribute>
    <jsp:attribute name="corpo">
        <p>
            <strong>Identificador:</strong>
            <span>${produto.id}</span>
        </p>
        <p>
            <strong>Nome:</strong>
            <span>${produto.nome}</span>
        </p>
        <p>
            <strong>Tipo:</strong>
            <span>${produto.tipo.descricao}</span>
        </p>
        <c:if test="${produto.tipo == 'LIVRO'}">
            <p>
                <strong>Autor:</strong>
                <span>${produto.autor.nome}</span>
            </p>
        </c:if>
        <c:if test="${produto.tipo == 'NAO_DURAVEL'}">
            <p>
                <strong>Data de vencimento:</strong>
                <span>
                    <fmt:formatDate pattern="dd/MM/yyyy" value="${produto.dataVencimento}" />
                </span>
            </p>
        </c:if>
        <p>
            <strong>Descri&ccedil;&atilde;o:</strong>
            <span>${produto.descricao}</span>
        </p>
        <p>
            <strong>Pre&ccedil;o:</strong>
            <span>
                <fmt:formatNumber type="currency" value="${produto.preco}" />
            </span>
        </p>
        <div class="d-flex">
            <a class="btn btn-danger mr-4" href="${pageContext.request.contextPath}/produto-excluir?id=${produto.id}&tipoProduto=${produto.tipo}" role="button" onclick="confirm('Tem certeza de que deseja excluir o produto ${produto.nome}?')">Excluir</a>
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/produto-editar?id=${produto.id}&action=produto-editar" role="button">Editar</a>
        </div>
    </jsp:attribute>
</t:template>
