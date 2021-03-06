/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.svim.servlet;

import br.com.svim.controller.FilialController;
import br.com.svim.model.Filial;
import br.com.svim.model.Funcionario;
import br.com.svim.model.Telas;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Cauê Ghetti
 */
public class FilialCadastrar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            Funcionario funcionario = (Funcionario) request.getSession().getAttribute("funcionario");
            if (funcionario == null) {
                response.sendRedirect("index.jsp");
            } else {
                if (funcionario.getCargo().getHierarquia() < 3) {
                    response.sendRedirect("index.jsp");
                }
            }

            request.removeAttribute("msg");

            Filial filial = new Filial();
            filial.setNomeFilial(request.getParameter("nome"));
            filial.setRua(request.getParameter("endereco"));
            filial.setBairro(request.getParameter("bairro"));
            filial.setCidade(request.getParameter("cidade"));
            filial.setUf(request.getParameter("uf"));
            filial.setCep(request.getParameter("cep"));
            filial.setNumero(Integer.parseInt(request.getParameter("numero")));

            FilialController.cadastrar(filial);
            request.getRequestDispatcher("./FilialListar").forward(request, response);
        } catch (Exception e) {
            System.err.println("ERROR-----> " + e);
            request.getSession().setAttribute("erro", "Algo de Errado Ocorreu: " + e.getMessage());
            request.getRequestDispatcher("./FilialListar").forward(request, response);
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
