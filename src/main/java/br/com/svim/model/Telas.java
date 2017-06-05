/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.svim.model;

/**
 *
 * @author caue.ghetti
 */
public class Telas {
    
    String filial,cargo,venda,relatorio,estoque,funcionario,produto,tipo_produto;
    
    
    
    public Telas(){
        this.filial = "WEB-INF/filial.jsp";
        this.cargo = "WEB-INF/cargo.jsp";
        this.venda = "WEB-INF/venda.jsp";
        this.relatorio = "WEB-INF/relatorio.jsp";
        this.estoque = "WEB-INF/estoque.jsp";
        this.funcionario = "WEB-INF/funcionario.jsp";
        this.produto = "WEB-INF/produto.jsp";
        this.tipo_produto = "WEB-INF/tipo_produto.jsp";
    }
    
    
    public String getFilialScreen() {
        return filial;
    }

    public String getCargoScreen() {
        return cargo;
    }

    public String getVendaScreen() {
        return venda;
    }

    public String getRelatorioScreen() {
        return relatorio;
    }

    public String getEstoqueScreen() {
        return estoque;
    }

    public String getFuncionarioScreen() {
        return funcionario;
    }

    public String getProdutoScreen() {
        return produto;
    }

    public String getTipo_produtoScreen() {
        return tipo_produto;
    }
    
    
    
    
}
