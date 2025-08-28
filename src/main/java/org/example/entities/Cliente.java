package org.example.entities;

import org.example.interfaces.AdmConexion;

public class Cliente {
  public int getTelefono;
  private int idCliente;
  private String nombre;
  private String apellido;
  private int telefono;

  public Cliente(int idCliente, String nombre, String apellido, int telefono) {
    this.idCliente = idCliente;
    this.nombre = nombre;
    this.apellido = apellido;
    this.telefono = telefono;
  }

  public AdmConexion getIdCliente() {
    return idCliente;
  }

  public void setIdCliente(int idCliente) {
    this.idCliente = idCliente;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getApellido() {
    return apellido;
  }

  public void setApellido(String apellido) {
    this.apellido = apellido;
  }

  public int getTelefono() {
    return telefono;
  }

  public void setTelefono(int telefono) {
    this.telefono = telefono;
  }


  @Override
  public String toString() {
    return "Cliente [" +  idCliente +"  nombre=" + nombre + ", apellido=" + apellido + ", telefono=" + telefono;
  }
}
