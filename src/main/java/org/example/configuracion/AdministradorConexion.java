package org.example.configuracion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AdministradorConexion {

  public static Connection obtenerConexion(){
    //4 datos de conexion
    String dbDriver = "com.mysql.cj.jdbc.Driver";

    //Cadena de conexion a mi BD
    String dbCadenaConexion="jdbc:mysql://localhost:3306/progAutos";

    //nom usuarioBD
    String dbUsuario = "root";

    //Pass bd
    String dbPass ="1234";

    Connection conn = null;

    try {
      Class.forName(dbDriver);

      conn= DriverManager.getConnection(dbCadenaConexion,dbUsuario,dbPass);

    } catch (ClassNotFoundException e) {
      System.out.println("No se encontro el driver del la BD");
      throw new RuntimeException(e);
    } catch (SQLException e) {
      System.out.println("No se pudo conectar a la BD");
      throw new RuntimeException(e);
    }


    System.out.println("Conexión exitosa a la BD");
    return conn;
  }
}
