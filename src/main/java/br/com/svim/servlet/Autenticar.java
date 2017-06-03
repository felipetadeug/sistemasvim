/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.svim.servlet;

import br.com.svim.controller.FuncionarioController;
import br.com.svim.model.Funcionario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author iago.cguimaraes
 */
@WebServlet(name = "Autenticar", urlPatterns = {"/Autenticar"})
public class Autenticar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String cpf = request.getParameter("cpf");
            String senha = request.getParameter("senha");
            Funcionario funcionario = FuncionarioController.logar(cpf, senha);

            if (funcionario.getIdFuncionario() > 0) {
                request.getSession().setAttribute("funcionario", funcionario);
                request.getRequestDispatcher("./VendaListar").forward(request, response);
            } else {
                throw new Exception("Usuário e/ou senha incorreto(s)");
            }
        } catch (Exception e) {
            System.err.println("ERRO --->" + e.getMessage());
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
