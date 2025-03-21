package uniandes.edu.co.proyecto.modelo;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="especialidad")
public class Especialidad {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer especialidad_id;
    
    private String nombre;
    
    @OneToMany(mappedBy = "especialidad")
    private List<Medico> medicos;

    public Especialidad(String nombre, List<Medico> medicos) {
        this.nombre = nombre;
        this.medicos = medicos;
    }

    public Integer getEspecialidad_id() {
        return especialidad_id;
    }

    public void setEspecialidad_id(Integer especialidad_id) {
        this.especialidad_id = especialidad_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Medico> getMedicos() {
        return medicos;
    }

    public void setMedicos(List<Medico> medicos) {
        this.medicos = medicos;
    }
    public Especialidad(){;}

}