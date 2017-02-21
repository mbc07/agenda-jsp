<%--
    Document   : novo
    Created on : 20/02/2017, 15:26:36
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

        <form action="${pageContext.request.contextPath}/cadastra" method="post">
            <label for="nome">Nome:</label>
            <input type="text" name="nome" id="nome" placeholder="João" required>

            <label for="sobrenome">Sobrenome:</label>
            <input type="text" name="sobrenome" id="sobrenome" placeholder=" Silva"> <br>

            <label for="email">E-mail:</label>
            <input type="email" name="email" id="email" placeholder="some@body.net" required>

            <label for="telefone">Telefone:</label>
            <input type="number" name="telefone" placeholder="11222223333" id="telefone"> <br>

            <input type="reset">
            <input type="submit">

        </form>

        <div id="footer">
            <a href="${pageContext.request.contextPath}/lista">Listar contatos cadastrados</a> <br>
            <a href="${pageContext.request.contextPath}/logout">Encerrar sessão</a>

        </div>

    </body>

</html>
