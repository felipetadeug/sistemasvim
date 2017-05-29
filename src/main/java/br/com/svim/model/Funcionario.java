/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.svim.model;

import java.sql.Date;

/**
 *
 * @author Cauê Ghetti
 */
public class Funcionario {

    private int idFuncionario;
    private String nome;
    private String cpf;
    private Date dataNascimento;
    private Date dataAdmissao;
    private Cargo cargo;
    private Filial filial;
    private String senha;

    public Funcionario(){
        
    }
    
    public Funcionario(int idFuncionario, String nome, String cpf, Date dataNascimento, Date dataAdmissao, Cargo cargo, Filial filial, String senha) {
        this.idFuncionario = idFuncionario;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.dataAdmissao = dataAdmissao;
        this.cargo = cargo;
        this.filial = filial;
        this.senha = senha;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }
        
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(java.util.Date dataNascimento) {
        this.dataNascimento = new java.sql.Date(dataNascimento.getTime());
    }

    public Date getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(java.util.Date dataAdmissao) {
        this.dataAdmissao = new java.sql.Date(dataAdmissao.getTime());
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Filial getFilial() {
        return filial;
    }

    public void setFilial(Filial filial) {
        this.filial = filial;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    

    
    
}
