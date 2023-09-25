package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "RESERVA_SERVICIO")
public class ReservaServicio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String fechaEntrada;

    public ReservaServicio(String fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public ReservaServicio() {;}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(String fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }
}
