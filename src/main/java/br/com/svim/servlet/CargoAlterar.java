/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.svim.servlet;

import br.com.svim.controller.CargoController;
import br.com.svim.model.Cargo;
import br.com.svim.model.Funcionario;
import br.com.svim.model.Telas;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Cauê Ghetti
 */
public class CargoAlterar extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Funcionario funcionario = (Funcionario)request.getSession().getAttribute("funcionario");
        if (funcionario == null) {
            response.sendRedirect("index.jsp");
        } else {
            if (funcionario.getCargo().getHierarquia() < 2) {
                response.sendRedirect("index.jsp");
            }
        }

        Cargo cargo = new Cargo();
        cargo.setIdCargo(Integer.parseInt(request.getParameter("id")));
        cargo.setCargo(request.getParameter("cargo"));
        cargo.setHierarquia(Integer.parseInt(request.getParameter("hierarquia")));

        
        
        try {
            CargoController.alterar(cargo);
            request.getRequestDispatcher("./CargoListar").forward(request, response);

        } catch (Exception e) {
            Telas tela = new Telas();
            System.err.println("ERROR ----> " + e);
            request.setAttribute("msg", "Algo de Errado Ocorreu: "+ e);
            request.getRequestDispatcher(tela.getCargoScreen()).forward(request, response);
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
