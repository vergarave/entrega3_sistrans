package uniandes.edu.co.proyecto.modelo;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="medico")
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer medico_id;
    
    private String nombre;
    private String registroMedico;
    
    @ManyToOne
    @JoinColumn(name = "especialidad_id")
    private Especialidad especialidad;
    
    @OneToMany(mappedBy = "medico")
    private List<Cita> citas;
    
    @OneToMany(mappedBy = "medico")
    private List<Receta> recetas;

    @ManyToOne
    @JoinColumn(name = "ips_id")
    private Ips ips;

    public Medico(String nombre, String registroMedico, Especialidad especialidad, List<Cita> citas, List<Receta> recetas) {
        this.nombre = nombre;
        this.registroMedico = registroMedico;
        this.especialidad = especialidad;
        this.citas = citas;
        this.recetas = recetas;
    }

    public Integer getMedico_id() {
        return medico_id;
    }

    public void setMedico_id(Integer medico_id) {
        this.medico_id = medico_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRegistroMedico() {
        return registroMedico;
    }

    public void setRegistroMedico(String registroMedico) {
        this.registroMedico = registroMedico;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public List<Cita> getCitas() {
        return citas;
    }

    public void setCitas(List<Cita> citas) {
        this.citas = citas;
    }

    public List<Receta> getRecetas() {
        return recetas;
    }

    public void setRecetas(List<Receta> recetas) {
        this.recetas = recetas;
    }
    public Medico() {;}
}