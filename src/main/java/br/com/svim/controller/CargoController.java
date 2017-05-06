/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.svim.controller;

import br.com.svim.dao.DaoCargo;
import br.com.svim.model.Cargo;
import java.util.ArrayList;

/**
 *
 * @author Iago
 */
public class CargoController {
    public static void cadastrar(Cargo cargo) throws Exception {
        try {
            DaoCargo.cadastrar(cargo);
        } catch (Exception e) {
            throw e;
        }
    }

    public static void alterar(Cargo cargo) throws Exception {
        try {
            DaoCargo.alterar(cargo);
        } catch (Exception e) {
            throw e;
        }
    }

    public static Cargo obter(int idCargo) throws Exception {
        try {
            return DaoCargo.obter(idCargo);
        } catch (Exception e) {
            throw e;
        }
    }
    
        public static ArrayList<Cargo> obter() throws Exception {
        try {
            return DaoCargo.obter();
        } catch (Exception e) {
            throw e;
        }
    }
}
