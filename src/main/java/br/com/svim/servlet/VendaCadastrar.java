/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.svim.servlet;

import br.com.svim.controller.ProdutoController;
import br.com.svim.controller.VendaController;
import br.com.svim.model.Filial;
import br.com.svim.model.Funcionario;
import br.com.svim.model.ItemVenda;
import br.com.svim.model.Produto;
import br.com.svim.model.Telas;
import br.com.svim.model.Venda;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Iago
 */
public class VendaCadastrar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        
        try {
            if (request.getSession().getAttribute("funcionario") == null) {
                response.sendRedirect("index.jsp");
            }

            String[] produtos = request.getParameterValues("produto");
            String[] quantidade = request.getParameterValues("quantidade");
            ArrayList<ItemVenda> items = new ArrayList<ItemVenda>();

            for (int i = 0; i < produtos.length; i++) {
                int idProduto = Integer.parseInt(produtos[i]);
                double qtd = Double.parseDouble(quantidade[i]);

                if (qtd > 0) {
                    ItemVenda item = new ItemVenda();
                    Produto produto = ProdutoController.obter(idProduto);
                    item.setProduto(produto);
                    item.setQuantidade(qtd);
                    items.add(item);
                }
            }
            
            request.removeAttribute("msg");

            Funcionario funcionario = (Funcionario)request.getSession().getAttribute("funcionario");
            Filial filial = funcionario.getFilial();

            Venda venda = new Venda();
            venda.setFilial(filial);
            venda.setFuncionario(funcionario);
            venda.setItems(items);

            VendaController.cadastrar(venda);
            
            request.getRequestDispatcher("./VendaListar").forward(request, response);
        } catch (Exception e) {
            System.err.println("ERRO --->" + e.getMessage());
            request.getSession().setAttribute("erro", "Algo de Errado Ocorreu: " + e.getMessage());
            request.getRequestDispatcher("./VendaListarListar").forward(request, response);
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
