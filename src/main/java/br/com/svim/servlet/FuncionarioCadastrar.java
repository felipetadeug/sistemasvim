/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.svim.servlet;

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
 * @author caue.ghetti
 */
public class FuncionarioCadastrar extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Funcionario funcionario = new Funcionario();
        
        funcionario.setNome(request.getParameter("nome"));
        funcionario.setCpf(request.getParameter("cpf"));
        
        try {
            SimpleDateFormat dateType = new SimpleDateFormat( "dd/MM/yyyy" );
            funcionario.setDataAdmissao((Date) dateType.parse(request.getParameter("data_ad")));
            funcionario.setDataNascimento((Date) dateType.parse(request.getParameter("data_nasc")));
        } catch (ParseException ex) {
            Date data;
            Logger.getLogger(FuncionarioCadastrar.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Cargo cargo = new Cargo();
        cargo.setCargo(request.getParameter("cargo"));
        funcionario.setCargo(cargo);
        
        Filial filial = new Filial();
        filial.setNomeFilial(request.getParameter("filial"));
        funcionario.setFilial(filial);
        
        funcionario.setSenha(request.getParameter("filial"));
        
        FuncionarioController control = new FuncionarioController();
        
        try {
            control.cadastrar(funcionario);
        } catch (Exception ex) {
            Logger.getLogger(FuncionarioCadastrar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    
}
