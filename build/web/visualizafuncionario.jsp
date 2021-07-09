<%-- 
    Document   : visualizafuncionario
    Created on : Jun 29, 2021, 7:52:29 PM
    Author     : luiz
--%>

<%@page import="br.recife.edu.ifpe.model.classes.Funcionario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Funcionário Cadastrado</h1>

        <%
            Funcionario funcionario = (Funcionario) request.getAttribute("funcionario");
            if (funcionario != null) {
        %>

        <table border="1">
            <tr>
                <th>Código</th><td><%= funcionario.getCodigo()%></td>
            </tr>
            <tr>
                <th>Nome</th><td><%= funcionario.getNome()%></td>
            </tr>
            <tr>
                <th>Departamento</th><td><%= funcionario.getDepartamento()%></td>
            </tr>
        </table>
        <%
            }
        %>
    </body>
</html>
