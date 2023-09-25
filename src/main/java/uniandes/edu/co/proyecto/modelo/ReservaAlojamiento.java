package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "RESERVA_ALOJAMIENTO")
public class ReservaAlojamiento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String fechaEntrada;
    private String fechaSalida;
    private Integer personas;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "plan_consumo_nombre")
    private PlanConsumo planConsumo;

    public ReservaAlojamiento(String fechaEntrada, String fechaSalida, Integer personas, PlanConsumo planConsumo) {
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.personas = personas;
        this.planConsumo = planConsumo;
    }

    public ReservaAlojamiento() {;}

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

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public Integer getPersonas() {
        return personas;
    }

    public void setPersonas(Integer personas) {
        this.personas = personas;
    }

    public PlanConsumo getPlanConsumo() {
        return planConsumo;
    }

    public void setPlanConsumo(PlanConsumo planConsumo) {
        this.planConsumo = planConsumo;
    }
}
