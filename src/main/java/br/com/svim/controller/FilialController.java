/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.svim.controller;

import br.com.svim.dao.DaoFilial;
import br.com.svim.model.Filial;
import java.util.ArrayList;

/**
 *
 * @author Iago
 */
public class FilialController {
    public static void cadastrar(Filial filial) throws Exception {
    try {
            validar(filial);
            DaoFilial.cadastrar(filial);
        } catch (Exception e) {
            throw e;
        }
    }

    public static void alterar(Filial filial) throws Exception {
        try {
            validar(filial);
            DaoFilial.alterar(filial);
        } catch (Exception e) {
            throw e;
        }
    }

    public static Filial obter(int idFilial) throws Exception {
        try {
            return DaoFilial.obter(idFilial);
        } catch (Exception e) {
            throw e;
        }
    }
    
        public static ArrayList<Filial> obter() throws Exception {
        try {
            return DaoFilial.obter();
        } catch (Exception e) {
            throw e;
        }
    }
        private static void validar(Filial filial) throws Exception {
            try{
                if(filial.getNomeFilial() == null || filial.getNomeFilial().trim().isEmpty()){
                    throw new Exception("Nome de Filial está vazio");
                }
                if(filial.getRua() == null || filial.getRua().trim().isEmpty()){
                    throw new Exception("Campo Rua vazio");
                }
                if(filial.getCep() == null || filial.getCep().trim().isEmpty()){
                    throw new Exception("Campo CEP vazio");
                }
                if(filial.getBairro() == null || filial.getBairro().trim().isEmpty()){
                    throw new Exception("Campo Bairro vazio");
                }
                if(filial.getCidade() == null || filial.getCidade().trim().isEmpty()){
                    throw new Exception("Campo Cidade Vazio");
                }
                if(filial.getUf() == null || filial.getUf().trim().isEmpty()){
                    throw new Exception("Campo UF vazio");
                }
                
            } catch(Exception e){
                throw e;
            }
        }
}
