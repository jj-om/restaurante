package dominio.entidades;

import dominio.enums.UnidadMedicion;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Jesús Osuna 240549
 */

@Entity
@Table(name = "ingredientes")
public class Ingrediente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "nombre", length = 50, nullable = false)
    private String nombre;
    
    @Column (name = "unidadMedicion", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private UnidadMedicion unidadMedicion;
    
    @Column (name = "stock")
    private Integer stock;

    public Ingrediente() {
        this.stock = 0;
    }

    public Ingrediente(String nombre, UnidadMedicion unidadMedicion, Integer stock) {
        this.nombre = nombre;
        this.unidadMedicion = unidadMedicion;
        this.stock = stock;
    }

    public Ingrediente(Long id, String nombre, UnidadMedicion unidadMedicion, Integer stock) {
        this.id = id;
        this.nombre = nombre;
        this.unidadMedicion = unidadMedicion;
        this.stock = stock;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public UnidadMedicion getUnidadMedicion() {
        return unidadMedicion;
    }

    public void setUnidadMedicion(UnidadMedicion unidadMedicion) {
        this.unidadMedicion = unidadMedicion;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
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
        if (!(object instanceof Ingrediente)) {
            return false;
        }
        Ingrediente other = (Ingrediente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Ingrediente{" + "id=" + id + ", nombre=" + nombre + ", unidadMedicion=" + unidadMedicion + ", stock=" + stock + '}';
    }
    
}
