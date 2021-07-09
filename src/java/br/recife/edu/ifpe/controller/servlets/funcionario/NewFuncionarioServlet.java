/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.recife.edu.ifpe.controller.servlets.funcionario;

import br.recife.edu.ifpe.model.classes.Funcionario;
import br.recife.edu.ifpe.model.repositorios.RepositorioFuncionario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author luiz
 */
@WebServlet(name = "NewFuncionarioServlet", urlPatterns = {"/NewFuncionarioServlet"})
public class NewFuncionarioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String codigo = request.getParameter("codigo");

        Funcionario f = RepositorioFuncionario.getCurrentInstance().read(Integer.parseInt(codigo));

        request.setAttribute("funcionario", f);

        getServletContext().getRequestDispatcher("/funcionarios.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String a = request.getParameter("atualizar");

        Funcionario f = new Funcionario();

        int codigo = Integer.parseInt(request.getParameter("codigo"));

        String atualizar = request.getParameter("atualizar");

        f.setCodigo(codigo);
        f.setNome(request.getParameter("nome"));
        f.setDepartamento(request.getParameter("departamento"));

        HttpSession session = request.getSession();

        if (a == null) {
            RepositorioFuncionario.getCurrentInstance().create(f);

            session.setAttribute("msg", "Funcionario " + f.getNome() + " cadastrado com sucesso.");
        } else {
            RepositorioFuncionario.getCurrentInstance().update(f);
            session.setAttribute("msg", "Funcionário" + f.getNome() + " foi cadastrato com sucesso.");
        }

        response.sendRedirect("funcionarios.jsp");

    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doDelete(request, response); //To change body of generated methods, choose Tools | Templates.

        int codigo = Integer.parseInt(request.getParameter("codigo"));

        Funcionario f = RepositorioFuncionario.getCurrentInstance().read(codigo);

        RepositorioFuncionario.getCurrentInstance().delete(f);

        HttpSession session = request.getSession();

        session.setAttribute("msg", "O funcionário " + f.getNome() + " foi deletado com sucesso!");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
