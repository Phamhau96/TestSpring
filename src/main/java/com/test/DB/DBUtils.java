/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author TAND.M
 */
public class DBUtils {

    private final static String connectionURL = "jdbc:mysql://localhost:3306/";
    private final static String dbName = "test";
    private final static String userName = "root";
    private final static String password = "";

    public static Connection getConnection() throws ClassNotFoundException {
        Connection connection = null;
        Class.forName("com.mysql.jdbc.Driver");
        try {
            connection = DriverManager.getConnection(connectionURL + dbName + "?useUnicode=true&characterEncoding=utf-8", userName, password);
        } catch (Exception e) {

        }
        return connection;
    }

}
