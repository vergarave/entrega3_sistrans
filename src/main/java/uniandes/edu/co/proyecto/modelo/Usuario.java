package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="usuarios")

public class Usuario 
{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)

    private Integer loginUsuario;
    private String palabraClave;
    private String tipoDocumento;
    private String numeroDocumento;
    private String nombre;
    private String apellido;
    private String nacionalidad;
    private String direccionFisica;
    private String direccionElectronica;
    private String telefono;
    private String ciudad;
    private String codigoPostal;
}
