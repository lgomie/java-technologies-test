<%-- 
    Document   : cadastroproduto
    Created on : Jun 28, 2021, 11:36:45 AM
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

        <h1>Cadastro Produto</h1>
        <form method="post" action="NewProdutoServlet">
            Código: <input type="text" name="codigo" value="${(param.redirect != null && param["redirect"] eq 'atualiza')?produto.codigo:''}"/><br>
            Nome: <input type="text" name="nome" value="${(param.redirect != null && param["redirect"] eq 'atualiza')?produto.nome:''}"/><br>
            Marca: <input type="text" name="marca" value="${(param.redirect != null && param["redirect"] eq 'atualiza')?produto.marca:''}"/><br>
            Categoria: <input type="text" name="categoria" value="${(param.redirect != null && param["redirect"] eq 'atualiza')?produto.categoria:''}"/><br>
            Descrição: <textarea name="descricao" >${(param.redirect != null && param["redirect"] eq 'atualiza')?produto.codigo:''}</textarea><br>
            <input type="hidden" name="${(param.redirect != null && param.redirect eq 'atualiza')?'atualizar':'cadastrar'}" value="1">

            <input type="submit" value="${(param.redirect != null && param.redirect eq 'atualiza')?'atualizar':'cadastrar'}" />
        </form>
    </body>
</html>
