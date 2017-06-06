/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.svim.controller;

import br.com.svim.dao.DaoVenda;
import br.com.svim.model.Venda;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author Iago
 */
public class VendaController {

    public static void cadastrar(Venda venda) throws Exception {
        try {
            DaoVenda.cadastrar(venda);
        } catch (Exception e) {
            throw e;
        }
    }

    public static Venda obterVenda(int idVenda) throws Exception {
        try {
            return DaoVenda.obterVenda(idVenda);
        } catch (Exception e) {
            throw e;
        }
    }

    public static ArrayList<Venda> obter(int idFilial) throws Exception {
        try {
            return DaoVenda.obter(idFilial);
        } catch (Exception e) {
            throw e;
        }
    }

    public static ArrayList<Venda> obter() throws Exception {
        try {
            return DaoVenda.obter();
        } catch (Exception e) {
            throw e;
        }
    }

    public static ArrayList<Venda> obter(Date dtini, Date dtfim) throws Exception {
        try {
            return DaoVenda.obter(dtini, dtfim);
        } catch (Exception e) {
            throw e;
        }
    }

    private static void validar(Venda venda) throws Exception {
        try {
            if (venda.getItems().isEmpty()) {
                throw new Exception("Nenhum item na venda");
            }
            if (venda.getFuncionario().getIdFuncionario() <= 0) {
                throw new Exception("Funcionario inválido");
            }
            if (venda.getFilial().getIdFilial() <= 0) {
                throw new Exception("Filial inválida");
            }
        } catch (Exception e) {
            throw e;
        }
    }

}
