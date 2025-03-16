package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;

@Embeddable
public class AfiliadoPK implements Serializable{
    
    //@ManyToOne
    //@JoinColumn(name= "tipoDoc", referencedColumnName = "tipoDoc")
    private String tipoDoc;

    //@ManyToOne
    //@JoinColumn(name = "numDoc", referencedColumnName = "numDoc")
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        AfiliadoPK that = (AfiliadoPK) obj;
        return Objects.equals(tipoDoc, that.tipoDoc) && Objects.equals(numDoc, that.numDoc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tipoDoc, numDoc);
    }

}
