package org.example.dao;

import org.example.configuracion.AdministradorConexion;
import org.example.entities.Auto;

import javax.xml.transform.Result;
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
    String sql = "INSERT INTO autos (idAuto,patente,color,anio,kilometraje,marca,modelo) " +
        "VALUES (" + auto.getIdAuto() + "," +
        "'" + auto.getPatente() + "'," +
        "'" + auto.getColor() + "'," +
        + auto.getAnio()+ "," +
        + auto.getKilometraje() + "," +
        "'" + auto.getMarca() + "'," +
        "'" + auto.getModelo() + "')" ;


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
    // 1 conectar
    conn = AdministradorConexion.obtenerConexion();

    // 2 crear consulta SQL
    String sql = "SELECT * FROM autos order by patente";

    // 3 crear statement y resulset
    Statement st = null;
    Result rs = null;

    try {
      // paso 3 creaR INSTRUCCION
      st = conn.createStatement();

      //PaSO 4 EJECUTAR CONSULTA Y GUARDAR EL RESUTADO EN EL RESULLTSET

      rs = st.executeQuery(sql);

      //paso 5 recorrer el resultset y guardar los autos en la lista
      while (rs.next()){
        Auto auto = new auto ();
        auto.setIdAuto(rs.getInt("Id"));
      }

    } catch (SQLException e) {
      System.out.println("Error al crear el statement");
      throw new RuntimeException(e);
    }


    return null;
  }


}
