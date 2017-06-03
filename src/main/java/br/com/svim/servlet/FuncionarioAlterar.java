/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.svim.servlet;

import br.com.svim.controller.CargoController;
import br.com.svim.controller.FilialController;
import br.com.svim.controller.FuncionarioController;
import br.com.svim.model.Cargo;
import br.com.svim.model.Filial;
import br.com.svim.model.Funcionario;
import java.io.IOException;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Cauê Ghetti
 */
public class FuncionarioAlterar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            if (request.getSession().getAttribute("funcionario") == null) {
                response.sendRedirect("index.jsp");
            }

            Funcionario funcionario = new Funcionario();
            funcionario.setIdFuncionario(Integer.parseInt(request.getParameter("id")));
            funcionario.setNome(request.getParameter("nome"));
            funcionario.setCpf(request.getParameter("cpf"));
            SimpleDateFormat dateType = new SimpleDateFormat("yyyy-MM-dd");
            funcionario.setDataAdmissao(dateType.parse(request.getParameter("dtadm")));
            funcionario.setDataNascimento(dateType.parse(request.getParameter("dtnasc")));
            Cargo cargo = CargoController.obter(Integer.parseInt(request.getParameter("cargo")));
            funcionario.setCargo(cargo);
            Filial filial = FilialController.obter(Integer.parseInt(request.getParameter("filial")));
            funcionario.setFilial(filial);
            funcionario.setSenha(request.getParameter("senha"));
            FuncionarioController.alterar(funcionario);
            request.getRequestDispatcher("./FuncionarioListar").forward(request, response);
        } catch (Exception e) {
            System.err.println("ERRO -->" + e.getMessage());
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
