package org.example.dao;

import com.mysql.cj.protocol.Resultset;
import org.example.configuracion.AdministradorConexion;
import org.example.entities.Auto;
import org.example.entities.Marca;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class AutoDAO {

  private static Connection conn;

  public void update(Auto auto){

    //Establecer la conexion

    //Solo si el auto existe lo modifico
    if (this.existById(auto.getIdAuto())){
      String sql = "UPDATE autos SET " +
          "patente = '" + auto.getPatente() + "', " +
          "color = '" + auto.getColor() + "', " +
          "anio = " + auto.getAnio() + ", " +
          "kilometraje = " + auto.getKilometraje() + ", " +
          "marca = '" + auto.getMarca() + "', " +
          "modelo = '" + auto.getModelo() + "' " +
          "WHERE idAuto = " + auto.getIdAuto();
      conn = AdministradorConexion.obtenerConexion();


      //Se crea el statement
      Statement st = null;

      try {
        //Ejecuto
        st = conn.createStatement();
        st.execute(sql);

        //Cierro.
        st.close();
        conn.close();

      } catch (SQLException e) {
        System.out.println("Error al crear el statement");
        throw new RuntimeException(e);
      }

    }
  }

  public boolean existById(int id){
    //establecer conexion
    conn = AdministradorConexion.obtenerConexion();
    String sql = "SELECT * FROM autos WHERE idAuto = " + id;
    //Creamos statemant
    Statement st = null;
    ResultSet rs = null;
    boolean existe = false;

      try {
        st = conn.createStatement();// CREO STATEMENT
        rs = st.executeQuery(sql); //EJECUTO CONSULTA

        //SI LA CONSULTA DEVUELVE AL MENOS UN REGISTRO, EXISTE
        if (rs.next()){
          existe = true;
        }

        //CIERRRO RESULSET Y STATEMENT
        rs.close();
        st.close();
        conn.close();

      } catch (SQLException e) {
        throw new RuntimeException(e);
      }

    return existe;
  }

  public void insertarAuto(Auto auto) {
    //1 establecer conexion a la base de datos
    conn = AdministradorConexion.obtenerConexion();
    //establecer conexcion a la base de datos

    //paso 2 crear String consulta SQL
    String sql = "INSERT INTO autos (idAuto,patente,color,anio,kilometraje,marca,modelo) " +
        "VALUES (" + auto.getIdAuto() + "," +
        "'" + auto.getPatente() + "'," +
        "'" + auto.getColor() + "'," +
        +auto.getAnio() + "," +
        +auto.getKilometraje() + "," +
        "'" + auto.getMarca() + "'," +
        "'" + auto.getModelo() + "')";

    //paso 3 crear instruccion
    Statement st = null;
    try {
      st = conn.createStatement();

      //paso 4 ejecutar instruccion
      st.execute(sql);

      //paso 5 cerrar conexion
      st.close();
      conn.close();

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }


  }

  public List<Auto> findAll() {

    //1 conectar
    conn = AdministradorConexion.obtenerConexion();

    //2 crear consulta SQL
    String sql = "SELECT * FROM autos order by patente";

    //3 crear statement y resultset
    Statement st = null;
    ResultSet rs = null;

    List<Auto> listaAutos = new java.util.ArrayList<>();
    try {
      //paso 3 crear instruccion
      st = conn.createStatement();
      //paso 4 ejecutar consulta y guarda el resultado en resultset
      rs = st.executeQuery(sql);


      //paso 5 recorrer el resultset y guardar los autos en una lista
      while (rs.next()) {
        Auto auto = new Auto();
        auto.setIdAuto(rs.getInt("idAuto"));
        auto.setAnio(rs.getInt("anio"));
        auto.setPatente(rs.getString("patente"));
        auto.setColor(rs.getString("color"));
        auto.setKilometraje(rs.getInt("kilometraje"));
        auto.setMarca(Marca.valueOf(rs.getString("marca")));
        auto.setModelo(rs.getString("modelo"));

        listaAutos.add(auto);
      }
      //paso 6 cerrar el resultset y statement
      rs.close();
      st.close();
      conn.close();


    } catch (SQLException e) {
      System.out.println("Error al crear el statement");
      throw new RuntimeException(e);
    }


    return listaAutos;
  }

  public void delete(int idAuto){
    conn = AdministradorConexion.obtenerConexion();
    String sql = " DELETE FROM autos Where idAuto = " + idAuto;
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

  public boolean getById(int id){
    //establecer conexion
    conn = AdministradorConexion.obtenerConexion();
    String sql = "SELECT * FROM autos WHERE idAuto = " + id;
    //Creamos statemant
    Statement st = null;
    ResultSet rs = null;

    try {
      st = conn.createStatement();// CREO STATEMENT
      rs = st.executeQuery(sql); //EJECUTO CONSULTA

      Auto auto = null;
      if (rs.next()){
        //Asigno los datos al auto
        auto.setIdAuto(rs.getInt("idAuto"));
        auto.setPatente(rs.getString("patente"));
        auto.setColor(rs.getString("color"));
        auto.setMarca(Marca.valueOf(rs.getString("idAuto")));
        auto.setAnio(rs.getInt("anio"));
        auto.setKilometraje(rs.getInt("kilometraje"));

      }

      //CIERRRO RESULSET Y STATEMENT
      rs.close();
      st.close();
      conn.close();

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }

    return existe;
  }




}
