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
public class TipoProduto {

    private int idTipoProduto;

    private String tipoProduto;

    public TipoProduto() {
    }

    public TipoProduto(int idTipoProduto, String tipoProduto) {
        this.idTipoProduto = idTipoProduto;
        this.tipoProduto = tipoProduto;
    }

    public int getIdTipoProduto() {
        return idTipoProduto;
    }

    public String getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(String tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

}
