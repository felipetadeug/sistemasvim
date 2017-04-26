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
public class ItemVenda {
    private int idItemVenda;
    private Produto produto;
    private double quantidade;
    private double valor;

    public ItemVenda() {
    }

    public ItemVenda(int idItemVenda, Produto produto, double quantidade, double valor) {
        this.idItemVenda = idItemVenda;
        this.produto = produto;
        this.quantidade = quantidade;
        this.valor = valor;
    }

    public int getIdItemVenda() {
        return idItemVenda;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    
}
