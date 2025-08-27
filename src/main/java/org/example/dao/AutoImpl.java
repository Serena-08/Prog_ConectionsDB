package org.example.dao;

import org.example.entities.Auto;
import org.example.interfaces.AdmConexion;
import org.example.interfaces.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AutoImpl implements DAO<Auto,Integer>,AdmConexion{
  private Connection conn=null;

  @Override
  public List<Auto> getAll() {
    List<Auto> lista=new ArrayList<>();
    return lista;
  }

  @Override
  public void insert(Auto objeto) {
    //1 establecer conexion a la base de datos
    Auto auto = objeto;
    conn = obtenerConexion();
    //establecer conexion a la base de datos

    //paso 2 crear String consulta SQL
    String sql="INSERT INTO autos (idAuto,patente,color,anio,kilometraje,marca,modelo) " +
        "VALUES (" + auto.getIdAuto() + "," +
        "'" + auto.getPatente() + "'," +
        "'" + auto.getColor() + "'," +
        + auto.getAnio()+ "," +
        + auto.getKilometraje() + "," +
        "'" + auto.getMarca() + "'," +
        "'" + auto.getModelo() + "')" ;

    //paso 3 crear instruccion
    Statement st=null;
    try {
      st= conn.createStatement();

      //paso 4 ejecutar instruccion
      st.execute(sql);

      //paso 5 cerrar conexion
      st.close();
      conn.close();

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }



  }

  @Override
  public void update(Auto objeto) {

  }

  @Override
  public void delete(Integer id) {

  }

  @Override
  public Auto getById(Integer id) {

    return null;
  }

  @Override
  public boolean existsById(Integer id) {
    return false;
  }
}

