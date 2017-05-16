/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.svim.servlet;

import br.com.svim.controller.CargoController;
import br.com.svim.model.Cargo;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author caue.ghetti
 */
public class CargoCadastrar extends HttpServlet {

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

        Cargo cargo = new Cargo();

        cargo.setCargo(request.getParameter("cargos"));
        cargo.setHierarquia(2);

        try {

            CargoController cargoCon = new CargoController();
            cargoCon.cadastrar(cargo);
            
            request.getRequestDispatcher("./CargoListar").forward(request, response);

        } catch (Exception e) {

            System.err.println("ERROR-----> " + e);

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

        Cargo cargo = new Cargo();

        cargo.setCargo(request.getParameter(""));
        cargo.setHierarquia(Integer.parseInt(request.getParameter("")));

        try {

            CargoController cargoCon = new CargoController();
            cargoCon.cadastrar(cargo);

        } catch (Exception e) {

            System.err.println("ERROR-----> " + e);

        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
}
