package org.example.dao;

import org.example.configuracion.AdministradorConexion;
import org.example.entities.Auto;
import org.example.entities.Marca;
import org.example.interfaces.AdmConexion;
import org.example.interfaces.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
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
    Auto auto = objeto;
    if (this.existsById(auto.getIdAuto())){

      String sql = "UPDATE autos SET " +
          "patente = '" + auto.getPatente() + "', " +
          "color = '" + auto.getColor() + "', " +
          "anio = " + auto.getAnio() + ", " +
          "kilometraje = " + auto.getKilometraje() + ", " +
          "marca = '" + auto.getMarca() + "', " +
          "modelo = '" + auto.getModelo() + "' " +
          "WHERE idAuto = " + auto.getIdAuto();
      conn = AdministradorConexion.obtenerConexion();


      //Creao un statementn
      Statement st = null;

      try {
        st = conn.createStatement();
        st.execute(sql);
        st.close();
        conn.close();
      } catch (SQLException e) {
        System.out.println("Error al crear el statement");
        throw new RuntimeException(e);
      }
    }

  }

  @Override
  public void delete(Integer idauto) {
    conn = AdministradorConexion.obtenerConexion();

    String sql = "DELETE FROM autos WHERE idAuto = " + idauto;
    Statement st = null;

    try {
      st = conn.createStatement();
      st.execute(sql);
      st.close();
      conn.close();

    } catch (SQLException e) {
      System.out.println("Error al crear el statement");
      throw new RuntimeException(e);
    }

  }

  @Override
  public Auto getById(Integer id) {
    conn = AdministradorConexion.obtenerConexion();

    String sql= "SELECT * FROM autos WHERE idAuto = " + id;

    Statement st = null;
    ResultSet rs = null;
    Auto auto = new Auto();

    try {
      st = conn.createStatement(); //CREO STATEMENT
      rs = st.executeQuery(sql);  //EJECUTO CONSULTA
      //SI LA CONSULTA DEVUELVE AL MENOS UN REGISTRO, EXISTE

      if (rs.next()){
        //Asigno datos al auto
        auto.setIdAuto(rs.getInt("idAuto"));
        auto.setPatente((rs.getString("patente")));
        auto.setColor(rs.getString("color"));
        auto.setMarca(Marca.valueOf(rs.getString("marca")));
        auto.setAnio(rs.getInt("anio"));
        auto.setKilometraje(rs.getInt("kilometraje"));
        auto.setModelo(rs.getString("modelo"));

      }

      rs.close();
      st.close();
      conn.close();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return auto;
  }

  @Override
  public boolean existsById(Integer id) {
    conn = AdministradorConexion.obtenerConexion();

    String sql= "SELECT * FROM autos WHERE idAuto = " + id;

    Statement st = null;
    ResultSet rs = null;
    boolean existe = false;
    try {
      st = conn.createStatement(); //CREO STATEMENT
      rs = st.executeQuery(sql);  //EJECUTO CONSULTA
      //SI LA CONSULTA DEVUELVE AL MENOS UN REGISTRO, EXISTE

      if (rs.next()){
        existe=true;
      }

      rs.close();
      st.close();
      conn.close();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return existe;
  }
}

