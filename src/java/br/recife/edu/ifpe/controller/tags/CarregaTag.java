/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.recife.edu.ifpe.controller.tags;

import br.recife.edu.ifpe.model.classes.Estoque;
import br.recife.edu.ifpe.model.classes.Funcionario;
import br.recife.edu.ifpe.model.classes.LoteEntrada;
import br.recife.edu.ifpe.model.classes.LoteSaida;
import br.recife.edu.ifpe.model.classes.Produto;
import br.recife.edu.ifpe.model.repositorios.RepositorioEstoque;
import br.recife.edu.ifpe.model.repositorios.RepositorioFuncionario;
import br.recife.edu.ifpe.model.repositorios.RepositorioLoteEntrada;
import br.recife.edu.ifpe.model.repositorios.RepositorioLoteSaida;
import br.recife.edu.ifpe.model.repositorios.RepositorioProdutos;
import java.io.IOException;
import java.util.List;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author luiz
 */
public class CarregaTag extends SimpleTagSupport {

    @Override
    public void doTag() throws JspException, IOException {
        super.doTag(); //To change body of generated methods, choose Tools | Templates.

        // TO-DO instanciar os repositórios, criar a tag e passar nas páginas produtos.jsp e funcionarios.jsp
        List< Produto> produtos = RepositorioProdutos.getCurrentInstance().readAll();
        List< Funcionario > funcionarios = RepositorioFuncionario.getCurrentInstance().readAll();
        List< LoteEntrada > lotesEntrada = RepositorioLoteEntrada.getCurrentInstance().readAll();
        List< LoteSaida > lotesSaida = RepositorioLoteSaida.getCurrentInstance().readAll();
        Estoque estoque = RepositorioEstoque.getCurrentInstance().read();

        getJspContext().setAttribute("produtos", produtos, PageContext.PAGE_SCOPE);
        getJspContext().setAttribute("funcionarios", funcionarios, PageContext.PAGE_SCOPE);
        getJspContext().setAttribute("lotesEntrada", lotesEntrada, PageContext.PAGE_SCOPE);
        getJspContext().setAttribute("lotesSaida", lotesSaida, PageContext.PAGE_SCOPE);
        getJspContext().setAttribute("estoque", estoque, PageContext.PAGE_SCOPE);

    }

}
