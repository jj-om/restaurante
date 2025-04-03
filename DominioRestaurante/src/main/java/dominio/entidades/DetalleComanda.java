package dominio.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Jesús Osuna 240549
 */

@Entity
@Table(name = "detalleComanda")
public class DetalleComanda implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column (name = "cantidad", nullable = false)
    private Integer cantidad;
    
    @Column (name = "notas", length = 200, nullable = false)
    private String notas;
    
    @Column (name = "precioUnitario", nullable = false)
    private Long precioUnitario;
    
    @Column (name = "importeTotal")
    private Long importeTotal;
    
    @ManyToOne 
    @JoinColumn(name = "id_producto", nullable = false)
    private Producto producto;
    
    @ManyToOne
    @JoinColumn(name = "id_comanda", nullable = true)
    private Comanda comanda;

    public DetalleComanda() {
        
    }

    public DetalleComanda(Integer cantidad, String notas, Long precioUnitario, Long importeTotal, Producto producto, Comanda comanda) {
        this.cantidad = cantidad;
        this.notas = notas;
        this.precioUnitario = precioUnitario;
        this.importeTotal = importeTotal;
        this.producto = producto;
        this.comanda = comanda;
    }

    public DetalleComanda(Long id, Integer cantidad, String notas, Long precioUnitario, Long importeTotal, Producto producto, Comanda comanda) {
        this.id = id;
        this.cantidad = cantidad;
        this.notas = notas;
        this.precioUnitario = precioUnitario;
        this.importeTotal = importeTotal;
        this.producto = producto;
        this.comanda = comanda;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public Long getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Long precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Long getImporteTotal() {
        return importeTotal;
    }

    public void setImporteTotal(Long importeTotal) {
        this.importeTotal = importeTotal;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Comanda getComanda() {
        return comanda;
    }

    public void setComanda(Comanda comanda) {
        this.comanda = comanda;
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
        if (!(object instanceof DetalleComanda)) {
            return false;
        }
        DetalleComanda other = (DetalleComanda) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DetalleComanda{" + "id=" + id + ", cantidad=" + cantidad + ", notas=" + notas + ", precioUnitario=" + precioUnitario + ", importeTotal=" + importeTotal + ", producto=" + producto + ", comanda=" + comanda + '}';
    }

}
