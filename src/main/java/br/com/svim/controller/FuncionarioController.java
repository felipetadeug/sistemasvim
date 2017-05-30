/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.svim.controller;

import br.com.svim.dao.DaoFuncionario;
import br.com.svim.model.Funcionario;
import java.util.ArrayList;
import java.util.InputMismatchException;

/**
 *
 * @author Iago
 */
public class FuncionarioController {

    public static void cadastrar(Funcionario funcionario) throws Exception {
        try {
            validar(funcionario);
            DaoFuncionario.cadastrar(funcionario);
        } catch (Exception e) {
            throw e;
        }
    }

    public static void alterar(Funcionario funcionario) throws Exception {
        try {
            validar(funcionario);
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

    public static Funcionario logar(String cpf, String senha) throws Exception {
        try {
            Funcionario funcionario = DaoFuncionario.obter(cpf, senha);
            if (funcionario.getIdFuncionario() == 0) {
                throw new Exception("CPF e/ou senha incorreto(s)");
            }
            return funcionario;
        } catch (Exception e) {
            throw e;
        }
    }

    public static void deletar(int id) throws Exception {
        try {
            DaoFuncionario.deletar(id);
        } catch (Exception e) {
            throw e;
        }
    }

    private static void validar(Funcionario funcionario) throws Exception {
        try {
            if (funcionario.getNome() == null || funcionario.getNome().trim().isEmpty()) {
                throw new Exception("Campo Nome vazio");
            }
            validarCPF(funcionario.getCpf());

            if (!(funcionario.getFilial().getIdFilial() <= 0)) {
                throw new Exception("Filial inválida");
            }
            if (!(funcionario.getCargo().getIdCargo() <= 0)) {
                throw new Exception("Cargo inválido");
            }

        } catch (Exception e) {
            throw e;
        }
    }

    private static void validarCPF(String CPF) throws Exception {
        try {
            if (!(CPF.length() == 11)) {
                throw new Exception("CPF inválido");
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
