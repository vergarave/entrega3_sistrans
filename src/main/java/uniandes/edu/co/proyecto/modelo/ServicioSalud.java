package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "serviciosdesalud")
public class ServicioSalud {
    
    enum TipoServicio{
        consultaGeneral,
        consultaEspecialista,
        consultaControl,
        consultaUrgencia,
        examenDiagnostico,
        terapia
    }

    @Id
    private String nombre;
    private String descripcion;
    private TipoServicio tipoServicio;

    public ServicioSalud(String nombre, String descripcion, TipoServicio tipoServicio){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipoServicio = tipoServicio;
    }

    public ServicioSalud()
    {;}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public TipoServicio getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(TipoServicio tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    
}
