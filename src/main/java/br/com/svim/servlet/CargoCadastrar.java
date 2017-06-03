/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.svim.servlet;

import br.com.svim.controller.CargoController;
import br.com.svim.model.Cargo;
import br.com.svim.model.Funcionario;
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

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Funcionario funcionario = (Funcionario) request.getSession().getAttribute("funcionario");
        if (funcionario == null) {
            response.sendRedirect("index.jsp");
        } else {
            if (funcionario.getCargo().getHierarquia() < 2) {
                response.sendRedirect("index.jsp");
            }
        }

        Cargo cargo = new Cargo();
        cargo.setCargo(request.getParameter("cargo"));
        cargo.setHierarquia(Integer.parseInt(request.getParameter("hierarquia")));
        try {
            CargoController.cadastrar(cargo);
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
        processRequest(request, response);
    }
}
