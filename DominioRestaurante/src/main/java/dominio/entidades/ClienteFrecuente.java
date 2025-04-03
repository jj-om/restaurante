package dominio.entidades;

import dominio.enums.TipoCliente;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @author Jesús Osuna 240549
 */

@Entity
public class ClienteFrecuente extends Cliente implements Serializable {

    @Column (name = "totalGastado")
    private Long totalGastado;
    
    @Column (name = "cantidadVisitas")
    private Integer cantidadVisitas;
    
    @Column (name = "puntos")
    private Integer puntos;

    public ClienteFrecuente() {
        
    }

    public ClienteFrecuente(Long totalGastado, Integer cantidadVisitas, Integer puntos, String nombre, String apellidoPaterno, String apellidoMaterno, String telefono, String correoElectronico, TipoCliente tipo) {
        super(nombre, apellidoPaterno, apellidoMaterno, telefono, correoElectronico, tipo);
        this.totalGastado = totalGastado;
        this.cantidadVisitas = cantidadVisitas;
        this.puntos = puntos;
    }

    public ClienteFrecuente(Long totalGastado, Integer cantidadVisitas, Integer puntos, Long id, String nombre, String apellidoPaterno, String apellidoMaterno, String telefono, String correoElectronico, TipoCliente tipo) {
        super(id, nombre, apellidoPaterno, apellidoMaterno, telefono, correoElectronico, tipo);
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

    @Override
    public String toString() {
        return "ClienteFrecuente{" + "totalGastado=" + totalGastado + ", cantidadVisitas=" + cantidadVisitas + ", puntos=" + puntos + '}';
    }
    
}
