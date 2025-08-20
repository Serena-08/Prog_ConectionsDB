package org.example;

import org.example.configuracion.AdministradorConexion;
import org.example.dao.AutoDAO;
import org.example.entities.Auto;
import org.example.entities.Marca;

import java.sql.Connection;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }

    Auto auto =
        new Auto("CCCCCC", "Blanco", 2025, 897, Marca.Honda, "Fit");

    //Guardo en la BD
    AutoDAO autoDAO = new AutoDAO();
    autoDAO.insertarAuto(auto);
    autoDAO.insertar





    Connection miConexion = AdministradorConexion.obtenerConexion();
}
