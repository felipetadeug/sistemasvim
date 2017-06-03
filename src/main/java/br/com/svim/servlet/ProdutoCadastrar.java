/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.svim.servlet;

import br.com.svim.controller.ProdutoController;
import br.com.svim.controller.TipoProdutoController;
import br.com.svim.model.Produto;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author iago.cguimaraes
 */
public class ProdutoCadastrar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            if (request.getSession().getAttribute("funcionario") == null) {
                response.sendRedirect("index.jsp");
            }

            Produto produto = new Produto();
            produto.setProduto(request.getParameter("produto"));
            produto.setPreco(Double.parseDouble(request.getParameter("preco")));
            produto.setTipoProduto(TipoProdutoController.obter(Integer.parseInt(request.getParameter("tipo_produto"))));
            produto.setCombustivel(Boolean.parseBoolean(request.getParameter("combustivel")));
            produto.setEstocavel(Boolean.parseBoolean(request.getParameter("estocavel")));
            ProdutoController.cadastrar(produto);
            request.getRequestDispatcher("./ProdutoListar").forward(request, response);
            
        } catch (Exception e) {
            System.err.println("ERROR-----> " + e);
        }
    }

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
        processRequest(request, response);
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
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
