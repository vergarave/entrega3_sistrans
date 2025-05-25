package uniandes.edu.co.proyecto.modelo;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "agendamientos")
public class Agendamiento {
    @Id
    private String id;
    private LocalDate fecha;
    private String hora; // puede ser tipo string "HH:mm"

    private String afiliado; // id del afiliado (tipoDocumento-numeroDocumento)
    private String medico;   // registro médico
    private String ips;
    private String servicio;
    private String orden; // puede ser null

    public Agendamiento(String id, LocalDate fecha, String hora, String afiliado, String medico, String ips, String servicio, String orden) {
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
        this.afiliado = afiliado;
        this.medico = medico;
        this.ips = ips;
        this.servicio = servicio;
        this.orden = orden;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
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

    public String getIps() {
        return ips;
    }

    public void setIps(String ips) {
        this.ips = ips;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public String getOrden() {
        return orden;
    }

    public void setOrden(String orden) {
        this.orden = orden;
    }
}

