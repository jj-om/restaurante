/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencia.interfaces;

import dominio.entidades.Cliente;
import persistencia.exception.PersistenciaException;

/**
 *
 * @author alexnieblas
 */
public interface IClienteDAO {
    public Cliente guardar(Cliente c) throws PersistenciaException;
}
