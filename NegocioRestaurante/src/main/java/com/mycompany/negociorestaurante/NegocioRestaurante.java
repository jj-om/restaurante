/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.negociorestaurante;

import dominio.entidades.Producto;
import negocio.BO.ProductoBO;
import persistencia.DAOs.ProductoDAO;
import persistencia.interfaces.IProductoDAO;

/**
 *
 * @author Jesús Osuna 240549
 */
public class NegocioRestaurante {

    public static void main(String[] args) {
        //prueba de si funciona en capa negocio el desactivar un producto
        IProductoDAO productoDAO = ProductoDAO.getInstanceDAO();
        ProductoBO productoBO = new ProductoBO (productoDAO);
        String nombreP = "Sandwich";
        
        try {
            productoBO.activarProducto(nombreP);
            System.out.println("Deshabilitado con exito desde negocio :)");
        } catch (Exception e) {
        }
    }
}
