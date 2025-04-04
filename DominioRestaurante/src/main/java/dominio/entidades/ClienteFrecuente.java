package dominio.entidades;

import dominio.enums.TipoCliente;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @author Jesús Osuna 240549
 */

@Entity
@Table(name = "clientesFrecuentes")
public class ClienteFrecuente extends Cliente implements Serializable {

    @Transient
    private Long totalGastado;

    @Transient
    private Integer cantidadVisitas;

    @Transient
    private Integer puntos;

    public ClienteFrecuente() {
    }

    public ClienteFrecuente(String nombre, String apellidoPaterno, String apellidoMaterno, String telefono, String correoElectronico, TipoCliente tipo) {
        super(nombre, apellidoPaterno, apellidoMaterno, telefono, correoElectronico, tipo);
    }

    public ClienteFrecuente(Long id, String nombre, String apellidoPaterno, String apellidoMaterno, String telefono, String correoElectronico, TipoCliente tipo) {
        super(id, nombre, apellidoPaterno, apellidoMaterno, telefono, correoElectronico, tipo);
    }

    public Long getTotalGastado() {
        return totalGastado;
    }

    public Integer getCantidadVisitas() {
        return cantidadVisitas;
    }

    public Integer getPuntos() {
        return puntos;
    }

    @Override
    public String toString() {
        return "ClienteFrecuente{" + "totalGastado=" + totalGastado + ", cantidadVisitas=" + cantidadVisitas + ", puntos=" + puntos + '}';
    }
}
