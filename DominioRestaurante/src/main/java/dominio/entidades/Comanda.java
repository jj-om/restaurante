package dominio.entidades;

import dominio.enums.EstadoComanda;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Jesús Osuna 240549
 */

@Entity
@Table(name = "comandas")
public class Comanda implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column (name = "folio", length = 15, unique = true)
    private String folio;
    
    @Column (name = "fechaHora")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHora;
    
    @Column (name = "estado", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private EstadoComanda estado;
    
    @Column (name = "totalVenta")
    private Long totalVenta;
    
    @ManyToOne
    @JoinColumn(name = "id_mesa", nullable = true)
    private Mesa mesa;
    
    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = true)
    private Cliente cliente;
    
    @OneToMany(mappedBy = "comanda", cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
    private List<DetalleComanda> detallesComanda = new ArrayList<>();

    public Comanda() {
        
    }

    public Comanda(String folio, Date fechaHora, EstadoComanda estado, Mesa mesa, Cliente cliente, Long totalVenta) {
        this.folio = folio;
        this.fechaHora = fechaHora;
        this.estado = estado;
        this.mesa = mesa;
        this.cliente = cliente;
        this.totalVenta = totalVenta;
    }

    public Comanda(Long id, String folio, Date fechaHora, EstadoComanda estado, Mesa mesa, Cliente cliente, Long totalVenta) {
        this.id = id;
        this.folio = folio;
        this.fechaHora = fechaHora;
        this.estado = estado;
        this.mesa = mesa;
        this.cliente = cliente;
        this.totalVenta = totalVenta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public EstadoComanda getEstado() {
        return estado;
    }

    public void setEstado(EstadoComanda estado) {
        this.estado = estado;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Long getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(Long totalVenta) {
        this.totalVenta = totalVenta;
    }

    public List<DetalleComanda> getDetallesComanda() {
        return detallesComanda;
    }

    public void setDetallesComandas(List<DetalleComanda> detallesComanda) {
        this.detallesComanda = detallesComanda;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comanda)) {
            return false;
        }
        Comanda other = (Comanda) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Comanda{" + "id=" + id + ", folio=" + folio + ", fechaHora=" + fechaHora + ", estado=" + estado + ", totalVenta=" + totalVenta + ", mesa=" + mesa + ", cliente=" + cliente + ", detallesComanda=" + detallesComanda + '}';
    }

}
