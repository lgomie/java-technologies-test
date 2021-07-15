<%-- 
   Document   : funcionarios
   Created on : Jun 28, 2021, 12:26:06 AM
   Author     : luiz
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="br.recife.edu.ifpe.model.repositorios.RepositorioFuncionario"%>
<%@page import="br.recife.edu.ifpe.model.classes.Funcionario"%>
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
        <h1>Funcionários cadastrados</h1>
        <%
            String mensagem = (String) session.getAttribute("msg");
            if (mensagem != null) {
                out.println("<h1>" + mensagem + "</h1>");
                session.removeAttribute("msg");
            }
        %>

        <button onclick="modalOpen()">Novo Funcionário</button>
        <div id="modal" style="position: absolute; top: 200px; left: 200px; border: 1px solid orangered; background-color: white">

            <%@include file="cadastrofuncionario.jsp"%>

            <br>
            <button onclick="modalClose()">Fechar</button>
        </div>

        <div id="modal2" style="position: absolute; top: 200px; left: 200px; border: 1px solid orangered; background-color: white">

            <%@include file="visualizafuncionario.jsp"%>

            <br>
            <button onclick="modal2Close()">Fechar</button>
        </div>

        <table border="1">
            <tr>
                <th>Código</th><th>Nome</th><th>Departamento</th><th>Operações</th>
            </tr>
            <c:forEach var="fAux" items="${funcionarios}">
                <tr>
                    <td>${fAux.codigo}</td>
                    <td>${fAux.nome}</td>
                    <td>${fAux.departamento}</td>
                    <td><a href="NewFuncionarioServlet?codigo=${fAux.codigo}&redirect=visualiza">Visualizar</a>
                        <a href="NewFuncionarioServlet?codigo=${fAux.codigo}&redirect=atualiza">Atualizar</a>
                        <a href="#" onclick="deleteFuncionario(${fAux.codigo})">Deletar</a></td>
                </tr>
            </c:forEach>
        </table>

        <script>
            var modal = document.getElementById("modal");

            var modal2 = document.getElementById("modal2");

            <%
                String redirect = request.getParameter("redirect");

                if (redirect == null) {
            %>
            document.body.removeChild(modal);
            document.body.removeChild(modal2);
            <%
            } else if (redirect.equals("visualiza")) {
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

            function deleteFuncionario(codigo) {
                fetch("NewFuncionarioServlet?codigo=" + codigo, {method: 'delete'})
                        .then(function (response) {
                            location.reload();
                        });
            }
            ;


        </script>
    </body>
</html>
