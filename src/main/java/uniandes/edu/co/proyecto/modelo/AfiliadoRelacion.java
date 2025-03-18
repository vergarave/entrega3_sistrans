package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "AFILIADOSRELACIONADOS")
public class AfiliadoRelacion {

    @EmbeddedId
    private AfiliadosRelacionadosPK pk;
    
    public enum TipoAfiliado{
        contribuyente,
        beneficiario
    }

    /*@Id
    private String tipoDoc;
    @Id
    private Integer numDoc;*/
    
    @Column(name = "TIPO")
    @Enumerated(EnumType.STRING)
    private TipoAfiliado tipo;

    @Column(name = "RELACION_PARENTESCO")
    private String relacionParentesco;

    @ManyToOne
    @MapsId("numeroDocumento")
    @JoinColumn(name = "NUMERO_DOCUMENTO", referencedColumnName = "NUMERO_DOCUMENTO")
    private Afiliado afiliadoPrincipal;

    @ManyToOne
    @MapsId("afiliadoRelacionadoNum")
    @JoinColumn(name = "AFILIADO_RELACIONADO_NUM", referencedColumnName = "NUMERO_DOCUMENTO")
    private Afiliado afiliadoRelacionado;


    public AfiliadoRelacion(Afiliado afiliadoPrincipal, Afiliado afiliadoRelacionado, TipoAfiliado tipo, String relacionParentesco){
        //this.pk = new AfiliadoPK(tipoDoc, numDoc);
        this.pk = new AfiliadosRelacionadosPK(afiliadoPrincipal.getNumDoc().toString(), afiliadoRelacionado.getNumDoc().toString());
        this.afiliadoPrincipal = afiliadoPrincipal;
        this.afiliadoRelacionado = afiliadoRelacionado;
        this.tipo = tipo;
        this.relacionParentesco = relacionParentesco;
    }

    public AfiliadoRelacion()
    {;}

    /*public AfiliadoPK getPK() {
        return pk;
    }

    public void setPK(AfiliadoPK pk) {
        this.pk = pk;
    }*/
    
    public AfiliadosRelacionadosPK getPk() {
        return pk;
    }

    public TipoAfiliado getTipoAfiliado() {
        return tipo;
    }

    public Integer getNumDoc() {
        return Integer.parseInt(pk.getNumeroDocumento());
    }

    public void setNumDoc(Integer numDoc) {
        pk.setNumeroDocumento(numDoc.toString());
    }


    public void setTipoAfiliado(TipoAfiliado tipo) {
        this.tipo = tipo;
    }

    public String getRelacionParentesco() {
        return relacionParentesco;
    }

    public void setRelacionParentesco(String relacionParentesco) {
        this.relacionParentesco = relacionParentesco;
    }

    public Afiliado getPkAfiliadoRel() {
        return afiliadoRelacionado;
    }

    public void setPkAfiliadoRel(Afiliado pkAfiliadoRel) {
        this.afiliadoRelacionado = pkAfiliadoRel;
    }
}
