package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Embeddable;

@Embeddable
public class AfiliadoPK {
    

    private String tipoDoc;
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
