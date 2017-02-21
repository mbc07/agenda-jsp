<%--
    Document   : mensagem
    Created on : 20/02/2017, 15:26:18
    Author     : 201319050441
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/estilo.css">
        <title>Exercício 10</title>

    </head>

    <body>
        <h1>Agenda JSP</h1>

        <div id="mensagem">
            ${msgData}
        </div>

        <div id="footer">
            <meta http-equiv="refresh" content="5; url=${pageContext.request.contextPath}/${msgRedirPath}">
            <a href="${pageContext.request.contextPath}/${msgRedirPath}">Clique aqui se não for redirecionado em alguns segundos</a>

        </div>

    </body>

</html>
