package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class AfiliadosRelacionadosPK implements Serializable {

    @Column(name = "NUMERO_DOCUMENTO")
    private String numeroDocumento;

    @Column(name = "AFILIADO_RELACIONADO_NUM")
    private String afiliadoRelacionadoNum;

    public AfiliadosRelacionadosPK() {;}

    public AfiliadosRelacionadosPK(String numeroDocumento, String afiliadoRelacionadoNum) {
        this.numeroDocumento = numeroDocumento;
        this.afiliadoRelacionadoNum = afiliadoRelacionadoNum;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getAfiliadoRelacionadoNum() {
        return afiliadoRelacionadoNum;
    }

    public void setAfiliadoRelacionadoNum(String afiliadoRelacionadoNum) {
        this.afiliadoRelacionadoNum = afiliadoRelacionadoNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AfiliadosRelacionadosPK that = (AfiliadosRelacionadosPK) o;
        return Objects.equals(numeroDocumento, that.numeroDocumento) &&
               Objects.equals(afiliadoRelacionadoNum, that.afiliadoRelacionadoNum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeroDocumento, afiliadoRelacionadoNum);
    }

}

