/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio.BO;

import dominio.DTOs.ClienteDTO;
import dominio.entidades.Cliente;
import negocio.exception.NegocioException;
import negocio.interfaces.IClienteBO;
import negocio.mappers.ClienteMapper;
import persistencia.exception.PersistenciaException;
import persistencia.interfaces.IClienteDAO;

/**
 *
 * @author alexnieblas
 */
public class ClienteBO implements IClienteBO {
    /**
     * Instancia del DAO que maneja la persistencia de videojuegos.
     */
    private IClienteDAO clienteDAO;
    
    /**
     * Constructor que recibe el DAO como dependencia. Se sigue el principio de
     * inversión de dependencias para facilitar la inyección de dependencias.
     *
     * @param clienteDAO DAO que se usará para acceder a la base de datos.
     */
    public ClienteBO(IClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }

    @Override
    public ClienteDTO registrarVideojuego(ClienteDTO cliente) throws NegocioException {
        if (cliente.getNombre() == null || cliente.getNombre().trim().isEmpty()) {
            throw new NegocioException("El nombre no puede estar vacío ni ser nulo.");
        }
    
        if (cliente.getApellidoPaterno() == null || cliente.getApellidoPaterno().trim().isEmpty()) {
            throw new IllegalArgumentException("El apellido paterno no puede estar vacío ni ser nulo.");
        }

        if (cliente.getTelefono() == null || !cliente.getTelefono().matches("\\d{10}")) { // Valida que sea numérico y tenga 10 dígitos
            throw new IllegalArgumentException("El teléfono debe contener exactamente 10 dígitos numéricos.");
        }

        if (cliente.getCorreoElectronico() != null && !cliente.getCorreoElectronico().trim().isEmpty() && !cliente.getCorreoElectronico().matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            throw new IllegalArgumentException("El correo electrónico no tiene un formato válido.");
        }

        if (cliente.getTipoCliente() == null) {
            throw new IllegalArgumentException("El tipo de cliente no puede ser nulo.");
        }
        
        Cliente clienteARegistrar = ClienteMapper.toEntity(cliente);
        try {
            Cliente clienteRegistrado = clienteDAO.guardar(clienteARegistrar);
            
            if (clienteRegistrado == null || clienteRegistrado.getId() == null) {
                throw new NegocioException("No se pudo registrar el cliente.");
            }
            return ClienteMapper.toDTO(clienteRegistrado);

        } catch (PersistenciaException ex) {
            throw new NegocioException("No se pudo registrar el cliente", ex);
        }

    }
}
