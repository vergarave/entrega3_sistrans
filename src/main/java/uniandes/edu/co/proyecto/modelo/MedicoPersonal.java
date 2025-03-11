package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "medicospersonal")
public class MedicoPersonal {
    @Id
    private String registroMedico;
    private String tipoDoc;
    private Integer numDoc;
    private String nombre;

    public MedicoPersonal(String registroMedico, String tipoDoc, Integer numDoc, String nombre){
        this.registroMedico = registroMedico;
        this.tipoDoc = tipoDoc;
        this.numDoc = numDoc;
        this.nombre = nombre;

    }

    public MedicoPersonal()
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

    

}
