/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.svim.controller;

import br.com.svim.dao.DaoProduto;
import br.com.svim.model.Produto;
import java.util.ArrayList;

/**
 *
 * @author Iago
 */
public class ProdutoController {
    public static void cadastrar(Produto produto) throws Exception {
        try {
           DaoProduto.cadastrar(produto);
        } catch (Exception e) {
            throw e;
        }
    }

    public static void alterar(Produto produto) throws Exception {
        try {
            DaoProduto.alterar(produto);
        } catch (Exception e) {
            throw e;
        }
    }

    public static Produto obter(int idProduto) throws Exception {
        try {
            return DaoProduto.obter(idProduto);
        } catch (Exception e) {
            throw e;
        }
    }
    
        public static ArrayList<Produto> obter() throws Exception {
        try {
            return DaoProduto.obter();
        } catch (Exception e) {
            throw e;
        }
    }
}
