<%-- 
    Document   : cadastrofuncionario
    Created on : Jul 28, 2021, 10:36:45 AM
    Author     : luiz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <h1>Cadastro Funcionario</h1>
        <form method="post" action="NewFuncionarioServlet">
            Código: <input type="text" name="codigo" value="${(param.redirect != null && param["redirect"] eq 'atualiza')?funcionario.codigo:''}"/><br>
            Nome: <input type="text" name="nome" value="${(param.redirect != null && param["redirect"] eq 'atualiza')?funcionario.nome:''}"/><br>
            Departamento: <input type="text" name="departamento" value="${(param.redirect != null && param["redirect"] eq 'atualiza')?funcionario.departamento:''}"/><br>
            <input type="hidden" name="${(param.redirect != null && param.redirect eq 'atualiza')?'atualizar':'cadastrar'}" value="1">

            <input type="submit" value="${(param.redirect != null && param.redirect eq 'atualiza')?'atualizar':'cadastrar'}" />
        </form>
    </body>
</html>
