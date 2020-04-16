<%@ page isELIgnored="false" contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<t:template>
    <jsp:attribute name="titulo">Listar produtos</jsp:attribute>
    <jsp:attribute name="corpo">
        <div class="text-right">
            <a class="btn btn-success mb-4" href="${pageContext.request.contextPath}/produto-cadastrar?action=produto-cadastrar" role="button">Cadastrar novo produto</a>
        </div>
        <form action="${pageContext.request.contextPath}/produto-listar" method="post">
            <div class="input-group mb-3 input-search">
                <div class="input-group-prepend">
                    <select name="tipoProduto" class="custom-select">
                        <option value="">Todos</option>
                        <c:forEach items="${tiposProduto}" var="tipoProduto">
                            <c:choose>
                                <c:when test="${tipoProdutoFiltro == tipoProduto}">
                                    <option value="${tipoProduto}" selected>${tipoProduto.descricao}</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${tipoProduto}">${tipoProduto.descricao}</option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                </div>
                <input name="nome" value="${nomeFiltro}" class="form-control" placeholder="Nome do produto ou do autor do livro">
                <div class="input-group-append">
                    <button class="btn btn-primary" type="submit">
                        <img src="${pageContext.request.contextPath}/assets/img/search.svg" />
                    </button>
                </div>
            </div>
        </form>
        <div class="table-responsive">
            <table class="table table-hover">
                <thead class="thead-light">
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Nome</th>
                        <th scope="col">Tipo</th>
                        <th scope="col">Pre&ccedil;o</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${produtos}" var="produto">
                        <tr>
                            <th scope="row">${produto.id}</th>
                            <td>
                                <a href="${pageContext.request.contextPath}/produto-detalhar?id=${produto.id}">
                                    ${produto.nome}
                                </a>
                            </td>
                            <td>${produto.tipo.descricao}</td>
                            <td>
                                <fmt:formatNumber type="currency" value="${produto.preco}" />
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </jsp:attribute>
</t:template>
