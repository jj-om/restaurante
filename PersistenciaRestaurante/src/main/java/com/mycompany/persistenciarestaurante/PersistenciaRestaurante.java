/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.persistenciarestaurante;

import dominio.entidades.Cliente;
import dominio.enums.TipoCliente;
import javax.persistence.EntityManager;
import persistencia.DAOs.ClienteDAO;
import persistencia.conexion.Conexion;
import persistencia.exception.PersistenciaException;

/**
 *
 * @author Jesús Osuna 240549
 */
public class PersistenciaRestaurante {

    public static void main(String[] args) {
        EntityManager em = Conexion.crearConexion();
        
        em.getTransaction().begin();
        em.getTransaction().commit();
        
        //Registrar un cliente
        Cliente c = new Cliente("Alex Adrian", "Nieblas", "Moreno", "6442253326", "alex@gmail.com", TipoCliente.frecuente);
        try{
            Cliente cl = ClienteDAO.getInstanceDAO().guardar(c);
            System.out.println(cl.toString());
        }catch (PersistenciaException pe){
            pe.printStackTrace();
        }
    }
}
