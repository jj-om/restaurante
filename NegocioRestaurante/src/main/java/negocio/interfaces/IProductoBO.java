/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package negocio.interfaces;

import dominio.DTOs.ProductoDTO;
import dominio.entidades.Producto;
import java.util.List;
import negocio.exception.NegocioException;

/**
 *
 * @author Gael
 */
public interface IProductoBO {
    
    public ProductoDTO registrarProducto (ProductoDTO producto) throws NegocioException;
    public ProductoDTO actualizarProducto (ProductoDTO producto) throws NegocioException;
    public List<ProductoDTO> buscarProductosPorNombre(String nombre) throws NegocioException;
    public void deshabilitarProducto (String nombre) throws NegocioException;
    public Producto buscarPorNombre(String nombre) throws NegocioException;
    public void activarProducto (String nombre) throws NegocioException;
    
}
