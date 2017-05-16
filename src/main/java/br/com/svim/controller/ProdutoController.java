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
    public  void cadastrar(Produto produto) throws Exception {
        try {
            validar(produto);
           DaoProduto.cadastrar(produto);
        } catch (Exception e) {
            throw e;
        }
    }

    public  void alterar(Produto produto) throws Exception {
        try {
            validar(produto);
            DaoProduto.alterar(produto);
        } catch (Exception e) {
            throw e;
        }
    }

    public  Produto obter(int idProduto) throws Exception {
        try {
            return DaoProduto.obter(idProduto);
        } catch (Exception e) {
            throw e;
        }
    }
    
        public  ArrayList<Produto> obter() throws Exception {
        try {
            return DaoProduto.obter();
        } catch (Exception e) {
            throw e;
        }
    }
       private  void validar(Produto produto) throws Exception{
           try {
               if (produto.getProduto() == null || produto.getProduto().trim().isEmpty()){
                   throw new Exception("Produto vazio");
               }
               
           } catch (Exception e){
               throw e;
           }
       }
}
