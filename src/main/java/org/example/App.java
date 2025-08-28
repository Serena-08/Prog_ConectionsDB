package org.example;

import org.example.configuracion.AdministradorConexion;
import org.example.dao.AutoDAO;
import org.example.dao.AutoImpl;
import org.example.entities.Auto;
import org.example.entities.Marca;

import java.sql.Connection;
import java.util.List;


public class App
{
  public static void main( String[] args )
  {

    System.out.println( "Hello World!" );
    //Connection miConexion = AdministradorConexiones.obtenerConexion();

    Auto auto= new Auto("CCCCCC","Blanco",2025,897,
        Marca.Honda,"Fit");

    //Guardo en la BD
    AutoDAO autoDAO = new AutoDAO();
    //autoDAO.insertarAuto(auto);


    //Recorro la lista de autos
    List<Auto> miLista = autoDAO.findAll();
    if(!miLista.isEmpty()) {
      for (Auto auto1 : miLista) {
        System.out.println(auto1.toString());
      }
    }

    //Modifica auto
    Auto autoAModificar= new Auto(12,"AABBCC","Gris",2024,897555,
        Marca.Honda,"Fit");


    autoDAO.update(autoAModificar);
    //autoDAO.delete(8);

    System.out.println("Auto encontrado: " + autoDAO.getById(12).toString());

    System.out.println("Lista de autos despues de la modificacion");
    //recorro la lista de autos
    miLista = autoDAO.findAll();
    if(!miLista.isEmpty()) {
      for (Auto auto1 : miLista) {
        System.out.println(auto1.toString());
      }
    }

    System.out.println("--------------  AGREGANDO CON DAO IMPL  ---------------");
    Auto autoTest = new Auto(12,"CCCCCC","Blanco",2025,0,
        Marca.Toyota,"Corolla");
    AutoImpl autoImpl = new AutoImpl();
    autoImpl.insert(autoTest);
  }
}