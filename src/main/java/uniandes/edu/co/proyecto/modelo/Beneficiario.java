package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="beneficiario")
public class Beneficiario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer beneficiario_id;
    
    private String nombre;
    private String parentesco;
    
    @ManyToOne
    @JoinColumn(name = "contribuyente_id")
    private Contribuyente contribuyente;

    public Beneficiario(String nombre, String parentesco, Contribuyente contribuyente) {
        this.nombre = nombre;
        this.parentesco = parentesco;
        this.contribuyente = contribuyente;
    }

    public Integer getBeneficiario_id() {
        return beneficiario_id;
    }

    public void setBeneficiario_id(Integer beneficiario_id) {
        this.beneficiario_id = beneficiario_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
    public Beneficiario() {;}

}