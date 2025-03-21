package uniandes.edu.co.proyecto.modelo;

import java.sql.Date;
import java.util.List;

import org.hibernate.persister.entity.DiscriminatorType;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="afiliado")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Afiliado {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nombre;
    private String direccion;
    private String telefono;
    private Date fechaNacimiento;
    private String parentesco;
    
    @ManyToOne
    @JoinColumn(name = "contribuyente_id")
    private Contribuyente contribuyente;

    @ManyToOne
    @JoinColumn(name = "beneficiario_id")
    private Beneficiario beneficiario;

    @OneToMany(mappedBy = "afiliado")
    private List<Cita> citas;

    @OneToMany(mappedBy = "afiliado")
    private List<Receta> receta;

    @ManyToOne
    @JoinColumn(name = "eps_id")
    private Eps eps;


    public Afiliado(String nombre, String direccion, String telefono, Date fechaNacimiento, String parentesco,
            Contribuyente contribuyente, List<Cita> citas) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.parentesco = parentesco;
        this.contribuyente = contribuyente;
        this.citas = citas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    public Contribuyente getContribuyente() {
        return contribuyente;
    }

    public void setContribuyente(Contribuyente contribuyente) {
        this.contribuyente = contribuyente;
    }

    public List<Cita> getCitas() {
        return citas;
    }

    public void setCitas(List<Cita> citas) {
        this.citas = citas;
    }
    public Afiliado() {;} 
}