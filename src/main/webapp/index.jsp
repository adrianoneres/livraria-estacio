<%@ page isELIgnored="false" contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <title>📚 Livraria Est&aacute;cio</title>
    <style><%@include file="/assets/css/login.css"%></style>
</head>
    <body class="text-center">
        <main>
            <form  action="${pageContext.request.contextPath}/login" method="post">
                <h1>📚 Livraria Est&aacute;cio</h1>
                <c:if test="${mensagemErro != null}">
                    <div class="alert alert-danger" role="alert">
                        ${mensagemErro}
                    </div>
                </c:if>
                <h2 class="h5 mb-3 font-weight-normal mt-4">Efetue o login</h2>
                <input name="login" class="form-control" placeholder="Login" required autofocus>
                <input type="password" name="senha" class="form-control mt-2" placeholder="Senha" required>
                <button class="btn btn-lg btn-primary btn-block mt-2" type="submit">Entrar</button>
            </form>
        </main>
    </body>
</html>

