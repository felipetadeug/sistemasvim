/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.svim.controller;

import br.com.svim.dao.DaoFuncionario;
import br.com.svim.model.Funcionario;
import java.util.ArrayList;

/**
 *
 * @author Iago
 */
public class FuncionarioController {
    public static void cadastrar(Funcionario funcionario) throws Exception {
        try {
            DaoFuncionario.cadastrar(funcionario);
        } catch (Exception e) {
            throw e;
        }
    }

    public static void alterar(Funcionario funcionario) throws Exception {
        try {
            DaoFuncionario.alterar(funcionario);
        } catch (Exception e) {
            throw e;
        }
    }

    public static Funcionario obter(int idFuncionario) throws Exception {
        try {
            return DaoFuncionario.obter(idFuncionario);
        } catch (Exception e) {
            throw e;
        }
    }

    public static ArrayList<Funcionario> obter() throws Exception {
        try {
            return DaoFuncionario.obter();
        } catch (Exception e) {
            throw e;
        }
    }
}
