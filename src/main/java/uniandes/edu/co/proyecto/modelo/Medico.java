package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "medicos")
public class Medico {
    
    @Id
    private String registroMedico;
    private String tipoDoc;
    private Integer numDoc;
    private String nombre;
    private String especialidad;
    
    public Medico(String registroMedico, String tipoDoc, Integer numDoc, String nombre, String especialidad){
            this.registroMedico = registroMedico;
            this.tipoDoc = tipoDoc;
            this.numDoc = numDoc;
            this.nombre = nombre;
            this.especialidad = especialidad;
    }

    public Medico()
    {;}

    public String getRegistroMedico() {
        return registroMedico;
    }

    public void setRegistroMedico(String registroMedico) {
        this.registroMedico = registroMedico;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    

}
