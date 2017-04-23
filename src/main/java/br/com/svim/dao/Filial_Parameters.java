/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.svim.dao;

import br.com.svim.model.Filial;

/**
 *
 * @author Cauê Ghetti
 */
public class Filial_Parameters {

    protected String insertFilial(Filial filial){
        
        
        
         String sql = "insert into filial("
                                            + "nome,"
                                            + "logradouro,"
                                            + "numero,"
                                            + "bairro,"
                                            + "cidade,"
                                            + "uf,"
                                            + "cep ) "
                                                + "values('"+filial.getNome_filial()+"',"
                                                + "'"+filial.getRua()+"',"
                                                +""+filial.getNumero()+","
                                                + "'"+filial.getBairro()+"',"
                                                + "'"+filial.getCidade()+"',"
                                                + "'"+filial.getUf()+"',"
                                                + "'"+filial.getCep()+"')";
        
        return sql;
    }

}
