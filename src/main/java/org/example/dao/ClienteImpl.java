package org.example.dao;

import org.example.configuracion.AdministradorConexion;
import org.example.entities.Cliente;
import org.example.interfaces.AdmConexion;
import org.example.interfaces.DAO;

import java.sql.*;
import java.util.List;

public class ClienteImpl implements DAO<Cliente, AdmConexion> {
  private Connection conn = null;

  private static final String SQL_INSERT =
      "INSERT INTO cliente (idCliente, nombre, apellido, telefono" +
          "VALUES (?   , ?   , ?   , ?)";

  private static final String SQL_UPDATE =
      "UPDATE cleinte SET " +
          "idCliente = ?" +
          "nombre = ? " +
          "apellido = ?" +
          "telefono = ?";

  private static final String SQL_DELETE = "DELETE FROM cliente WHERE idCliente = ?";
  private static final String SQL_GETALL = "SELECT * FROM cliente ORDER BY apellido";
  private static final String SQL_GETBYID = "SELECT * FROM cleinte WHERE idCliente = ?";


  @Override
  public List<Cliente> getAll() {
    return Cliente;
  }

  @Override
  public void insert(Cliente objeto) {
    Cliente cliente = objeto;
    Connection obtenerConexion;
    conn = obtenerConexion;
    PreparedStatement pst = null;

    try {
      pst = conn.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
      pst.setInt(1, cliente.getIdCliente());
      pst.setString(2, cliente.getNombre());
      pst.setString(3, cliente.getApellido());
      pst.setInt(4, cliente.getTelefono);

      //4 Ejecutar instruccion
      int resultado = pst.executeUpdate();
      if (resultado == 1){
        System.out.println("Cliente insertado correctamente");
      } else {
        System.out.println("No se pudo insertar el cliente");
      }

      ResultSet rs = pst.getGeneratedKeys();
      if (rs.next()){
        cliente.setIdCliente(rs.getInt(1));
        System.out.println("El id asignado es: " + Cliente.getIdCliente);
      }

      //5 cerrar cinexion.

      pst.close();
      conn.close();


    } catch (SQLException e) {
      throw new RuntimeException(e);
    }

  }

  @Override
  public void update(Cliente objeto) {
    Cliente cliente = objeto;


    if (this.existsById(cliente.getIdCliente())){
      String sql = "UPDATE cliente SET" +
          "nombre = '"+ cliente.getNombre() + "',";
          "apellido = '"+ cliente.getApellido() + "',";

    }

  }

  @Override
  public void delete(AdmConexion id) {

  }

  @Override
  public void getById(AdmConexion id) {

  }

  @Override
  public boolean existsById(AdmConexion id) {
    return false;
  }
}

