

package dominio.entidades;

import dominio.enums.TipoCliente;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

/**
 * @author Jesús Osuna 240549
 */

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "nombre", nullable = false, length = 40)
    private String nombre;
    
    @Column(name = "apellidoPaterno", nullable = false, length = 20)
    private String apellidoPaterno;
    
    @Column(name = "apellidoMaterno", nullable = true, length = 20)
    private String apellidoMaterno;
    
    @Column(name = "telefono", nullable = false, length = 15, unique = true)
    private String telefono;
    
    @Column (name = "correoElectronico", nullable = true, length = 80)
    private String correoElectronico;
    
    @Column (name = "tipoCliente", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private TipoCliente tipo;
    
    @OneToMany(mappedBy = "cliente", cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
    private List<Comanda> comandas = new ArrayList<>();

    public Cliente() {
        
    }

    public Cliente(String nombre, String apellidoPaterno, String apellidoMaterno, String telefono, String correoElectronico, TipoCliente tipo) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
        this.tipo = tipo;
    }

    public Cliente(Long id, String nombre, String apellidoPaterno, String apellidoMaterno, String telefono, String correoElectronico, TipoCliente tipo) {
        this.id = id;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
        this.tipo = tipo;
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

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public TipoCliente getTipo() {
        return tipo;
    }

    public void setTipo(TipoCliente tipo) {
        this.tipo = tipo;
    }

    public List<Comanda> getComandas() {
        return comandas;
    }

    public void setComandas(List<Comanda> comandas) {
        this.comandas = comandas;
    }

    

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nombre=" + nombre + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno + ", telefono=" + telefono + ", correoElectronico=" + correoElectronico + ", tipo=" + tipo + ", comandas=" + comandas + '}';
    }

}
