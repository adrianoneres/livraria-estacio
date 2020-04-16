<%@ page isELIgnored="false" contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<t:template>
    <jsp:attribute name="titulo">Editar produto</jsp:attribute>
    <jsp:attribute name="corpo">
        <jsp:include page="form.jsp" />
    </jsp:attribute>
</t:template>
