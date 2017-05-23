/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.svim.controller;

import br.com.svim.dao.DaoTipoProduto;
import br.com.svim.model.TipoProduto;
import java.util.ArrayList;

/**
 *
 * @author Iago
 */
public class TipoProdutoController {

    public static void cadastrar(TipoProduto tipoProduto) throws Exception {
        try {
            validar(tipoProduto);
            DaoTipoProduto.cadastrar(tipoProduto);
        } catch (Exception e) {
            throw e;
        }
    }

    public static void alterar(TipoProduto tipoProduto) throws Exception {
        try {
            validar(tipoProduto);
            DaoTipoProduto.alterar(tipoProduto);
        } catch (Exception e) {
            throw e;
        }
    }

    public static TipoProduto obter(int idTipoProduto) throws Exception {
        try {
            return DaoTipoProduto.obter(idTipoProduto);
        } catch (Exception e) {
            throw e;
        }
    }

    public static ArrayList<TipoProduto> obter() throws Exception {
        try {
            return DaoTipoProduto.obter();
        } catch (Exception e) {
            throw e;
        }
    }

    public static void deletar(int id) throws Exception {
        try {
            DaoTipoProduto.deletar(id);
        } catch (Exception e) {
            throw e;
        }
    }

    private static void validar(TipoProduto tipoProduto) throws Exception {
        try {
            if (tipoProduto.getTipoProduto() == null || tipoProduto.getTipoProduto().trim().isEmpty()) {
                throw new Exception("Tipo de Produto vazio");
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
