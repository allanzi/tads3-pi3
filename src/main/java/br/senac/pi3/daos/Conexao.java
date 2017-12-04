/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.pi3.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author allan
 */
public abstract class Conexao {

    public static String status = "Não conectou...";

    public static java.sql.Connection obterConexao() {

        Connection conexao = null;

        try {
            String driverName = "com.mysql.jdbc.Driver";

            Class.forName(driverName);

            String serverName = "35.194.5.64";

            String database = "pi3";

            String url = "jdbc:mysql://" + serverName + "/" + database;

            String username = "root";

            String password = "root";

            conexao = DriverManager.getConnection(url, username, password);

            if (conexao != null) {
                status = ("STATUS--->Conectado com sucesso!");

            } else {

                status = ("STATUS--->Não foi possivel realizar conexão");
            }

            return conexao;

        } catch (Exception e) {
            e.getStackTrace();
        }

        return null;
    }

    public static String obterStatus() {
        return status;
    }

    public static boolean FecharConexao() {

        try {
            Conexao.obterConexao().close();
            return true;

        } catch (SQLException e) {
            return false;
        }
    }

    public static java.sql.Connection ReiniciarConexao() {
 
        FecharConexao(); 
        return Conexao.obterConexao();
 
    }
}
