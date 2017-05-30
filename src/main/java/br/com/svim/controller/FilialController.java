/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.svim.controller;

import br.com.svim.dao.DaoFilial;
import br.com.svim.model.Filial;
import java.util.ArrayList;
import java.util.List;

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

    public static void deletar(int id) throws Exception {
        try {
            DaoFilial.deletar(id);
        } catch (Exception e) {
            throw e;
        }
    }

    private static void validar(Filial filial) throws Exception {
        try {
            if (filial.getNomeFilial() == null || filial.getNomeFilial().trim().isEmpty()) {
                throw new Exception("Nome de Filial está vazio");
            }
            if (filial.getRua() == null || filial.getRua().trim().isEmpty()) {
                throw new Exception("Campo Rua vazio");
            }
            if (filial.getCep() == null || filial.getCep().trim().isEmpty()) {
                throw new Exception("Campo CEP vazio");
            }
            if (!isNumeric(filial.getCep())) {
                throw new Exception("Campo CEP inválido (não numérico)");
            }
            if (filial.getBairro() == null || filial.getBairro().trim().isEmpty()) {
                throw new Exception("Campo Bairro vazio");
            }
            if (filial.getCidade() == null || filial.getCidade().trim().isEmpty()) {
                throw new Exception("Campo Cidade Vazio");
            }
            if (filial.getUf() == null || filial.getUf().trim().isEmpty()) {
                throw new Exception("Campo UF vazio");
            }

        } catch (Exception e) {
            throw e;
        }
    }

    private static boolean isNumeric(String str) {
        try {
            double d = Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
    
    public static List<String> ListUFs(){
            
        List<String> UFs = new ArrayList<>();
        UFs.add("AC");
        UFs.add("AL");
        UFs.add("AP");
        UFs.add("AM");
        UFs.add("BA");
        UFs.add("CE");
        UFs.add("DF");
        UFs.add("ES");
        UFs.add("GO");
        UFs.add("MA");
        UFs.add("MT");
        UFs.add("MS");
        UFs.add("MG");
        UFs.add("PA");
        UFs.add("PB");
        UFs.add("PE");
        UFs.add("PI");
        UFs.add("PR");
        UFs.add("RJ");
        UFs.add("RN");
        UFs.add("RO");
        UFs.add("RR");
        UFs.add("RS");
        UFs.add("SC");
        UFs.add("SE");
        UFs.add("SP");
        UFs.add("TO");
        
        return UFs;
    }

}
