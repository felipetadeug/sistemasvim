/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.svim.controller;

import br.com.svim.dao.DaoEstoque;
import br.com.svim.model.Estoque;
import java.util.ArrayList;

/**
 *
 * @author Iago
 */
public class EstoqueController {
    public static void alterar(Estoque estoque) throws Exception {
        try {
            DaoEstoque.alterar(estoque);
        } catch (Exception e) {
            throw e;
        }
    }

    public static ArrayList<Estoque> obter(int idFilial) throws Exception {
        try {
            return DaoEstoque.obter(idFilial);
        } catch (Exception e) {
            throw e;
        }
    }

    public static ArrayList<Estoque> obter() throws Exception {
        try {
            return DaoEstoque.obter();
        } catch (Exception e) {
            throw e;
        }
    }
}
