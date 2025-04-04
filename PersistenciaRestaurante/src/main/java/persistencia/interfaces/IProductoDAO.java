/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencia.interfaces;

import dominio.entidades.Producto;
import persistencia.exception.PersistenciaException;

/**
 *
 * @author Gael
 */
public interface IProductoDAO {
   
    public Producto registrarProducto (Producto producto) throws PersistenciaException;
    public Producto actualizarProducto (Producto producto) throws PersistenciaException;
}
