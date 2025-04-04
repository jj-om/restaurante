/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio.mappers;

import dominio.DTOs.ClienteDTO;
import dominio.entidades.Cliente;

/**
 *
 * @author alexnieblas
 */
public class ClienteMapper {
    /**
     * Convierte un objeto de tipo Cliente a ClienteDTO.
     * 
     * Este método toma una entidad Cliente y extrae sus atributos para 
     * crear un objeto de tipo DTO, que se utiliza en la capa de presentación o negocio.
     * 
     * @param cliente Objeto de tipo Cliente que se desea convertir.
     * @return Objeto ClienteDTO con los mismos datos que la entidad.
     */
    public static ClienteDTO toDTO(Cliente cliente) {
        return new ClienteDTO(
                cliente.getNombre(),
                cliente.getApellidoPaterno(),
                cliente.getApellidoMaterno(),
                cliente.getTelefono(),
                cliente.getCorreoElectronico(),
                cliente.getTipo()
        );
    }
    
    /**
     * Convierte un objeto de tipo ClienteDTO a Cliente.
     * 
     * Este método toma un DTO y lo transforma en una entidad Cliente, 
     * que puede ser utilizada en la capa de persistencia para almacenar 
     * los datos en la base de datos.
     * 
     * @param clienteDTO Objeto de tipo ClienteDTO que se desea convertir.
     * @return Objeto Cliente con los mismos datos que el DTO.
     */
    public static Cliente toEntity(ClienteDTO clienteDTO) {
        return new Cliente(
                clienteDTO.getNombre(),
                clienteDTO.getApellidoPaterno(),
                clienteDTO.getApellidoMaterno(),
                clienteDTO.getTelefono(),
                clienteDTO.getCorreoElectronico(),
                clienteDTO.getTipoCliente()
        );
    }
}
