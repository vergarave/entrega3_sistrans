package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "puntos_de_atencion")
public abstract class PuntoDeAtencion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String tipo;
    private String localizacion;
    private Oficina oficina;
  

    public PuntoDeAtencion(String id,String tipo, String localizacion,Oficina oficina) {
        this.id = id;
        this.tipo = tipo;
        this.localizacion   = localizacion;
        this.oficina = oficina;
    }


    public PuntoDeAtencion()
        {;}


    public String getId() {
            return tipo;
        }
    
    public void setId(String tipo) {
            this.tipo = tipo;
        }
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getOficina() {
        return tipo;
    }

    public void setOficina(String tipo) {
        this.tipo = tipo;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }
}
        
    
    