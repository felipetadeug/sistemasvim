/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.svim.dao;

import br.com.svim.model.Cargo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Iago
 */
public class DaoCargo {

    public static void cadastrar(Cargo cargo) throws Exception {
        try {
            Connection conn = SqlConnection.getConexao();
            String sql = "call cadastrar_cargo(?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, cargo.getCargo());
            stmt.setInt(2, cargo.getHierarquia());

            stmt.execute();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            throw e;
        }
    }

    public static void alterar(Cargo cargo) throws Exception {
        try {
            Connection conn = SqlConnection.getConexao();
            String sql = "call alterar_cargo(?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, cargo.getIdCargo());
            stmt.setString(2, cargo.getCargo());
            stmt.setInt(3, cargo.getHierarquia());

            stmt.execute();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            throw e;
        }
    }

    public static Cargo obter(int idCargo) throws Exception {
        try {
            Cargo cargo = new Cargo();
            Connection conn = SqlConnection.getConexao();
            String sql = "call obter_cargo(?)";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, idCargo);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                cargo = new Cargo(
                        rs.getInt("id_cargo"),
                        rs.getString("cargo"),
                        rs.getInt("hierarquia"));
            }
            stmt.close();
            conn.close();

            return cargo;
        } catch (Exception e) {
            throw e;
        }
    }

    public static ArrayList<Cargo> obter() throws Exception {
        try {
            ArrayList<Cargo> cargos = new ArrayList<Cargo>();
            Connection conn = SqlConnection.getConexao();
            String sql = "call obter_cargos()";
            PreparedStatement stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                cargos.add(new Cargo(
                        rs.getInt("id_cargo"),
                        rs.getString("cargo"),
                        rs.getInt("hierarquia")));
            }
            stmt.close();
            conn.close();

            return cargos;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static void deletar(int id) throws Exception{
        try{
            Connection conn = SqlConnection.getConexao();
            String sql = "call remover_cargo(?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            stmt.close();
            conn.close();
        }
        catch(Exception e){
            throw e;
        }
    }

}
