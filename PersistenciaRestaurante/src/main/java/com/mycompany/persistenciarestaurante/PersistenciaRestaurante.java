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
        
        //Producto p = new Producto("Sandwich", 204L, TipoProducto.platillo);
        //Cliente c = new Cliente("Alex Adrian", "Nieblas", "Moreno", "6442253326", "alex@gmail.com", TipoCliente.frecuente);
        
        //buscar producto
        String nombreProducto = "sand";
        try{
           
            List<Producto> productosEncontrados = ProductoDAO.getInstanceDAO().buscarPorNombreParcial(nombreProducto);
          //  Cliente cl = ClienteDAO.getInstanceDAO().guardar(c);
            if (productosEncontrados.isEmpty()) {
                System.out.println("No se encontraron coincidencias");
            }else{
                for (Producto producto : productosEncontrados) {
                    System.out.println("nombre:"+ producto.getNombre());
                    System.out.println("precio:" + producto.getPrecio());
                    System.out.println("tipo:"+ producto.getTipoProducto());
                }
            
            }
            
            //System.out.println(cl.toString());
            System.out.println(productosEncontrados.toString());
        }catch (PersistenciaException pe){
            pe.printStackTrace();
        }
    }
}
