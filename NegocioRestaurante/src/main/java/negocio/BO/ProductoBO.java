/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio.BO;

import com.google.protobuf.Message;
import dominio.DTOs.ProductoDTO;
import dominio.entidades.Producto;
import java.util.ArrayList;
import java.util.List;
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
     * Instancia del DAO que maneja la persistencia de producto.
     */
    private IProductoDAO ProductoDAO;

    public ProductoBO(IProductoDAO ProductoDAO) {
        this.ProductoDAO = ProductoDAO;
    }
    
    public ProductoDTO registrarProducto (ProductoDTO producto) throws NegocioException{
      
    
        if (producto.getNombre() == null || producto.getNombre().trim().isEmpty()) {
            throw new NegocioException("El nombre no puede estar vacío ni ser nulo.");
        }
        if (producto.getPrecio() <= 0) {
            throw new NegocioException("El precio debe ser mayor a 0.");
        }
        if (producto.getTipoProducto() == null) {
            throw new NegocioException("El tipo de producto no puede ser nulo.");
        }
        if (producto.getIngredientesProducto() == null) {
            throw new NegocioException ("No se puede registrar un producto sin ingredientes.");
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
    
    public ProductoDTO actualizarProducto (ProductoDTO producto) throws NegocioException{
    
    
        if (producto.getPrecio() == null || producto.getPrecio()<= 0 ){
            throw new NegocioException("El precio debe ser mayor a cero y no puede quedar vacio");
        }
        if (producto.getTipoProducto() == null) {
            throw new NegocioException("Debe seleccionar una categoría para el producto");
        }
        if (producto.getIngredientesProducto() == null) {
            throw new NegocioException ("No puedes actualizar productos sin ingredientes");
        }
        Producto productoActualizar = ProductoMapper.toEntity(producto);
        try {
            Producto productoR = ProductoDAO.actualizarProducto(productoActualizar);
            if (productoR.getId()== null) {
                    throw new NegocioException ("No existe un producto con este id");
                }
            return ProductoMapper.toDTO(productoR);
        } catch (Exception e) {
        }throw new NegocioException ("No se pudo actualizar el producto");
    }
    public List<ProductoDTO> buscarProductosPorNombre(String nombre) throws NegocioException {
        
        try {
            List<Producto> productos = ProductoDAO.buscarPorNombreParcial(nombre);
        
            List<ProductoDTO> productosDTO = new ArrayList<>();
                for (Producto producto : productos) {
            productosDTO.add(ProductoMapper.toDTO(producto));
            }
            return productosDTO;
            } catch (PersistenciaException e) {
                throw new NegocioException("Error al buscar productos por nombre", e);
         }
}
    public void deshabilitarProducto (String nombre) throws NegocioException{
        try {
            Producto producto = ProductoDAO.buscarPorNombre(nombre);
            if (producto == null) {
                throw new NegocioException("El producto con nombre: "+ nombre + "no existe.");
            }
            ProductoDAO.deshabilitarProducto(nombre);
            System.out.println("Producto deshabilitado correctamente: "+ nombre);
        }catch (PersistenciaException e) {
                throw new NegocioException("Error al deshabilitar producto", e);
         }

}
    public void activarProducto (String nombre) throws NegocioException{
        try {
            Producto producto = ProductoDAO.buscarPorNombre(nombre);
            if (producto==null) {
                throw new NegocioException ("El producto con nombre: " + nombre + "no existe.");
            }
            ProductoDAO.activarProducto(nombre);
            System.out.println("Producto habilitado correctamente: "+ nombre);
        } catch (Exception e) {
            throw new NegocioException("Error al habilitar producto", e);
        }
    
    
    }
}
