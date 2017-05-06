/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.svim.dao;

import br.com.svim.model.ItemVenda;
import br.com.svim.model.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Iago
 */
class DaoItemVenda {
     protected static void cadastrar(Venda venda, ItemVenda itemVenda) throws Exception {
        try {
            Connection conn = SqlConnection.getConexao();
            String sql = "call cadastrar_item_venda(?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, venda.getIdVenda());
            stmt.setInt(2, itemVenda.getProduto().getIdProduto());
            stmt.setDouble(3, itemVenda.getQuantidade());
            stmt.setDouble(4, itemVenda.getValor());

            stmt.execute();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            throw e;
        }
    }

    protected static ArrayList<ItemVenda> obter(int idVenda) throws Exception {
        try {
            ArrayList<ItemVenda> itemsVenda = new ArrayList<ItemVenda>();
            Connection conn = SqlConnection.getConexao();
            String sql = "call obter_items_venda(?)";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, idVenda);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                itemsVenda.add(new ItemVenda(
                        DaoProduto.obter(rs.getInt("id_produto")),
                        rs.getDouble("quantidade")));
            }
            stmt.close();
            conn.close();

            return itemsVenda;
        } catch (Exception e) {
            throw e;
        }
    }
    
}
