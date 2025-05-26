package uniandes.edu.co.proyecto.modelo;

import java.time.LocalDate;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ordenes")
public class OrdenServicio {

    private String numero;
    private LocalDate fecha;
    private String estado; // vigente, cancelada, completada

    private String afiliado;  // id del afiliado (tipoDocumento-numeroDocumento)
    private String medico;     // registro médico
    private String servicio;   // código

    public OrdenServicio(String numero, LocalDate fecha, String estado, String afiliado, String medico, String servicio) {
        this.numero = numero;
        this.fecha = fecha;
        this.estado = estado;
        this.afiliado = afiliado;
        this.medico = medico;
        this.servicio = servicio;
    }

    public String getId() {
        return numero;
    }

    public void setId(String numero) {
        this.numero = numero;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getAfiliado() {
        return afiliado;
    }

    public void setAfiliado(String afiliado) {
        this.afiliado = afiliado;
    }

    public String getMedico() {
        return medico;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }
}

