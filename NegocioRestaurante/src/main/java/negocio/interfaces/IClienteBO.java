/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package negocio.interfaces;

import dominio.DTOs.ClienteDTO;
import negocio.exception.NegocioException;

/**
 *
 * @author alexnieblas
 */
public interface IClienteBO {
        public ClienteDTO registrarCliente(ClienteDTO cliente) throws NegocioException;

}
