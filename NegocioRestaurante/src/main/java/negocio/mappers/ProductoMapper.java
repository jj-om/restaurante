/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio.mappers;

import dominio.DTOs.ProductoDTO;
import dominio.entidades.Producto;

/**
 *
 * @author Gael
 */
public class ProductoMapper {
    
    /**
     * Convierte un objeto de tipo Producto a ProductoDTO.
     * 
     * @param producto Objeto de tipo Producto que se desea convertir.
     * @return Objeto ProductoDTO con los mismos datos que la entidad.
     */
    public static ProductoDTO toDTO(Producto producto) {
        return new ProductoDTO(
                producto.getNombre(),
                producto.getPrecio(),
                producto.getTipoProducto()
        );
    }
    
    /**
     * Convierte un objeto de tipo ProductoDTO a Producto.
     * 
     * @param productoDTO Objeto de tipo ProductoDTO que se desea convertir.
     * @return Objeto Producto con los mismos datos que el DTO.
     */
    public static Producto toEntity(ProductoDTO productoDTO) {
        Producto producto = new Producto();
        producto.setNombre(productoDTO.getNombre());
        producto.setPrecio(productoDTO.getPrecio());
        producto.setTipoProducto(productoDTO.getTipoProducto());
        return producto;
    }
}


