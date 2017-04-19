/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.svim.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Cauê Ghetti
 */
public class SQL_Connection {

    private String user;
    private String senha;
    private String database;
    private String driver;

    SQL_Connection() {
        this.user = "root";
        this.senha = "";
        this.database = "autopostosvim";
        this.driver = "com.mysql.jdbc.Driver";
    }

    public Connection getConexao() throws SQLException, ClassNotFoundException {

        Connection conn = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + database,user,senha);

            return conn;

        } catch (ClassNotFoundException e) {
            throw new ClassNotFoundException(
                    "Driver MySql não foi encontrado " + e.getMessage());

        } catch (SQLException e) {
            throw new SQLException("Erro ao conectar "
                    + "com a base de dados" + e.getMessage());
        }
    }

}
