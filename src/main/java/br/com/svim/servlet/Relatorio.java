/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.svim.servlet;

import br.com.svim.controller.VendaController;
import br.com.svim.model.Funcionario;
import br.com.svim.model.Telas;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Iago
 */
public class Relatorio extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.removeAttribute("msg");
        Telas tela = new Telas();
        try {
            Funcionario funcionario = (Funcionario) request.getSession().getAttribute("funcionario");
            if (funcionario == null) {
                response.sendRedirect("index.jsp");
            } else {
                if (funcionario.getCargo().getHierarquia() < 2) {
                    response.sendRedirect("index.jsp");
                }
            }

            // se o usuario nao tiver setado data, obtem vendas de hoje
            java.util.Date _dtini = new java.util.Date();
            java.util.Date _dtfim = new java.util.Date();
            Date dtini = new java.sql.Date(_dtini.getTime());
            Date dtfim = new java.sql.Date(_dtfim.getTime());

            // se tiver data, obtem vendas do período passado
            if (request.getParameter("dtini") != null) {
                SimpleDateFormat dateType = new SimpleDateFormat("yyyy-MM-dd");
                _dtini = dateType.parse(request.getParameter("dtini"));
                _dtfim = dateType.parse(request.getParameter("dtfim"));
            }

            // adiciona um dia a data fim
            Calendar c = Calendar.getInstance();
            c.setTime(_dtfim);
            c.add(Calendar.DATE, 1);
            _dtfim = c.getTime();

            // seta no forma sql.date
            dtini = new java.sql.Date(_dtini.getTime());
            dtfim = new java.sql.Date(_dtfim.getTime());

            request.setAttribute("ListVenda", VendaController.obter(dtini, dtfim));
            request.getRequestDispatcher(tela.getRelatorioScreen()).forward(request, response);
        } catch (Exception e) {
            System.err.println("ERRO -->" + e.getMessage());

            request.setAttribute("msg", "Algo de Errado Ocorreu: " + e);
            request.getRequestDispatcher(tela.getRelatorioScreen()).forward(request, response);
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
