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
public class Produto {
    private int idProduto;
    private String produto;
    private TipoProduto tipoProduto;
    private double preco;
    private boolean ehCombustivel;
    private boolean ehEstocavel;

    public Produto() {
    }

    public Produto(int idProduto, String produto, TipoProduto tipoProduto, double preco, boolean ehCombustivel, boolean ehEstocavel) {
        this.idProduto = idProduto;
        this.produto = produto;
        this.tipoProduto = tipoProduto;
        this.preco = preco;
        this.ehCombustivel = ehCombustivel;
        this.ehEstocavel = ehEstocavel;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public TipoProduto getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(TipoProduto tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public boolean isEhCombustivel() {
        return ehCombustivel;
    }

    public void setEhCombustivel(boolean ehCombustivel) {
        this.ehCombustivel = ehCombustivel;
    }

    public boolean isEhEstocavel() {
        return ehEstocavel;
    }

    public void setEhEstocavel(boolean ehEstocavel) {
        this.ehEstocavel = ehEstocavel;
    }
    
    
}
