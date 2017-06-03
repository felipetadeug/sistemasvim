/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.svim.dao;

import br.com.svim.model.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Iago
 */
public class DaoFuncionario {

    public static void cadastrar(Funcionario funcionario) throws Exception {
        try {
            Connection conn = SqlConnection.getConexao();
            String sql = "call cadastrar_funcionario(?,?,?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getCpf());
            stmt.setDate(3, funcionario.getDataNascimento());
            stmt.setDate(4, funcionario.getDataAdmissao());
            stmt.setInt(5, funcionario.getCargo().getIdCargo());
            stmt.setInt(6, funcionario.getFilial().getIdFilial());
            stmt.setString(7, funcionario.getSenha());

            stmt.execute();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            throw e;
        }
    }

    public static void alterar(Funcionario funcionario) throws Exception {
        try {
            Connection conn = SqlConnection.getConexao();
            String sql = "call alterar_funcionario(?,?,?,?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, funcionario.getIdFuncionario());
            stmt.setString(2, funcionario.getNome());
            stmt.setString(3, funcionario.getCpf());
            stmt.setDate(4, funcionario.getDataNascimento());
            stmt.setDate(5, funcionario.getDataAdmissao());
            stmt.setInt(6, funcionario.getCargo().getIdCargo());
            stmt.setInt(7, funcionario.getFilial().getIdFilial());
            stmt.setString(8, funcionario.getSenha());

            stmt.execute();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            throw e;
        }
    }

    public static Funcionario obter(int idFuncionario) throws Exception {
        try {
            Funcionario funcionario = new Funcionario();
            Connection conn = SqlConnection.getConexao();
            String sql = "call obter_funcionario(?)";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, idFuncionario);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                funcionario = new Funcionario(
                        rs.getInt("id_funcionario"),
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getDate("data_nascimento"),
                        rs.getDate("data_admissao"),
                        DaoCargo.obter(rs.getInt("id_cargo")),
                        DaoFilial.obter(rs.getInt("id_filial")),
                        rs.getString("senha"));
            }
            stmt.close();
            conn.close();

            return funcionario;
        } catch (Exception e) {
            throw e;
        }
    }

    public static ArrayList<Funcionario> obter() throws Exception {
        try {
            ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
            Connection conn = SqlConnection.getConexao();
            String sql = "call obter_funcionarios()";
            PreparedStatement stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                funcionarios.add(new Funcionario(
                        rs.getInt("id_funcionario"),
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getDate("data_nascimento"),
                        rs.getDate("data_admissao"),
                        DaoCargo.obter(rs.getInt("id_cargo")),
                        DaoFilial.obter(rs.getInt("id_filial")),
                        rs.getString("senha")));
            }
            stmt.close();
            conn.close();

            return funcionarios;
        } catch (Exception e) {
            throw e;
        }
    }

    public static Funcionario obter(String cpf, String senha) throws Exception {
        try {
            Funcionario funcionario = new Funcionario();
            Connection conn = SqlConnection.getConexao();
            String sql = "call obter_funcionario_bylogin(?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, cpf);
            stmt.setString(2, senha);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                funcionario = new Funcionario(
                        rs.getInt("id_funcionario"),
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getDate("data_nascimento"),
                        rs.getDate("data_admissao"),
                        DaoCargo.obter(rs.getInt("id_cargo")),
                        DaoFilial.obter(rs.getInt("id_filial")),
                        rs.getString("senha"));
            }
            stmt.close();
            conn.close();

            return funcionario;
        } catch (Exception e) {
            throw e;
        }
    }

    public static void deletar(int id) throws Exception {
        try {
            Connection conn = SqlConnection.getConexao();
            String sql = "call remover_funcionario(?)";
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
