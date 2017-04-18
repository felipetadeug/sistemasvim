/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.svim.dao;

import br.com.svim.model.Filial;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Cauê Ghetti
 */
public class FilialDao {

    private Filial_Parameters param = new Filial_Parameters();

    public void cadastrarFilial(Filial filial) throws ClassNotFoundException {

        try {

            SQL_Connection conn = new SQL_Connection();
            Connection conexao = conn.getConexao();
            Statement Stat = conexao.createStatement();

            String sql = param.insertFilial(filial.getNome_filial(),
                                            filial.getRua(),
                                            filial.getNumero(),
                                            filial.getBairro(),
                                            filial.getCidade(),filial.getUf(),
                                            filial.getCep());

            Stat.executeUpdate(sql);

            System.err.println("br.com.svim.dao.FilialDao.cadastrarFilial() - Sucesso");
            Stat.close();
            conexao.close();

        } catch (SQLException error) {
            System.err.println("br.com.svim.dao.FilialDao.cadastrarFilial() - Falha");

        } finally {

        }
    }

}
