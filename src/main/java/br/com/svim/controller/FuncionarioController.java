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


    private static void validar(Funcionario funcionario) throws Exception {
        try {
            if (funcionario.getNome() == null || funcionario.getNome().trim().isEmpty()) {
                throw new Exception("Campo Nome vazio");
            }
            if (!isCPF(funcionario.getCpf())){
                throw new Exception("CPF inválido");
            }
        } catch (Exception e) {
            throw e;
        }
    }

    private static boolean isCPF(String CPF) {

        if (CPF.equals("00000000000") || CPF.equals("11111111111")
                || CPF.equals("22222222222") || CPF.equals("33333333333")
                || CPF.equals("44444444444") || CPF.equals("55555555555")
                || CPF.equals("66666666666") || CPF.equals("77777777777")
                || CPF.equals("88888888888") || CPF.equals("99999999999")
                || (CPF.length() != 11)) {
            return (false);
        }

        char dig10, dig11;
        int sm, i, r, num, peso;

        try {
            sm = 0;
            peso = 10;
            for (i = 0; i < 9; i++) {
                num = (int) (CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11)) {
                dig10 = '0';
            } else {
                dig10 = (char) (r + 48);
            }

            sm = 0;
            peso = 11;
            for (i = 0; i < 10; i++) {
                num = (int) (CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11)) {
                dig11 = '0';
            } else {
                dig11 = (char) (r + 48);
            }

            if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10))) {
                return (true);
            } else {
                return (false);
            }
        } catch (InputMismatchException erro) {
            return (false);
        }
    }

    public static Funcionario logar(String cpf, String senha) throws Exception {
        try {
            Funcionario funcionario = DaoFuncionario.obter(cpf,senha);
            if(funcionario.getIdFuncionario() == 0){
                throw new Exception("CPF e/ou senha incorreto(s)");
            }
            return funcionario;
        } catch (Exception e) {
            throw e;
        }
    }

}
