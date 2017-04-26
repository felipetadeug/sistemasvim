/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.svim.model;

/**
 *
 * @author Cauê Ghetti
 */
public class Filial {

    private int idFilial;
    private String nomeFilial;
    private String rua;
    private String cep;
    private int numero;
    private String bairro;
    private String Cidade;
    private String uf;

    public Filial() {
    }

    public Filial(int idFilial, String nomeFilial, String rua, String cep, int numero, String bairro, String Cidade, String uf) {
        this.idFilial = idFilial;
        this.nomeFilial = nomeFilial;
        this.rua = rua;
        this.cep = cep;
        this.numero = numero;
        this.bairro = bairro;
        this.Cidade = Cidade;
        this.uf = uf;
    }

    public int getIdFilial() {
        return idFilial;
    }

    public String getNomeFilial() {
        return nomeFilial;
    }

    public void setNomeFilial(String nomeFilial) {
        this.nomeFilial = nomeFilial;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return Cidade;
    }

    public void setCidade(String Cidade) {
        this.Cidade = Cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

}
