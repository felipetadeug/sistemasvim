/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.svim.dao;

import br.com.svim.model.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Iago
 */
public class DaoEstoque {

    public static void alterar(Estoque estoque) throws Exception {
        try {
            Connection conn = SqlConnection.getConexao();
            String sql = "call alterar_estoque(?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, estoque.getFilial().getIdFilial());
            stmt.setInt(2, estoque.getProduto().getIdProduto());
            stmt.setDouble(3, estoque.getQuantidade());

            stmt.execute();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            throw e;
        }
    }

    public static ArrayList<Estoque> obter(int idFilial) throws Exception {
        try {
            ArrayList<Estoque> estoque = new ArrayList<Estoque>();
            Connection conn = SqlConnection.getConexao();
            String sql = "call obter_estoque_filial(?)";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, idFilial);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                estoque.add(new Estoque(
                        DaoProduto.obter(rs.getInt("id_produto")),
                        DaoFilial.obter(rs.getInt("id_filial")),
                        rs.getDouble("quantidade")));
            }
            stmt.close();
            conn.close();

            return estoque;
        } catch (Exception e) {
            throw e;
        }
    }

    public static ArrayList<Estoque> obter() throws Exception {
        try {
            ArrayList<Estoque> estoque = new ArrayList<Estoque>();
            Connection conn = SqlConnection.getConexao();
            String sql = "call obter_estoque()";
            PreparedStatement stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                estoque.add(new Estoque(
                        DaoProduto.obter(rs.getInt("id_produto")),
                        DaoFilial.obter(rs.getInt("id_filial")),
                        rs.getDouble("quantidade")));
            }
            stmt.close();
            conn.close();

            return estoque;
        } catch (Exception e) {
            throw e;
        }
    }

}
