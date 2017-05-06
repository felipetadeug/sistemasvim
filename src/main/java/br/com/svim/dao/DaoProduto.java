/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.svim.dao;

import br.com.svim.model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Iago
 */
public class DaoProduto {
    public static void cadastrar(Produto produto) throws Exception {
        try {
            Connection conn = SqlConnection.getConexao();
            String sql = "call cadastrar_produto(?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, produto.getProduto());
            stmt.setInt(2, produto.getTipoProduto().getIdTipoProduto());
            stmt.setDouble(3, produto.getPreco());
            stmt.setBoolean(4, produto.isCombustivel());
            stmt.setBoolean(5, produto.isEstocavel());

            stmt.execute();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            throw e;
        }
    }

    public static void alterar(Produto produto) throws Exception {
        try {
            Connection conn = SqlConnection.getConexao();
            String sql = "call alterar_produto(?,?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, produto.getIdProduto());
            stmt.setString(1, produto.getProduto());
            stmt.setInt(2, produto.getTipoProduto().getIdTipoProduto());
            stmt.setDouble(3, produto.getPreco());
            stmt.setBoolean(4, produto.isCombustivel());
            stmt.setBoolean(5, produto.isEstocavel());

            stmt.execute();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            throw e;
        }
    }

    public static Produto obter(int idProduto) throws Exception {
        try {
            Produto produto = new Produto();
            Connection conn = SqlConnection.getConexao();
            String sql = "call obter_produto(?)";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, idProduto);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                produto = new Produto(
                        rs.getInt("id_produto"),
                        rs.getString("produto"),
                        DaoTipoProduto.obter(rs.getInt("id_tipo_produto")),
                        rs.getDouble("preco"),
                        rs.getBoolean("eh_combustivel"),
                        rs.getBoolean("eh_estocavel"));
            }
            stmt.close();
            conn.close();

            return produto;
        } catch (Exception e) {
            throw e;
        }
    }
    
        public static ArrayList<Produto> obter() throws Exception {
        try {
            ArrayList<Produto> produtos = new ArrayList<Produto>();
            Connection conn = SqlConnection.getConexao();
            String sql = "call obter_produtos()";
            PreparedStatement stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                produtos.add(new Produto(
                        rs.getInt("id_produto"),
                        rs.getString("produto"),
                        DaoTipoProduto.obter(rs.getInt("id_tipo_produto")),
                        rs.getDouble("preco"),
                        rs.getBoolean("eh_combustivel"),
                        rs.getBoolean("eh_estocavel")));
            }
            stmt.close();
            conn.close();

            return produtos;
        } catch (Exception e) {
            throw e;
        }
    }
}
