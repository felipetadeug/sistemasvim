/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.svim.dao;

/**
 *
 * @author Cauê Ghetti
 */
public class Filial_Parameters {

    protected String insertFilial(String Nome,String Rua,int Numero,String Bairro,String Cidade,String UF,String CEP){
        
         String sql = "insert into filial("
                                            + "nome,"
                                            + "logradouro,"
                                            + "numero,"
                                            + "bairro,"
                                            + "cidade,"
                                            + "uf,"
                                            + "cep ) "
                                                + "values('"+Nome+"',"
                                                + "'"+Rua+"',"
                                                +""+Numero+","
                                                + "'"+Bairro+"',"
                                                + "'"+Cidade+"',"
                                                + "'"+UF+"',"
                                                + "'"+CEP+"')";
        
        return sql;
    }

}
