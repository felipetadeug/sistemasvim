/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.svim.model;

import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author iago.cguimaraes
 */
public class Venda {
    private int idVenda;
    private Funcionario funcionario;
    private Filial filial;
    private Date dataVenda;
    private ArrayList<ItemVenda> items;

    public Venda() {
    }

    public Venda(int idVenda, Funcionario funcionario, Filial filial, Date dataVenda, ArrayList<ItemVenda> items) {
        this.idVenda = idVenda;
        this.funcionario = funcionario;
        this.filial = filial;
        this.dataVenda = dataVenda;
        this.items = items;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Filial getFilial() {
        return filial;
    }

    public void setFilial(Filial filial) {
        this.filial = filial;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public ArrayList<ItemVenda> getItems() {
        return items;
    }

    public void setItems(ArrayList<ItemVenda> items) {
        this.items = items;
    }
    
    
}
