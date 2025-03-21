package uniandes.edu.co.proyecto.modelo;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="eps")
public class Eps {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer eps_id;
    
    private String nombre;
    private String direccion;
    private String telefono;
    
    @OneToMany(mappedBy = "eps")
    private List<Afiliado> afiliados;
    
    @OneToMany(mappedBy = "eps")
    private List<OrdenServicio> ordenServicios;


    public Eps(String nombre, String direccion, String telefono, List<Afiliado> afiliados,
            List<OrdenServicio> ordenServicios) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.afiliados = afiliados;
        this.ordenServicios = ordenServicios;
    }


    public Eps() {;}


    public Integer getEps_id() {
        return eps_id;
    }


    public void setEps_id(Integer eps_id) {
        this.eps_id = eps_id;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getDireccion() {
        return direccion;
    }


    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }


    public String getTelefono() {
        return telefono;
    }


    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }


    public List<Afiliado> getAfiliados() {
        return afiliados;
    }


    public void setAfiliados(List<Afiliado> afiliados) {
        this.afiliados = afiliados;
    }


    public List<OrdenServicio> getOrdenServicios() {
        return ordenServicios;
    }


    public void setOrdenServicios(List<OrdenServicio> ordenServicios) {
        this.ordenServicios = ordenServicios;
    }
    
}
