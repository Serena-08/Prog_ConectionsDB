package org.example.dao;

import org.example.configuracion.AdministradorConexion;
import org.example.entities.Auto;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class AutoDAO {

  private static Connection conn;

  public void insertarAuto(Auto auto){
    //1 Establecer la conexion a la base de datos
    conn = AdministradorConexion.obtenerConexion();

    //2 crear string consulta sql
    String sql = "INSERT INTO autos (idAuto,patente,color,anio,kilometraje,marca,modelo)" +
        "VALUES      ("+ auto.getIdAuto() + "," +
        "'" + auto.getPatente() + "',"+
        "'"   auto.getColor() +  "'," +
         +  auto.getAnio() +  "',"
        +  auto.getAnio() +  "',"


    //paso 3 crear instruccion

    Statement st= null;
    try {
      st = conn.createStatement();

      //paso 4 ejecutar instruccion
      st.execute(sql);

      //paso 5 cerrar conexion
      st.close();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public List<Auto>findAll(){
    return null;
  }


}
