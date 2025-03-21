package uniandes.edu.co.proyecto.modelo;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="contribuyente")
public class Contribuyente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer contribuyente_id;
    
    private String nombre;
    private String documento;
    
    @OneToMany(mappedBy = "contribuyente")
    private List<Afiliado> afiliados;

    public Contribuyente(String nombre, String documento, List<Afiliado> afiliados) {
        this.nombre = nombre;
        this.documento = documento;
        this.afiliados = afiliados;
    }

    public Integer getContribuyente_id() {
        return contribuyente_id;
    }

    public void setContribuyente_id(Integer contribuyente_id) {
        this.contribuyente_id = contribuyente_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public List<Afiliado> getAfiliados() {
        return afiliados;
    }

    public void setAfiliados(List<Afiliado> afiliados) {
        this.afiliados = afiliados;
    }
    public Contribuyente() {;}
}