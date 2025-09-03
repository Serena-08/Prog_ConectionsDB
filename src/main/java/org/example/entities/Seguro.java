package org.example.entities;

public class Seguro {
  private int idSeguro;
  private String tipo;
  private double costoMensual;
  private String compania;


  public Seguro() {
  }

  public Seguro(int idSeguro, String tipo, double costoMensual, String compania) {
    this.idSeguro = idSeguro;
    this.tipo = tipo;
    this.costoMensual = costoMensual;
    this.compania = compania;
  }

  //Getetter, Setter


  public int getIdSeguro() {
    return idSeguro;
  }

  public void setIdSeguro(int idSeguro) {
    this.idSeguro = idSeguro;
  }

  public String getTipo() {
    return tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  public double getCostoMensual() {
    return costoMensual;
  }

  public void setCostoMensual(double costoMensual) {
    this.costoMensual = costoMensual;
  }

  public String getCompania() {
    return compania;
  }

  public void setCompania(String compania) {
    this.compania = compania;
  }

  @Override
  public String toString() {
    return "Seguro{" +
        "idSeguro=' " + idSeguro +
        ", tipo=' " + tipo +
        ", costoMensual=' " + costoMensual +
        ", compania=' " + compania + '\'' +
        ']';
  }
}
