/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.svim.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import br.com.svim.model.TipoProduto;

/**
 *
 * @author Iago
 */
public class DaoTipoProduto {

    public static void cadastrar(TipoProduto tipoProduto) throws Exception {
        try {
            Connection conn = SqlConnection.getConexao();
            String sql = "call cadastrar_tipo_produto(?)";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, tipoProduto.getTipoProduto());

            stmt.execute();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            throw e;
        }
    }

    public static void alterar(TipoProduto tipoProduto) throws Exception {
        try {
            Connection conn = SqlConnection.getConexao();
            String sql = "call alterar_tipo_produto(?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, tipoProduto.getIdTipoProduto());
            stmt.setString(2, tipoProduto.getTipoProduto());

            stmt.execute();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            throw e;
        }
    }

    public static TipoProduto obter(int idTipoProduto) throws Exception {
        try {
            TipoProduto tipoProduto = new TipoProduto();
            Connection conn = SqlConnection.getConexao();
            String sql = "call obter_tipo_produto(?)";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, idTipoProduto);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                tipoProduto = new TipoProduto(
                        rs.getInt("id_tipo_produto"),
                        rs.getString("tipo_produto"));
            }
            stmt.close();
            conn.close();

            return tipoProduto;
        } catch (Exception e) {
            throw e;
        }
    }

    public static ArrayList<TipoProduto> obter() throws Exception {
        try {
            ArrayList<TipoProduto> tipos = new ArrayList<TipoProduto>();
            Connection conn = SqlConnection.getConexao();
            String sql = "call obter_tipos_produto()";
            PreparedStatement stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                tipos.add(new TipoProduto(
                        rs.getInt("id_tipo_produto"),
                        rs.getString("tipo_produto")));
            }
            stmt.close();
            conn.close();

            return tipos;
        } catch (Exception e) {
            throw e;
        }
    }

    public static void deletar(int id) throws Exception {
        try {
            Connection conn = SqlConnection.getConexao();
            String sql = "call remover_tipo_produto(?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            throw e;
        }
    }

}
