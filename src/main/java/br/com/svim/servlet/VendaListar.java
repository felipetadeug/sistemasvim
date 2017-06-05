/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.svim.servlet;

import br.com.svim.controller.ProdutoController;
import br.com.svim.controller.TipoProdutoController;
import br.com.svim.model.Telas;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author iago.cguimaraes
 */
public class VendaListar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Telas tela = new Telas();
        
        try {
            if (request.getSession().getAttribute("funcionario") == null) {
                response.sendRedirect("index.jsp");
            }
            
            request.setAttribute("ListProduto", ProdutoController.obter());
            request.setAttribute("ListTipoProduto", TipoProdutoController.obter());
            request.getRequestDispatcher(tela.getVendaScreen()).forward(request, response);
        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
            
            request.setAttribute("msg", "Algo de Errado Ocorreu: "+ e);
            request.getRequestDispatcher(tela.getVendaScreen()).forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
