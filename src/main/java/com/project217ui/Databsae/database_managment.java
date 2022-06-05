package com.project217ui.Databsae;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class database_managment {
    private final String user="root";
    private final String pass="";
    private final String url="jdbc:mysql://localhost/vet_system";



    public Connection conn() throws SQLException {
       Connection c = (Connection) DriverManager.getConnection(url,user,pass);
       return c;
    }
}