/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia.DAOs;

import dominio.entidades.Producto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import persistencia.conexion.Conexion;
import persistencia.exception.PersistenciaException;
import persistencia.interfaces.IProductoDAO;

/**
 *
 * @author Gael
 */
public class ProductoDAO implements IProductoDAO{
    private static ProductoDAO instanceProductoDAO;

    private ProductoDAO() {
    }
        /**
    * Obtiene una única instancia de la clase ProductoDAO siguiendo el patrón Singleton.
    * 
    * Este método garantiza que solo exista una única instancia de ProductoDAO en toda la aplicación,
    * evitando la creación de múltiples instancias innecesarias.
    * 
    * @return La instancia única de ProductoDAO.
    */
    public static ProductoDAO getInstanceDAO() {
        if (instanceProductoDAO == null) {
            instanceProductoDAO = new ProductoDAO();
        }
        return instanceProductoDAO;
    }
    
    public Producto registrarProducto (Producto producto) throws PersistenciaException{
        EntityManager em = Conexion.crearConexion();
        try {
            em.getTransaction().begin();
            em.persist(producto);
            em.getTransaction().commit();
            if (producto.getId() == null) {
                throw new PersistenciaException("Error: No se generó un ID para el producto.");
            }
            return producto;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("No se pudo registrar el producto: " + e.getMessage());
        } finally {
            em.close();
        }
    }
    public Producto actualizarProducto (Producto producto) throws PersistenciaException{
        EntityManager em = Conexion.crearConexion();
        try {
            em.getTransaction().begin();
            em.merge(producto);
            em.getTransaction().commit();
            if (producto.getId() == null) {
                throw new PersistenciaException("Error: No se actualizo el producto correctamente.");
            }
            return producto;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("No se pudo registrar el producto: " + e.getMessage());
        } finally {
            em.close();
        }
    }
    public List<Producto> buscarPorNombreParcial(String nombre) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            em.getTransaction().begin();
        return em.createQuery(
                "SELECT p FROM Producto p WHERE LOWER(p.nombre) LIKE LOWER(:nombre)",
                Producto.class)
            .setParameter("nombre", "%" + nombre + "%")
            .getResultList();
         } catch (Exception e) {
             em.getTransaction().rollback();
            throw new PersistenciaException("No se busco el producto correctamente: " + e.getMessage(), e);
    }
}
    public Producto buscarPorNombre (String nombre) throws PersistenciaException{
        EntityManager em = Conexion.crearConexion();
        try {
              em.getTransaction().begin();
        Producto buscarProducto = em.createQuery(
                "SELECT p FROM Producto p WHERE LOWER(p.nombre) = LOWER(:nombre)",
                Producto.class)
            .setParameter("nombre",nombre)
            .getSingleResult();
            return buscarProducto;
        } catch (NoResultException e) {
            return null; // 
         } catch (Exception e) {
             em.getTransaction().rollback();
            throw new PersistenciaException("No se pudo buscar el producto correctamente: " + e.getMessage(), e);
    }
}
    public void deshabilitarProducto (String nombre) throws PersistenciaException{
        EntityManager em = Conexion.crearConexion();
        try {
            em.getTransaction().begin();
            Producto producto = buscarPorNombre(nombre);
            
            if (producto == null) {
                throw new PersistenciaException ("No se encontró el producto a desactivar");
            }
            producto.setActivo(false);
            em.merge(producto);
            em.getTransaction().commit();
            
        } catch (Exception e) {
         em.getTransaction().rollback();
        throw new PersistenciaException("Error al deshabilitar el producto: " + e.getMessage(), e);
    }
    }
    
    
}
