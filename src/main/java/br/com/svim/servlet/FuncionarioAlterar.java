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
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
public class FuncionarioAlterar extends HttpServlet {

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

        Funcionario funcionario = new Funcionario();

        funcionario.setIdFuncionario(Integer.parseInt(request.getParameter("id")));
        funcionario.setNome(request.getParameter("nome"));
        funcionario.setCpf(request.getParameter("cpf"));

        try {
            SimpleDateFormat dateType = new SimpleDateFormat("yyyy-MM-dd");
            funcionario.setDataAdmissao(dateType.parse(request.getParameter("dtadm")));
            funcionario.setDataNascimento(dateType.parse(request.getParameter("dtnasc")));

        } catch (ParseException ex) {
            Date data;
            Logger.getLogger(FuncionarioCadastrar.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            Cargo cargo = CargoController.obter(Integer.parseInt(request.getParameter("cargo")));
            funcionario.setCargo(cargo);

            Filial filial = FilialController.obter(Integer.parseInt(request.getParameter("filial")));
            funcionario.setFilial(filial);
        } catch (Exception ex) {
            Logger.getLogger(FuncionarioCadastrar.class.getName()).log(Level.SEVERE, null, ex);
        }

        funcionario.setSenha(request.getParameter("senha"));

        try {
            FuncionarioController.alterar(funcionario);
            request.getRequestDispatcher("./FuncionarioListar").forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(FuncionarioCadastrar.class.getName()).log(Level.SEVERE, null, ex);
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
