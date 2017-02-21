<%--
    Document   : lista
    Created on : 20/02/2017, 15:25:35
    Author     : 201319050441
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html>
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/estilo.css">
        <title>Exercício 10</title>

    </head>

    <body>
        <h1>Agenda JSP</h1>

        <table id="lista">
            <caption>Contatos Cadastrados</caption>

            <thead>
                <tr>
                    <th style="border-right-style: none;"></th>
                    <th style="border-left-style: none;">Nome</th>
                    <th>E-mail</th>
                    <th>Telefone</th>
                </tr>

            </thead>

            <tbody>
                <c:forEach items="${contatos}" var="contato">
                    <tr>
                        <td>
                            <form action="${pageContext.request.contextPath}/apaga" method="post">
                                <input style="display: none;" type="text" name="email" value="${contato.getEmail()}">
                                <input type="submit" value="X">
                            </form>
                        </td>
                        <td>${contato.getNomeCompleto()}</td>
                        <td>${contato.getEmail()}</td>
                        <td>${contato.getTelefone()}</td>
                    </tr>
                </c:forEach>
            </tbody>

        </table>

        <p>Total de contatos: <strong>${contatos.size()}</strong></p>

        <div id="footer">
            <a href="${pageContext.request.contextPath}/novo">Cadastrar novo contato</a> <br>
            <a href="${pageContext.request.contextPath}/logout">Encerrar sessão</a>

        </div>

    </body>

</html>
