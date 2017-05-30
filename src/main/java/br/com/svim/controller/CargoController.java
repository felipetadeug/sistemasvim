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
            validar(cargo);
            DaoCargo.cadastrar(cargo);
        } catch (Exception e) {
            throw e;
        }
    }

    public static void alterar(Cargo cargo) throws Exception {
        try {
            validar(cargo);
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

    public static void deletar(int id) throws Exception {
        try {
            DaoCargo.deletar(id);
        } catch (Exception e) {
            throw e;
        }
    }

    private static void validar(Cargo cargo) throws Exception {
        try {
            if (!(cargo.getHierarquia() > 0 && cargo.getHierarquia() < 4)){
                throw new Exception("Hierarquia inválida");
            }
            
            if (cargo.getCargo() == null || cargo.getCargo().trim().isEmpty()) {
                throw new Exception("Cargo vazio");
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
