package dominio.DTOs;

import dominio.enums.TipoCliente;

/**
 *
 * @author alexnieblas
 */
public class ClienteFrecuenteDTO extends ClienteDTO {
    private Long totalGastado;
    private Integer cantidadVisitas;
    private Integer puntos;

    public ClienteFrecuenteDTO(String nombre, String apellidoPaterno, String apellidoMaterno, String telefono, String correoElectronico, TipoCliente tipoCliente, Long totalGastado, Integer cantidadVisitas, Integer puntos) {
        super(nombre, apellidoPaterno, apellidoMaterno, telefono, correoElectronico, tipoCliente);
        this.totalGastado = totalGastado;
        this.cantidadVisitas = cantidadVisitas;
        this.puntos = puntos;
    }

    public Long getTotalGastado() {
        return totalGastado;
    }

    public void setTotalGastado(Long totalGastado) {
        this.totalGastado = totalGastado;
    }

    public Integer getCantidadVisitas() {
        return cantidadVisitas;
    }

    public void setCantidadVisitas(Integer cantidadVisitas) {
        this.cantidadVisitas = cantidadVisitas;
    }

    public Integer getPuntos() {
        return puntos;
    }

    public void setPuntos(Integer puntos) {
        this.puntos = puntos;
    }
}
