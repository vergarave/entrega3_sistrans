package uniandes.edu.co.proyecto.modelo;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "afiliados")
public class Afiliado {

    @Id
    private String id; // tipoDocumento-numeroDocumento, ej: "CC-123456789"

    private String tipoDocumento;
    private String numeroDocumento;
    private String nombre;
    private LocalDate fechaNacimiento;
    private String direccion;
    private String telefono;
    private String tipoAfiliado; // "contribuyente" o "beneficiario"
    private String parentesco;   // solo si es beneficiario
    private String idContribuyente; // id del afiliado contribuyente ("CC-99999999")

    public Afiliado(String id, String tipoDocumento, String numeroDocumento, String nombre, LocalDate fechaNacimiento,
                    String direccion, String telefono, String tipoAfiliado, String parentesco, String idContribuyente) {
        this.id = id;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.telefono = telefono;
        this.tipoAfiliado = tipoAfiliado;
        this.parentesco = parentesco;
        this.idContribuyente = idContribuyente;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTipoAfiliado() {
        return tipoAfiliado;
    }

    public void setTipoAfiliado(String tipoAfiliado) {
        this.tipoAfiliado = tipoAfiliado;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    public String getIdContribuyente() {
        return idContribuyente;
    }

    public void setIdContribuyente(String idContribuyente) {
        this.idContribuyente = idContribuyente;
    }
}

