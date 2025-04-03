/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.persistenciarestaurante;

import javax.persistence.EntityManager;
import persistencia.conexion.Conexion;

/**
 *
 * @author Jesús Osuna 240549
 */
public class PersistenciaRestaurante {

    public static void main(String[] args) {
        EntityManager em = Conexion.crearConexion();
        
        em.getTransaction().begin();
        em.getTransaction().commit();
    }
}
