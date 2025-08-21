package org.example;

import org.example.configuracion.AdministradorConexion;
import org.example.dao.AutoDAO;
import org.example.entities.Auto;
import org.example.entities.Marca;

import java.sql.Connection;
import java.util.List;


public class App {
  public static void main(String[] args) {

    System.out.println("Hello World!");
    //Connection miConexion = AdministradorConexiones.obtenerConexion();

    Auto auto = new Auto("CCCCCC", "Blanco", 2025, 897,
        Marca.Honda, "Fit");

    //guardo en la BD
    AutoDAO autoDAO = new AutoDAO();
    autoDAO.insertarAuto(auto);

    //recorreo la lista de autos
    List<Auto> miLista = autoDAO.findAll();
    if (!miLista.isEmpty()) {
      for (Auto auto1 : miLista) {
        System.out.println(auto1.toString());
      }
    }

    Auto autoAModificar = new Auto("AABBCC", "Gis", 2024, 897555, Marca.Honda, "Fit");

    autoAModificar.setIdAuto(14);
    autoDAO.update(autoAModificar);

    autoDAO.update(autoAModificar);
    autoDAO.delete(13);



    //Recorro la lista de autos
    miLista = autoDAO.findAll();
    if (!miLista.isEmpty()) {
      for (Auto auto1 : miLista) {
        System.out.println(auto1.toString());
      }
    }



  }
}


