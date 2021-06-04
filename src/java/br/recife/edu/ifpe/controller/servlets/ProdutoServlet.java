/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.recife.edu.ifpe.controller.servlets;

import br.recife.edu.ifpe.model.classes.ItemEstoque;
import br.recife.edu.ifpe.model.classes.Produto;
import br.recife.edu.ifpe.model.repositorios.RepositorioEstoque;
import br.recife.edu.ifpe.model.repositorios.RepositorioProdutos;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author luiz
 */
@WebServlet(name = "ProdutoServlet", urlPatterns = {"/ProdutoServlet"})
public class ProdutoServlet extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String atualizar = request.getParameter("atualizar");
        String deletar = request.getParameter("deletar");
        String codAux = request.getParameter("codigo");

        if (deletar != null) {

            Produto p = RepositorioProdutos.getCurrentInstance().read(Integer.parseInt(codAux));

            RepositorioProdutos.getCurrentInstance().delete(p);

            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet ProdutoServlet</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>O Produto " + p.getNome() + " foi devidamente deletado.</h1>");
                out.println("<a href=\"index.html\">home </a>");
                out.println("</body>");
                out.println("</html>");
            }
        }

        if (atualizar != null) {

            Produto p = RepositorioProdutos.getCurrentInstance().read(Integer.parseInt(codAux));

            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet ProdutoServlet</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Produto recuperado</h1>");
                out.println("<a href=\"ProdutoServlet\">Lista de produtos cadastrados</a><br><br>");

                out.println("        <h1>Cadastro de Produtos</h1>\n"
                        + "        <form method=\"post\" action=\"ProdutoServlet\">\n"
                        + "            Código: <input type=\"hidden\" name=\"codigo\" value=\"" + p.getCodigo() + "\"/><br>\n"
                        + "            Nome: <input type=\"text\" name=\"nome\" value=\"" + p.getNome() + "\"/><br>\n"
                        + "            Marca: <input type=\"text\" name=\"marca\" value=\"" + p.getMarca() + "\"/><br>\n"
                        + "            Categoria: <input type=\"text\" name=\"categoria\" value=\"" + p.getCategoria() + "\"/><br>\n"
                        + "            Descrição: <textarea name=\"descricao\" >" + p.getDescricao() + "</textarea><br>\n"
                        + "            <input type=\"hidden\" name=\"atualizar\" value=\"1\">"
                        + "            \n"
                        + "            <input type=\"submit\" value=\"atualizar\" />\n"
                        + "        </form>");
                out.println("</body>");
                out.println("</html>");
            }
        }

        if (codAux == null && atualizar == null && deletar == null) {
            List< Produto> produtos = RepositorioProdutos.getCurrentInstance().readAll();

            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet ProdutoServlet</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Produtos cadastrados</h1>");
                out.println("<a href=\"index.html\">home </a><br><br>");
                out.println("<table border=\"1\">");
                out.println("<tr><th>Código</th><th>Nome</th><th>Marca</th><th>Categoria</th><th>Operações</th></tr>");
                for (Produto produto : produtos) {
                    out.println("<tr>");
                    out.println("<td>" + produto.getCodigo() + "</td>");
                    out.println("<td>" + produto.getNome() + "</td>");
                    out.println("<td>" + produto.getMarca() + "</td>");
                    out.println("<td>" + produto.getCategoria() + "</td>");
                    out.println("<td><a href=\"ProdutoServlet?codigo=" + produto.getCodigo() + "\">Visualizar</a> "
                            + "<a href=\"ProdutoServlet?codigo=" + produto.getCodigo() + "&atualizar=1\">Atualizar</a> "
                            + "<a href=\"ProdutoServlet?codigo=" + produto.getCodigo() + "&deletar=1\">Deletar</a> </td>");
                    out.println("</tr>");
                }
                out.println("</table>");
                out.println("</body>");
                out.println("</html>");
            }
        } else {

            Produto p = RepositorioProdutos.getCurrentInstance().read(Integer.parseInt(codAux));

            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet ProdutoServlet</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Produto recuperado</h1>");
                out.println("<a href=\"index.html\">home </a><br><br>");

                out.println("Código : " + p.getCodigo() + "<br>");
                out.println("Nome: " + p.getNome() + "<br>");
                out.println("Marca: " + p.getMarca() + "<br>");
                out.println("Categoria: " + p.getCategoria() + "<br>");
                out.println("Descrição: " + p.getDescricao() + "<br>");

                out.println("</body>");
                out.println("</html>");
            }
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Produto p = new Produto();
        
        int codigo = Integer.parseInt(request.getParameter("codigo"));

        String atualizar = request.getParameter("atualizar");

        p.setCodigo(codigo);
        p.setNome(request.getParameter("nome"));
        p.setMarca(request.getParameter("marca"));
        p.setCategoria(request.getParameter("categoria"));
        p.setDescricao(request.getParameter("descricao"));

        if (atualizar != null) {
            RepositorioProdutos.getCurrentInstance().update(p);
        } else {

            RepositorioProdutos.getCurrentInstance().create(p);

            ItemEstoque item = new ItemEstoque();
            item.setProduto(p);
            item.setQuantidade(0);
            item.setCodigo(p.getCodigo());

            RepositorioEstoque.getCurrentInstance().read().addItem(item);
        }

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProdutoServlet</title>");
            out.println("</head>");
            out.println("<body>");
            if (atualizar == null) {
                out.println("<h1>Produto " + p.getNome() + " foi devidamente cadastrado.</h1>");
            } else {
                out.println("<h1>Produto " + p.getNome() + " foi devidamente atualizado.</h1>");

            }
            out.println("<a href=\"index.html\">home </a>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp); //To change body of generated methods, choose Tools | Templates.
    }

}
