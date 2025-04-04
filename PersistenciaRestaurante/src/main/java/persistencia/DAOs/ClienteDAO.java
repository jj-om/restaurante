/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia.DAOs;

import dominio.entidades.Cliente;
import javax.persistence.EntityManager;
import persistencia.conexion.Conexion;
import persistencia.exception.PersistenciaException;
import persistencia.interfaces.IClienteDAO;

/**
 *
 * @author alexnieblas
 */
public class ClienteDAO implements IClienteDAO {
    private static ClienteDAO instanceClaseDAO;

    private ClienteDAO() {
    }

    /**
    * Obtiene una única instancia de la clase ClienteDAO siguiendo el patrón Singleton.
    * 
    * Este método garantiza que solo exista una única instancia de ClienteDAO en toda la aplicación,
    * evitando la creación de múltiples instancias innecesarias.
    * 
    * @return La instancia única de ClienteDAO.
    */
    public static ClienteDAO getInstanceDAO() {
        if (instanceClaseDAO == null) {
            instanceClaseDAO = new ClienteDAO();
        }
        return instanceClaseDAO;
    }
    
    /**
    * Guarda un cliente en la base de datos.
    * 
    * Este método utiliza JPA para guardar un objeto Cliente en la base de datos.
    * Si el cliente se guarda correctamente, se retorna el objeto con su ID asignado.
    * Si ocurre un error durante la transacción, se revierte y se lanza una excepción.
    * 
    * @param c El objeto Cliente que se desea guardar.
    * @return El objeto Cliente guardado con su ID generado.
    * @throws PersistenciaException Si ocurre un error al intentar guardar el cliente.
    */
    public Cliente guardar(Cliente c)throws PersistenciaException{
        EntityManager em = Conexion.crearConexion();
        
        try{
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();
            if (c.getId() == null) {
                throw new PersistenciaException("Error: No se generó un ID para el cliente.");
            }
            return c;
        }catch(Exception ex){
            em.getTransaction().rollback();
            throw new PersistenciaException("No se pudo registrar al cliente");
        }
    }
}
