<%--
    Document   : index
    Created on : 20/02/2017, 15:24:58
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

        <div id="footer">
            <a href="${pageContext.request.contextPath}/novo">Cadastrar novo contato</a> <br>
            <a href="${pageContext.request.contextPath}/lista">Listar contatos cadastrados</a> <br>
            <a href="${pageContext.request.contextPath}/logout">Encerrar sessão</a>

        </div>

    </body>

</html>
