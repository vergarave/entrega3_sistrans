package uniandes.edu.co.proyecto.modelo;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="ips")
public class Ips {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer ips_id;
    
    private String nit;
    
    private String nombre;
    private String direccion;
    private String telefono;
    
    @OneToMany(mappedBy = "ips")
    private List<Medico> medicos;
    
    @OneToMany(mappedBy = "ips")
    private List<Cita> citas;
    
    @ManyToMany
    @JoinTable(
      name = "ips_servicio", 
      joinColumns = @JoinColumn(name = "ips_id"), 
      inverseJoinColumns = @JoinColumn(name = "servicio_id"))
    private List<Servicio> servicios;

    public Ips(String nit, String nombre, String direccion, String telefono, List<Medico> medicos, List<Cita> citas,
            List<Servicio> servicios) {
        this.nit = nit;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.medicos = medicos;
        this.citas = citas;
        this.servicios = servicios;
    }

    public Integer getIps_id() {
        return ips_id;
    }

    public void setIps_id(Integer ips_id) {
        this.ips_id = ips_id;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
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

    public List<Medico> getMedicos() {
        return medicos;
    }

    public void setMedicos(List<Medico> medicos) {
        this.medicos = medicos;
    }

    public List<Cita> getCitas() {
        return citas;
    }

    public void setCitas(List<Cita> citas) {
        this.citas = citas;
    }

    public List<Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(List<Servicio> servicios) {
        this.servicios = servicios;
    }

    public Ips() {;}    
}
