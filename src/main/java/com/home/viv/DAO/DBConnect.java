package com.home.viv.DAO;

import com.home.viv.Main;

import java.sql.*;
import java.util.Locale;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by viv on 14.06.2017.
 */
public class DBConnect {

    public Statement openDb(String url, String name, String password) {

        Connection connection = null;
        Locale.setDefault(Locale.ENGLISH);

        try {
            //load driver
            Class.forName("oracle.jdbc.driver.OracleDriver");
            //create connect
            connection = DriverManager.getConnection(url, name, password);
            Statement statement = null;
            statement = connection.createStatement();

            return statement;

        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }

    }

    public boolean closeDb(Statement st){

        try{
            st.close();
            return true;

        } catch (SQLException ex) {
            //выводим наиболее значимые сообщения
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }







}
