
package br.com.svim.dao;

import br.com.svim.model.Filial;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DaoFilial {

    public static void cadastrar(Filial filial) throws Exception {
        try {
            Connection conn = SqlConnection.getConexao();
            String sql = "call cadastrar_filial(?,?,?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, filial.getNomeFilial());
            stmt.setString(2, filial.getRua());
            stmt.setInt(3, filial.getNumero());
            stmt.setString(4, filial.getBairro());
            stmt.setString(5, filial.getCidade());
            stmt.setString(6, filial.getUf());
            stmt.setString(7, filial.getCep());

            stmt.execute();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            throw e;
        }
    }

    public static void alterar(Filial filial) throws Exception {
        try {
            Connection conn = SqlConnection.getConexao();
            String sql = "call alterar_filial(?,?,?,?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, filial.getIdFilial());
            stmt.setString(2, filial.getNomeFilial());
            stmt.setString(3, filial.getRua());
            stmt.setInt(4, filial.getNumero());
            stmt.setString(5, filial.getBairro());
            stmt.setString(6, filial.getCidade());
            stmt.setString(7, filial.getUf());
            stmt.setString(8, filial.getCep());

            stmt.execute();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            throw e;
        }
    }

    public static Filial obter(int idFilial) throws Exception {
        try {
            Filial filial = new Filial();
            Connection conn = SqlConnection.getConexao();
            String sql = "call obter_filial(?)";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, idFilial);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                filial = new Filial(
                        rs.getInt("id_filial"),
                        rs.getString("nome"),
                        rs.getString("logradouro"),
                        rs.getString("cep"),
                        rs.getInt("numero"),
                        rs.getString("bairro"),
                        rs.getString("cidade"),
                        rs.getString("uf"));
            }
            stmt.close();
            conn.close();

            return filial;
        } catch (Exception e) {
            throw e;
        }
    }
    
        public static ArrayList<Filial> obter() throws Exception {
        try {
            ArrayList<Filial> filiais = new ArrayList<Filial>();
            Connection conn = SqlConnection.getConexao();
            String sql = "call obter_filiais()";
            PreparedStatement stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                filiais.add(new Filial(
                        rs.getInt("id_filial"),
                        rs.getString("nome"),
                        rs.getString("logradouro"),
                        rs.getString("cep"),
                        rs.getInt("numero"),
                        rs.getString("bairro"),
                        rs.getString("cidade"),
                        rs.getString("uf")));
            }
            stmt.close();
            conn.close();

            return filiais;
        } catch (Exception e) {
            throw e;
        }
    }

}
