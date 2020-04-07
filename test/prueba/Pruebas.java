package prueba;

import dao.Conexion;
import java.sql.Connection;


public class Pruebas {

    public static void main(String[] args) throws Exception {
        Conexion.conectar(); // actualizar mi variable "cnx"
        if (Conexion.cnx !=null){
            System.out.println("Eureka !!!");
        }else
            System.out.println("Error :(");
    }
    
}
