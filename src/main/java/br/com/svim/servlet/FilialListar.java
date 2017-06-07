/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.svim.servlet;

import br.com.svim.controller.FilialController;
import br.com.svim.model.Funcionario;
import br.com.svim.model.Telas;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Cauê Ghetti
 */
public class FilialListar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        
        
        Telas tela = new Telas();
        
        try {
            Funcionario funcionario = (Funcionario) request.getSession().getAttribute("funcionario");
            if (funcionario == null) {
                response.sendRedirect("index.jsp");
            } else {
                if (funcionario.getCargo().getHierarquia() < 3) {
                    response.sendRedirect("index.jsp");
                }
            }
            
            String erro = (String) request.getSession().getAttribute("erro");
            request.getSession().removeAttribute("erro");
            if (erro != null) {
                request.setAttribute("msg", erro);
            } else {
                request.removeAttribute("msg");             
            }

            request.setAttribute("ListFilial", FilialController.obter());
            request.setAttribute("UFsList", FilialController.ListUFs());
            request.getRequestDispatcher(tela.getFilialScreen()).forward(request, response);
        } catch (Exception e) {
            System.err.println("ERROR-----> " + e);
            request.setAttribute("msg", "Algo de Errado Ocorreu: "+ e);
            request.getRequestDispatcher(tela.getFilialScreen()).forward(request, response);
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(FilialListar.class.getName()).log(Level.SEVERE, null, ex);
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(FilialListar.class.getName()).log(Level.SEVERE, null, ex);
        }
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
