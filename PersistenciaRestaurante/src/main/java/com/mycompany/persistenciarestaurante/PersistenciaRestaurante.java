/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.persistenciarestaurante;

import dominio.entidades.Cliente;
import dominio.entidades.Producto;
import dominio.enums.TipoCliente;
import dominio.enums.TipoProducto;
import java.util.List;
import javax.persistence.EntityManager;
import persistencia.DAOs.ClienteDAO;
import persistencia.DAOs.ProductoDAO;
import persistencia.conexion.Conexion;
import persistencia.exception.PersistenciaException;

/**
 *
 * @author Jesús Osuna 240549
 */
public class PersistenciaRestaurante {

    public static void main(String[] args) {
        
        

        
        
        //Registrar un cliente y un producto
        
        Producto p = new Producto("Sandwich", 200.00, TipoProducto.platillo);
        //Cliente c = new Cliente("Alex Adrian", "Nieblas", "Moreno", "6442253326", "alex@gmail.com", TipoCliente.frecuente);
        
        //buscar producto
        String nombreProducto = "Sandwich";
        try{
            //Producto productoRegistrar = ProductoDAO.getInstanceDAO().registrarProducto(p);
            
            ProductoDAO.getInstanceDAO().activarProducto(nombreProducto);
            System.out.println("Producto deshabilitado correctamente");
            //Cliente cl = ClienteDAO.getInstanceDAO().guardar(c);
            
          //  Cliente cl = ClienteDAO.getInstanceDAO().guardar(c);
            //System.out.println(cl.toString());
           // System.out.println(productoDesactivar.toString());
        }catch (PersistenciaException pe){
            pe.printStackTrace();
        }
    }
}
