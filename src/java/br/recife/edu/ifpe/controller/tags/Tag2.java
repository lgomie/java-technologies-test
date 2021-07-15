/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.recife.edu.ifpe.controller.tags;

import java.io.IOException;
import java.io.StringWriter;
import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author luiz
 */
public class Tag2 extends SimpleTagSupport {
    
    private String var;

    public void setVar(String var) {
        this.var = var;
    }
    
    @Override
    public void doTag() throws JspException, IOException {
        super.doTag(); //To change body of generated methods, choose Tools | Templates.
        
        StringWriter tagBody = new StringWriter();
        
        getJspBody().invoke(tagBody);
        
        getJspContext().getOut().write("<h1>" + tagBody.toString() +" " + this.var + "</h1>");
    }
    
    
    
}
