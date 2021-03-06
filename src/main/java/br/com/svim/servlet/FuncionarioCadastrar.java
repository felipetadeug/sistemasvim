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
import br.com.svim.model.Telas;
import java.io.IOException;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author caue.ghetti
 */
public class FuncionarioCadastrar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // AUTENTICACAO/AUTORIZACAO
            Funcionario f = (Funcionario) request.getSession().getAttribute("funcionario");
            if (f == null) {
                response.sendRedirect("index.jsp");
            } else {
                if (f.getCargo().getHierarquia() < 2) {
                    response.sendRedirect("index.jsp");
                }
            }

            request.removeAttribute("msg");

            Funcionario funcionario = new Funcionario();
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
            FuncionarioController.cadastrar(funcionario);
            request.getRequestDispatcher("./FuncionarioListar").forward(request, response);
        } catch (Exception e) {
            System.err.println("ERRO --->" + e.getMessage());            
            request.getSession().setAttribute("erro", "Algo de Errado Ocorreu: " + e.getMessage());  
            Telas tela = new Telas();
            request.getRequestDispatcher("./FuncionarioListar").forward(request, response);
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
