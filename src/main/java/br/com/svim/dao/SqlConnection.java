
package br.com.svim.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SqlConnection {

    private static String user = "root";
    private static String senha = "";
    private static String database = "jdbc:mysql://localhost/autopostosvim";
    private static String driver = "com.mysql.jdbc.Driver";

    public static Connection getConexao() throws Exception {
        try {
            Class.forName(driver);
            return DriverManager.getConnection(database, user, senha);
        } catch (Exception e) {
            throw new Exception("Erro ao fazer conexao com banco de dados: " + e.getMessage());
        }
    }

}
