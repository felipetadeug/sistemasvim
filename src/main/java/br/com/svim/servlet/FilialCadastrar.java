/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.svim.servlet;


import br.com.svim.controller.FilialController;
import br.com.svim.model.Filial;
import java.io.IOException;
import java.io.PrintWriter;
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
public class FilialCadastrar extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Filial filial = new Filial();

        filial.setNomeFilial(request.getParameter("FilialNome"));
        filial.setRua(request.getParameter("FilialRua"));
        filial.setBairro(request.getParameter("FilialBairro"));
        filial.setCidade(request.getParameter("FilialCidade"));
        filial.setUf(request.getParameter("FilialUF"));
        filial.setCep(request.getParameter("FilialCEP"));
        filial.setNumero(Integer.parseInt(request.getParameter("FilialNumero")));     
        
        
        try{
        
           FilialController filialCon = new FilialController();
           filialCon.cadastrar(filial);
           
            
        }catch(Exception e){
        
            System.err.println("ERROR-----> " +e);
            
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
