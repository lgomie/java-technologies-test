/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.recife.edu.ifpe.controller.servlets;

import br.recife.edu.ifpe.model.classes.Funcionario;
import br.recife.edu.ifpe.model.repositorios.RepositorioFuncionario;
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
@WebServlet(name = "FuncionarioServlet", urlPatterns = {"/FuncionarioServlet"})
public class FuncionarioServlet extends HttpServlet {

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

            Funcionario f = RepositorioFuncionario.getCurrentInstance().read(Integer.parseInt(codAux));

            RepositorioFuncionario.getCurrentInstance().delete(f);

            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<meta charset=\"UTF-8\">");
                out.println("<title>Servlet FuncionarioServlet</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>O funcionário " + f.getNome() + " foi devidamente deletado.</h1>");
                out.println("<a href=\"index.html\">home</a>");
                out.println("</body>");
                out.println("</html>");
            }
        }

        if (atualizar != null) {

            Funcionario f = RepositorioFuncionario.getCurrentInstance().read(Integer.parseInt(codAux));

            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<meta charset=\"UTF-8\">");
                out.println("<title>Servlet FuncionarioServlet</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Funcionário recuperado</h1>");
                out.println("<a href=\"FuncionarioServlet\">Lista de funcionários cadastrados</a><br><br>");

                out.println("        <h1>Cadastro de Funcionários</h1>\n"
                        + "        <form method=\"post\" action=\"FuncionarioServlet\">\n"
                        + "            Código: <input type=\"hidden\" name=\"codigo\" value=\"" + f.getCodigo() + "\"/><br>\n"
                        + "            Nome: <input type=\"text\" name=\"nome\" value=\"" + f.getNome() + "\"/><br>\n"
                        + "            Departamento: <input type=\"text\" name=\"departamento\" value=\"" + f.getDepartamento() + "\"/><br>\n"
                        + "            <input type=\"hidden\" name=\"atualizar\" value=\"1\">"
                        + "            \n"
                        + "            <input type=\"submit\" value=\"atualizar\" />\n"
                        + "        </form>");
                out.println("</body>");
                out.println("</html>");
            }
        }

        if (codAux == null && atualizar == null && deletar == null) {
            List<Funcionario> funcionarios = RepositorioFuncionario.getCurrentInstance().readAll();

            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<meta charset=\"UTF-8\">");
                out.println("<title>Servlet FuncionarioServlet</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Funcinarios cadastrados</h1>");
                out.println("<a href=\"index.html\">home </a><br><br>");
                out.println("<table border=\"1\">");
                out.println("<tr><th>Código</th><th>Nome</th><th>Departamento</th><th>Operações</th></tr>");
                for (Funcionario f : funcionarios) {
                    out.println("<tr>");
                    out.println("<td>" + f.getCodigo() + "</td>");
                    out.println("<td>" + f.getNome() + "</td>");
                    out.println("<td>" + f.getDepartamento() + "</td>");
                    out.println("<td><a href=\"FuncionarioServlet?codigo=" + f.getCodigo() + "\">Visualizar</a> "
                            + "<a href=\"FuncionarioServlet?codigo=" + f.getCodigo() + "&atualizar=1\">Atualizar</a> "
                            + "<a href=\"FuncionarioServlet?codigo=" + f.getCodigo() + "&deletar=1\">Deletar</a> </td>");
                    out.println("</tr>");
                }
                out.println("</table>");
                out.println("</body>");
                out.println("</html>");
            }
        } else {

            Funcionario f = RepositorioFuncionario.getCurrentInstance().read(Integer.parseInt(codAux));

            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<meta charset=\"UTF-8\">");
                out.println("<title>Servlet FuncionarioServlet</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Funcionário recuperado</h1>");
                out.println("<a href=\"index.html\">home </a><br><br>");

                out.println("Código : " + f.getCodigo() + "<br>");
                out.println("Nome: " + f.getNome() + "<br>");
                out.println("Departamento: " + f.getDepartamento() + "<br>");

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

        Funcionario f = new Funcionario();

        String atualizar = request.getParameter("atualizar");

        f.setCodigo(Integer.parseInt(request.getParameter("codigo")));
        f.setNome(request.getParameter("nome"));
        f.setDepartamento(request.getParameter("departamento"));

        if (atualizar != null) {
            RepositorioFuncionario.getCurrentInstance().update(f);
        } else {

            RepositorioFuncionario.getCurrentInstance().create(f);

        }

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset=\"UTF-8\">");
            out.println("<title>Servlet FuncionarioServlet</title>");
            out.println("</head>");
            out.println("<body>");
            if (atualizar == null) {
                out.println("<h1>Funcionário " + f.getNome() + " foi devidamente cadastrado.</h1>");
            } else {
                out.println("<h1>Funcionário " + f.getNome() + " foi devidamente atualizado.</h1>");

            }
            out.println("<a href=\"index.html\">home</a>");
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
