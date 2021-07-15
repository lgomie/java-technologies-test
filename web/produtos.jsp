<%-- 
   Document   : produtos
   Created on : Jun 20, 2021, 1:30:06 PM
   Author     : luiz
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="br.recife.edu.ifpe.model.classes.Produto"%>
<%@page import="br.recife.edu.ifpe.model.repositorios.RepositorioProdutos"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="ifpe" uri="br.recife.edu.ifpe.customtags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <ifpe:carrega/>

        <h1>Produtos cadastrados</h1>
        <%
            String mensagem = (String) session.getAttribute("msg");
            if (mensagem != null) {
                out.println("<h1>" + mensagem + "</h1>");
                session.removeAttribute("msg");
            }
        %>

        <button onclick="modalOpen()">Novo Produto</button>
        <div id="modal" style="position: absolute; top: 200px; left: 200px; border: 1px solid orangered; background-color: white">

            <jsp:include page="cadastroproduto.jsp"/>
            <br>

            <button onclick="modalClose()">Fechar</button>
        </div>

        <div id="modal2" style="position: absolute; top: 200px; left: 200px; border: 1px solid orangered; background-color: white">

            <%@include file="visualizaproduto.jsp"%>
            <br>

            <button onclick="modal2Close()">Fechar</button>
        </div>

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
                    <td><a href="NewProdutoServlet?codigo=${pAux.codigo}&redirect=visualiza">Visualizar</a>
                        <a href="NewProdutoServlet?codigo=${pAux.codigo}&redirect=atualiza">Atualizar</a>
                        <a href="#" onclick="deleteProduto(${pAux.codigo})">Deletar</a></td>

                </tr>
            </c:forEach>

        </table>

        <script>
            var modal = document.getElementById("modal");

            var modal2 = document.getElementById("modal2");

            <%                    String redirect = request.getParameter("redirect");

                if (redirect
                        == null) {
            %>
            document.body.removeChild(modal);
            document.body.removeChild(modal2);
            <%
            } else if (redirect.equals(
                    "visualiza")) {
            %>
            document.body.removeChild(modal);
            <%
            } else {
            %>
            document.body.removeChild(modal2);

            <%
                }
            %>

            function modalOpen() {
                document.body.appendChild(modal);
            }

            function modalClose() {
                document.body.removeChild(modal);
            }

            function modal2Close() {
                document.body.removeChild(modal2);
            }

            function deleteProduto(codigo) {
                fetch("NewProdutoServlet?codigo=" + codigo, {method: 'delete'})
                        .then(function (response) {
                            location.reload();
                        });
            }
            ;

        </script>
    </body>
</html>
