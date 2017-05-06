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
            DaoFilial.cadastrar(filial);
        } catch (Exception e) {
            throw e;
        }
    }

    public static void alterar(Filial filial) throws Exception {
        try {
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
}
