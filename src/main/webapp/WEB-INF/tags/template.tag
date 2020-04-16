<%@ tag description="Template principal" pageEncoding="UTF-8" %>
<%@ attribute name="titulo" fragment="true" %>
<%@ attribute name="corpo" fragment="true" %>

<!doctype html>
<html lang="pt">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <title>📚 Livraria Est&aacute;cio</title>
    <style><%@include file="/assets/css/styles.css"%></style>
</head>
<body class="d-flex flex-column">
    <jsp:include page="/WEB-INF/include/nav.jsp" />
    <div class="container">
        <h1><jsp:invoke fragment="titulo" /></h1>
    </div>
    <main>
        <div class="container">
            <jsp:invoke fragment="corpo" />
        </div>
    </main>
    <jsp:include page="/WEB-INF/include/footer.jsp" />
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>