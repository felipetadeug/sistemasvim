/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.svim.dao;

import br.com.svim.model.Venda;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Iago
 */
public class DaoVenda {

    public static void cadastrar(Venda venda) throws Exception {
        try {
            Connection conn = SqlConnection.getConexao();
            String sql = "call cadastrar_venda(?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, venda.getFuncionario().getIdFuncionario());
            stmt.setInt(2, venda.getFilial().getIdFilial());

            ResultSet rs = stmt.executeQuery();
            rs.last();
            venda.setIdVenda(rs.getInt(1));

            stmt.close();
            conn.close();

            for (int i = 0; i < venda.getItems().size(); i++) {
                DaoItemVenda.cadastrar(venda, venda.getItems().get(i));
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public static Venda obterVenda(int idVenda) throws Exception {
        try {
            Venda venda = new Venda();
            Connection conn = SqlConnection.getConexao();
            String sql = "call obter_venda(?)";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, idVenda);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                venda = new Venda(
                        rs.getInt("id_venda"),
                        DaoFuncionario.obter(rs.getInt("id_funcionario")),
                        DaoFilial.obter(rs.getInt("id_filial")),
                        rs.getDate("data_venda"),
                        DaoItemVenda.obter(idVenda));
            }
            stmt.close();
            conn.close();

            return venda;
        } catch (Exception e) {
            throw e;
        }
    }

    public static ArrayList<Venda> obter(int idFilial) throws Exception {
        try {
            ArrayList<Venda> vendas = new ArrayList<Venda>();
            Connection conn = SqlConnection.getConexao();
            String sql = "call obter_vendas_filial(?)";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, idFilial);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                vendas.add(new Venda(
                        rs.getInt("id_venda"),
                        DaoFuncionario.obter(rs.getInt("id_funcionario")),
                        DaoFilial.obter(rs.getInt("id_filial")),
                        rs.getDate("data_venda"),
                        DaoItemVenda.obter(rs.getInt("id_venda"))));
            }
            stmt.close();
            conn.close();

            return vendas;
        } catch (Exception e) {
            throw e;
        }
    }

    public static ArrayList<Venda> obter() throws Exception {
        try {
            ArrayList<Venda> vendas = new ArrayList<Venda>();
            Connection conn = SqlConnection.getConexao();
            String sql = "call obter_vendas()";
            PreparedStatement stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                vendas.add(new Venda(
                        rs.getInt("id_venda"),
                        DaoFuncionario.obter(rs.getInt("id_funcionario")),
                        DaoFilial.obter(rs.getInt("id_filial")),
                        rs.getDate("data_venda"),
                        DaoItemVenda.obter(rs.getInt("id_venda"))));
            }
            stmt.close();
            conn.close();

            return vendas;
        } catch (Exception e) {
            throw e;
        }
    }

    public static ArrayList<Venda> obter(Date dtini,Date dtfim) throws Exception {
        try {
            ArrayList<Venda> vendas = new ArrayList<Venda>();
            Connection conn = SqlConnection.getConexao();
            String sql = "call obter_vendas_data(?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setDate(1, dtini);
            stmt.setDate(2, dtfim);
            
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                vendas.add(new Venda(
                        rs.getInt("id_venda"),
                        DaoFuncionario.obter(rs.getInt("id_funcionario")),
                        DaoFilial.obter(rs.getInt("id_filial")),
                        rs.getDate("data_venda"),
                        DaoItemVenda.obter(rs.getInt("id_venda"))));
            }
            stmt.close();
            conn.close();

            return vendas;
        } catch (Exception e) {
            throw e;
        }
    }

}
