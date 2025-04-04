/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio.BO;

import dominio.DTOs.ProductoDTO;
import dominio.entidades.Producto;
import negocio.exception.NegocioException;
import negocio.mappers.ProductoMapper;
import persistencia.exception.PersistenciaException;
import persistencia.interfaces.IProductoDAO;

/**
 *
 * @author Gael
 */
public class ProductoBO {
    
       /**
     * Instancia del DAO que maneja la persistencia de videojuegos.
     */
    private IProductoDAO ProductoDAO;

    public ProductoBO(IProductoDAO ProductoDAO) {
        this.ProductoDAO = ProductoDAO;
    }
    
    public ProductoDTO registrarProducto (ProductoDTO producto) throws NegocioException{
      
    
        if (producto.getNombre() == null || producto.getNombre().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío ni ser nulo.");
        }
        if (producto.getPrecio() <= 0) {
            throw new IllegalArgumentException("El precio debe ser mayor a 0.");
        }
        if (producto.getTipoProducto() == null) {
            throw new IllegalArgumentException("El tipo de producto no puede ser nulo.");
        }
        Producto productoRegistrar = ProductoMapper.toEntity(producto);
        
        try {
           Producto productoR = ProductoDAO.registrarProducto(productoRegistrar);
            if (productoR == null || productoR.getId() == null) {
                throw new NegocioException("No se pudo registrar el cliente.");
            }
            return ProductoMapper.toDTO(productoR);

        } catch (PersistenciaException ex) {
            throw new NegocioException("No se pudo registrar el cliente", ex);
        }

    }
}
