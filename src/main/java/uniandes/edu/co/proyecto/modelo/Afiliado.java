package uniandes.edu.co.proyecto.modelo;

import java.util.Date;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "afiliados")
public class Afiliado {

    /*@Id
    private String tipoDoc;
    @Id
    private Integer numDoc;*/

    //@EmbeddedId
    //private AfiliadoPK pk;

    private String tipoDoc;
    @Id
    private Integer numDoc;
    private String nombre;
    private Date fechaNac;
    private String ciudad;
    private String direccion;
    private Integer telefono;

    @ManyToOne
    @JoinColumn(name = "epsAsociada", referencedColumnName = "nit")
    private Eps epsAsociada;


    public Afiliado(String tipoDoc, Integer numDoc, String nombre, Date fechaNac, String ciudad, String direccion, 
                            Integer telefono, Eps epsAsociada){
        //this.pk = new AfiliadoPK(tipoDoc, numDoc);
        this.tipoDoc = tipoDoc;
        this.numDoc = numDoc;
        this.nombre = nombre;
        this.fechaNac = fechaNac;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.telefono = telefono;
        this.epsAsociada = epsAsociada;

    }

    public Afiliado()
    {;}

    /*public AfiliadoPK getPK() {
        return pk;
    }

    public void setPK(AfiliadoPK pk) {
        this.pk = pk;
    }*/
    
    public String getNombre() {
        return nombre;
    }

    public String getTipoDoc() {
        return tipoDoc;
    }

    public void setTipoDoc(String tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    public Integer getNumDoc() {
        return numDoc;
    }

    public void setNumDoc(Integer numDoc) {
        this.numDoc = numDoc;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public Eps getEpsAsociada() {
        return epsAsociada;
    }

    public void setEpsAsociada(Eps epsAsociada) {
        this.epsAsociada = epsAsociada;
    }

}
