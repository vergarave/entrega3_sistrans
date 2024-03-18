package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class TrabajaEnPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "id_Empleado", referencedColumnName = "id")
    private Empleado idEmpleado;

    @ManyToOne
    @JoinColumn(name = "id_Oficina", referencedColumnName = "id")
    private Oficina idOficina;

    public TrabajaEnPK() {
        super();
    }

    public TrabajaEnPK(Empleado idEmpleado, Oficina idOficina) {
        this.idEmpleado = idEmpleado;
        this.idOficina = idOficina;
    }

    public Empleado getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Empleado idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Oficina getIdOficina() {
        return idOficina;
    }

    public void setIdOficina(Oficina idOficina) {
        this.idOficina = idOficina;
    }

}
