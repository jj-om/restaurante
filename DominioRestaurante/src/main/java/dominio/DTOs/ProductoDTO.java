/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio.DTOs;

import dominio.entidades.IngredientesProductos;
import dominio.enums.TipoProducto;
import java.util.ArrayList;

/**
 *
 * @author Gael
 */
public class ProductoDTO {
    
    private String nombre;
    private Double precio;
    private TipoProducto tipoProducto;
    private ArrayList<IngredientesProductos> ingredientesProducto;

    public ProductoDTO() {
    }

    public ProductoDTO(String nombre, Double precio, TipoProducto tipoProducto, ArrayList<IngredientesProductos> ingredientesProducto) {
        this.nombre = nombre;
        this.precio = precio;
        this.tipoProducto = tipoProducto;
        this.ingredientesProducto = ingredientesProducto;
    }

    public ArrayList<IngredientesProductos> getIngredientesProducto() {
        return ingredientesProducto;
    }

    public void setIngredientesProducto(ArrayList<IngredientesProductos> ingredientesProducto) {
        this.ingredientesProducto = ingredientesProducto;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public TipoProducto getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(TipoProducto tipoProducto) {
        this.tipoProducto = tipoProducto;
    }
    
    
    
}
