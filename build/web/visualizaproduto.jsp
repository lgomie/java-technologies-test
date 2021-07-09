<%-- 
    Document   : visualizaproduto
    Created on : Jun 29, 2021, 7:52:29 PM
    Author     : luiz
--%>

<%@page import="br.recife.edu.ifpe.model.classes.Produto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Produto Cadastrado</h1>

        <%
            Produto produto = (Produto) request.getAttribute("produto");
            if (produto != null) {
        %>

        <table border="1">
            <tr>
                <th>Código</th><td><%= produto.getCodigo()%></td>
            </tr>
            <tr>
                <th>Nome</th><td><%= produto.getNome()%></td>
            </tr>
            <tr>
                <th>Marca</th><td><%= produto.getMarca()%></td>
            </tr>
            <tr>
                <th>Categoria</th><td><%= produto.getCategoria()%></td>
            </tr>            
            <tr>
                <th>Descrição</th><td><%= produto.getDescricao()%></td>
            </tr>
        </table>
        <%
            }
        %>
    </body>
</html>
