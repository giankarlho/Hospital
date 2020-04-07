package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    public static Connection cnx = null;

    public static Connection conectar() throws Exception {
        String user = "sa";
        String pwd = "@gvs123@";
        String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String url = "jdbc:sqlserver://localhost;databaseName=BDHospital";
        try {
            Class.forName(driver).newInstance();
            cnx = DriverManager.getConnection(url, user, pwd);
        } catch (Exception e) {
            System.out.println("Hay un error de conexión");
        }
        return cnx;
    }
}
