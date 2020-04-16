<%@ page isELIgnored="false" contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form action="${pageContext.request.contextPath}/${pageContext.request.getParameter("action")}" method="post">
    <c:if test="${produto.id != null}">
        <div class="form-group">
            <label for="nome">Identificador</label>
            <input class="form-control" id="id" name="id" value="${produto.id}" readonly>
        </div>
    </c:if>
    <div class="form-group">
        <label for="nome">Nome do produto</label>
        <input class="form-control" id="nome" name="nome" value="${produto.nome}">
    </div>
    <div class="form-group">
        <label>Tipo do produto</label>
        <div>
            <c:forEach items="${tiposProduto}" var="tipoProduto">
                <div class="form-check">
                    <c:choose>
                        <c:when test="${tipoProduto == produto.tipo}">
                            <input class="form-check-input" type="radio" id="${tipoProduto}" name="tipoProduto" value="${tipoProduto}" checked>
                        </c:when>
                        <c:otherwise>
                            <input class="form-check-input" type="radio" id="${tipoProduto}" name="tipoProduto" value="${tipoProduto}">
                        </c:otherwise>
                    </c:choose>
                    <label class="form-check-label" for="${tipoProduto}">${tipoProduto.descricao}</label>
                </div>
            </c:forEach>
        </div>
    </div>
    <div id="form-group-data-vencimento" class="form-group mb-2 ${produto.tipo != 'NAO_DURAVEL' ? 'd-none' : ''}">
        <label for="dataVencimento">Data de vencimento</label>
        <c:choose>
            <c:when test="${produto.tipo == 'NAO_DURAVEL'}">
                <input type="date" class="form-control" id="dataVencimento" name="dataVencimento" value="${dataVencimentoFormatada}">
            </c:when>
            <c:otherwise>
                <input type="date" class="form-control" id="dataVencimento" name="dataVencimento">
            </c:otherwise>
        </c:choose>
    </div>
    <c:choose>
        <c:when test="${produto.tipo == 'LIVRO'}">
            <div id="form-group-autor" class="form-group">
                <label for="autor">Autor</label>
                <select id="autor" name="autor" class="form-control">
                    <c:forEach items="${autores}" var="autor">
                        <c:choose>
                            <c:when test="${autor.id == produto.autor.id}">
                                <option value="${autor.id}" selected>${autor.nome}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${autor.id}">${autor.nome}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select>
            </div>
        </c:when>
        <c:otherwise>
            <div id="form-group-autor" class="form-group mb-2 d-none">
                <label for="autor">Autor</label>
                <select id="autor" name="autor" class="form-control">
                    <c:forEach items="${autores}" var="autor">
                        <option value="${autor.id}">${autor.nome}</option>
                    </c:forEach>
                </select>
            </div>
        </c:otherwise>
    </c:choose>
    <div class="form-group">
        <label for="descricao">Descri&ccedil;&atilde;o</label>
        <textarea class="form-control" id="descricao" name="descricao">
            ${produto.descricao}
        </textarea>
    </div>
    <div class="form-group">
        <label for="preco">Pre&ccedil;o</label>
        <input class="form-control" id="preco" name="preco" value="${produto.preco}">
    </div>
    <button type="submit" class="btn btn-success">Salvar produto</button>
    <script src="${pageContext.request.contextPath}/assets/js/form.js"></script>
</form>
