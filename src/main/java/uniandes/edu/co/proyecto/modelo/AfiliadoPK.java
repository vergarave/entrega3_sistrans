package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class AfiliadoPK implements Serializable{
    
    @ManyToOne
    @JoinColumn(name= "tipoDoc", referencedColumnName = "tipoDoc")
    private String tipoDoc;

    @ManyToOne
    @JoinColumn(name = "numDoc", referencedColumnName = "numDoc")
    private Integer numDoc;

    public AfiliadoPK(String tipoDoc, Integer numDoc) 
    {
        super();
        this.tipoDoc = tipoDoc;
        this.numDoc = numDoc;
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

}
