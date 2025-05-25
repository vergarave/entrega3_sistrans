package uniandes.edu.co.proyecto.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "medicos")
public class Medico {

    @Id
    private String registroMedico;

    private String tipoDocumento;
    private String numeroDocumento;
    private String nombre;

    private Especialidad especialidad; // objeto embebido

    private List<String> ips;        // lista de NITs
    private List<String> servicios;  // lista de códigos de servicio

    // Getters, setters, constructores

    public static class Especialidad {
        private String nombre;

        public Especialidad() {}

        public Especialidad(String nombre) {
            this.nombre = nombre;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }
    }

    public Medico() {}

    public Medico(String registroMedico, String tipoDocumento, String numeroDocumento, String nombre,
                  Especialidad especialidad, List<String> ips, List<String> servicios) {
        this.registroMedico = registroMedico;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.ips = ips;
        this.servicios = servicios;
    }

    public String getRegistroMedico() {
        return registroMedico;
    }

    public void setRegistroMedico(String registroMedico) {
        this.registroMedico = registroMedico;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public List<String> getIps() {
        return ips;
    }

    public void setIps(List<String> ips) {
        this.ips = ips;
    }

    public List<String> getServicios() {
        return servicios;
    }

    public void setServicios(List<String> servicios) {
        this.servicios = servicios;
    }
}


