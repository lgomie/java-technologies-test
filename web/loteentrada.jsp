<%-- 
    Document   : loteentrada
    Created on : Jul 11, 2021, 7:59:25 PM
    Author     : luiz
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="ifpe" uri="br.recife.edu.ifpe.customtags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Cadastro de Lote de Entrada</h1>
        
        <ifpe:carregaprodutos/>
        
        <table border="1">
            <tr>
                <th>Código</th><th>Nome</th><th>Marca</th><th>Categoria</th><th>Operações</th>
            </tr>
            
            <c:forEach var="pAux" items="${produtos}">
                <tr>
                    <td>${pAux.codigo}</td>
                    <td>${pAux.nome}</td>
                    <td>${pAux.marca}</td>
                    <td>${pAux.categoria}</td>
                </tr>
            </c:forEach>
                       
            
        </table>
    </body>
</html>
