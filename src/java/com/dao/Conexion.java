package com.dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Conexion {

    public static Connection cnx = null;

    public static Connection conectar() throws Exception {

//        String user="";
//        String pwd = "";
//        String url = "";
//        String drive = "";
        InputStream inputStream = Conexion.class.getClassLoader().getResourceAsStream("properties/db.properties");
        Properties properties = new Properties();
        properties.load(inputStream);
        String user = properties.getProperty("user");
        String pwd = properties.getProperty("pwd");
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");
        try {
            Class.forName(driver);
            cnx = DriverManager.getConnection(url, user, pwd);
        } catch (Exception e) {
            System.out.println("Error de conexión: " + e.getMessage() + e.getStackTrace());
        }
        return cnx;
    }
    
    public void cerrarCnx() throws Exception{
        if(Conexion.cnx != null)
            cnx.close();            
    }
    
    public static void main(String[] args) throws SQLException, Exception {
        Conexion.conectar();
        if(Conexion.cnx != null)
            System.out.println("Conectado"); 
    }
    
}