package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "afiliadosrelaciones")
public class AfiliadoRelacion {
    
    enum TipoAfiliado{
        contribuyente,
        beneficiario
    }

    @Id
    private String tipoDoc;
    @Id
    private Integer numDoc;
    private TipoAfiliado tipoAfiliado;
    private String relacionParentesco;

    @ManyToOne
    @JoinColumn(name = "tipoDocRelacionado", referencedColumnName = "tipoDoc")
    private Afiliado tipoDocRelacionado;

    @ManyToOne
    @JoinColumn(name = "tipoNumRelacionado", referencedColumnName = "numDoc")
    private Afiliado numDocRelacionado;

    public AfiliadoRelacion(String tipoDoc, Integer numDoc, TipoAfiliado tipoAfiliado, String relacionParentesco, 
                            Afiliado tipoDocRelacionado, Afiliado numDocRelacionado){
        this.tipoDoc = tipoDoc;
        this.numDoc = numDoc;
        this.tipoAfiliado = tipoAfiliado;
        this.relacionParentesco = relacionParentesco;
        this.tipoDocRelacionado = tipoDocRelacionado;
        this.numDocRelacionado = numDocRelacionado;
    }

    public AfiliadoRelacion()
    {;}

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

    public TipoAfiliado getTipoAfiliado() {
        return tipoAfiliado;
    }

    public void setTipoAfiliado(TipoAfiliado tipoAfiliado) {
        this.tipoAfiliado = tipoAfiliado;
    }

    public String getRelacionParentesco() {
        return relacionParentesco;
    }

    public void setRelacionParentesco(String relacionParentesco) {
        this.relacionParentesco = relacionParentesco;
    }

    public Afiliado getTipoDocRelacionado() {
        return tipoDocRelacionado;
    }

    public void setTipoDocRelacionado(Afiliado tipoDocRelacionado) {
        this.tipoDocRelacionado = tipoDocRelacionado;
    }

    public Afiliado getNumDocRelacionado() {
        return numDocRelacionado;
    }

    public void setNumDocRelacionado(Afiliado numDocRelacionado) {
        this.numDocRelacionado = numDocRelacionado;
    }

    

}
