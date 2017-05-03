/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.svim.dao;

import br.com.svim.model.Filial;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author iago.cguimaraes
 */
public class TestarDaos {

    public static void main(String[] args) throws Exception{
        try {
            /* FILIAL */
            Filial f = new Filial();
            f.setNomeFilial("filial");
            f.setRua("rua");
            f.setNumero(123);
            f.setBairro("bairro");
            f.setCidade("cidade");
            f.setUf("uf");
            f.setCep("12345");

            //DaoFilial.cadastrarFilial(f);       
            //DaoFilial.alterarFilial(f);
            
            Filial f2 = DaoFilial.obterFilial(6);                     
            System.out.println(f2.getIdFilial());
            System.out.println(f2.getNomeFilial());
            System.out.println(f2.getBairro());
            System.out.println(f2.getNumero());
            

            ArrayList<Filial> filiais = DaoFilial.obterFiliais();
            System.out.println(filiais.size());
            

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
