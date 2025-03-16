package uniandes.edu.co.proyecto.modelo;


import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "afiliadosrelaciones")
public class AfiliadoRelacion {
    
    public enum TipoAfiliado{
        contribuyente,
        beneficiario
    }

    /*@Id
    private String tipoDoc;
    @Id
    private Integer numDoc;*/
    @Id
    private Integer numDoc;
    private String tipoDoc;
    @Enumerated(EnumType.STRING)
    private TipoAfiliado tipoAfiliado;
    private String relacionParentesco;

    @ManyToOne
    @MapsId("pkAfiliadoRel")
    @JoinColumn(name = "pkAfiliadoRel", referencedColumnName = "numDoc")
    private Afiliado pkAfiliadoRel;


    public AfiliadoRelacion(String tipoDoc, Integer numDoc, TipoAfiliado tipoAfiliado, String relacionParentesco, 
                            Afiliado pkAfiliadoRel){
        //this.pk = new AfiliadoPK(tipoDoc, numDoc);
        this.tipoDoc = tipoDoc;
        this.numDoc = numDoc;
        this.tipoAfiliado = tipoAfiliado;
        this.relacionParentesco = relacionParentesco;
        this.pkAfiliadoRel = pkAfiliadoRel;
    }

    public AfiliadoRelacion()
    {;}

    /*public AfiliadoPK getPK() {
        return pk;
    }

    public void setPK(AfiliadoPK pk) {
        this.pk = pk;
    }*/
    

    public TipoAfiliado getTipoAfiliado() {
        return tipoAfiliado;
    }

    public Integer getNumDoc() {
        return numDoc;
    }

    public void setNumDoc(Integer numDoc) {
        this.numDoc = numDoc;
    }

    public String getTipoDoc() {
        return tipoDoc;
    }

    public void setTipoDoc(String tipoDoc) {
        this.tipoDoc = tipoDoc;
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

    public Afiliado getPkAfiliadoRel() {
        return pkAfiliadoRel;
    }

    public void setPkAfiliadoRel(Afiliado pkAfiliadoRel) {
        this.pkAfiliadoRel = pkAfiliadoRel;
    }
    
}
