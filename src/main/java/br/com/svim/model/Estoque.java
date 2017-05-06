/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.svim.model;

/**
 *
 * @author iago.cguimaraes
 */
public class Estoque {
    private Produto produto;
    private Filial filial;
    private double quantidade;

    public Estoque() {
    }

    public Estoque(Produto produto, Filial filial, double quantidade) {
        this.produto = produto;
        this.filial = filial;
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public Filial getFilial() {
        return filial;
    }

    public void setFilial(Filial filial) {
        this.filial = filial;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }
    
    
}
