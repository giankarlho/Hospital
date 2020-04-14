package prueba;

import dao.Conexion;

public class Pruebas {

    public static void main(String[] args) throws Exception {
        Conexion.conectar(); // actualizar mi variable "cnx"
        if (Conexion.cnx !=null){
            System.out.println("Eureka !!!");
        }else
            System.out.println("Error :(");
    }
    
}
